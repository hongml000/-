var express = require('express');
// var app = express();
// app.get('/', function (req, res) {
//   res.send('hello world' + req.hostname)
// })

// app.use('/admin', function (req, res) {
//   console.log(req.originalUrl)
//   console.log(req.url)
//   res.send(req.baseUrl)
// })

// app.listen(8000);
// var server = app.listen(8080, function () {
//   var host = server.address().address
//   console.log(server.address())
//   var port = server.address().port
//   console.log("访问地址为http://%s:%s", host, port)
// })


var router = require('./express-router');
var app = express()

app.use('/home', router)

// 注意路径要加上/,即/static，否则会不生效
app.use('/static', express.static('public'))

app.get('/', function (req, res) {
  console.log(req.baseUrl)
  console.log(req.params)
  // 打印get方法的查询参数
  console.log(req.query)

  console.log(req.fresh, req.hostname, req.ip, req.protocol);

})
app.listen(3000, function () {
  console.log('______________________________________________________________');
  console.log("app is runningat port: 3000")
})

var app1 = express()
app1.listen(8000, function () {
  console.log("app1 is running at port: 8000")
})
app1.get('/', function (req, res) {
  res.send('hello 8000!')
})