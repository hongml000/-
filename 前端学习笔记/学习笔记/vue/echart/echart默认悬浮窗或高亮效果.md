# 默认有悬浮窗效果
```js
this.chart.setOption(option);
// 初始时，默认有悬浮窗
this.chart.dispatchAction({
  type: "showTip",  // 隐藏是 hideTip
  seriesIndex: 0, //选择第几个seriesIndex，未特殊定义的series默认下标从0开始
  dataIndex: number, // 显示第几个数据，下标从0开始，一般如果是后台获取数据，下标是不定的，这时不建议使用这个；另外，对于data里的数据，一般第一行title是默认不取的，从第二行index开始才是0
  name: string  // 后台传数据时可以用name来明确是哪个
})

// 初始时，默认高亮效果
this.chart.dispatchAction({
  type: "highlight",    // 取消高亮是 downplay
  seriesIndex: 0, //选择第几个seriesIndex，未特殊定义的series默认下标从0开始
  dataIndex: number, // 显示第几个数据，下标从0开始，一般如果是后台获取数据，下标是不定的，这时不建议使用这个
  name: string  // 后台传数据时可以用name来明确是哪个
})


```

# 自动循环遍历每个item高亮和悬浮效果
```js
let currentIndex = -1;
setTimeout(function() {
    var dataLen = gradeOption.series[0].data.length;
    // 取消之前高亮的图形
    gradeEchart.dispatchAction({
        type: 'downplay',
        seriesIndex: 0,
        dataIndex: currentIndex
    });
    currentIndex = (currentIndex + 1) % dataLen;
    // 高亮当前图形
    gradeEchart.dispatchAction({
        type: 'highlight',
        seriesIndex: 0,
        dataIndex: currentIndex
    });
}, 100);
$("#showEchart").mouseenter(function() {
    gradeEchart.dispatchAction({
        type: 'downplay',
        seriesIndex: 0,
        dataIndex: currentIndex
    });
});
$("#showEchart").mouseleave(function() {
    gradeEchart.dispatchAction({
        type: 'highlight',
        seriesIndex: 0,
        dataIndex: currentIndex
    });
});
```
官网示例：https://www.echartsjs.com/gallery/editor.html?c=doc-example/pie-highlight