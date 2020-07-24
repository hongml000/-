var mysql = require("mysql");
var connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "test"
});

connection.connect();
connection.query("select * from users", function (err, result, fields) {
  if (err) {
    console.log(err);
  }
  console.log(result[0]) // RowDataPacket { username: 'mary' }
  console.log(result[0].username); //mary
});