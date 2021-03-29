<%@page import="java.net.URI"%>
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


	<h2>BankBook List</h2>
	
	
	
	
	
	<table class ="table">
	
		<thead class="thead-dark">
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
	
	</div>
	
	<div class="container">
     
  		<ul class="pagination">
          <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    
  	        <c:forEach begin="${bpager.startBlock}" end="${bpager.lastBlock}" var="i"> 
   				 <li class="page-item"><a class="page-link" href="./bankbookList?curPage=${i}"> ${i} </a></li>
    		</c:forEach>
    
    		<li class="page-item"><a class="page-link" href="#">Next</a></li>
  		</ul>
	</div>
	
	
		
		

</body>
</html>