<template>
  <div class="flex flex-column items-center">
    <div class="flex md:pl-12 py-3 bg-gradient-to-r from-gray-800 to-blue-600 text-3xl text-white w-full">
      <p>商品推荐</p>

      <b-dropdown class="ml-12" :disabled="busy" text="推荐数量" variant="success">
        <b-dropdown-item href="#">10</b-dropdown-item>
        <b-dropdown-item href="#">15</b-dropdown-item>
        <b-dropdown-item href="#">20</b-dropdown-item>
      </b-dropdown>

      <b-button class="ml-10" :disabled="busy" variant="success">
        <i class="fa fa-refresh mr-1" />换一批
      </b-button>

      <a class="fa fa-sign-out :hover-none ml-auto mr-12 sticky right-2" href="#" v-b-tooltip.hover title="导出商品单" />
    </div>

    <b-overlay :show="busy" class="w-full">
      <b-table responsive hover bordered :fields="fields" :items="content"></b-table>
    </b-overlay>
  </div>
</template>

<script>
export default {
  data() {
    return {
      fields: [
        {
          key: "idCommodity",
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
    };
  },
  created() {
    this.$api.core.rec
      .recommend({
        uid: this.$cookies.get("uid"),
      })
      .then((res) => {
        this.content = [];
        res.data.content.forEach((item) => {
          this.content.push({
            idCommodity: item.idCommodity,
            title: item.title,
            value: item.value,
            specification: item.specification,
            reason: "todo",
          });
        });
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>
