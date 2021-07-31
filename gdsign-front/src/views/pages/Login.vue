<template>
  <index-layout>
    <g-alert class="absolute top-4 self-center z-30" />
    <b-form class="w-5/6 sm:w-96 bg-gray-200 p-12 rounded-lg z-10">
      <div class="text-2xl text-center">登录</div>
      <b-form-group class="mt-10" label="用户ID">
        <b-form-input v-model="form.uid" required placeholder="请输入用户ID">
        </b-form-input>
      </b-form-group>
      <b-form-group class="mt-6" label="密码">
        <b-form-input v-model="form.password" required type="password" placeholder="请输入密码">
        </b-form-input>
      </b-form-group>
      <router-link class="block mt-6 text-right text-primary" to="/register">还没有账号？点我注册</router-link>
      <b-button class="mt-6 w-full" variant="primary" @click="handleLogin" :disabled="busy">登录</b-button>
    </b-form>
  </index-layout>
</template>

<script>
import indexLayout from "@/views/layout/IndexLayout.vue";
import constants from "@/constants/constants.js";
import GAlert from "@/components/GAlert.vue";
let timer = null;
export default {
  components: {
    indexLayout,
    GAlert,
  },
  data() {
    return {
      form: {
        uid: "",
        password: "",
      },
      busy: false,
    };
  },
  methods: {
    handleLogin: function () {
      this.busy = true;
      this.$api.user
        .login({
          uid: this.form.uid,
          password: this.form.password,
        })
        .then((res) => {
          const msg = res.data.message;
          if (msg === constants.user.login.success) {
            this.$cookies.set("uid", this.form.uid);
            this.$store.commit("notify", ["登录成功", "success"]);
            timer = setTimeout(() => {
              this.$router.push("/home");
              this.$store.commit("removeNotify");
              this.busy = false;
            }, 2000);
          }
          if (msg === constants.user.login.failed) {
            this.$store.commit("notify", ["登录失败", "danger"]);
            timer = setTimeout(() => {
              this.$store.commit("removeNotify");
            }, 5000);
            this.busy = false;
          }
        })
        .catch((err) => {
          this.$store.commit("notify", ["登录失败", "danger"]);
          timer = setTimeout(() => {
            this.$store.commit("removeNotify");
          }, 5000);
          console.error(err);
          this.busy = false;
        });
    },
  },
  beforeDestroy() {
    clearTimeout(timer);
  },
};
</script>

<style></style>
