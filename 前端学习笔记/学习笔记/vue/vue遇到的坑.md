# computed 里function不能直接传参

computed里，属性方法是不能直接传参的，否则参数都会以vue对象显示，达不到想要的目的
```html
<!-- 实现的功能: 类是由参数动态加载 -->
<template>
  <div :class="change(a)"></div>
</template>
<script>
  data() {
    return {
      a: 'red',
    }
  },
  computed: {
    // 读参异常，直接写上参数的话，a,b所有参数都会显示为vueComponent对象
    add(a) {
      return a === 'red' ? 'red' : 'yellow'
    }
  }
</script>  
<style>
.red {
  color: red;
}
.yellow {
  color: yellow;
}
</style>

<!-- 解决方法有2种： -->
<!-- 第一种，将方法改写到methods中,可以实现，但这种方法起不到缓存的作用 -->
<script>
  data() {
    return {
      a: 10,
    }
  },
  methods: {
    // 读参异常，直接写上参数的话，所有参数(这里是a参数)都会显示为vueComponent对象
    add(a) {
      return a === 'red' ? 'red' : 'yellow'
    }
  }
</script>  

<!-- 第二种，computed里使用闭包，既可以实现传参，又可实现computed缓存作用 -->
<script>
  data() {
    return {
      a: 10,
    }
  },
  computed: {
    // 读参异常，直接写上参数的话，a,b所有参数都会显示为vueComponent对象
    add() {
      return function(a) {
        return a === 'red' ? 'red' : 'yellow'
      }
    }
  }
</script>  

```


# vue规范
props传参时，要写类型和默认值
```js
props: ['content']

// >>>
props: {
  content: {
    type: String,
    default: ''
  }
}

```