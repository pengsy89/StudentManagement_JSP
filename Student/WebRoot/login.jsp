<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	${requestScope.error}
	<form action="/HW3_Student/servlet/UserSer" method="post" id="login"
		name="login">

		User Name:<input type="text" name="uname"> Password:<input type="password" name="upass" id="upass" value="">
		 <input type="hidden"	id="status" name="status" value="" /> 
		 <input type="button"	value="Log in" onclick="log()">

<script type="text/javascript" src="SHA-256.js"></script>
		<script type="text/javascript">  
      function log()
{
 	var value = document.getElementById("status");
    value.value="login";
    var password=login.upass.value;
    var hash = Sha256.hash(password);
	login.upass.value=hash;
	login.submit(); 
}
</script>
		<script type="text/javascript" src="sign.js" >  </script>
		<input type="button" value="Sign up" onclick="sign()">
		<br>
	</form>
</body>

</html>
