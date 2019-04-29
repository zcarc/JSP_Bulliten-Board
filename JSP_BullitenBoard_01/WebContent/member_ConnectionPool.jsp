<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%!
	
	Context context = null;
	DataSource dataSource = null;
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
		context = new InitialContext();
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	
		try {
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			
			while(resultSet.next()){
				
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				
				out.println("id: " + id + " pw: " + pw + " name: " + name + " phone: " + phone + "<br>");
						
			}
			
			
			
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