<template>
<div>
<div>
  <el-row :gutter="20">
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
</el-row>
</div>
<div>
  <el-row :gutter="20">
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
</el-row>
</div>
<div id="container" ref = 'aaa'></div>
</div>

</template>
<script>
import * as echarts from 'echarts'
export default{
  data () {
    return {
      Option: {
        tooltip: {
          trigger: 'axis',
          position: function (pt) {
            return [pt[0], '10%']
          }
        },
        title: {
          left: 'center',
          text: 'Large Area Chart'
        },
        toolbox: {
          feature: {
            dataZoom: {
              yAxisIndex: 'none'
            },
            restore: {},
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          //   data: this.date
          data: ['1968/10/4', '1968/10/5', '1968/10/6', '1968/10/7', '1968/10/8', '1968/10/9', '1968/10/10', '1968/10/11', '1968/10/12']

        },
        yAxis: {
          type: 'value',
          boundaryGap: [0, '100%']
        },
        dataZoom: [
          {
            type: 'inside',
            start: 0,
            end: 10
          },
          {
            start: 0,
            end: 10
          }
        ],
        series: [
          {
            name: 'Fake Data',
            type: 'line',
            symbol: 'none',
            sampling: 'lttb',
            itemStyle: {
              color: 'rgb(255, 70, 131)'
            },
            areaStyle: {
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                {
                  offset: 0,
                  color: 'rgb(255, 158, 68)'
                },
                {
                  offset: 1,
                  color: 'rgb(255, 70, 131)'
                }
              ])
            },
            // data: this.datas
            data: [47.51675878445181, 57, 55, 55, 50, 43, 53, 44, 45, 40, 50, 50, 50, 40, 44, 42, 39, 33, 29]
          }
        ]
      }

    }
  },
  computed: {
    datas () {
      let base = +new Date(1968, 9, 3)
      let oneDay = 24 * 3600 * 1000
      let date = []
      let data = [Math.random() * 300]
      for (let i = 1; i < 20000; i++) {
        var now = new Date((base += oneDay))
        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'))
        data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]))
      }
      return data
    },
    date () {
      let base = +new Date(1968, 9, 3)
      let oneDay = 24 * 3600 * 1000
      let date = []
      //   let data = [Math.random() * 300]
      for (let i = 1; i < 20000; i++) {
        var now = new Date((base += oneDay))
        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'))
        // data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]))
      }
      return date
    }
  },
  mounted () {
    const dom = this.$refs.aaa
    const myCharts = echarts.init(dom)
    myCharts.setOption(this.Option)
    console.log(this.datas, this.date)
  }
}
</script>
<style>
#container{
    width: 1000px;
    height: 500px;
}
.grid-content {
  display: flex;
  align-items: center;
  height: 100px;
}
.el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
