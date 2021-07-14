import core from "./core";

export default {
  install(Vue) {
    Vue.prototype.$api = {
      core
    };
  }
};
