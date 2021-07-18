<template>
  <div>
    <navbar class="w-100" />
    <div class="flex">
      <div class="w-1/6 max-w-max">
        <g-sidebar />
      </div>
      <console-panel class="m-4">
        <router-view></router-view>
      </console-panel>
    </div>
  </div>
</template>

<script>
import navbar from "@/components/Navbar.vue";
import ConsolePanel from "@/components/ConsolePanel.vue";
import GSidebar from "../../components/GSidebar.vue";
export default {
  components: {
    ConsolePanel,
    navbar,
    GSidebar
  },
  data() {
    return {};
  }
};
</script>
