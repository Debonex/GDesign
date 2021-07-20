<template>
  <div class="flex flex-column items-center">
    <div
      class="flex md:pl-12 py-3 bg-gradient-to-r from-gray-800 to-blue-600 text-3xl text-white w-full"
    >
      <p>订单操作</p>
      <b-button class="ml-10" :disabled="busy" variant="success">
        <i class="fa fa-plus mr-1" />新增订单
      </b-button>
    </div>
    <b-overlay :show="busy" class="w-full">
      <b-table hover bordered :fields="fields" :items="content"></b-table>
    </b-overlay>
  </div>
</template>

<script>
export default {
  data() {
    return {
      fields: [
        {
          key: "title",
          label: "商品名称",
          sortable: true,
          tdClass: "font-bold text-center"
        },
        {
          key: "num-commodity",
          label: "商品数量",
          sortable: true
        },
        {
          key: "value",
          label: "商品单价(元)",
          sortable: true
        },
        {
          key: "amount-order",
          label: "订单金额(元)",
          sortable: true
        },
        {
          key: "uid",
          label: "用户ID"
        }
      ],
      content: [],
      busy: false
    };
  }
};
</script>
