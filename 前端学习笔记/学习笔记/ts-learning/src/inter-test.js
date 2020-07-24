var Al = /** @class */ (function () {
    function Al(interest, rebate) {
        this.interest = interest;
        this.rebate = rebate;
    }
    return Al;
}());
var lobj = new Al(4, 1);
console.log(lobj.interest + " " + lobj.rebate);
