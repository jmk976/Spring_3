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
  		<c:if test="${pager.pre}">
          <li class="page-item"><a class="page-link" href="./bankbookList?curPage=${pager.startBlock-1}"&kind=${pager.kind}&search=${pager.search}>Previous</a></li>
        </c:if>
  	        <c:forEach begin="${pager.startBlock}" end="${pager.lastBlock}" var="i"> 
   				 <li class="page-item"><a class="page-link" href="./bankbookList?curPage=${i}&kind=${pager.kind}&search=${pager.search}"> ${i} </a></li>
    		</c:forEach>
          
          <c:if test="${pager.next}">
    		<li class="page-item"><a class="page-link" href="./bankbookList?curPage=${pager.lastBlock+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
  		  </c:if>
  		</ul>
  		
  		<div class="input-group mt-3 mb-3">
			<form action="./bankbookList" class="form-inline">
			  <div class="input-group-prepend">
			   	<select class="form-control" name="kind" id="sel1">
			    	<option>Bookname</option>
			    	<option>Booknumber</option>
			    	<option>Booksale</option>
			 	 </select>
			  </div>
			  <input type="text" class="form-control" name="search" placeholder="">
			    <div class="input-group-append">
			    <button class="btn btn-success" type="submit">Search</button>
			  </div>
			 </form> 
			</div>
  		
	</div>

		

</body>
</html>