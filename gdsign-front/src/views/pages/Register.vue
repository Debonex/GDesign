<template>
  <index-layout>
    <g-alert class="absolute top-4 self-center z-30" />
    <b-form class="w-5/6 sm:w-96 bg-gray-200 p-12 rounded-lg z-10">
      <div class="text-2xl text-center">注册</div>
      <b-form-group class="mt-10" label="用户ID">
        <b-form-input v-model="form.uid" required placeholder="请输入用户ID">
        </b-form-input>
      </b-form-group>
      <b-form-group class="mt-6" label="密码">
        <b-form-input v-model="form.password" required type="password" placeholder="请输入密码">
        </b-form-input>
      </b-form-group>
      <b-form-group class="mt-6" label="确认密码">
        <b-form-input v-model="form.password2" required type="password" placeholder="请确认密码">
        </b-form-input>
      </b-form-group>
      <router-link class="block mt-6 text-right text-primary" to="/login">已有账号，前往登录</router-link>
      <b-button class="mt-6 w-full" @click="handleRegister" variant="primary" :disabled="busy">注册</b-button>
    </b-form>
  </index-layout>
</template>

<script>
import indexLayout from "@/views/layout/IndexLayout.vue";
import constants from "@/constants/constants.js";
import GAlert from "@/components/GAlert.vue";
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
        password2: "",
      },
      busy: false,
    };
  },
  methods: {
    handleRegister: function (e) {
      this.busy = true;
      this.$api.user.register(this.form).then((res) => {
        const msg = res.data.message;
        if (msg === constants.user.register.success) {
          this.notify("注册成功!", "success", 3000);
          setTimeout(() => {
            this.$router.push("/login");
            this.busy = false;
          }, 1000);
        } else {
          this.notify(res.data.content, "danger", 3000);
          this.busy = false;
        }
      });
    },
  },
};
</script>
