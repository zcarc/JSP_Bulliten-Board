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

	
	
	<form action="reply.do" method="post">
		
			<input type="hidden" name="id" value="${reply_write_view.id }">
			
			
			<input type="hidden" name="group" value="${reply_write_view.group }">
			<input type="hidden" name="step" value="${reply_write_view.step }">
			<input type="hidden" name="indent" value="${reply_write_view.indent }">
			
		<table>
			
			<tr>
				<td>번호</td>
				<td>${reply_write_view.id }</td>
			</tr>
			
			<tr>
				<td>조회수</td>
				<td>${reply_write_view.hit }</td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><input type="text" name="content"></td>
			</tr>
			
			
			
			<tr>
				<td colspan="2">
					<input type="submit" value="답글 완료">
					&nbsp;&nbsp;
					
					<a href="list.do">목록보기</a>
					&nbsp;&nbsp;
					
					<a href="delete.do?id=${content_view.id }">삭제</a>
					&nbsp;&nbsp;
				</td>
				
			</tr>
			
		</table>
		
	</form>
		
	

</body>
</html>