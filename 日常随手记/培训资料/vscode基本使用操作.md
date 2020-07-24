# VSCode软件
工欲善其事必先利其器,vscode支持大量前端开发插件，非常推荐你们使用这个编辑器

## 安装
官网：https://code.visualstudio.com/

## 目录说明
1. 文件资源管理器（ctrl + shift + e）
2. 全局搜索(ctrl + shift + f)
3. git 管理
4. debug调试
5. 插件管理

## 常用快捷(mac将ctrl替换成cmd)
1. ctrl + ~: 打开/关闭终端（这个例外，mac 也是control + ~）
2. ctrl + p: 快速打开文件，输入？为获取帮助
3. ctrl + shift + p: 打开命令面板
4. ctrl + f: 文件内搜索
5. ctrl+ shift + f: 全局搜索
6. ctrl + /: 注释
7. ctrl + c: 复制
8. ctrl + v: 粘贴
9. ctrl + x: 剪切
10. ctrl + z: 撤消
11. ctrl + shift + z: 反撤消

参考： https://www.cnblogs.com/bindong/p/6045957.html

## 更换主题
file -- preferences -- Color Theme
 
## 基本配制项
file -- preferences -- settings -- user settings:
```json
// 自定义配置项
{
    //设置tab缩进为2个空格
    "editor.tabSize": 2,
    // 字体大小
    "editor.fontSize": 14
}
```

## 设置代码片段(快捷键生成代码)
1. command + shift + p打开命令面板
2. 输入snippets，选择 Preferences: Configure User Snippets
3. 选择新建一个全局代码片段文件 New Global snippets file...，自定义文件名，这里命名"comment"

```js
{
	// Example: comment.code-snippets
  // "add Comment"这里是输入快捷时，会显示的提示语
	"add Comment": {
    // 适用文件范围，不写就默认全部类型文件都适用
    // "scope": "javascript,typescript",
    // 快捷键
    "prefix": "ct",
    // 生成的代码片段，一个数组，每个元素代表一行
		"body": [
			"/*",
      // $n表示一个占位符
      "* @author: $1",
      "*/"
		],
		"description": "add Comment to function"
	}
}
```
* vue常用的代码片段
```js
{
    "vue snippets": {
        "prefix": "vue",
        "body": [
            "<template>",
            "    <div>\n",
            "    </div>",
            "</template>\n",
            "<script>",
            "export default {",
            "    props: {\n",
            "    },",
            "    data() {",
            "        return {\n",
            "        };",
            "    },",
            "    computed: {\n",
            "    },",
            "    created() {\n",
            "    },",
            "    mounted() {\n",
            "    },",
            "    watch: {\n",
            "    },",
            "    methods: {\n",
            "    },",
            "    components: {\n",
            "    },",
            "};",
            "</script>\n",
            "<style scoped lang=\"${1:scss}\">\n",
            "</style>\n",
        ],
        "description": "Create vue template"
    }
}
```

## 常用的插件推荐
* vscode-icons: 将左侧文件目录变成视图文件树
* auto close tag: 自动补齐html的关闭标签
* auto rename tag: 自动重全名标签对
* bracket pair colorizer: 将括号以颜色区分
* vetur: vue多功能集成插件，高亮vue语法、自动补齐等，vue官方指定插件
* open-in-browers: 在浏览器预览html文件

参考： https://www.cnblogs.com/sanday/p/10162713.html


## 使用vscode进行git管理
参考： https://www.cnblogs.com/richard1015/p/8336429.html

# npm
npm 是javascript的包管理工具，并且是node.js平台的默认包管理工具，通过npm可以安装、共享、分发代码，管理项目依赖关系

## 安装
1. Node.js 是一个基于 Chrome V8 引擎的 JavaScript 运行环境，npm 是随同 NodeJS 一起安装的包管理工具，所以直接安装node.js 即可
官网下载：https://nodejs.org/en/

2. 安装完成后，windows需要将node.js增加到系统环境变量中
安装教程：https://www.cnblogs.com/wenyiadai/p/6518777.html

3. 查看是否安装成功：
node -v 
npm -v

## vscode debug（针对js）
### 方法一 使用debugger，在浏览器上调试
1. 在前端js代码，想要断点的位置，加上debugger
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>前端调试</title>
</head>
<body>
    <h1>vscode 调试 demo</h1>
    <script>
      var data = []
      for(let i = 0; i < 10; i ++){
        data.push(i)
        // 比如在这里断点
        debugger
        // 打日志
        console.log(data)
      }
    </script>
</body>
</html>
```
2. 然后在浏览器中打开（安装open in browser插件）
3. 右键选择“检查”，刷新，然后就可以一步一步调试了，在sources里悬停在对应变量（比如i 和 data），可以查看对应的值

### 方法二 输出日志，使用chrome的控制台查看消息
1. 直接使用console.log(v)打印日志
2. 在chrome的开发环境Console里查看日志


### 方法三 使用vscode本地调试代码js
1. 下载debugger for chrome插件并使用
2. 打开一个项目
```html
<!-- test.html -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>vscode 调试 demo</h1>
    <script src="./test.js"></script>
</body>
</html>
```
```js
// test.js
var data = []
for(let i = 0; i < 10; i ++){
  data.push(i)
  console.log(data) //在这里，行号前打了个断点
}
```
2. 点击debug---点击上方的设置，这时，会在当前文件目录下，生成一个json文件： .vscode/launch.json
```json
{
  // Use IntelliSense to learn about possible attributes.
  // Hover to view descriptions of existing attributes.
  // For more information, visit: https://go.microsoft.com/fwlink/?linkid=830387
  "version": "0.2.0",
  "configurations": [
    {
      "type": "chrome",
      "request": "launch",
      "name": "Launch Chrome against localhost",
      // 这里是在浏览器里访问的地址，可以写本地地址，也可以启一个服务，使用服务地址，这里以本地地址为例
      "url": "file:///Users/miao/Desktop/%E5%9F%B9%E8%AE%AD%E8%B5%84%E6%96%99/test1_debug/test1.html",
      "webRoot": "${workspaceFolder}"
    }
  ]
}
```

3. 点击运行按钮，这时可以看到浏览器上有运行效果
4. 然后回到vscode中，就有了调试按钮  
* 在debug console控制台里，就可以看到日志的输出了   
* 悬停在对应变量上，也可以看到相应的变量变化  

参考：https://blog.csdn.net/l_mloveforever/article/details/82416731

## 设置npm包源地址
* 设置仓库源
```
npm config set registry=https://registry.npm.taobao.org
```
* 查看仓库源
```
npm config get registry
```

## 安装包

```js
npm i packageName
// 使用临时仓库源下载包
npm i packageName --registry https://registry.npm.taobao.org

// 卸载
npm uninstall packageName
```

使用命令后，会在当前目录文件夹下生成node_modules/packageName