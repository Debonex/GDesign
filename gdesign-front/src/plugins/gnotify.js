exports.install = function(Vue) {
  Vue.prototype.notify = function(msg, type, duration) {
    this.$store.commit("notify", [msg, type]);
    if (duration) {
      setTimeout(() => {
        this.$store.commit("removeNotify");
      }, duration);
    }
  };
};
