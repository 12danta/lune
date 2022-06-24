<template>
  <div class="footerBox">
    <div class="copyright">Copyright© 2022 Lune</div>
    <div class="legalBox">
      <ul class="legalList">
        <li>Websites Privacy Notice</li>
        <li class="erect">|</li>
        <li>Cookies</li>
        <li class="erect">|</li>
        <li>Legal</li>
        <li class="erect">|</li>
        <li>Feedback</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style scope>
.footerBox{
  width: 40%;
  height: 60px;
  margin-left: 40px;
}
.legalList{
  display: flex;
  padding-left: 0;
  white-space:normal;
  flex:50px;
}
.legalList li{
  margin-right: 20px;
  list-style:none;
  cursor: pointer;
}
.copyright{
  font-size: 100%;
  color: white;
}
.legalBox{
  font-size: 100%;
  color: white;
}
.erect{
  color: rgb(160, 163, 165);
}
</style>
