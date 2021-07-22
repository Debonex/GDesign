<template>
  <div class="flex flex-column items-center">
    <div
      class="flex pl-2 md:pl-12 py-3 bg-gradient-to-r from-gray-800 to-blue-600 text-3xl text-white w-full"
    >
      <p>商品上传</p>

      <b-button class="ml-10" :disabled="busy" variant="success" v-b-toggle.sidebar-commodity-add>
        <i class="fa fa-plus mr-1" />新增商品
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
          key: "id",
          label: "商品编号",
          sortable: true,
          tdClass: "font-bold text-center"
        },
        {
          key: "title",
          label: "商品名称",
          sortable: true
        },
        {
          key: "value",
          label: "商品单价(元)",
          sortable: true
        },
        {
          key: "resason",
          label: "推荐理由"
        }
      ],
      content: [],
      busy: false
    };
  }
};
</script>
