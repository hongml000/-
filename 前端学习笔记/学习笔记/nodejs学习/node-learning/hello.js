// console.log(process.argv);

// let path = require('path');
// console.log(path.resolve(__dirname, "hello.js"));


// let fs = require('fs');
// fs.readFile("./hello.js",(err,data) => {
//   if(err){
//     // err是指发生的错误
//     console.log(err); 
//   }else{
//     // data指的是对应的二进制文件
//     console.log(data);
//     console.log(data.toString())
//   }
// })

// let modu = require('./modu.js');
// // console.log(modu.a);
// // console.log(modu.func());
// console.log(modu())
let fs = require('fs')
let http = require('http');
http.createServer((req, res) => {
  // 在浏览器上访问： http://localhost:8888/hello
  console.log(req.url)
  if (req.url === "/hello") {
    // 读取本地文件
    fs.readFile('./index.html', (err, data) => {
      // 如果不存在，变返回404
      if (err) {
        res.end('404. this page is not founded')
        // 如果存在，则显示对应的页面
      } else {
        res.end(data)
      }
    })
  }
  // 设置监听端口
}).listen(8888);