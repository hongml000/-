# 发送请求的写法
## 在api中定义请求url和参数
```js
// @/api/overview/overvies.js
import request from '@/utils/request'
export function getList(params) {
  return request({
    url: 'xxx',
    methods: 'get',
    params
  })
export function getPostData(params) {
  return request({
    url: 'xxx',
    methods: 'post',
    data: params
  })
}
```

## 在对应的.vue中（一个页面中多个组件一般都由index.vue定义）增加请求逻辑
```html
<template>
  <div>{{ channelCount }} </div>
</template>
<script>
  import { getList } from '@/api/overview/overvies.js'
  export default {
    name: 'modelName',
    data () {
      return {
        channelCount: 2,
        data: { 
          "name": "Lee"
          }
        // ...
      }
    },
    methods: {
      fetchData () {
        getList().then( res => {
          consolo.log(res.data);
          this.channelCount = res.data.channelCount;
        }).catch( err => {
          console.log(error);
        })
        getPostData(this.data).then( res => {
          consolo.log(res.data);
        }).catch( err => {
          console.log(error);
        })      
      }
    },
    created() {
      this.fetchData();
    }
  }
</script>
```