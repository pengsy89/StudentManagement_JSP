<%@page language="java" import="java.util.*, com.stu.bean.*" pageEncoding="ISO-8859-1"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'retrieve.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
<form action="/HW3_Student/servlet/StudentSer" method="post" id="retrievejsp">    
    <table width="574" height="608">
    <%//Student bean=(Student)request.getAttribute("bean");// Remember qiangzhuan!!%>
  <tr>
    <td width="155" height="40">Student ID:</td>
    <td colspan="2"><input type="text" name="id" value="${requestScope.bean.id}"></td>
    </tr>
  <tr>
    <td width="155" height="40">First Name:</td>
    <td colspan="2"><input type="text" name="firstname" value="${requestScope.bean.firstname}"> </td> 
    </tr>
  <tr>
    <td width="155" height="40">Last Name:</td>
    <td colspan="2"><input type="text" name="lastname" value="${requestScope.bean.lastname}"></td>
    </tr>
  <tr>
    <td width="155" height="40">Date of Birth:</td>
    <td colspan="2"><input type="text" name="dateob" value="${requestScope.bean.dateob}"></td>
    </tr>
  <tr>
    <td width="155" height="40">Major:</td>
    <td colspan="2"><input type="text" name="major" value="${requestScope.bean.major}"></td>
    </tr>
  <tr>
    <td width="155" height="122">Description:</td>
    <td height="122" colspan="2"><textarea name="description" cols="55" rows="9">${requestScope.bean.description}</textarea>
	<br></td> 
  
</tr><tr>
    <td width="155" height="40"></td>
    <td width="235"><div align="center">Course Name</div></td>
    <td width="168"><div align="center">Grade</div></td>
  </tr>
  <tr>
    <td width="155" height="40">Course 1</td>
    <td><div align="center">
      <input type="text" name="course1name" value="${requestScope.bean.course1name}">
    </div></td>
    <td width="168"><div align="center">
      <input type="text" name="course1grade" value="${requestScope.bean.course1grade}">
    </div></td>
  </tr>
  <tr>
    <td width="155" height="40">Course 2</td>
    <td><div align="center">
      <input type="text" name="course2name" value="${requestScope.bean.course2name}">
    </div></td>
    <td width="168"><div align="center">
      <input type="text" name="course2grade" value="${requestScope.bean.course2grade}">
    </div></td>
  </tr>
  <tr>
    <td width="155" height="40">Course 3</td>
    <td><div align="center">
      <input type="text" name="course3name" value="${requestScope.bean.course3name}">
    </div></td>
    <td width="168"><div align="center">
      <input type="text" name="course3grade" value="${requestScope.bean.course3grade}">
    </div></td>
  </tr>
  <tr>
    <td width="155" height="40">Course 4</td>
    <td><div align="center">
      <input type="text" name="course4name" value="${requestScope.bean.course4name}">
    </div></td>
    <td width="168"><div align="center">
      <input type="text" name="course4grade" value="${requestScope.bean.course4grade}">
    </div></td>
  </tr>
  <tr>
    <td width="155" height="40">Course 5</td>
    <td><div align="center">
      <input type="text" name="course5name" value="${requestScope.bean.course5name}">
    </div></td>
    <td width="168"><div align="center">
      <input type="text" name="course5grade" value="${requestScope.bean.course5grade}">
    </div></td>
  </tr>
</table>
       <input type="hidden" id="status" name="status" value="">
    <table>
    <tr>

    <td width="140"><div align="center">
      <input type="button" value="Retrieve" onclick="retrieve()"> 
      <script type>
      function  retrieve(){
    var value = document.getElementById("status");
    value.value="retrieveStudent";
    retrievejsp.submit(); 
      }
      </script>

    </div></td>
    <td width="140"><div align="center">
      <input type="button" value="Update" onclick="update()"> 
            <script>
      function  update(){
    var value = document.getElementById("status");
    value.value="updateStudent";
    retrievejsp.submit(); 
    window.location.href="/HW3_Student/jspfile/index.jsp";
      }
      </script>
     
    </div></td>
    <td width="140"><div align="center">
      <input type="button" value="Delete" onclick="deletes()">
            <script>
      function  deletes(){
    var value = document.getElementById("status");
    value.value="deleteStudent";
    retrievejsp.submit(); 
    window.location.href="/HW3_Student/jspfile/index.jsp";
      }
      </script> 

    </div></td>
    <td width="140"><div align="center">
      <input type="button" value="Logout" onclick="logout()"> 
                  <script>
      function  logout(){
    var value = document.getElementById("status");
    value.value="logout";
    retrievejsp.submit(); 
    window.location.href="/HW3_Student/login.jsp";
      }
      </script> 
    </div></td>
    </tr>
</table>
</form>
</body>

</html>