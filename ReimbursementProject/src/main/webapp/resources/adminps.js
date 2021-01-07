let password = document.getElementById("password")
  , confirm_password = document.getElementById("confirm_password"),
	emp_id = document.getElementById("emp-code");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

function validateAdminCode(){
	
  if(emp_id.value != 1357) {
    emp_id.setCustomValidity("Incorrect Employee Password");
  } else {
    emp_id.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
emp_id.onchange = validateAdminCode;