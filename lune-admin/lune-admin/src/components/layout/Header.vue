<template>
<el-container>
  <el-header>
    <div class= "header">
      <div class="menu-btn" @click="handleCollapse">
        <img height="40px" width="40px" src="../../assets/img/moon.svg"/>
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
  <!-- 侧边栏 -->
  <el-container style="display:flex">
    <el-aside style="overflow: hidden" v-bind:style="{width:isCollapse ? '64px':'200px'}">
      <el-menu  :collapse="isCollapse"  @select="handleSelect" :default-active="activeIndex"  style="margin-top:10px">
        <el-menu-item index="/dashboard">
          <li class="iconfont icon-dashboard icon"></li>
          <span slot="title" class="title">Dashboard</span>
        </el-menu-item>
        <el-menu-item index="/music">
          <li class="iconfont icon-music icon"></li>
          <span slot="title" class="title">Music Manage</span>
        </el-menu-item>

        <el-menu-item index="/users">
          <li class="iconfont icon-user icon"></li>
          <span slot="title" class="title">User Manage</span>
        </el-menu-item>
        <el-menu-item index="/performer">
          <li class="iconfont icon-piano icon"></li>
          <span slot="title" class="title">Performer Manage</span>
        </el-menu-item>
        <el-menu-item index="/composer">
          <li class="iconfont icon-line-quillpenyumaobi icon"></li>
          <span slot="title" class="title">Composer Manage</span>
        </el-menu-item>
        <el-menu-item index="/album">
          <li class="iconfont icon-album icon"></li>
          <span slot="title" class="title">Album Manage</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main style="flex:1 ;background:rgb(231, 236, 235); margin-top:10px" >
      <div>
        <router-view/>
      </div>
    </el-main>
  </el-container>
</el-container>
</template>

<script>

export default {
  data () {
    return {
      activeIndex: '/dashboard',
      isCollapse: false,
      username: 'admin',
      userPic: require('@/assets/img/user.jpg'),
      nusicName: 'music'
    }
  },
  mounted () {
    this.activeIndex = this.handleSelect()
  },
  methods: {
    // 用户名下拉菜单选择事件
    // 侧边栏折叠
    handleCollapse () {
      this.isCollapse = !this.isCollapse
    },
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
      // this.activeIndex = keyPath[0]
      console.log(this.activeIndex)
      this.$router.push(key)
      return key

      // return keyPath[0]
    },
    // 用户名下拉菜单选择事件
    handleCommand (command) {
      if (command === 'loginout') {
      }
    }
  }
}
</script>

<style scoped>

.el-header{
  padding: 0;
}
.el-aside {
    line-height: 200px;
}

.header {
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
</style>
