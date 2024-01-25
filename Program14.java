// sql file
CREATE TABLE tshirt (
    id INT AUTO_INCREMENT PRIMARY KEY,
    accessories VARCHAR(255),
    tagline VARCHAR(255),
    chestpocket VARCHAR(255),
    color VARCHAR(255)
);


// input jsp file

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1> online t-shirt form</h1>
<form action="response.jsp">

select t-shirt accessories :
<br>
<label><input type="checkbox" name="accessories" value="belt">belt</label> 
<label><input type="checkbox" name="accessories" value="cap">cap</label> 
<label><input type="checkbox" name="accessories" value="hairband">hairband</label> 
<br>

enter your tag line : <input type="text" name="tagline">
<br>

T shirt options : 
<br>
<label><input type="radio" name="chestpocket">with chest pocket</label>
<label><input type="radio" name="chestpocket">without chest pocket</label>
<br>

T shirt color :
<br>
<select name="color">
<option>lemon yellow</option>
<option> baby pink</option>
<option>copper brown</option>
</select> 

<br>
<input type="submit" value="click me">

</form>


</body>
</html>

//  response jsp file
// no need to worry about id , its been auto incrementing each time you submit input form
  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
	String[] accessories = request.getParameterValues("accessories");
	String tagLine = request.getParameter("tagline");
	String option = request.getParameter("chestpocket");
	String color = request.getParameter("color");

	// since check boxes can take more than one choosings so all chosen options are populated into array
	// just converting this array into a readable stringbuffer
	//why string buffer? its mutable!
	StringBuilder str = new StringBuilder();
	if (accessories.length > 0) {
		for (String acr : accessories) {
			str.append(acr).append(" , ");
		}
	}
	String accr = str.toString();

	Connection conn = null;
	PreparedStatement stmnt, stmnt1 = null;
	ResultSet rs = null;

	String dburl = "jdbc:mysql://localhost:3306/java";
	String username = "springstudent";
	String password = "springstudent";

	try {
		conn = DriverManager.getConnection(dburl, username, password);
		stmnt = conn.prepareStatement("INSERT INTO tshirt (accessories, tagline, chestpocket, color) VALUES (?,?,?,?)");

		stmnt.setString(1, accr);
		stmnt.setString(2, tagLine);
		stmnt.setString(3, option);
		stmnt.setString(4, color);

		int eff = stmnt.executeUpdate();
		if (eff > 0) {
			System.out.println("entered");
		}

		stmnt1 = conn.prepareStatement("select * from tshirt");
		rs = stmnt1.executeQuery();
		
		out.println("<table>");
		out.println("<tr><th>id</th><th>accessories</th><th>tagline</th><th>option</th><th>color</th></tr>");

		while (rs.next()) {
			
			int id = rs.getInt(1);
			String accessory = rs.getString(2);
			String tagline = rs.getString(3);
			String optiona = rs.getString(4);
			String colors = rs.getString(5);
			out.println("<tr><td>" + id + "</td><td>" + accessory + "</td>" + "<td>" + tagline + "</td>" + "<td>" + optiona
			+ "</td>" + "<td>" + colors + "</td></tr>");

		}

	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	%>

</body>
</html>

    
