import core from "./core";
import user from "./user";

export default {
  install(Vue) {
    Vue.prototype.$api = {
      core,
      user
    };
  }
};
