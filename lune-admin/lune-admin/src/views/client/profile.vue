<template>
    <div>
        <div class="profile_header">
            <client-header></client-header>
        </div>
        <div class="mainPage_up">
            <div class="mainHolder">
                <div class="textHolder">
                    <div class="avatar">
                        <img class = "avatar_img" src="https://s2.loli.net/2022/07/02/4QGV5nohvHiRast.png" alt="">
                    </div>
                </div>
            </div>
            <!-- <img src="https://s2.loli.net/2022/07/02/4QGV5nohvHiRast.png" alt=""> -->
        </div>
        <div class="mainPage_down"></div>
        <div class="profile_footer">
            <page-footer></page-footer>
        </div>
    </div>
</template>

<script>
import clientHeader from '../../components/layout/clientHeader.vue'
import PageFooter from '../../components/layout/pageFooter.vue'
export default {
  components: { clientHeader, PageFooter }

}
</script>

<style scope>

.profile_header{

    padding-top: 15px;
    height: 80px;
    background-color: rgba(58, 34, 63, 0.849);
}
.mainPage_up{
    width: 100%;
    height: 50%;
    background-size:cover;
}
.mainPage_down{
    width: 100%;
    height: 400px;
    background-color: white;
}
.profile_footer{
    background-color: #4b4954;
    height: 100px;
    margin-top: 0;
    width: 100%;
    padding-top: 30px;
}
* {
  box-sizing: border-box;
}
.mainHolder {
  overflow:hidden;
  width: 100%;
  height: 400px;
  background-image: url(https://s2.loli.net/2022/07/02/4QGV5nohvHiRast.png);
  background-position: center;
  background-size: cover;
  position: relative;
  filter: blur(10);
}
.textHolder {
  overflow: hidden;
  width: 100%;
  height: 700px;
  position: absolute;
  right: 0;
  top: 0;
  background: inherit;
  overflow: hidden;
}
.textHolder::before {
  overflow: hidden;
  content: '';
  position: absolute;
  top:0;
  right: 0;
  bottom: 0;
  left: 0;
  margin-top: -100px;
  background: inherit;
  -webkit-filter: blur(40px);
  filter: blur(40px);
}
.textHolder::after {
  content: "";
  position: absolute;
  top:0;
  right: 0;
  bottom: 0;
  left: 0;
  background: rgba(0, 0, 0, 0.25);
}
p {
  margin-top: 100px;
  z-index: 1;
  color: white;
  position: relative;
  margin: 0;
}
.avatar{
    margin-left: 45%;
    margin-top: 100px;
    z-index: 1;
    position: relative;
    width: 8%;
    height: 16%;

}
.avatar_img{
    width: 100%;
    height: 100%;
    border-radius: 100%;
}
</style>
