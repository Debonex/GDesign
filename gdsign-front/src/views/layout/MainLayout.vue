<template>
  <div class="container-fluid">
    <div class="row">
      <navbar class="navbar-main" />
    </div>
    <div class="row">
      <div class="col-2">
        <sidebar />
      </div>
      <div class="col-10">
        <console-panel>
          <slot></slot>
        </console-panel>
      </div>
    </div>
  </div>
</template>

<script>
import sidebar from "@/components/Sidebar.vue";
import navbar from "@/components/Navbar.vue";
import consolePanel from "@/components/ConsolePanel.vue";
export default {
  components: {
    consolePanel,
    sidebar,
    navbar,
  },
  data() {
    return {};
  },
};
</script>

<style lang="less" scoped>
@import "../../assets/less/views/layout/main-layout";
</style>
