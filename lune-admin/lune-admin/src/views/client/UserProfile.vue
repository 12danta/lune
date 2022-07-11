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
                    <div class="name">{{name}}</div>
                    <div class="introduction">{{introduction}}</div>
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
  components: { clientHeader, PageFooter },
  data () {
    return {
      name: 'Chloe',
      introduction: 'welcome to here, nice to meet you !'
    }
  }
}
</script>

<style scope>

.profile_header{

    padding-top: 15px;
    height: 80px;
    background-color: rgb(86, 69, 89);
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
  background: rgba(0, 0, 0, 0.537);
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
    margin-top: 70px;
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
.name{
    text-align:center;
    width: 15%;
    height: 10;
    z-index: 1;
    position: relative;
    margin-top: 20px;
    margin-left: 41%;
    color: rgba(247, 247, 247, 0.79);
    font-weight: 900;
}
.introduction {
    color: rgba(247, 247, 247, 0.79);
    font-weight: 500;
    text-align: center;
    z-index: 1;
    position: relative;
    margin-left: 20%;
    margin-top: 30px;
    width: 60%;
    height: 20%;
}
</style>
