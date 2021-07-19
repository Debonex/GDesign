<template>
  <div>
    <b-card no-body>
      <b-card-header class="bg-gradient-to-r from-gray-800 to-blue-600">
        <b-nav card-header tabs>
          <b-nav-item class="mr-4" active>
            默认排序<i class="fa fa-sort ml-1" />
          </b-nav-item>
          <b-nav-item class="mr-4">
            时间：从早到晚<i class="fa fa-sort ml-1" />
          </b-nav-item>
          <b-nav-item class="mr-4">
            金额：从高到底<i class="fa fa-sort ml-1" />
          </b-nav-item>
        </b-nav>
      </b-card-header>

      <b-card-body class="text-center">
        <b-card-text>
          你的订单信息都在这里了
        </b-card-text>

        <b-button variant="primary">哇！太好了！</b-button>
      </b-card-body>
    </b-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      orderList:[]
    };
  }
};
</script>
