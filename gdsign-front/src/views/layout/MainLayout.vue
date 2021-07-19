<template>
  <div class="fit">
    <g-navbar />
    <div class="flex fit">
      <g-sidebar />
      <div class="bg-white shadow-lg max-h-max m-4 flex-grow flex-shrink-0">
        <router-view></router-view>
      </div>
    </div>
    <footer
      class="bg-gradient-to-r from-gray-800 to-blue-600 text-secondary text-center py-1"
    >
      Copyright &copy; 2021. NJU Software Academy.
    </footer>
  </div>
</template>

<script>
import GNavbar from "@/components/GNavbar.vue";
import GSidebar from "@/components/GSidebar.vue";
export default {
  components: {
    GNavbar,
    GSidebar
  },
  data() {
    return {};
  }
};
</script>
