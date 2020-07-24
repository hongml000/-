let message: string = "hello world";
console.log(message);

class Site {
  user: string;
  private user2: string = "world";
  constructor(user: string) {
    // this.user指的是Site的属性user
    this.user = user;
  }
  name(): void {
    console.log(this.user);
    console.log("name-user2:", this.user2);
    
  }
}

const obj = new Site('hahah');
// 会提示报错
console.log('user2:', obj.user2);

obj.name()

let str = '绪哥';
let age = 4;
let words = `一一，今年${ age }岁，是${ str }的女儿`
console.log(words)

let x:any = 4.55;
console.log(x.toFixed())
