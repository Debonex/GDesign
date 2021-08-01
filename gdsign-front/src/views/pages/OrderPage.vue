<template>
  <div class="flex flex-column items-center">
    <g-alert class="absolute top-4 self-center z-30" />
    <div class="flex pl-2 md:pl-12 py-3 bg-gradient-to-r from-gray-800 to-blue-600 text-3xl text-white w-full">
      <p>订单操作</p>
      <b-button class="ml-10" :disabled="busy" variant="success" v-b-toggle.sidebar-order-add>
        <i class="fa fa-plus mr-1" />新增订单
      </b-button>
    </div>

    <b-overlay :show="busy" class="w-full">
      <b-table hover bordered :fields="fields" :items="content">
        <template #cell(amountOrder)="data">
          {{ data.value.toFixed(2) }}
        </template>
        <template #cell(value)="data">
          {{ data.value.toFixed(2) }}
        </template>
      </b-table>
    </b-overlay>

    <b-pagination class="absolute bottom-0" v-model="currentPage" :total-rows="totalRow" :per-page="perPage" :disabled="busy" @change="selectOrderPage" limit="7" v-show="totalRow>perPage" />

    <b-sidebar class="z-20" id="sidebar-order-add" width="max-content" body-class="bg-white w-screen md:w-screen-3/5 h-4 py-5 px-4 md:px-8" header-class="bg-gradient-to-r from-gray-800 to-blue-600 justify-between h-18" right shadow backdrop-variant="dark" backdrop>
      <template #header={hide}>
        <span class="text-3xl mr-2 text-white">订单信息</span>
        <button><i class="fa fa-remove text-white" @click="hide" /></button>
      </template>
      <template #footer="{ hide }">
        <div class="d-flex text-light align-items-center px-3 py-2">
          <b-button class="mr-3" variant="success" size="md" @click="handleAddOrder" :disabled="busy">确认</b-button>
          <b-button variant="outline-primary" size="md" @click="hide">取消</b-button>
        </div>
      </template>
      <label class="text-xl font-bold" label-for="input-id">商品ID</label>
      <b-input-group>
        <b-form-input id="input-id" list="list-commodity" placeholder="输入商品标题或ID进行搜索" v-model="inputCommodity"></b-form-input>
        <b-datalist id="list-commodity">
          <option v-for="commodity in order.searchList" :key="commodity.idCommodity" :value="commodity.idCommodity">
            {{commodity.title}}
          </option>
        </b-datalist>
        <b-input-group-append>
          <b-button variant="outline-primary">清空</b-button>
        </b-input-group-append>
      </b-input-group>
      <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-num">商品数量</label>
      <b-form-input id="input-num" v-model="order.numCommodity" type="number" placeholder="输入商品数量" required></b-form-input>
      <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-value">商品单价（元）</label>
      <b-form-input id="input-value" v-model="order.valueCommodity" type="number" placeholder="输入商品单价" readonly></b-form-input>
      <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-amount">订单金额（元）</label>
      <b-form-input id="input-amount" v-model="amountOrder" readonly></b-form-input>
      <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-date">订单日期</label>
      <b-form-input id="input-date" v-model="order.date" type="date"></b-form-input>
    </b-sidebar>

  </div>
</template>

<script>
import GAlert from "@/components/GAlert.vue";
import constants from "@/constants/constants.js";
let timer = null;
export default {
  components: {
    GAlert,
  },
  data() {
    return {
      fields: [
        {
          key: "idOrder",
          label: "订单编号",
          tdClass: "font-bold",
        },
        {
          key: "title",
          label: "商品名称",
          sortable: true,
        },
        {
          key: "numCommodity",
          label: "商品数量",
          sortable: true,
        },
        {
          key: "value",
          label: "商品单价(元)",
          sortable: true,
        },
        {
          key: "amountOrder",
          label: "订单金额(元)",
          sortable: true,
        },
      ],
      content: [],
      busy: false,
      currentPage: 1,
      totalRow: 0,
      perPage: 20,
      order: {
        numCommodity: 0,
        valueCommodity: 0,
        date: "",
        searchList: [],
      },
      inputCommodity: "",
    };
  },
  computed: {
    amountOrder() {
      return this.order.numCommodity * this.order.valueCommodity;
    },
  },
  created() {
    this.selectOrderPage(1);
  },
  methods: {
    selectOrderPage: function (page) {
      this.busy = true;
      this.$api.order
        .selectOrderPage({
          currentPage: page,
          perPage: 20,
          uid: this.$cookies.get("uid"),
        })
        .then((res) => {
          this.currentPage = res.data.content.currentPage;
          this.totalRow = res.data.content.totalRow;
          this.content = [];
          res.data.content.orderList.forEach((order) => {
            this.content.push({
              idOrder: order.idOrder,
              title: order.commodity.title,
              numCommodity: order.numCommodity,
              value: order.commodity.value,
              amountOrder: order.amountOrder,
            });
          });
          this.busy = false;
        })
        .catch((err) => {
          console.error(err);
          this.busy = false;
        });
    },
    handleAddOrder: function () {
      this.busy = true;
      this.$api.order
        .insertOrder({
          idCommodity: this.inputCommodity,
          numCommodity: this.order.numCommodity,
          valueCommodity: this.order.valueCommodity,
          date: this.order.date,
          uid: this.$cookies.get("uid"),
        })
        .then((res) => {
          console.log(res);
          if (res.data.message === constants.success) {
            this.notify("新增订单成功", "success", 3000);
            this.order = {
              numCommodity: 0,
              valueCommodity: 0,
              date: "",
            };
            this.inputCommodity = "";
            this.$api.order
              .selectOrderPage({
                currentPage: this.currentPage,
                perPage: 20,
                uid: this.$cookies.get("uid"),
              })
              .then((res) => {
                this.currentPage = res.data.content.currentPage;
                this.totalRow = res.data.content.totalRow;
                this.content = [];
                res.data.content.orderList.forEach((order) => {
                  this.content.push({
                    idOrder: order.idOrder,
                    title: order.commodity.title,
                    numCommodity: order.numCommodity,
                    value: order.commodity.value,
                    amountOrder: order.amountOrder,
                  });
                });
                this.busy = false;
              });
          } else {
            this.notify("新增订单失败", "danger", 3000);
            this.busy = false;
          }
        })
        .catch((err) => {
          console.error(err);
          this.notify("新增订单失败", "danger", 3000);
          this.busy = false;
        });
    },
  },
  watch: {
    inputCommodity(item) {
      if (!item) return;
      this.$api.commodity.searchCommodityList({ keyword: item }).then((res) => {
        this.order.searchList = res.data.content;
        if (/^\d+$/.test(item)) {
          console.log(item);
          for (let searchItem of this.order.searchList) {
            if (searchItem.idCommodity == item)
              this.order.valueCommodity = searchItem.value;
          }
        }
      });
    },
  },
};
</script>
