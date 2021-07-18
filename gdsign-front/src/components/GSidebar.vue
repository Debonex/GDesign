<template>
  <b-navbar class="min-w-min h-screen items-start shadow-lg">
    <b-nav vertical class="pr-20 pl-8">
      <b-navbar-brand class="mt-10 border-b-2">业务操作</b-navbar-brand>
      <b-nav-item class="mt-4" @click="$router.push('/order')" active
        >订单操作</b-nav-item
      >
      <b-nav-item class="mt-4" @click="$router.push('/commodity')" active
        >商品上传</b-nav-item
      >
      <b-navbar-brand class="mt-10 border-b-2">智能决策</b-navbar-brand>
      <b-nav-item class="mt-4" @click="$router.push('/recommend')" active
        >商品推荐</b-nav-item
      >
      <b-nav-item class="mt-4" @click="$router.push('/compare')" active
        >商品比较</b-nav-item
      >
    </b-nav>
  </b-navbar>
</template>

<script>
export default {};
</script>
