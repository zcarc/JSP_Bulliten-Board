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

	<table border="1" cellpadding="5" cellspacing="3">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>이름</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		
		<c:forEach items="${list }" var="dto">
			<tr>
				<!-- 글 번호 -->
				<td>${dto.id }</td>
				
				<!-- 글 제목 -->
				<td>
					<c:forEach begin="1" end="${dto.indent}">-</c:forEach>
					<a href="content_view.do?id=${dto.id }">${dto.title }</a>
				</td>
				
				<!-- 글 작성자 -->
				<td>${dto.name }</td>
				
				<!-- 글 작성일 -->
				<td>${dto.dDate }</td>
				
				<!-- 글 조회수 -->
				<td>${dto.hit }</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td><button><a href="write_view.do">글 작성</a></button></td>
		</tr>
		
	</table>

</body>
</html>