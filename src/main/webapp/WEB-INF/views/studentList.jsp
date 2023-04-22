<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet" %>
     <%@ include file="menu.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>

<form>
<table border="1" >
<tr><th>Name</th>
<th>Email</th>
<th>Class</th>
<th>Age</th>
<th>Delete</th>
<th>Update</th></tr>
<% 
if(request.getAttribute("result")!=null){
	ResultSet result=(ResultSet)request.getAttribute("result");
	while(result.next()){
%>
		<tr><td><%out.print(result.getString(1)); %></td>
		<td><%out.println(result.getString(2)); %></td>
		<td><%out.println(result.getString(3));%></td>
		<td><%out.println(result.getString(4)); %></td>
		<td><a href="delete?email=<%=result.getString(2)%>">Delete</a></td>
		<td><a href="update?email=<%=result.getString(2)%>&name=<%=result.getString(1) %>">Update</a></td>
		</tr>
<%
	}
}
%>
</table>
</form>
</body>
</html>