<template>
  <index-layout>
    <b-form
      @submit="onSubmit"
      class="w-5/6 sm:w-96 bg-gray-200 p-12 rounded-lg"
    >
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
      <b-form-group class="mt-6" label="确认密码" label-for="input-password2">
        <b-form-input
          v-model="form.password2"
          required
          type="password"
          placeholder="请确认密码"
        >
        </b-form-input>
      </b-form-group>
      <b-button class="mt-6 w-full" type="submit" variant="success"
        >注册</b-button
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
        password: "",
        password2: ""
      }
    };
  },
  methods: {
    onSubmit: function(e) {}
  }
};
</script>
