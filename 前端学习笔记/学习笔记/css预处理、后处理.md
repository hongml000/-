# css预处理器
## 定义
CSS预处理器定义了一种新的语言，其基本思想是，用一种专门的编程语言，为CSS增加了一些编程的特性，将CSS作为目标生成文件，然后开发者就只要使用这种语言进行编码工作。通俗的说，CSS预处理器用一种专门的编程语言，进行Web页面样式设计，然后再编译成正常的CSS文件

## 优缺点
提供CSS层缺失的样式层复用机制
减少冗余代码
提高样式代码的可维护性
优点：语言级逻辑处理，动态特性，改善项目结构 
缺点：采用特殊语法，框架耦合度高，复杂度高

## 分类
Sass（SCSS）、LESS、Stylus、Turbine、Swithch CSS、CSS Cacheer、DT CSS

### Sass（SCSS）
标准的 CSS 语法，默认的扩展名.sass,包含花括号和分号

1. 基本写法
```scss
/* 一般写法，推荐使用 */
h1 {
  color: #0982c1;
}

/* 同时也支持老式的写法，不包含花括号和分号 */
h1
  color: #0982c1
```

2. 支持定义变量，以$开头定义变量
```scss
$bgcolor: #0982c1;
body {
  color: $bgcolor;
  boder: 1px solid $bgcolor;
}
```

3. 支持嵌套写法
```scss
body {
  h1 {
    color: red;
  }
  div {
    span {
      color: yellow;
    }
  }
}
```

4. Mixins 混入
Mixins有点像是函数或者宏，当css经常需要在多个元素中使用时，可以为这些共用的css定义一个mixin，然后引用时调用mixin即可
```scss
@mixin error($borderWidth: 2px) {
  border: $borderWidth solid #F00;
  color: #F00;
}
.generic-error {
  padding: 20px;
  margin: 4px;
  @include error(); /* Applies styles from mixin error */
}
.login-error {
  left: 12px;
  position: absolute;s
  top: 20px;
  @include error(5px); /* Applies styles from mixin error with argument $borderWidth equal to 5px*/
}
```

5. 继承
```scss
/* 日常写法 */
.p, .div, .h1 {
  margin: 0;
}

/* sass写法 */
.div {
  margin: 0;
}
.p {
  @extend .div;
  border: 1px solid #888;
}
.h1 {
  @extend .p;
}
```

6. import 样式文件
```scss
/* reset.css */
body {
  background: #eee;
}
/* main.css */
@ import "reset.css"
p {
  height: 100px;
}
/* main.css最终效果 */
body {
  background: #eee;
}
p {
  height: 100px;
}
```

7. 运算符
你可以直接在 CSS 预处理器中进行样式的计算，例如：
```scss
/* reset.css */
body {
  margin: (14px/2);
  top: 50px + 100px;
  right: 100px - 50px;
  left: 10 * 10;
}
```

# 预处理的应用
一些跟具体浏览器相关的处理，这样可以节省的大量的时间和汗水创。建一个mixin来处理不同浏览器的CSS写法是很简单的，节省了大量的重复工作和痛苦的代码编辑。
```scss

@mixin border-radius($values) {
  -webkit-border-radius: $values;
     -moz-border-radius: $values;
          border-radius: $values;
}

div {
  @include border-radius(10px);
}
```

# CSS 后处理器
CSS 后处理器 是对 CSS 进行处理，并最终生成 CSS 的 预处理器，它属于广义上的 CSS 预处理器