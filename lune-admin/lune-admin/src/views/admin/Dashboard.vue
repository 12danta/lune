<template>
<div>
<div>
  <el-row :gutter="40">
  <el-col :span="8">
    <div class="grid-content bg-purple">
      <div class="stats-content">
        <div class="stats-name">user count</div>
        <div class="stats-data">{{user_count}}</div>
      </div>
    </div>
  </el-col>
  <el-col :span="8">
    <div class="grid-content bg-purple">
      <div class="stats-content">
        <div class="stats-name">piece count</div>
        <div class="stats-data">{{piece_count}}</div>
      </div>
    </div>
  </el-col>
  <el-col :span="8">
    <div class="grid-content bg-purple">
      <div class="stats-content">
        <div class="stats-name">sheet count</div>
        <div class="stats-data">{{sheet_count}}</div>
      </div>
    </div>
  </el-col>

</el-row>
</div>
<div>
  <el-row :gutter="30">
  <el-col :span="24">
    <div class="cav-info box" >
      <div id="container" ref = 'aaa' ></div>
    </div></el-col>
</el-row>
</div>
<div>
  <el-row :gutter="20">
  <el-col :span="12"><div class="grid-bottom bg-purple" ref="bbb"></div></el-col>
  <el-col :span="12"><div class="grid-bottom bg-purple" ref="ccc"></div></el-col>
</el-row>
</div>
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
          text: 'Flow Statistic'
        },
        toolbox: {
          right: '20',
          feature: {
            dataZoom: {
              yAxisIndex: 'none'
            },
            restore: {},
            saveAsImage: {}
          }
        },
        grid: {
          x: 40,
          y: 30,
          x2: 30,
          y2: 100,
          borderWidth: 1
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          // data: this.date
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
      },
      second_option: {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1048, name: 'Search Engine' },
              { value: 735, name: 'Direct' },
              { value: 580, name: 'Email' },
              { value: 484, name: 'Union Ads' },
              { value: 300, name: 'Video Ads' }
            ]
          }
        ]
      },
      third_option: {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1048, name: 'Search Engine' },
              { value: 735, name: 'Direct' },
              { value: 580, name: 'Email' },
              { value: 484, name: 'Union Ads' },
              { value: 300, name: 'Video Ads' }
            ]
          }
        ]
      },

      user_count: 2415,
      piece_count: 410,
      sheet_count: 378

    }
  },
  computed: {
    datas () {
      let base = +new Date(1968, 9, 3)
      let oneDay = 24 * 3600 * 1000
      let date = []
      let datas = [Math.random() * 300]
      for (let i = 1; i < 20000; i++) {
        var now = new Date((base += oneDay))
        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'))
        datas.push(Math.round((Math.random() - 0.5) * 20 + datas[i - 1]))
      }
      return datas
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

    const dom2 = this.$refs.bbb
    const myCharts2 = echarts.init(dom2)
    myCharts2.setOption(this.second_option)

    const dom3 = this.$refs.ccc
    const myCharts3 = echarts.init(dom3)
    myCharts3.setOption(this.third_option)
  }
}
</script>
<style>

#container{
    display: flex;
    width: 90%;
    margin: auto;
    justify-content:center;
    height: 300px;
}
.box {
    width: 100%;
    display: flex;
    height: 350px;

}
.grid-content {
  display: flex;
  align-items: center;
  height: 100px;
}
.grid-bottom{
  display: flex;
  border-radius: 4px;
  padding-top: 15px;
  align-items: center;
  height: 280px;
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
.cav-info {
  border-radius: 6px;
  overflow: hidden;
  background-color: #d7e0ec;
}
.stats-content{
  display: inline-flex;
    margin: 2px 50px;
    height: 60px;
    width: 300px;
}
.stats-name{

    width: 100px;
    height: 30px;
    margin-left: 10px;
    margin-top: 20px;
    color:#ebeef3;
    font-weight: 700;

}
.stats-data{

    font-size: 200%;
    width: 100px;
    height: 50px;
    margin-left: 25px;
    margin-top: 5px;
    color: #9da1a7;
    font-weight: 800;
}
</style>
