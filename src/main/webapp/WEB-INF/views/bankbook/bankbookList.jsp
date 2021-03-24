<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	
	<table>
		<thead>
			<tr>
			 <th>Name</th>
			 <th>Rate</th>
			 <th>Sale</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${list}" var="dto"> 
			<tr>
				<td><a href="./bankbookSelect?booknumber=${dto.booknumber}" >${dto.bookname}</a></td>
				<td>${dto.bookrate}</td>
				<td>${dto.booksale}</td>
			
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<a href="./bankbookAdd?booknumber=${dto.booknumber}">ADD</a>
	

</body>
</html>