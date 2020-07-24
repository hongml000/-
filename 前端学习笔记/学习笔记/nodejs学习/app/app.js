let http = require('http');
let url = require('url')
http.createServer((req, res) => {
  if (req.method == "GET") {
    let {
      pathname,
      query
    } = url.parse(req.url, true);

  } else if (req.method == "POST") {
    let arr = []
    req.on('data', buffer => {
      arr.push(buffer)
    })
    req.on('end', () => {
      Buffer.concat(arr)
    })
  }
})