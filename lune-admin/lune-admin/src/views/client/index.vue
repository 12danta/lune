<template>
  <div>
  <video playsinline autoplay muted loop poster="..\..\assets\img\videoCover.png" id="bgvid">
    <source src="..\..\assets\video\Recordplayer1_1080p_Videvo_x264.mp4" type="video/mp4">
  </video>
  <el-container>
    <el-header>
        <div class= "header">
            <div class="header-left">
                <div class="menu-btn" @click="handleCollapse">
                    <img height="40px" width="40px" src="../../assets/img/moon.svg"/>
                </div>
                <!--搜索框-->
                <div class="header-search">
                    <input type="text" placeholder="搜索音乐" >
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
  <div class="mainPage">

  </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
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
    float: left;
    width: 500px;
}
.el-aside {
    line-height: 200px;
}

.header {
  margin-left: -20px;
  position: absolute;
  z-index: 100;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 30px;
  color: #0f382a;
  box-shadow: 0px 0px 8px 2px rgba(136, 108, 108, 0.3);
  border-bottom: #9b9f9e;
}
.header-search {
    margin-top: 1%;
    margin-left: 3%;
    float: left;
    width: 15%;
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
    margin-top: 50%;
    background-color: rgb(255, 255, 255);
    color: white;
}
</style>
