let username = document.getElementById("username")
  , password = document.getElementById("password")


function validatePassword(){


    let uname = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
	var xhr = new XMLHttpRequest();
	var url = "http://localhost:8080/ReimbursementProject/bank/check";
	
	xhr.onreadystatechange = function () {
	
	    if (xhr.status != 200) {
    		password.setCustomValidity("Invalid username & password combination");
	    }else{
	    	password.setCustomValidity("");
	    }
	};
	
    let userData = {
    "userId": 0,
    "username": uname,
    "pass": pass,
    "userStatus" : 1,
    "firstName" : "first",
    "lastName" : "last",
    "email": "email"
	};
	
	var data = JSON.stringify(userData);
	console.log(data);
	xhr.open("POST", url);
	xhr.setRequestHeader("Content-Type", "application/json");

	xhr.send(data);
	
}

//let submit = document.getElementById("confirm_submit");
//submit.onkeydown = validatePassword;
username.onchange = validatePassword;
password.onchange = validatePassword;

