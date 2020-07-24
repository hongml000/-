var message = "hello world";
console.log(message);
var Site = /** @class */ (function () {
    function Site(user) {
        this.user2 = "world";
        // this.user指的是Site的属性user
        this.user = user;
    }
    Site.prototype.name = function () {
        console.log(this.user);
        console.log("name-user2:", this.user2);
    };
    return Site;
}());
var obj = new Site('hahah');
console.log('user2:', obj.user2);
obj.name();
var str = '绪哥';
var age = 4;
var words = "\u4E00\u4E00\uFF0C\u4ECA\u5E74" + age + "\u5C81\uFF0C\u662F" + str + "\u7684\u5973\u513F";
console.log(words);
var x = 4.55;
console.log(x.toFixed());
