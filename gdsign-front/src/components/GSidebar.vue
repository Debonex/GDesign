<template>
  <b-navbar class="min-w-min h-screen items-start shadow-lg">
    <b-nav vertical class="pr-20 pl-8">
      <b-navbar-brand class="mt-10 border-b-2 font-semibold">业务操作</b-navbar-brand>
      <b-nav-item class="mt-4" @click="$router.push('/order')" active>
        <i class="fa fa-shopping-cart mr-2"></i>订单操作
      </b-nav-item>
      <b-nav-item class="mt-4" @click="$router.push('/commodity')" active
        ><i class="fa fa-upload mr-2"></i>商品上传
      </b-nav-item>
      <b-navbar-brand class="mt-10 border-b-2 font-semibold">智能决策</b-navbar-brand>
      <b-nav-item class="mt-4" @click="$router.push('/recommend')" active
        ><i class="fa fa-thumbs-up mr-2"></i>商品推荐
      </b-nav-item>
      <b-nav-item class="mt-4" @click="$router.push('/compare')" active
        ><i class="fa fa-paste mr-2"></i>商品比较
      </b-nav-item>
    </b-nav>
  </b-navbar>
</template>

<script>
export default {};
</script>
