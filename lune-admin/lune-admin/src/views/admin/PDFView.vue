<template>
  <div class="page">
    <div class="pageHeader">
       <el-button @click.stop="prePage">上一页</el-button>
       <el-button @click.stop="nextPage">下一页</el-button>
       <div class="pageNum">{{pageNum}}/{{pageTotalNum}}</div>
    </div>
    <div class = "parent">
      <div class="left">
          <div class="el-icon-arrow-left" @click.stop="prePage" style="font-size:50px ;color: rgb(210, 241, 230);" ></div>
      </div>
      <div class="pdfPage">
        <pdf ref = "pdf"
        :src="url"
        :page="pageNum"
        @progress="loadedRatio = $event"
        @num-pages="pageTotalNum=$event"
        @error="pdfError($event)"
        @link-clicked="page = $event">
      </pdf>
      </div>
      <div class = "right">
        <div class="el-icon-arrow-right" @click.stop="nextPage" style="font-size:50px;color: rgb(210, 241, 230);"></div>
        </div>
    </div>
  </div>
</template>

<script>

import pdf from 'vue-pdf'
export default {
  components: {
    pdf
  },
  data () {
    return {
      url: 'http://storage.xuetangx.com/public_assets/xuetangx/PDF/PlayerAPI_v1.0.6.pdf',
      pageNum: 1,
      pageTotalNum: 1,
      pageRotate: 0,
      // 加载进度
      loadedRatio: 0,
      curPageNum: 0
    }
  },
  mounted: function () {},
  methods: {
    // 上一页函数，
    prePage () {
      var page = this.pageNum
      page = page > 1 ? page - 1 : this.pageTotalNum
      this.pageNum = page
    },
    // 下一页函数
    nextPage () {
      var page = this.pageNum
      page = page < this.pageTotalNum ? page + 1 : 1
      this.pageNum = page
    },
    // 页面加载回调函数，其中e为当前页数
    pageLoaded (e) {
      this.curPageNum = e
    }
  }

}
</script>

<style scope>
.page{

}
.parent {
  display: flex;
}
.pdfPage{
  box-shadow: 0 4px 8px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 50%;
  margin-left: 10%;
}
.pageHeader {

  height: 10%;
  margin-top: 30px;
  width:20%;
  margin-left: 45%;
}
.pageNum{
  margin-top: 10px;
  margin-left: 70px;
  width: 10%;
}
.left {
  margin-top: 25%;
  margin-left: 10%;
  width: 100px;
  height: 100px;
}
.right {
  width:100px;
  margin-top: 25%;
  height: 100px;
  margin-left: 10%;

}

</style>
