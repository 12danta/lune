<template>
  <div class= "composerWorkContainer">
    <!--popular-->
    <el-row :gutter="20" class="musicTitle">
        <el-col :span="16"><div>Audio</div></el-col>
    </el-row>
    <div>
        <el-row :gutter="20">
            <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="5" ><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="3" class="more_btn_container">
                <div class="more_btn">
                    <router-link to="/composer_profile">
                        <a>more></a>
                    </router-link>
                </div>
            </el-col>
        </el-row>
    </div>
    <el-divider></el-divider>
    <!--piece-->
    <el-row :gutter="20" class="musicTitle">
        <el-col :span="16"><div>Audio</div></el-col>
    </el-row>
    <div>
        <el-row :gutter="20">
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="3" class="more_btn_container">
            <div class="more_btn">
                <router-link to="/composer_profile">
                    <a>more></a>
                </router-link>
            </div>
        </el-col>
        </el-row>
    </div>
    <el-divider></el-divider>
    <!--album-->
    <el-row :gutter="20" class="musicTitle">
        <el-col :span="16"><div>Audio</div></el-col>
    </el-row>
    <div>
        <el-row :gutter="20">
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="3" class="more_btn_container">
            <div class="more_btn">
                <router-link to="/composer_profile">
                    <a>more></a>
                </router-link>
            </div>
            </el-col>
        </el-row>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
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
    min-height: 196px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .composerWorkContainer{
        width: 70%;
        height: 60%;
        margin-top: 5%;
        margin-left: 10%;
  }
  .musicTitle{
    color: #737b86;
    font-weight: 600;
  }
   .more_btn_container {
    padding-left: 65px!important;
    margin-left: 40px;
    margin-top: 170px;
  }
  .more_btn{

    width: 41px;
  }
  .more_btn a:link {text-decoration:none;color:rgb(163, 124, 196);}
  .more_btn a:hover {text-decoration:underline;color: rgb(163, 124, 196);}
  .more_btn a:active{text-decoration:none;color:#ffffff}
  .more_btn a:visited {text-decoration:none;color:#505051;}
</style>
