let express = require('express');
let router = express.Router();

router.get('/', (req, res) => {
  res.send('home')
})

router.get('/one', (req, res) => {
  res.send('one')
})

router.get('/second', (req, res) => {
  res.send('second')
})

router.get('/three', (req, res) => {
  res.send('three')
})

module.exports = router;