<template>
  <div class="flex flex-column items-center">
    <g-alert class="absolute top-4 self-center z-30" />
    <div class="flex pl-2 md:pl-12 py-3 bg-gradient-to-r from-gray-800 to-blue-600 text-3xl text-white w-full">
      <p>商品上传</p>
      <b-button class="ml-10" :disabled="busy" variant="success" v-b-toggle.sidebar-commodity-add>
        <i class="fa fa-plus mr-1" />新增商品
      </b-button>
    </div>

    <b-overlay :show="busy" class="w-full">
      <b-table hover bordered :fields="fields" :items="content"></b-table>
    </b-overlay>

    <b-pagination class="absolute bottom-0" v-model="currentPage" :total-rows="totalRow" :per-page="perPage" :disabled="busy" @change="selectCommodityPage" limit="7" v-show="totalRow>perPage" />

    <b-sidebar class="z-20" id="sidebar-commodity-add" width="max-content" body-class="bg-white w-screen md:w-screen-3/5 h-4 py-5 px-4 md:px-8" header-class="bg-gradient-to-r from-gray-800 to-blue-600 justify-between h-18" right shadow backdrop-variant="dark" backdrop>
      <template #header={hide}>
        <span class="text-3xl mr-2 text-white">商品信息</span>
        <button><i class="fa fa-remove text-white" @click="hide" /></button>
      </template>
      <template #footer="{ hide }">
        <div class="d-flex text-light align-items-center px-3 py-2">
          <b-button class="mr-3" variant="success" size="md" @click="handleAddCommodity" :disabled="busy">确认</b-button>
          <b-button variant="outline-primary" size="md" @click="hide">取消</b-button>
        </div>
      </template>

      <label class="text-xl font-bold" label-for="input-title">商品标题</label>
      <b-form-input id="input-title" v-model="commodity.title" placeholder="输入商品标题" required></b-form-input>

      <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-specification">商品规格</label>
      <b-form-input id="input-specification" v-model="commodity.specification" placeholder="输入商品规格" required></b-form-input>

      <label class="text-xl font-bold mt-4 md:mt-8" label-for="input-value">商品单价（元）</label>
      <b-form-input id="input-value" v-model="commodity.value" type="number" placeholder="输入商品单价" required></b-form-input>

      <label class="text-xl font-bold mt-4 md:mt-8" for="select-entity">商品类型</label>
      <b-form-select id="select-entity" v-model="commodity.entity" :options="entityOptions">
      </b-form-select>

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
      ],
      content: [],
      busy: false,
      currentPage: 1,
      perPage: 0,
      totalRow: 0,
      entityOptions: [
        { value: 0, text: "虚拟商品" },
        { value: 1, text: "实体商品" },
      ],
      commodity: {
        title: "",
        specification: "",
        value: 0.0,
        entity: 0,
        timelimit: "",
      },
    };
  },
  created() {
    this.selectCommodityPage(1);
  },
  methods: {
    selectCommodityPage(page) {
      this.busy = true;
      this.$api.commodity
        .selectPage({
          currentPage: page,
          perPage: 20,
          uid: this.$cookies.get("uid"),
        })
        .then((res) => {
          this.totalRow = res.data.content.totalRow;
          this.content = res.data.content.commodityList;
          this.busy = false;
        });
    },
    handleAddCommodity() {
      this.busy = true;
      this.$api.commodity.addCommodity(this.commodity).then((res) => {
        if (res.data.message === constants.success) {
          this.notify("上传商品成功!", "success", 3000);
          this.commodity = {
            title: "",
            specification: "",
            value: 0.0,
            entity: 0,
            timelimit: "",
          };
          this.busy = false;
        } else {
          this.notify(res.data.content, "danger", 3000);
          this.busy = false;
        }
      });
    },
  },
};
</script>
