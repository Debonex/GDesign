<template>
  <div class="w-full h-full">
    <g-navbar />
    <div class="flex w-full h-full">
      <g-sidebar class="pr-2 pl-2 md:pr-10 md:pl-10" />
      <div class="bg-white shadow-lg max-h-max m-8 flex-grow flex-shrink-0">
        <router-view></router-view>
      </div>
    </div>
    <footer class="bg-gradient-to-r from-gray-800 to-blue-600 text-secondary text-center py-1">
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
    GSidebar,
  },
  data() {
    return {};
  },
};
</script>
