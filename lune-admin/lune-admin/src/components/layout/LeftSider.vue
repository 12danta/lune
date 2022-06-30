<template>
    <div class="memu">
        <!-- <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
            点我打开
        </el-button> -->
        <li class="iconfont icon-caidan menu_btn" @click="drawer = true" style="list-style:none;margin-left: 16px;"></li>

        <el-drawer
            :wrapper-closable="true"
            :append-to-body="true"
            :modal-append-to-body="false"
            title="我是标题"
            :visible.sync="drawer"
            :direction="direction"
            :with-header="false"
            size = "80%">
            <div class="esc_btn">
                <li class="iconfont icon-esc menu_btn" @click="drawer = false" style="list-style:none;margin-left: 16px;"></li>
            </div>
            <div class="search">
                <search></search>
            </div>
            <div class="searchTitle">
                search
            </div>
            <div style="clear:both;">我来啦!</div>
        </el-drawer>
    </div>
</template>

<script>
import Search from '../Search.vue'
export default {
  components: { Search },
  data () {
    return {
      drawer: false,
      direction: 'ltr'
    }
  },
  methods: {
  }
}
</script>

<style scope>
.memu{
    width: 100px;
    margin-top: 10px;
    float: left;
}
.menu_btn{
    font-size: 150%;
    font-weight: 800;
    color: rgba(241, 237, 237, 0.792);
}
::v-deep.el-drawer__wrapper {
      z-index: -3000!important;
    }

    .el-drawer {
      position: relative;
      left: 1100px;
      top: 154px;
      padding: 0;

      height: 28.385vw;
      background: #4b4954be;
      font-size: 16px;

    }
.searchTitle{
    margin-top: 66px;
    margin-left: 20px;
    font-weight: bolder;
    float: left;
    color: rgba(241, 237, 237, 0.792);
    font-size: 160%;
    width: 100px;
    height: 50px;
}
.search{
    float: left;
    width: 256px;
    margin-left: 66px;
    margin-top: 46px;
}
.esc_btn{
    font-size: 170%;
    color: rgba(241, 237, 237, 0.792);
    width: 50px;
    font-weight: 800;
    margin-top: 55px;
    float: left;
}
</style>
