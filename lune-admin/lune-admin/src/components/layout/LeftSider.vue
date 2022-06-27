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
            :before-close="handleDrawClose"
            size = "80%">
            <search></search>
            <span>我来啦!</span>
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
    handleDrawClose (done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    }
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
      background: rgba(7, 18, 26, 0.8);
      font-size: 16px;

    }

</style>
