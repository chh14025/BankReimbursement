window.onload = function(){
    document.getElementById("confirm_submit").addEventListener('click',getSignup);
    console.log("setting the listener!");
    
};


document.addEventListener("DOMContentLoaded", ()=> {signupValidation();})


function signupValidation(){
  let request = new XMLHttpRequest();
  console.log("getting the js");

  request.open("GET", "http://localhost:8080/ReimbursementProject/bank/confirm");

  request.onload = () => {
      try{
        //console.log(request.responseText);
        const json = JSON.parse(request.responseText);
        //console.log(json);
        let username = document.getElementById('username')
        
        function validateUsername(e) {
          let input = e.target.value;
        	let bool = json.some(item => item.username == input);
        	console.log(bool);
           if(bool == true) {
            username.setCustomValidity("Username Taken");
          	} else {
          	console.log(bool);
          	username.setCustomValidity("");
			//document.getElementById("confirm_submit").addEventListener('click',getSignup);
          }
         
         
         }
         
       username.addEventListener('keyup', validateUsername);
         
      }catch(e){
          console.warn("could not load signup");
      }
  }

  request.send();
  
}





function getSignup(){




    let jsonString = null;
    let xhttp = new XMLHttpRequest();

    if(password.value != confirm_password.value) {
        console.log("incorrect pass")}
        else{
        
           let uname = document.getElementById("username").value;
		    let pass = document.getElementById("password").value;
		    let first = document.getElementById("firstname").value;
		    let last = document.getElementById("lastname").value;
		    let email = document.getElementById("email").value;
		    let p = 123;
        
            let userData = {
                userId: 0,
                username: uname,
                pass: pass,
                userStatus : 2, 
                firstName : first,
                lastName : last,
                email : email
            };
        
            jsonString = JSON.stringify(userData);
        
        
            console.log(jsonString);
        
            let bankURL = "http://localhost:8080/ReimbursementProject/bank/confirm";
        
            fetch(bankURL, {method:'POST', body: jsonString}).then(results => results.json());
        }

        }
        
        