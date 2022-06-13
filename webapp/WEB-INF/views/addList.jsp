<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 글쓰기 테이블 -->
	<form action="write" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" value="">
				</td>
				<td>비밀번호</td>
				<td>
					<input type="password" name="password" value="">
				</td>
			</tr>
			<tr>
				<td colspan="4" >
					<textarea rows="10" cols="80" name="content" value=""></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<button type="submit">확인</button>
				</td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	
 	
	<!-- 글 출력 -->
	<c:forEach items="${gbList }" var="gbVo">
		<table border="1">
			<tr>
				<td width="50px">${gbVo.no }</td>
				<td width="150px">${gbVo.name }</td>
				<td width="300px">${gbVo.date }</td>
				<td>
					<a href="deleteForm/${gbVo.no }">삭제</a>
				</td>
			</tr>
			<tr>
				<td colspan="4" width="590px">
					<p>${gbVo.content }</p>
				</td>
			</tr>
		</table>
		<br>
	</c:forEach>
</body>
</html>