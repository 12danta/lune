<template>
  <div>
      <audio controls ref="singeBox"></audio>
  </div>

</template>

<script>
export default {
  data () {
    return {
      box: undefined,
      musicPath: '******', // mp3链接
      coverPath: '******', // 封面
      musicTitle: '', // 当前播放标题
      musicImg: '', //  当前播放封面
      list: [ // 数据格式
      ]
    }
  },
  methods: {
    init () {
      this.box = this.$refs.singeBox
      this.box.src = this.list[0].url // 歌曲链接
      // 绑定三个触发方法
      // 当时长有变化时触发，由"NaN"变为实际时长也算
      this.box.ondurationchange = function () {
        console.log('时长发生了变化')
      }
      // 当前数据可用是触发
      this.box.oncanplay = function () {
        console.log('已经可以播放了')
      }
      // 播放位置发送改变时触发。
      this.box.ontimeupdate = function () {
        console.log('播放位置发送了变动')
      }
      // 音频播放完毕
      this.box.onended = function () {
        console.log('播放完毕，谢谢收听')
      }
      // 音频播放完毕
      this.box.onerror = function () {
        console.log('加载出错！')
      }
    }
  },
  mounted () {
    this.init()
  }
}
</script>

<style>
</style>
