<template>
    <section class="city-search">
        <li class="iconfont icon-fenxiang searchIcon" name = "search" style="list-style:none;"></li>
        <input  placeholder="" v-model="KeyWord">
    </section>

</template>

<script>
export default {
  data () {
    return {
      KeyWord: ''
    }
  },

  methods: {
    clearSearchInput () {
      this.KeyWord = ''
    }
  }

}
</script>

<style scope>
.city-search {

    border: 2px solid rgba(241, 237, 237, 0.792);
    background-color: #f7f8fa00;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    height: 2.3rem;
    width: 250px;
    margin-top: 15px;
    border-radius: 8px;
}
.search-icon {
    margin-left: 5px;
}
input {
    background-color: rgba(246, 246, 246, 0);
    color: rgb(246, 247, 248);
    outline:none;
    margin: 0 1.5vw;
    border: 0px;
    width: 200px;
    font-size: 14px;
    flex: 1
}
.clear-icon {
    color: #999;
}
::-webkit-input-placeholder{
  color: rgb(253, 250, 250);
  font-size: 110%;
}
.searchIcon{
  color: rgba(241, 237, 237, 0.792);
  font-weight: 600;
  margin-left: 10px;
}

</style>
