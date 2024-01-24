<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="response.jsp">
id : <input type="text" name="id">
<br>
first name : <input type="text" name="fName">
<br>
last name : <input type="text" name="lName">
<br>
city name : <input type="text" name="cityName">
<br>
email : <input type="text" name="email">
<br>
<input type="submit" value="enter">

</form>

</body>
</html>




  ******************************************************************8

  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String firstName = request.getParameter("fName");
	String lastName = request.getParameter("lName");
	String cityName = request.getParameter("cityName");
	String email = request.getParameter("email");
	
	Connection myConn=null;
	PreparedStatement myStmnt=null;
	ResultSet rs = null;
	
	String dburl = "jdbc:mysql://localhost:3306/java";
	String username="springstudent";
	String password="springstudent";
	
	myConn=DriverManager.getConnection(dburl,username,password);
	
	myStmnt=myConn.prepareStatement("insert into personal values (?,?,?,?,?)");
	myStmnt.setString(1,id);
	myStmnt.setString(2,firstName);
	myStmnt.setString(3,lastName);
	myStmnt.setString(4,cityName);
	myStmnt.setString(5,email);
	
	int noOfRows=myStmnt.executeUpdate();
	if(noOfRows>0){
		System.out.println("entered");
	}
	
	%>

</body>
</html>
