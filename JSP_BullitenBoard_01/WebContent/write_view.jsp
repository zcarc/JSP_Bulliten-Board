<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table>
	
		<form action="write.do" method="post">
		
		
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" ></td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><textarea name="content"></textarea></td>
			</tr>
			
			
			
			<tr>
				<td colspan="2">
					<input type="submit" value="작성완료">
					&nbsp;&nbsp;
					
					<a href="list.do">목록보기</a>
					&nbsp;&nbsp;
				</td>
				
			</tr>
		</form>
		
	</table>

</body>
</html>