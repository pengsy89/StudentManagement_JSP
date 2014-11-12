function sign()
 {
    var value = document.getElementById("status");
    value.value="signup";  
    var password=login.upass.value;
    var hash = Sha256.hash(password);
	login.upass.value=hash;  
    login.submit();    
}