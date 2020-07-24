var util = require('util');

function Base() {
  this.name = 'base';
  this.year = 1992;
  this.sayHello = function () {
    console.log('hello,', this.sayHello)
  }
}

Base.prototype.print = function () {
  console.log(this.name)
}

function Sub() {
  this.name = 'sub'
}

util.inherits(Sub, Base); // 仅继续base的原型，不继承其构造函数

var objBase = new Base();
console.log(objBase);

var objSub = new Sub()
console.log(objSub);
objSub.print()
// console.log()