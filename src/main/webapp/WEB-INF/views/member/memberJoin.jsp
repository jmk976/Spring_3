<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>

<style type="text/css">
	.r1{
		color:red;
		
	}
	
	.r2{
	   color:blue;    
	   }
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class ="container">
		<h2>Member Join Page</h2>
	<form id="frm" action="./memberJoin" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="id">ID</label>
    <input type="text" class="form-control" id="id" name="id" >
    <h6 id="idCheckResult"></h6>
  
    <!-- id는 6글자 이상 -->
  </div>
  <div class="form-group">
    <label for="pw">Password</label>
    <input type="password" class="form-control" id="pw" name="pw1">
     <h6 id="pwResult"></h6>
    <!-- pw는 8글자 이상 -->
  </div>
  
  <div class="form-group">
    <label for="pw2">Password</label>
    <input type="password" class="form-control" id="pw2" name="pw">

    <!--  pw 두개는 일치 (일치하면  blur 이벤트에서 아무일도 안일어남, 틀리면 지워준다) -->
  </div>
  
  
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control etc" id="name" name="name" >
    <!-- 비어 있으면 안됨 -->
  </div>
  <div class="form-group">
    <label for="phone">Phone</label>
    <input type="text" class="form-control etc" id="file" name="phone" >
    <!-- 비어 있으면 안됨 -->
  </div>
  <div class="form-group">
    <label for="email">E-mail</label>
    <input type="text" class="form-control etc" id="email" name="email" aria-describedby="#">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
     <!-- 비어 있으면 안됨 -->
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  
   <div class="form-group">
    <label for="file">file</label>
    <input type="file" class="form-control etc" id="avatar" name="avatar" >
    <!-- 비어 있으면 안됨 -->
  </div>
  
  
 
  
  
  <input type="submit" id="btn" value="JOIN" class="btn btn-primary">
</form></div>

 <script type="text/javascript" src="../resources/js/memberJoin.js">



</script>
	
	 
</body>
</html>