<template>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th v-for="(col, idx) in tableData.cols" :key="idx">
          {{ col }}
        </th>
      </tr>
    </thead>
    <tbody v-for="(item, idx) in tableData.content" :key="idx">
      <tr>
        <td v-for="(cell, i) in item" :key="i">
          {{ cell }}
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  props: {
    tableData: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style lang="less" scoped>
@import "../assets/less/components/gtable.less";
</style>
