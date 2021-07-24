<template>
  <b-navbar toggleable="lg" type="dark" class="bg-gradient-to-r from-gray-800 to-blue-600">
    <b-navbar-brand class="z-10" href="#">
      <i class="fa fa-area-chart mr-2" />Gdesign-
      <span class="text-blue-400 animate-pulse">rec</span>
    </b-navbar-brand>
    <div class="container-navbar-svg h-12 fit absolute left-0 top-0"></div>
    <b-navbar-toggle class="z-10 sticky right-2" target="nav-collapse"></b-navbar-toggle>
    <b-collapse class="z-10" id="nav-collapse" is-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-item-dropdown right>
          <template v-slot:button-content>
            <b-avatar variant="dark"></b-avatar>
            <em>User</em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script>
export default {};
</script>

<style lang="less" scoped>
@import "../assets/style/components/navbar.less";
</style>
