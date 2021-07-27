import core from "./core";
import user from "./user";
import order from "./order";

export default {
  install(Vue) {
    Vue.prototype.$api = {
      core,
      user,
      order
    };
  }
};
