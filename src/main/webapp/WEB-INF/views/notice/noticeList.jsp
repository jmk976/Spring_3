<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   <c:import url="../template/bootStrap.jsp"></c:import>
  </head>
  <body>
  
  
  	<c:import url="../template/header.jsp"></c:import>
		  
		
	
    
  
	<div class="container">


	<h2>NOTICE</h2>

	<table class ="table">
	
		<thead class="thead-dark">
			<tr>
			 <th>번호</th>
			 <th>제목</th>
			 <th>작성자</th>
			 <th>날짜</th>
			 <th>조회수</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${list}" var="dto"> 
			<tr>
				<td>${dto.num}</td>
				<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.regDate}</td>
				<td>${dto.hit}</td>
				
			
			</tr>
		</c:forEach>
		</tbody>
	</table>
  
	</div> 
	<div class="container">
      <a href="./noticeInsert"> <button type="button" class="btn btn-dark">글작성</button></a>
	</div>

</body>
</html>