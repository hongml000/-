# 安装
```
npm install echarts --save
```

# 全局引入
main.js
```
import echarts from 'echarts'
Vue.prototype.$echarts = echarts
```

# 组件中使用
```html
<template>
  <div>
    <div id="myChart"></div>
    <div id="map"></div>
  </div>
</template>

<script>
// 使用map必须再次引入地图，否则不显示..
import "echarts/map/js/china.js";
export default {
  name: "MyChart",
  components: {},
  data() {
    return {
      msg: "echart test!",
      mydata: [
        { name: "北京", value: "100" },
        { name: "天津", value: this.randomData() },
        { name: "上海", value: this.randomData() },
        { name: "重庆", value: this.randomData() },
        { name: "河北", value: this.randomData() },
        { name: "河南", value: this.randomData() },
        { name: "云南", value: this.randomData() },
        { name: "辽宁", value: this.randomData() },
        { name: "黑龙江", value: this.randomData() },
        { name: "湖南", value: this.randomData() },
        { name: "安徽", value: this.randomData() },
        { name: "山东", value: this.randomData() },
        { name: "新疆", value: this.randomData() },
        { name: "江苏", value: this.randomData() },
        { name: "浙江", value: this.randomData() },
        { name: "江西", value: this.randomData() },
        { name: "湖北", value: this.randomData() },
        { name: "广西", value: this.randomData() },
        { name: "甘肃", value: this.randomData() },
        { name: "山西", value: this.randomData() },
        { name: "内蒙古", value: this.randomData() },
        { name: "陕西", value: this.randomData() },
        { name: "吉林", value: this.randomData() },
        { name: "福建", value: this.randomData() },
        { name: "贵州", value: this.randomData() },
        { name: "广东", value: this.randomData() },
        { name: "青海", value: this.randomData() },
        { name: "西藏", value: this.randomData() },
        { name: "四川", value: this.randomData() },
        { name: "宁夏", value: this.randomData() },
        { name: "海南", value: this.randomData() },
        { name: "台湾", value: this.randomData() },
        { name: "香港", value: this.randomData() },
        { name: "澳门", value: this.randomData() }
      ]
    };
  },

  computed: {},

  methods: {
    drawCharts() {
      let mychart = this.$echarts.init(document.getElementById("myChart"));
      let m = this.$echarts.init(document.getElementById("map"));

      mychart.setOption({
        title: {
          // 标题文本
          text: "在vue-cli中使用echarts",

          // 是否显示
          // show: false
          // 链接，target为链接打开方式，默认blank，self为当前页打开，覆盖当前路由
          link: "http://www.baidu.com",
          target: "self",
          textAlign: "left",
          // 离外层容量的距离
          top: "0 ",
          left: "35%",
          // 也可以使用x来写水平上的位移,center或数值
          x: '35%',

          subtext: "subtext",
          sublink: "http://www.baidu.com",
          subtextStyle: {
            color: "red",
            fontStyle: "italic",
            fontWeight: "bold",
            fontSize: "16",
            align: "right",
            verticalAlign: "bottom",
            textBorderColor: "black"
          }
        },
        // 
        legend: {
          data: ["销量"],
          left: "right",
          top: 28
        },
        // 点击对应区域显示的提示框
        tooltip: {
          // 按条目来点击，也可以按坐标轴axis
          trigger: "item",
          // 可以自定义格式化显示文本格式，不写的话默认一般显示系统名，数据里的name和value: seriesName,name,value
          // 如果数据只有数据，则显示为 seriesName, value
          formatter: function(val) {
            console.log(val)
            return val.seriesName + ' ' + val.name + ' ' + val.value
            
          }
        },

        xAxis: {
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
        },
        yAxis: {},
        series: [
          {
            name: "销量",
            type: "bar",
            color: [
              "red",
              "yellow",
              "#61a0a8",
              "#d48265",
              "#91c7ae",
              "#749f83"
            ],
            data: [5, 20, 36, 10, 10, 20]
          }
        ]
      });
      m.setOption({
        title: {
          text: "中国地图",
          x: "center"
        },
        tooltip: {
          trigger: "item",
          formatter: function(val) {
            return val.seriesName + " " + val.name + " " + val.value;
          }
        },
        // 左侧小导航图标
        visualMap: {
          show: true,
          x: "left",
          y: "bottom",
          splitList: [
            { start: 500, end: 600 },
            { start: 400, end: 500 },
            { start: 300, end: 400 },
            { start: 200, end: 300 },
            { start: 100, end: 200 },
            { start: 0, end: 100 }
          ],
          color: [
            "#5475f5",
            "#9feaa5",
            "#85daef",
            "#74e2ca",
            "#e6ac53",
            "#9fb5ea"
          ]
        },
        series: [
          {
            name: "数据",
            type: "map",
            mapType: "china",
            data: this.mydata,
            roam: true,
            label: {
              normal: {
                show: true //省份名称
              },
              emphasis: {
                show: false
              }
            }
          }
        ]
      });
    },
    randomData() {
      return Math.round(Math.random() * 500);
    }
  },
  mounted() {
    this.drawCharts();
    console.log(this.mydata);
  }
};
</script>

<style lang="stylus" scoped>
#myChart {
  width: 500px;
  height: 500px;
}
#map{
  width: 500px;
  height: 500px;
}
</style>


```