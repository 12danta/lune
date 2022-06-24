<template>
  <div class="footerBox">
    <div class="copyright">Copyright© 2022 Lune</div>
    <div class="legalBox">
      <ul class="legalList">
        <li>Websites Privacy Notice</li>
        <li>|</li>
        <li>Cookies</li>
        <li>|</li>
        <li>Legal</li>
        <li>|</li>
        <li>Contact Us</li>
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
</style>
