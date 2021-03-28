<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

- <div class ="container"> 
		<h2>NOTICE</h2>
		
	<form action="noticeUpdate" method="post"> 
	
  	  <div class="form-group">
      	<label for="title"> 제목: </label>
      	<input type="text" class="form-control" id="title" name="title" value="${dto.title}">
    </div>
  
   	<div class="form-group">
      	<label for="contents">내용:</label>
      	<textarea class="form-control" rows="5" id="contents" name="contents">${dto.contents}</textarea>
    </div> 
    <input type="hidden" name="num" value="${dto.num}"> <br>
	  
  
     	  <button type="submit" class="btn btn-dark">Submit</button>
	</form>
 </div>

</body>
</html>