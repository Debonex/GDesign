<template>
  <b-alert :show="this.$store.state.notify.show" :variant="this.$store.state.notify.type" dismissible fade>
    {{this.$store.state.notify.msg}}
  </b-alert>
</template>

<script>
export default {
  watch: {},
};
</script>
