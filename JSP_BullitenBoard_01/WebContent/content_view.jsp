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

	<form id="form" action="modify.do" method="post"> 
	
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
				<td>${content_view.id }</td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td>${content_view.title }</td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td>${content_view.content }</td>
			</tr>
			
			
			
			<tr>
				<td colspan="2">
					<button type="button" id="modifyView">글 수정</button>
					&nbsp;&nbsp;
					
					<button type="button" id="replyWriteView">답글 달기</button>
					&nbsp;&nbsp;
					
					<a href="list.do">목록보기</a>
					&nbsp;&nbsp;
					
					<a href="delete.do?id=${content_view.id }">삭제</a>
					&nbsp;&nbsp;
				</td>
				
			</tr>
			
		
		</table>
	
	</form>
	<script>
		window.onload = function(){
			
			document.querySelector("#replyWriteView").addEventListener("click", function(){
				
				console.log("reply");
				view("reply_write_view");
			});
			
			
			/* document.querySelector("button").addEventListener("click", function(){
				
				alert(this.id);
				
				
				if(this.id === "modifyView") {
					
					view("modify_view");
					
					
				} else if(this.id === "replyView") {
					
					alert("replyview");
					view("reply_view");
				}
				
				
			}); */
		} 
		
		function view(name){
			
			const valueOfId = document.querySelector("input[name='id']").value;
			window.location.href = "http://localhost:8080/JSP_BullitenBoard_01/"+ name +".do?id=" + valueOfId;
		}
	</script>

</body>
</html>