<template>
<el-container>
  <el-header>
    <div class= "header">
      <div class="menu-btn" @click="handleCollapse">
        <el-icon class='el-icon-menu' ></el-icon>
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
      <el-menu  :collapse="isCollapse"  @select="handleSelect" :default-active="activeIndex">
        <el-menu-item index="/dashboard">
          <i class="el-icon-house"></i>
          <span slot="title">Dashboard</span>
        </el-menu-item>
        <el-menu-item index="/music">
          <i class="el-icon-service"></i>
          <span slot="title">music Manage</span>
        </el-menu-item>
        <el-menu-item index="/users">
          <i class="el-icon-s-custom"></i>
          <span slot="title">User Manager</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main style="flex:1">
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
  methods: {
    // 用户名下拉菜单选择事件
    // 侧边栏折叠
    handleCollapse () {
      this.isCollapse = !this.isCollapse
    },
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
      this.$router.push(key)
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
  background: #71a5a8;
  box-shadow: 0px 0px 8px 2px rgba(136, 108, 108, 0.3);
}

.menu-btn{
  all:unset;
  width: 40px;
  float: left;
  cursor: pointer;
  line-height: 70px;
  margin-left: 10px;
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
</style>
