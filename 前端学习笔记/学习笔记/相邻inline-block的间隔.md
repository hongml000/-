# inline-block
inline-block 后的元素创建了一个行级的块容器，该元素内部（内容）被格式化成一个块元素，同时元素本身则被格式化成一个行内元素。

## 相邻inline-block（span）间隔产生的原因
而西方的文字有空格作为词分界，而中文则没有，一般会默认行内元素有空隔符隔开
I am still a baby
我还是一个宝宝

## 解决方案

1. 改变代码书写方式   
比如在中间增加空注释，但这种方法来书写
```html
<ul>
    <li>控球后卫</li><!--
    --><li>得分后卫</li><!--
    --><li>小前锋</li><!--
    --><li>大前锋</li><!--
    --><li>中锋</li>
</ul>
```

2. 改变字符大小  
推荐使用，能解决大部分这类问题
```css
.parent {
  font-size: 0px;
}
```

3. 改变元素间隔，使用负边距  
但不同的字体的大小不一致，所以不好掌控
```css
.parent {
  margin-left: -140px;
}
```

4. 改变字符间距  
不太推荐  
letter-spacing子元素要设置letter-spacing为0，不然会继承父元素的值；使用word-spacing时，只需设置父元素word-spacing为合适值即可
使用letter-spacing和word-spacing时，其在不同浏览器下效果不同

5. 改变元素显示类型
```js
// span标签
display: inline-block;
```