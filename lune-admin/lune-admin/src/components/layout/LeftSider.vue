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
            :with-header="false"
            size = "80%">
            <div class="esc_btn">
                <li class="iconfont icon-esc menu_btn" @click="drawer = false" style="list-style:none;margin-left: 16px;"></li>
            </div>
            <div class="search">
                <search></search>
            </div>

            <div class="menu_box" style="clear:both;">
              <el-row class="titleBox">
                <el-col :span="3"><div class="title-content"></div></el-col>
                <el-col :span="6"><div class="title-content">Type</div></el-col>
                <el-col :span="6"><div class="title-content">Instrument</div></el-col>
                <el-col :span="6"><div class="title-content">Period</div></el-col>
                <el-col :span="3"><div class="title-content"></div></el-col>
                </el-row>
                <el-row class="tag-content tag-row">
                  <el-col :span="3"><div class="title-content"></div></el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Symphony</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Violin</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Baroque</a>
                    </router-link>
                  </el-col>
                  <el-col :span="3"></el-col>
                </el-row>
                <el-row class="tag-content tag-row">
                  <el-col :span="3" class="title-content"></el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Concerto</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Piano</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Classical</a>
                    </router-link>
                  </el-col>
                  <el-col :span="3"></el-col>
                </el-row>
                <el-row class="tag-content tag-row">
                  <el-col :span="3" class="title-content"></el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Sonata</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Piano</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Romantic</a>
                    </router-link>
                  </el-col>
                  <el-col :span="3"></el-col>
                </el-row>
                <el-row class="tag-content tag-row">
                  <el-col :span="3" class="title-content"></el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Quarte & Quintet</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Percussion</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>20th and 21st Century</a>
                    </router-link>
                  </el-col>
                </el-row>

                <el-row class="tag-content tag-row">
                  <el-col :span="3" class="title-content"></el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Waltz</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Woodwinds</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6"><div></div></el-col>
                  <el-col :span="3"></el-col>
                </el-row>
                <el-row class="tag-content tag-row">
                  <el-col :span="3" class="title-content"></el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Others</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Brass</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6"><div></div></el-col>
                  <el-col :span="3"></el-col>
                </el-row>
                <el-row class="tag-content tag-row">
                  <el-col :span="3" class="title-content"></el-col>
                  <el-col :span="6" class="title-content"><div></div></el-col>
                  <el-col :span="6">
                    <router-link to="/music_profile">
                      <a>Others</a>
                    </router-link>
                  </el-col>
                  <el-col :span="6"><div></div></el-col>
                  <el-col :span="3"></el-col>
                </el-row>

            </div>
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
    font-weight: 800;
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
      background: #4b4954;
      font-size: 16px;

    }

.search{
    float: left;
    width: 256px;
    margin-left: 700px;
    margin-top: 20px;
}
.esc_btn{
    font-size: 170%;
    color: rgba(241, 237, 237, 0.792);
    width: 50px;
    font-weight: 800;
    margin-top: 30px;
    float: left;
}
.titleBox{
  margin-bottom: 5%;
}
 .tag-row {
    margin-bottom: 20px;
  }

  .title-content {
    color: #ffffff;
    font-size: 200%;
    font-weight: 900;
    min-height: 56px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .menu_box{

    margin-top: 10%;
    height: 60%;
  }
  .tag-content {
    color: #ffffff;
    font-size: 100%;
    font-weight: 900;
    min-height: 56px;

  }
  .menu_box a:link {text-decoration:none;color:rgb(163, 124, 196);}
  .menu_box a:hover {text-decoration:underline;color: rgb(163, 124, 196);}
  .menu_box a:active{text-decoration:none;color:#ffffff}
  .menu_box a:visited {text-decoration:none;color:#ffffff;}

</style>
