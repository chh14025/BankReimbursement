/*window.onload = function(){
    //document.getElementById("confirm_submit").addEventListener('click',getLogin);
    document.getElementById("confirm_submit").onsubmit(getLogin());

    console.log("setting the listener!");
    
};
*/

/*
function getLogin(){

    let uname = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    console.log(uname);
    console.log(pass);

    let jsonString = null;
    let xhttp = new XMLHttpRequest();

            let userData = {
                userId: 0,
                username: uname,
                pass: pass,
                userStatus : 1
            };
        
            jsonString = JSON.stringify(userData);
        
        
            console.log(jsonString);
        
            let bankURL = "http://localhost:8080/ReimbursementProject/bank/employee";
        
            fetch(bankURL, {method:'POST', body: jsonString}).then(results => results.json());
			        

        }
*/
/*
function getLogin(){
	let uname = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
	var xhr = new XMLHttpRequest();
	var url = "http://localhost:8080/ReimbursementProject/bank/employee";
	
	xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	        //var json = JSON.parse(xhr.responseText);
	        //console.log(json.email + ", " + json.password);
	    }
	};
	
    let userData = {
    "userId": 0,
    "username": uname,
    "pass": pass,
    "userStatus" : 1
	};
	
	var data = JSON.stringify(userData);
	xhr.open("POST", url);
	xhr.setRequestHeader("Content-Type", "application/json");

	xhr.send(data);
	
}
*/

/*
function DOMmanip(){
	document.getElementById("login-form").action =

}
*/