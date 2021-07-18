<template>
  <div>
    <b-navbar
      toggleable="lg"
      type="dark"
      variant="dark"
      class="container-navbar-main ml-auto"
    >
      <b-navbar-brand href="#">Gdesign-rec</b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown right>
            <template v-slot:button-content>
              <em>User</em>
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {};
</script>

<style lang="less" scoped>
@import "../assets/less/components/navbar.less";
</style>
