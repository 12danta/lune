<template>
    <div class="memu">
        <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
            点我打开
        </el-button>

        <el-drawer
            :append-to-body="true"
            :modal-append-to-body="false"
            title="我是标题"
            :visible.sync="drawer"
            :direction="direction"
            :before-close="handleDrawClose">
            <span>我来啦!</span>
        </el-drawer>
    </div>
</template>

<script>
export default {
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
    width: 200px;
    float: left;
}

</style>
