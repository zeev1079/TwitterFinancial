var express = require('express');
var cors = require('cors');

var app = express();
app.use(cors());

var testUsers = [{    
    "email":"mherr059@fiu.edu",
    "password":"test123"
},{
    "email":"mherr059fiu.edu",
    "password":"test123"
},{
    "email":"mherr059@fiu.edu",
    "password":""
}];

app.get('/users',function(req,res){
	res.status(200).json(users);
})

app.listen(9001);
