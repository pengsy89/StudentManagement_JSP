<%@page language="java" import="java.util.*,com.stu.bean.*"
	pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Program of Student Management</title>

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
	Welcome ${uname}
	<br />
	<%
		Student stu1 = (Student) request.getAttribute("notfound");
		if (stu1 != null) {
			if (stu1.getId() == 0)
				out.println("The student is not found!");
		}
	%>

Student stu2 = (Student) request.getAttribute("isexisted");
			if (stu2 != null) {
				if (stu2.getId() == 0)
					out.println("The student is existed!");
			}
	}%>

	<form action="/HW3_Student/servlet/StudentSer" method="post" id="index"
		name="index">
		<input type="hidden" id="status" name="status" value="" />
		<table width="574" height="40">
			<tr>
				<td width="155" height="40">Student ID:</td>
				<td colspan="2"><input type="text" name="id"></td>
			</tr>
			</div>
			</td>
			</tr>
		</table>
		<table>
			<tr>
				<td width="110"><div align="center">
						<input type="button" value="Create" onclick="create()">
						<script>
							function create() {
								var value = document.getElementById("status");
								value.value = "createStudent";
								index.submit();
							}
						</script>
					</div></td>
				<td width="110"><div align="center">
						<input type="button" value="Retrieve" onclick="retrieve()">

						<script>
							function retrieve() {
								var value = document.getElementById("status");
								value.value = "retrieveStudent";
								index.submit();
							}
						</script>
					</div></td>

				<td width="110"><div align="center">
						<input type="button" value="Logout" onclick="logout()">
						<script>
							function logout() {
								var value = document.getElementById("status");
								value.value = "logout";
								index.submit();
								window.location.href = "/HW3_Student/login.jsp";
							}
						</script>
					</div></td>
			</tr>
		</table>
	</form>

</body>
</html>
