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


  <%-- <c:if test="${list.size() != 0}">
	${list.id} 님의 계좌
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
		<c:forEach items="${list}" var="dto"> 
			<tr>
				<td><a href="./bankbookSelect?booknumber=${dto.booknumber}" >${dto.booknumber}</a></td>
				<td>${dto.accountnumber}</td>
				<td>${dto.accountbalance}</td>
				<td>${dto.accountdate}</td>
			
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:if>
		
	

 --%>
</body>
</html>