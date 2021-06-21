<template>
  <main-layout>
    <div class="row d-flex justify-content-center">
      <div class="col-lg-12">
        <div class="card d-flex justify-content-center container-card">
          <div class="card-body">
            <div class="d-flex justify-content-between">
              <div class="col-4"></div>
              <h3 class="mb-3 col-3">商品推荐</h3>
              <div class="col-4 d-flex justify-content-end p-0"></div>
            </div>
            <g-table v-bind:tableData="tableData"></g-table>
          </div>
        </div>
      </div>
    </div>
  </main-layout>
</template>

<script>
import mainLayout from "@/views/layout/MainLayout.vue";
import gTable from "@/components/GTable.vue";
export default {
  created() {
    this.$axios
      .get("/rec/contentBase")
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  },
  data() {
    return {
      tableData: {
        cols: ["编号", "名称", "单价", "推荐理由"],
        content: [["1", "a", "b", "c"]],
      },
    };
  },
  components: {
    mainLayout,
    gTable,
  },
};
</script>

<style lang="less" scoped>
@import "../../assets/less/views/pages/RecommendPage";
</style>