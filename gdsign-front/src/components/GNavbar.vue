<template>
  <b-navbar toggleable="lg" type="dark" class="bg-gradient-to-r from-gray-800 to-blue-600">
    <b-navbar-brand class="z-10" href="#">
      <i class="fa fa-area-chart mr-2" />Gdesign-
      <span class="text-blue-400 animate-pulse">rec</span>
    </b-navbar-brand>
    <div class="container-navbar-svg w-full h-full absolute left-0 top-0"></div>
    <b-navbar-toggle class="z-10 sticky right-2" target="nav-collapse"></b-navbar-toggle>
    <b-collapse class="z-10" id="nav-collapse" is-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-item-dropdown right v-if="this.$cookies.get('uid')">
          <template v-slot:button-content>
            <b-avatar variant="dark"></b-avatar>
          </template>
          <b-dropdown-item href="#" @click="handleLogout">Logout</b-dropdown-item>
        </b-nav-item-dropdown>
        <div v-else>
          <router-link class="text-white mr-3" to="/login">Login</router-link>
          <router-link class="text-white" to="/register">Register</router-link>
        </div>

      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script>
export default {
  methods: {
    handleLogout: function () {
      this.$cookies.remove("uid");
      this.$router.push("/login");
    },
  },
};
</script>

<style lang="less" scoped>
@import "../assets/style/components/navbar.less";
</style>
