<template>
  <index-layout>
    <b-form class="w-5/6 sm:w-96 bg-gray-200 p-12 rounded-lg">
      <div class="text-2xl text-center">登录</div>
      <b-form-group class="mt-10" label="用户名" label-for="input-username">
        <b-form-input
          v-model="form.username"
          required
          placeholder="请输入用户名"
        >
        </b-form-input>
      </b-form-group>
      <b-form-group class="mt-6" label="密码" label-for="input-password">
        <b-form-input
          v-model="form.password"
          required
          type="password"
          placeholder="请输入密码"
        >
        </b-form-input>
      </b-form-group>
      <router-link class="block mt-6 text-right text-success" to="/register"
        >还没有账号？点我注册</router-link
      >
      <b-button class="mt-6 w-full" variant="success" @click="onSubmit"
        >登录</b-button
      >
    </b-form>
  </index-layout>
</template>

<script>
import indexLayout from "@/views/layout/IndexLayout.vue";
export default {
  components: {
    indexLayout
  },
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    onSubmit: function(e) {
      this.$router.push("/home");
    }
  }
};
</script>

<style></style>
