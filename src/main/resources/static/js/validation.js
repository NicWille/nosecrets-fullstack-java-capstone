function validateEmail() {
  var email = document.getElementById("email").value;
  var regex = /^\S+@\S+\.\S+$/; // regular expression for email validation

  if (!regex.test(email)) {
    alert("invalid email");
  }
}