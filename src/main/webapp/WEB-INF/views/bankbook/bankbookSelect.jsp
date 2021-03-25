<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Select Page</h1>
	
	<h3>Name : ${dto.bookname}</h3>
	<h3>Number : ${dto.booknumber}</h3>
	
	<a href="../account/accountAdd">계좌개설</a>
	
	
	<%-- <c:if test="${not empty member and member.id eq 'admin'}"> 
	<a href="./bankbookDelete?booknumber=${dto.booknumber}">DELETE</a>
	<a href="./bankbookUpdate?booknumber=${dto.booknumber}">UPDATE</a>
	</c:if>
	 --%>
	
	<c:catch>
	<c:if test="${member.id eq 'admin'}">
	<a href="./bankbookDelete?booknumber=${dto.booknumber}">DELETE</a>
	<a href="./bankbookUpdate?booknumber=${dto.booknumber}">UPDATE</a>
	</c:if>
	</c:catch>
	
</body>
</html>