<template>
  <div class="flex flex-column items-center">
    <div class="flex pl-2 md:pl-12 py-3 bg-gradient-to-r from-gray-800 to-blue-600 text-3xl text-white w-full">
      <p>商品上传</p>
      <b-button class="ml-10" :disabled="busy" variant="success" v-b-toggle.sidebar-commodity-add>
        <i class="fa fa-plus mr-1" />新增商品
      </b-button>
    </div>

    <b-overlay :show="busy" class="w-full">
      <b-table hover bordered :fields="fields" :items="content"></b-table>
    </b-overlay>

    <b-sidebar id="sidebar-commodity-add" width="max-content" body-class="bg-white w-screen md:w-screen-3/5 h-4 py-5 px-4 md:px-8" header-class="bg-gradient-to-r from-gray-800 to-blue-600 justify-between h-18" right shadow backdrop-variant="dark" backdrop>
      <template #header={hide}>
        <span class="text-3xl mr-2 text-white">商品信息</span>
        <button><i class="fa fa-remove text-white" @click="hide" /></button>
      </template>
      <template #footer="{ hide }">
        <div class="d-flex text-light align-items-center px-3 py-2">
          <b-button class="mr-3" variant="success" size="md">确认</b-button>
          <b-button variant="outline-primary" size="md" @click="hide">取消</b-button>
        </div>
      </template>

      <label class="text-xl font-bold" label-for="input-title">商品标题</label>
      <b-form-input id="input-title" v-model="commodity.title" placeholder="输入商品标题" required></b-form-input>

      <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-title">商品价格</label>
      <b-form-input id="input-value" v-model="commodity.value" type="number" placeholder="输入商品价格" required></b-form-input>

    </b-sidebar>
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
          tdClass: "font-bold text-center",
        },
        {
          key: "title",
          label: "商品名称",
          sortable: true,
        },
        {
          key: "specification",
          label: "商品规格",
        },
        {
          key: "value",
          label: "商品单价(元)",
          sortable: true,
        },
        {
          key: "resason",
          label: "推荐理由",
        },
      ],
      content: [],
      busy: false,
      commodity: {
        title: "",
        specification: "",
        value: 0.0,
      },
    };
  },
};
</script>

<style lang="less" scoped>
@import "../../assets/style/pages/CommodityPage.less";
</style>
