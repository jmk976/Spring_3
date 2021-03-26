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
<h1>Account List Page</h1>


  
	<table>
		<thead>
			<tr>
			 <th>Booknumber</th>
			 <th>Account Number</th>
			 <th>Account Balance</th>
			  <th>Account Date</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${list}" var="ar"> 
			<tr>
				<td><c:out value="${ar.booknumber}"/></td>
				<td>${ar.accountnumber}</td>
				<td>${ar.accountbalance}</td>
				<td>${ar.accountdate}</td>
			
			</tr>
		</c:forEach>
		</tbody>
	</table>

		
	

 
</body>
</html>