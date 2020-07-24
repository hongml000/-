interface Il {
  interest: number
}
class Al implements Il {
  // 必须再写一遍，强制按照接口定义执行
  interest: number
  rebate: number
  constructor(interest, rebate) {
    this.interest = interest;
    this.rebate = rebate;
  }
}

var lobj = new Al(4,1);
console.log(`${lobj.interest} ${lobj.rebate}`)
