<template>
  <div class="container">
    <!--音频title-->
    <el-row :gutter="20" class="multimediaTitle">
        <el-col :span="16"><div class="grid-content">Audio</div></el-col>
    </el-row>
    <!--音频-->
    <el-row :gutter="20">
        <el-col :span="6">
          <div class="audioContainer">
            <el-card class="box-card" shadow="hover">
            </el-card>
            <div class="performerLink">
            <template>
              <span v-for="item in audioPerformers"
                  :key="item.audioPerformer">
                  <router-link to="/composer_profile">
                          <a>{{item.audioPerformer}}&nbsp;,</a>
                  </router-link>
              </span>
            </template>
            </div>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="audioContainer">
            <el-card class="box-card" shadow="hover">
            </el-card>
            <div class="performerLink">
            <template>
              <span v-for="item in audioPerformers"
                  :key="item.audioPerformer">
                  <router-link to="/composer_profile">
                          <a>{{item.audioPerformer}}&nbsp;,</a>
                  </router-link>
              </span>
            </template>
            </div>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="audioContainer">
            <el-card class="box-card" shadow="hover">
            </el-card>
            <div class="performerLink">
            <template>
              <span v-for="item in audioPerformers"
                  :key="item.audioPerformer">
                  <router-link to="/composer_profile">
                          <a>{{item.audioPerformer}}&nbsp;,</a>
                  </router-link>
              </span>
            </template>
            </div>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="audioContainer">
            <el-card class="box-card" shadow="hover">
            </el-card>
            <div class="performerLink">
            <template>
              <span v-for="item in audioPerformers"
                  :key="item.audioPerformer">
                  <router-link to="/composer_profile">
                          <a>{{item.audioPerformer}}&nbsp;,</a>
                  </router-link>
              </span>
            </template>
            </div>
          </div>
        </el-col>
    </el-row>
    <!--视频title-->
    <el-row :gutter="20" class="multimediaTitle">
        <el-col :span="16"><div class="grid-content">Video</div></el-col>
    </el-row>
    <!--视频-->
    <el-row :gutter="20" >
        <el-col :span="6"><div class="videoContainer bg-purple"></div></el-col>
        <el-col :span="6"><div class="videoContainer bg-purple"></div></el-col>
        <el-col :span="6"><div class="videoContainer bg-purple"></div></el-col>
    </el-row>
    <!--乐谱title-->
    <el-row :gutter="20" class="multimediaTitle">
        <el-col :span="16"><div class="grid-content">Sheet</div></el-col>
    </el-row>
    <!--乐谱-->
    <el-row :gutter="20">
        <el-col :span="6"><div class="sheetContainer bg-purple"></div></el-col>
        <el-col :span="6"><div class="sheetContainer bg-purple"></div></el-col>
        <el-col :span="6"><div class="sheetContainer bg-purple"></div></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data () {
    return {

      audioId: '',
      audioLink: '',
      audioPerformers: [
        {audioPerformer: 'mozart'},
        {audioPerformer: 'mozart'},
        {audioPerformer: 'mozart'}
      ]
    }
  }

}
</script>

<style scope>
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .container{
    height: 80%;
    width: 80%;
    margin-top: 5%;
    margin-left: 5%;
  }
  .multimediaTitle{
    color: #1d4274;
    font-weight: 900;
  }
  .audioContainer{
    padding-top: 15px;
    padding-left: 20px;
    border-radius: 4px;
    min-height: 120px;

  }
  .videoContainer{
    border-radius: 4px;
    min-height: 120px;
    background: #d3dce6;
  }
  .sheetContainer{
    border-radius: 4px;
    min-height: 66px;
    background: #d3dce6;
  }

  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 200px;
    background-color: #e8e3ea;
  }
  .performerLink {
    width: 200px;
    margin-top: 10px;
  }
  .performerLink a:link {
    color:rgb(99, 75, 120);
    }
  .performerLink a:hover {
    color: rgb(163, 124, 196);
    }
  .performerLink a:active {
    color:#250a3a
    }
  .performerLink :visited {
    color:#290436;
    }

</style>
