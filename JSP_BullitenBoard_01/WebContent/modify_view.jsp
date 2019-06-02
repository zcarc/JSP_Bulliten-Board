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

	
	
		<form action="modify.do" method="post">
		
			<input type="hidden" name="id" value="${content_view.id }">
			
			
			<table>
			
			<tr>
				<td>번호</td>
				<td>${content_view.id }</td>
			</tr>
			
			<tr>
				<td>조회수</td>
				<td>${content_view.hit }</td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td>${content_view.name }</td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${content_view.title }"></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><textarea name="content">${content_view.content }</textarea></td>
			</tr>
			
			
			
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료">
					&nbsp;&nbsp;
					
					<a href="list.do">목록보기</a>
					&nbsp;&nbsp;
				</td>
				
			</tr>
			
			</table>
		</form>
		
	
	

</body>
</html>