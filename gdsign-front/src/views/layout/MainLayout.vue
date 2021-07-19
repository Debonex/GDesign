<template>
  <div class="fit">
    <navbar/>
    <div class="flex fit">
      <g-sidebar/>
      <console-panel class="m-4 flex-grow flex-shrink-0">
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
