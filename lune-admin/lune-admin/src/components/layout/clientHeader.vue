<template>
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

<style scoped>

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

</style>
