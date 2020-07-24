# css3常用的动画属性说明
## transform属性
1. 旋转
rotate以中心点来旋转的
* rotate(90deg) 实现旋转角度，支持负值
* rotateX(90deg) 以x轴为中心旋转
* rotateY(90deg) 以y轴为中心旋转

2. 移动
* translate(x,y)  实现2d转换，即x轴和y轴上的移动
* translateX(x)
* translateY(y)
* translate3d(x,y,z) 实现3d转换，即x轴和y轴、z轴上的移动

3. 缩放
scale是以中心点来缩放的
* scale(x,y)  2d缩放，x和y轴上的缩放

4. 兼容性
* 默认支持：ie10, firefox, opera
* ie9: -ms-transform,只支持2d
* safari和chrome: -webkit-transfrom,支持3d和2d
* opera: 只支持2d

```css
div {
  height: 100px;
  width: 100px;
  transform: rotate(90deg);
}
```

## transition 属性
transition: transition-property transition-duration transition-timing-function transition-delay

```html
<div></div>
<style>
div {
  height: 100px;
  width: 100px;
  transition: width 2s ease 0;
}
div:hover {
  width: 200px;
}
</style>

```
### 各属性意义
* transition-property 定义要变动的属性名，如果没有, 默认all
* transition-duration 定义动画时间 
* transition-timing-duration 定义动画速率方法
  1. linear 匀速
  2. ease 慢速开始，然后变快，再慢速结束
  3. ease-in 慢速开始的过渡
  4. ease-out 慢速结束
  5. ease-in-out 慢速开始和结束
  6. cubic-bezier(n,n,n,n) 自定义速度，n在0-1之间

* transition-delay 延迟动画

### 兼容性
默认： ie10, firefox, opera, chrome
firefox4: -moz-transition
safari chrome: -webkit-transition
opera: -o-transition  


## animation 
animation: name duration timing-function delay iteration-count direction;  

6个属性：  
* animation-name 绑定的keyframe名称
* animation-duraton 整个动画完成的时间
* animation-timing-function 动画执行的时间函数
* animation-delay 动画延迟时间
* animation-iteration-count 动画执行的次数
* animation-direction 动画是否轮流反向播放动画
* animation-play-state 规定动画是正在运行还是暂停 running, paused
* animation-fill-mode 规定动画时间之外的状态: none,forwards保持最后一个属性, backwards动画前应用开始属性, both

### steps函数，可以让动画不连续
steps指逐步运动，一般有两个参数
steps(number, position)
number: 表示把用户设置的每一段，各分为number段
position: 表示开始时，就所在的位置，但不显示，直接到下一阶段定义的位置，比如start，表示不显示第一段，直接显示第二段
```
div {
  animation: move 3s infinite steps(3,start)
}
@keyframe move {
  0% { left: 0; }
  50% { left: 20px; }
  100% { left: 40px; }
}
```
这里表示，第0-50%分为3段(16% 33% 50%)，50%-100%分为3段（66% 88% 100%）,start开始的位置就是33%