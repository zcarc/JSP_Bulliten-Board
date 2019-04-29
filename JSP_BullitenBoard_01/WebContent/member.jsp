<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%!
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null; 
	
	String query = "select * from jsppractice_member";
%>
<html>
<head>
<meta charset="EUC-KR">
<title>select member table</title>
</head>
<body>

	<%
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "jsppractice", "1234");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			
			while(resultSet.next()){
				
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				
				out.println("id: " + id + " pw: " + pw + " name: " + name + " phone: " + phone + "<br>");
						
			}
			
			out.println("test123");
			
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	%>

</body>
</html>