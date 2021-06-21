<template>
  <div id="console-panel" class="console-panel">
    <div class="content">
      <slot> </slot>
    </div>
    <footer class="footer-console-panel">
      <div class="bg-white">
        <div class="row">
          <div class="col-sm-4"></div>
          <div class="col-sm-8 text-secondary">
            Copyright &copy; 2021. NJU Software Academy.
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
export default {};
</script>

<style lang="less" scoped>
.footer-console-panel {
  position: sticky;
  bottom: 0;
}
</style>