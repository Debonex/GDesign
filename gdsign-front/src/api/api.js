import core from "./core";
import user from "./user";
import order from "./order";
import commodity from "./commodity";

export default {
  install(Vue) {
    Vue.prototype.$api = {
      core,
      user,
      order,
      commodity
    };
  }
};
