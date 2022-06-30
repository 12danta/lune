<template>
  <div>
    <video playsinline autoplay muted loop poster="..\..\assets\img\videoCover.png" id="bgvid">
        <source src="..\..\assets\video\Recordplayer1_1080p_Videvo_x264.mp4" type="video/mp4">
    </video>
    <el-container>
        <el-header>
            <div class= "header">
                <div class="header-left">
                    <left-sider></left-sider>
                    <!-- <div class="menu-btn">
                        <img height="40px" width="40px" src="../../assets/img/moon.svg"/>
                    </div> -->
                    <!--搜索框-->
                    <div class="header-search">
                        <search></search>
                    </div>

                </div>
                <div class="header-right">
                    <div class="header-user-con">
                        <!-- 用户头像 -->
                        <div class="user-avator">
                            <img :src="userPic" />
                        </div>
                        <!-- 用户名下拉菜单 -->
                        <el-dropdown class="user-name" trigger="click" @command="handleCommand" >
                            <span class="el-dropdown-link">
                                {{username}}
                                <i class="el-icon-caret-bottom"></i>
                            </span>
                            <template #dropdown>
                                <el-dropdown-menu>
                                <el-dropdown-item command="loginout">Log Out</el-dropdown-item>
                                </el-dropdown-menu>
                            </template>
                        </el-dropdown>
                    </div>
                </div>
            </div>
        </el-header>
    </el-container>
    <div class="helloFont">
        <div class="firstLine">lune</div>
        <div class="secondLine">Melody&nbsp;&nbsp;&nbsp;&nbsp;flowing&nbsp;&nbsp;&nbsp;&nbsp;like&nbsp;&nbsp;&nbsp;&nbsp;moonlight .</div>
        <el-button type="text" class="listen_btn">Litsen Now !&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>><br>____________________</el-button>

    </div>
    <div class="mainPage">
    </div>
    <div class="footer">
        <page-footer></page-footer>
    </div>
  </div>
</template>

<script>
import LeftSider from '../../components/layout/LeftSider.vue'
import pageFooter from '../../components/layout/pageFooter.vue'
import Search from '../../components/Search.vue'

export default {
  components: { pageFooter, Search, LeftSider },

  data () {
    return {
      drawer: false,
      direction: 'ltr',
      username: 'admin',
      userPic: require('@/assets/img/user.jpg'),
      nusicName: 'music'
    }
  },
  methods: {

    // 用户名下拉菜单选择事件
    handleCommand (command) {
      if (command === 'loginout') {
      }
    },
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
video#bgvid {

    position: fixed;
    top: 40%;
    left: 50%;
    bottom: 30%;
    min-width: 100%;
    min-height: 100%;
    width: auto;
    height: auto;
    z-index: -100;
    -ms-transform: translateX(-50%) translateY(-50%);
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
    background: url(..\..\assets\img\videoCover.png) no-repeat;
    background-size: cover;
}
.video{
    height: 60%;
    width: 60%;
    margin-top: 10%;
}
header-left{
    display: inline;
    float: left;
    width: 500px;
}
.el-aside {
    line-height: 200px;
}

.header {
  position:fixed;
  margin-top: 3%;
  margin-left: -20px;
  position: absolute;
  z-index: 100;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 30px;
  color: #0f382a;
  /* //box-shadow: 0px 0px 8px 2px rgba(136, 108, 108, 0.3);
  //border-bottom: #9b9f9e; */
}
.footer{
    background-color: #4b4954;
    height: 80px;
    margin-top: 0;
    width: 100%;
    padding-top: 30px;
}
.header-search {

    margin-left: 1%;
    float: left;
    width: 20%;
}

.menu-btn{
  all:unset;
  width: 40px;
  height: 40px;
  float: left;
  cursor: pointer;
  line-height: 70px;
  margin-left: 15px;
  margin-top: 10px;
}

.header-right {
  float: right;
  padding-right: 50px;
}

.header-user-con {
  display: flex;
  height: 70px;
  align-items: center;
}

.user-name {
  margin-left: 10px;
  color: rgb(249, 241, 241);
  font-weight: 800;
  font-size: 60%;
}

.user-avator {
  margin-left: 20px;
}

.user-avator img {
  display:block;
  width: 40px;
  height: 40px;
  border-radius: 40%;
}
.icon{
  display: inline;
  width: 20px;
}
.select{
  padding-top: 10px;
}
.icon img{
  margin-left: 6px;
  margin-top: -4px;
  width: 20px;
  height: 20px;
}
.title{
  margin-left: 10px;
}
menu-btn img{
  display:block;
  width:20px;
  height: 20px;
}
.mainPage{
    width: 100%;
    opacity: 90%;
    height: 800px;
    margin-top: 20%;
    background-color: rgb(255, 255, 255);
    color: white;
}
.helloFont{
    width: 600px;
    height: 200px;
    margin-top: 15%;
    margin-left: 15%;
}
.firstLine{
    display:inline;
    color: #837f99;
    font-size: 700%;
    font-weight:bolder;
    width: 200px;
}
.secondLine{
    margin-left: 2%;
    display:inline;
    color: #4b4954;
    font-size: 80%;
    font-weight: 600;
}
.listen_btn{
    font-size: 150%;
    font-weight: 700;
    margin-top: 3%;
    height: 25px;
    text-align: left;
    color:  rgb(59, 37, 71);
    line-height: 10px;
}
.line{
    height: 2px;
    width: 200px;
    margin-left: 0px;
    background-color: rgb(100, 58, 125);
}
.listen_btn:hover {
  color: rgb(201, 197, 197);
}

.listen_btn:focus{
    color:  rgb(59, 37, 71);
}
</style>
