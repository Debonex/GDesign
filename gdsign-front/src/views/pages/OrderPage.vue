<template>
  <div class="flex flex-column items-center">
    <div class="flex pl-2 md:pl-12 py-3 bg-gradient-to-r from-gray-800 to-blue-600 text-3xl text-white w-full">
      <p>订单操作</p>
      <b-button class="ml-10" :disabled="busy" variant="success">
        <i class="fa fa-plus mr-1" />新增订单
      </b-button>
    </div>
    <b-overlay :show="busy" class="w-full">
      <b-table hover bordered :fields="fields" :items="content"></b-table>
    </b-overlay>
    <b-pagination class="absolute bottom-0" v-model="currentPage" :total-rows="totalRow" :per-page="perPage" :disabled="busy" @change="selectOrderPage" limit="7" v-show="totalRow>perPage" />
  </div>
</template>

<script>
export default {
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
    };
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
          console.log(res.data.content);
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
  },
};
</script>
