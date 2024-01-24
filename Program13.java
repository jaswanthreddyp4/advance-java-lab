// same code is applicable to servlet file also jus change action attribute in input.jsp


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
patient id : <input type="text" name="id">
<br>
patient name : <input type="text" name="name">
<br>
patient age : <input type="text" name="age">
<br>
date of admission : <input type="text" name="doa">
<br>
cause : <input type="text" name="cause">
<br>
doctor diagnosed : <input type="text" name="doctorDiagnosed">
<br>
treatment proposed : <input type="text" name="trtmnt">
<br>
<input type="submit" value="submit">
</form>

</body>
</html>



  *****************************************************************************


  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String pName = request.getParameter("name");
	String pAge = request.getParameter("age");
	String doa = request.getParameter("doa");
	String cause = request.getParameter("cause");
	String doctor = request.getParameter("doctorDiagnosed");
	String treatment = request.getParameter("trtmnt");

	Connection conn = null;
	PreparedStatement myStmnt ,myStmnt2= null;
	ResultSet rs = null;

	String dburl = "jdbc:mysql://localhost:3306/java";
	String username = "springstudent";
	String password = "springstudent";

	try {
		conn = DriverManager.getConnection(dburl, username, password);
		myStmnt = conn.prepareStatement("insert into patients values (?,?,?,?,?,?,?)");
		myStmnt.setString(1, id);
		myStmnt.setString(2, pName);
		myStmnt.setString(3, pAge);
		myStmnt.setString(4, doa);
		myStmnt.setString(5, cause);
		myStmnt.setString(6, doctor);
		myStmnt.setString(7, treatment);

		int noOfRows = myStmnt.executeUpdate();
		if (noOfRows > 0) {
			System.out.println("entered");
		}
		
		myStmnt2=conn.prepareStatement("select * from patients");
		
		rs=myStmnt2.executeQuery();
		while(rs.next()){
			System.out.println("id : "+rs.getString(1)+"name : "+rs.getString(2));
		}
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	%>

</body>
</html>
