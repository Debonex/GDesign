<template>
  <div class="flex flex-column items-center">
    <g-alert class="absolute top-4 self-center z-30" />
    <div class="flex pl-2 md:pl-12 py-3 bg-gradient-to-r from-gray-800 to-blue-600 text-3xl text-white w-full">
      <p>订单操作</p>
      <b-button class="ml-10" :disabled="busy" variant="success" @click="handleAddOrderClick()">
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
        <template #cell(actions)="row">
          <b-button size="sm" class="mr-2" variant="primary" :disabled="busy" @click="handleUpdateOrderClick(row.item)">
            修改
          </b-button>
          <b-button size="sm" class="mr-2" variant="danger" :disabled="busy" @click="handleDelete(row.item)">
            删除
          </b-button>
        </template>
      </b-table>
    </b-overlay>

    <b-pagination class="absolute bottom-0" v-model="currentPage" :total-rows="totalRow" :per-page="perPage" :disabled="busy" @change="selectOrderPage" limit="7" v-show="totalRow>perPage" />

    <b-sidebar v-model="sidebarShow" class="z-20" id="sidebar-order-add" width="max-content" body-class="bg-white w-screen md:w-screen-3/5 h-4 py-5 px-4 md:px-8" header-class="bg-gradient-to-r from-gray-800 to-blue-600 justify-between h-18" right shadow backdrop-variant="dark" backdrop>
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
      <b-form>
        <label class="text-xl font-bold" label-for="input-id">商品ID</label>
        <b-input-group>
          <b-form-input id="input-id" list="list-commodity" placeholder="输入商品标题或ID进行搜索" v-model="inputCommodity"></b-form-input>
          <b-datalist id="list-commodity">
            <option v-for="commodity in commoditySearchList" :key="commodity.idCommodity" :value="commodity.idCommodity">
              {{commodity.title}}
            </option>
          </b-datalist>
          <b-input-group-append>
            <b-button variant="outline-primary" @click="inputCommodity=''">清空</b-button>
          </b-input-group-append>
        </b-input-group>
        <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-num">商品数量</label>
        <b-form-input id="input-num" v-model="order.numCommodity" type="number" placeholder="输入商品数量" required onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></b-form-input>
        <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-value">商品单价（元）</label>
        <b-form-input id="input-value" v-model="order.valueCommodity" type="number" placeholder="输入商品单价" disabled></b-form-input>
        <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-amount">订单金额（元）</label>
        <b-form-input id="input-amount" v-model="amountOrder" disabled></b-form-input>
        <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-date" v-show="method=='add'">订单日期</label>
        <b-form-input id="input-date" v-model="order.date" type="date" required v-show="method=='add'"></b-form-input>
      </b-form>
    </b-sidebar>

  </div>
</template>

<script>
import GAlert from "@/components/GAlert.vue";
import constants from "@/constants/constants.js";
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
        {
          key: "actions",
          label: "操作",
        },
      ],
      content: [],
      busy: false,
      currentPage: 1,
      totalRow: 0,
      perPage: 0,
      order: {
        numCommodity: 0,
        valueCommodity: 0,
        date: "",
      },
      inputCommodity: "",
      commoditySearchList: [],
      updateIdOrder: "",
      sidebarShow: false,
      method: "",
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
    selectOrderPage(page) {
      this.busy = true;
      this.$api.order
        .selectOrderPage({
          currentPage: page,
          perPage: 18,
          uid: this.$cookies.get("uid"),
        })
        .then((res) => {
          this.currentPage = res.data.content.currentPage;
          this.totalRow = res.data.content.totalRow;
          this.content = res.data.content.orderList.map((order) => {
            return {
              idOrder: order.idOrder,
              title: order.commodity.title,
              numCommodity: order.numCommodity,
              value: order.commodity.value,
              amountOrder: order.amountOrder,
              idCommodity: order.commodity.idCommodity,
            };
          });
          this.busy = false;
        });
    },
    handleAddOrder() {
      this.busy = true;
      if (this.method == "add") {
        this.$api.order
          .insertOrder({
            idCommodity: this.inputCommodity,
            numCommodity: this.order.numCommodity,
            valueCommodity: this.order.valueCommodity,
            date: this.order.date,
            uid: this.$cookies.get("uid"),
          })
          .then((res) => {
            if (res.data.message === constants.success) {
              this.notify("新增订单成功", "success", 3000);
              this.order = {
                numCommodity: 0,
                valueCommodity: 0,
                date: "",
              };
              this.inputCommodity = "";
              this.selectOrderPage(this.currentPage);
              this.busy = false;
            } else {
              this.notify(res.data.content, "danger", 3000);
              this.busy = false;
            }
          });
      }
      if (this.method == "update") {
        this.$api.order
          .updateOrder({
            idOrder: this.updateIdOrder,
            idCommodity: this.inputCommodity,
            numCommodity: this.order.numCommodity,
          })
          .then((res) => {
            if (res.data.message === constants.success) {
              this.selectOrderPage(this.currentPage);
              this.notify("更新订单成功", "success", 3000);
              this.sidebarShow = false;
              this.busy = false;
            } else {
              this.notify(res.data.content, "danger", 3000);
              this.busy = false;
            }
          });
      }
    },
    handleDelete(order) {
      console.log(order);
      this.busy = true;
      this.$api.order.deleteOrder({ idOrder: order.idOrder }).then((res) => {
        if (res.data.message === constants.success) {
          this.selectOrderPage(this.currentPage);
          this.notify("删除订单成功.", "success", 3000);
        } else {
          this.notify("删除订单失败.", "danger", 3000);
        }
      });
    },
    handleAddOrderClick() {
      this.method = "add";
      this.sidebarShow = true;
    },
    handleUpdateOrderClick(order) {
      console.log(order);
      this.method = "update";
      this.sidebarShow = true;
      this.order = order;
      this.inputCommodity = order.idCommodity;
      this.updateIdOrder = order.idOrder;
    },
  },
  watch: {
    inputCommodity(item) {
      if (!item) {
        this.order.valueCommodity = 0;
        return;
      }
      this.$api.commodity.searchCommodityList({ keyword: item }).then((res) => {
        this.commoditySearchList = res.data.content;
        if (/^\d+$/.test(item)) {
          for (let searchItem of this.commoditySearchList) {
            if (searchItem.idCommodity == item)
              this.order.valueCommodity = searchItem.value;
          }
        } else this.order.valueCommodity = 0;
      });
    },
  },
};
</script>
