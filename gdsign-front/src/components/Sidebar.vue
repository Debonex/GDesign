<template>
  <!-- Left Panel -->
  <aside id="left-panel" class="left-panel">
    <nav class="navbar navbar-expand-sm navbar-default">
      <div id="main-menu" class="main-menu collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="menu-title" style="text-align: left">业务操作</li>
          <!-- /.menu-title -->
          <li @click="$router.push('/order')">
            <a href="#">
              <b-icon-basket class="menu-icon"></b-icon-basket>订单操作</a
            >
          </li>
          <li @click="$router.push('/commodity')">
            <a href="#">
              <b-icon-table class="menu-icon"></b-icon-table>商品上传</a
            >
          </li>
          <li class="menu-title">智能决策</li>
          <!-- /.menu-title -->
          <li @click="$router.push('/recommend')">
            <a href="#">
              <b-icon-shop class="menu-icon"></b-icon-shop>商品推荐</a
            >
          </li>
          <li @click="$router.push('/compare')">
            <a href="#">
              <b-icon-reception4 class="menu-icon"></b-icon-reception4>商品比较</a
            >
          </li>
        </ul>
      </div>
      <!-- /.navbar-collapse -->
    </nav>
  </aside>
</template>

<script>
export default {
};
</script>

<style lang="less" scoped>
@import "../assets/less/components/sidebar.less";
</style>
