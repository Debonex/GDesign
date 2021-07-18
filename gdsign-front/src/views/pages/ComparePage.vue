<template>
  <main-layout>
      <div class="row d-flex justify-content-center">
        <div class="col-lg-12 row container-cards">
          <div class="card d-flex justify-content-center col-7">
            <div class="card-body">
              <div class="d-flex justify-content-between">
                <div class="col-3"></div>
                <h3 class="mb-3 col-6">商品比较</h3>
                <div class="col-3">
                  <button class="btn btn-outline-primary btn-sm">
                    <i class="fa fa-refresh"></i> 换一批
                  </button>
                </div>
              </div>

              <!--订单列表-->
              <table class="table table-commodity">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">商品1</th>
                    <th scope="col">商品2</th>
                    <th scope="col">关联度</th>
                    <th
                      id="tbModify"
                      scope="auto"
                      style="width: 170px; display: none"
                    >
                      操作
                    </th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL
                        </h5>
                        <h6 class="card-title text-muted">DZ201920</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL
                        </h5>
                        <h6 class="card-title text-muted">DZ201920</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h4 class="text-success">100%</h4>
                      </div>
                    </div>
                  </tr>
                  <tr>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL
                        </h5>
                        <h6 class="card-title text-muted">DZ201920</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>DHL
                        </h5>
                        <h6 class="card-title text-muted">DZ202220</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h4 class="text-warning">55%</h4>
                      </div>
                    </div>
                  </tr>
                  <tr>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL
                        </h5>
                        <h6 class="card-title text-muted">DZ201920</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL2
                        </h5>
                        <h6 class="card-title text-muted">DZ201921</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h4 class="text-success">91%</h4>
                      </div>
                    </div>
                  </tr>
                  <tr>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL
                        </h5>
                        <h6 class="card-title text-muted">DZ201920</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>DDD
                        </h5>
                        <h6 class="card-title text-muted">OPDD1220</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h4 class="text-danger">5%</h4>
                      </div>
                    </div>
                  </tr>
                  <tr>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL
                        </h5>
                        <h6 class="card-title text-muted">DZ201920</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>DDD
                        </h5>
                        <h6 class="card-title text-muted">OPDD1220</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h4 class="text-danger">5%</h4>
                      </div>
                    </div>
                  </tr>
                  <tr>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL
                        </h5>
                        <h6 class="card-title text-muted">DZ201920</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>DDD
                        </h5>
                        <h6 class="card-title text-muted">OPDD1220</h6>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-body">
                        <h4 class="text-danger">5%</h4>
                      </div>
                    </div>
                  </tr>
                </tbody>
              </table>
              <!--/订单列表-->
            </div>
          </div>
          <div class="card d-flex justify-content-center col-4">
            <div class="card-body">
              <div class="card">
                <div
                  style="
                    height: 3rem;
                    padding: 0.5rem;
                    text-align: start;
                    display: flex;
                    justify-content: space-between;
                  "
                  class="bg-dark text-white"
                >
                  <b>商品1</b
                  ><input
                    type="text"
                    placeholder="商品编号/名称"
                    class="form-control col-5 mr-3"
                    style="height: 2rem"
                  />
                </div>
                <div class="card-body">
                  <h5 class="card-title">
                    <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL
                  </h5>
                  <h6 class="card-title text-muted">DZ201920</h6>
                </div>
              </div>
              <div class="card">
                <div
                  style="
                    height: 3rem;
                    padding: 0.5rem;
                    text-align: start;
                    display: flex;
                    justify-content: space-between;
                  "
                  class="bg-dark text-white"
                >
                  <b>商品2</b
                  ><input
                    type="text"
                    placeholder="商品编号/名称"
                    class="form-control col-5 mr-3"
                    style="height: 2rem"
                  />
                </div>
                <div class="card-body">
                  <h5 class="card-title">
                    <b>商品名:&nbsp;&nbsp;&nbsp;&nbsp;</b>MKL2
                  </h5>
                  <h6 class="card-title text-muted">DZ201820</h6>
                </div>
              </div>
              <div class="card">
                <div
                  style="
                    height: 3rem;
                    padding: 0.5rem;
                    text-align: start;
                    display: flex;
                    justify-content: space-between;
                  "
                  class="bg-dark text-white"
                >
                  <b>关联度</b
                  >
                </div>
                <div class="card-body">
                  <h2 class="text-success">91%</h2>
                </div>
                <div class="card-body">
                  <h4 class="text-muted">支持度</h4>
                  <div style="height:.75rem" class="bg-secondary">
                    <div style="height:100%;width:90%" class="bg-success" title="91%"></div>
                  </div>
                </div>
                <div class="card-body">
                  <h4 class="text-muted">置信度</h4>
                  <div style="height:.75rem" class="bg-secondary">
                    <div style="height:100%;width:98%" class="bg-success" title="98%"></div>
                  </div>
                </div>
                <div class="card-body">
                  <h4 class="text-muted">提升度</h4>
                  <div style="height:.75rem" class="bg-secondary">
                    <div style="height:100%;width:60%" class="bg-warning" title="60%"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
  </main-layout>
</template>

<script>
import mainLayout from '@/views/layout/MainLayout.vue'
export default {
    components: {
        mainLayout
    }
}
</script>

<style lang="less" scoped>
@import "../../assets/less/views/pages/ComparePage.less";

</style>
