<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
  <link rel="stylesheet" href="./resources/css/test.css">
   <title>Home</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   <c:import url="./template/bootStrap.jsp"></c:import>
	
				 
  </head>
  <body>
  	<c:import url="./template/header.jsp"></c:import>
  
  	<button  class="b">button</button>
  	<button id="btn" class="b">CLICK</button>
  	<button id="btn2" class="b">CLICK2</button>
  	<h1 id="t"> version 5</h1>
  	<ol id="result">
  		<li>A</li>
  	
  	</ol>
  	
  	<select id="mon">
  	   <option>1</option>
  	</select>
  
		 
    <script type="text/javascript">
  	$("#btn").click(function(){
  		$("#result").prepend('<li>Go</li>');
  		
  	});
  	   
  	$('#btn2').click(function(){
  		for(let i=1; i<13; i++){
  			$("#mon").append("<option>"+i+"</option>");
  		}
  	});
  	  
    	</script>
  </body>
</html>