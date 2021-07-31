import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default function() {
  const Store = new Vuex.Store({
    state: {
      notify: {
        show: false,
        msg: "",
        type: ""
      }
    },
    mutations: {
      notify(state, msg, type) {
        state.notify.show = true;
        state.notify.msg = msg;
        state.notify.type = type;
      },
      removeNotify(state) {
        state.notify.show = false;
      }
    }
  });

  return Store;
}
