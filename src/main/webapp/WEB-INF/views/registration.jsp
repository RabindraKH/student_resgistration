<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>
</head>
<body>
<form action="registration" method="post">
<br>
Name<input type="text" name="name"/><br>
Email<input type="email" name="email"/><br>
Class<input type="text" name="class"/><br>
Age<input type="number" name="age"><br>
<input type="submit" value="Register">
</form>
<%
if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
}

%>

</body>
</html>