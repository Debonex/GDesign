<template>
  <b-alert :show="this.$store.state.notify.show" :variant="type" dismissible fade>
    {{this.$store.state.notify.msg}}
  </b-alert>
</template>

<script>
export default {
  computed: {
    type: {
      get() {
        return this.$store.state.notify.type;
      },
    },
  },
};
</script>
