# 属性布尔值的处理
当组件里，出现默认为boolean的属性值，写上一般就默认是默认值，不写就默认没有，不用赋值  
如果一定要赋值，必须使用:v-bind方法传


```html
<!-- 比如el-form里面的“hide-required-asterisk”属性，hide-required-asterisk默认是false，如果不写，就是按默认，不隐藏必填项的星号标识 -->
<el-form 
    ref="form" 
    :model="sizeForm"
    >
<el-form>

<!-- 写上就是为true，表示隐藏星号 -->
<el-form 
    ref="form" 
    :model="sizeForm"
    hide-required-asterisk
    >
<el-form>

<!-- 如果要动态绑定属性值，必须加上:绑定 -->
<el-form 
    ref="form" 
    :model="sizeForm"
    :hide-required-asterisk="true"
    >
<el-form>
```

# 时间树 el-timeline
时间树组件只支持2.6.0以上的版本

# 标签页
## el-tabs
el-tab-pane，如果标签名，使用自定义的样式，在slot的里面，绑定数据，数据无法做到响应式 
```
// 如果count是在钩子里获取的，无法做到响应性
<el-tab-pane>
    <span slot="label">
        <i class="el-icon-date"></i> 
        {{ count }}我的行程
    </span>
    我的行程
</el-tab-pane>
  
// 暂时解决方案
不使用自定义的slot(不用样式...)，直接在el-tab-pane的label中动态绑定
<el-tab-pane :label="count">
```

** 使用2.8.0的版本，切换标签会卡死 **

# el-button在firefox无法点击
因为el-button中，如果有其它标签或是跳转标签，点击在火狐浏览器中是无效的.
```html
<!-- 这段代码，在火狐浏览器无法点击 -->
<el-button @click="toPage" >
   <span class="carousel-link">click me!</span>
</el-button>

<!-- 改进后的 -->
<span @click="toPage" class="carousel-link">
    click me!
</span>

<script>
methods: {
    toPage() {
        this.$router.push({ name: 'otherpage'})
    }
}
    
</script>
```
修改方法：
1. 去掉el-button中的其它附加标签，直接使用el-button
2. 去年el-button，直接自己使用css，编辑样式
```
.carousel-link {
    cursor: pointer;
    color: blue;
}

```

# el-select宽度没跟el-input一致
直接在el-select中style中直接写样式，跟el-input一致即可
```HTML
<el-select v-model="value" placeholder="请选择" style="width:320px;">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value"
      :disabled="item.disabled">
    </el-option>
  </el-select>
```

# 表单校验
如果只想做非空校验，只需在自定义中对于非空部分做校验，对于空部分，可以直接callback()空，这样就不会做任何校验
```HTML
<el-form 
  :model="ruleForm" 
  status-icon 
  :rules="rules" 
  ref="ruleForm" 
  label-width="100px" 
  class="demo-ruleForm"

>
  <el-form-item label="密码" prop="pass">
    <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
  </el-form-item>
</el-form>
<script>
  export default {
    data() {
      return {
        ruleForm: {
          pass: '',
          checkPass: '',
          age: ''
        },
        rules: {
          // 如果只想做非空校验，只需要自定义那部分即可，required: true这一行，就不用写了
          age: [
            { required: true, message: '不能为空！', trigger: 'blur'},
            { validator: validateAge, trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      validateAge(rule, value, callback) {
        if(value){
          if(value < 0) {
            callback(new Error('不能小于1'))
          } 
          // 非空则直接回调，这样会执行required: true的校验
        } else {
          callback()
        }
      }
    }
  }
</script>
```