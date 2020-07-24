# VSCode软件

## 安装
官网：https://code.visualstudio.com/

## 目录说明
1. 文件资源管理器（ctrl + shift + e）
2. 全局搜索(ctrl + shift + f)
3. git 管理
4. debug调试
5. 插件管理

## 常用快捷(mac将ctrl替换成cmd)
1. ctrl + ~: 打开/关闭终端
2. ctrl + p: 快速打开文件，输入？为获取帮助
3. ctrl + f: 文件内搜索
4. ctrl+ shift + f: 全局搜索
5. ctrl + /: 注释
6. ctrl + c: 复制
7. ctrl + v: 粘贴
8. ctrl + x: 剪切
9. ctrl + z: 撤消
10. ctrl + shift + z: 反撤消

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
1. command + shift + p
2. 输入snippets，选择 Preferences: Configure User Snippets
3. 选择新建一个全局代码片段文件，自定义文件名

```js
{
	// Example:
	"add Comment": {
    // 适用文件范围，不写就默认全部文件
    // "scope": "javascript,typescript",
    // 快捷键
    "prefix": "ct",
    // 生成的代码片段 
		"body": [
			"/*",
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