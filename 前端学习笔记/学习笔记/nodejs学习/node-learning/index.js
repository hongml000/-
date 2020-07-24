let http = require('http');
let url = require('url');
let fs = require('fs');
let querystring = require('querystring')
http.createServer((req, res) => {
  // get请求
  // let {
  //   pathname,
  //   query
  // } = url.parse(req.url, true);
  // if (query.username === "bbb" && query.pwd === "bbb") {
  //   fs.readFile('./home.html', (err, data) => {
  //     if (err) {

  //     } else {
  //       res.end(data)
  //     }
  //   })
  // }

  // post请求
  let result = []
  // data指的就是传输的过程,一般文件大的话是分段传输的，所以可能存在多个data（buffer）
  req.on('data', buffer => {
    console.log(buffer.toString()); // tostring只针对字符串，如果是视频图片是不适用的
    result.push(buffer)
    console.log(result)
  })
  // end是指传输完成的回调
  req.on('end', () => {
    let data = Buffer.concat(result).toString()
    console.log(data)
    console.log(querystring.parse(data)); // querystring把字符串转换成json格式

  })
}).listen(8888);