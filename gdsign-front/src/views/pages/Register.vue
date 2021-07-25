<template>
  <index-layout>
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
      <b-button class="mt-6 w-full" @click="handleRegister" variant="primary">注册</b-button>
    </b-form>
  </index-layout>
</template>

<script>
import indexLayout from "@/views/layout/IndexLayout.vue";
import constants from "@/constants/constants.js";
export default {
  components: {
    indexLayout,
  },
  data() {
    return {
      form: {
        uid: "",
        password: "",
        password2: "",
      },
    };
  },
  methods: {
    handleRegister: function (e) {
      this.$api.user
        .register({
          uid: this.form.uid,
          password: this.form.password,
        })
        .then((res) => {
          const msg = res.data.message;
          if (msg === constants.user.register.success) {
            this.$router.push("/login");
          }
          console.log(res);
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
</script>
