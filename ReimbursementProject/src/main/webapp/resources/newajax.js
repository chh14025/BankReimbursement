window.onload = function(){
    document.getElementById("confirm_submit").addEventListener('click',getSignup());
    console.log("setting the listener!");
    
};





function getSignup(){

console.log("success");


    let uname = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    let confPass = document.getElementById("confirm_password").value;
    let first = document.getElementById("firstname").value;
    let last = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let p = 123;
    


    let jsonString = null;
    let xhttp = new XMLHttpRequest();

    if(password.value != confirm_password.value) {
        console.log("incorrect pass")}
        else{
        
            let userData = {
                userId: 0,
                username: uname,
                pass: p,
                userStatus : 1, 
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
        
        
 
 