<template>
  <div id="app">
    <div class="video-content">
      <player-video :src="src" ref="video" onloadstart="this.volume=0.2"></player-video>
    </div>
  </div>
</template>
<script>
import PlayerVideo from '../../components/playVideo.vue'
export default {
  components: {
    PlayerVideo
  },
  data () {
    return {
      volume: 0.2,
      src: 'http://vjs.zencdn.net/v/oceans.mp4'
    }
  },
  computed: {
    video () {
      return this.$refs.video
    }
  },
  methods: {
    // 父类组件调用子组件方法，触发播放器功能
    stopVideo () {
      this.video.stop()
    },
    playVideo () {
      this.video.play()
    },
    reloadVideo () {
      this.video.reload()
    },
    forwardVideo () {
      this.video.forward()
    },
    backVideo () {
      this.video.back()
    },
    fullScreenVideo () {
      this.video.fullScreen()
    },
    screenVideo () {
      this.video.exitScreen()
    },
    volumeUpVideo () {
      this.video.volumeUp()
    },
    volumeDownVideo () {
      this.video.volumeDown()
    },
    beforeCreate () {
      this.volume = window.localStorage.volume
    },
    toggleToFenghuangwang () {
      this.video.toggleTv({
        src: {
          type: 'application/x-mpegURL',
          src: 'https://playtv-live.ifeng.com/live/06OLEGEGM4G.m3u8'
        },
        load: 'https://playtv-live.ifeng.com/live/06OLEGEGM4G.m3u8'
      })
    },
    toggleToDefault () {
      this.video.toggleTv({
        src: {
          type: 'video/mp4',
          src: 'http://vjs.zencdn.net/v/oceans.mp4'
        },
        load: 'http://vjs.zencdn.net/v/oceans.mp4'
      })
    }
  }
}

</script>
<style lang="scss">
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;

    .video-content {
      display: flex;
      justify-content: center;
      flex-direction: column;
      align-items: center;
    }
  }
</style>
