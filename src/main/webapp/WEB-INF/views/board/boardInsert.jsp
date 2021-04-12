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
	#sample{
	display: none;
	
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>



<div class ="container">
		<h2>${board} form</h2>
	<form id="frm" action="./${board}Insert" method="post" enctype="multipart/form-data" >
	
	<div class="form-group">
      	<label for="writer"> 작성자: </label>
      	<input type="text" readonly="readonly" value="${member.id}" class="form-control myCheck" id="writer" name="writer">
    </div>
	
  	<div class="form-group">
      	<label for="title"> 제목: </label>
      	<input type="text" class="form-control myCheck" id="title" name="title">
    </div>
  
   	<div class="form-group">
      	<label for="contents">내용:</label>
      	<textarea class="form-control myCheck" rows="5" id="contents" name="contents"></textarea>
    </div>
       	  <input type="button" id="add" value="ADD" class="btn btn-danger">
       	  
     			<div id="files"></div>
  
     	  <input type="submit" id="btn" value="WRITE" class="btn btn-dark"> 
	</form>
</div>

<div id="sample">
	<div class="input-group">
 		 <div class="custom-file">
    			<input type="file" class="custom-file-input" id="inputGroupFile04" name="files" aria-describedby="inputGroupFileAddon04">
    		<label class="custom-file-label" for="inputGroupFile04">Choose file</label>
 		 </div>
  		<div class="input-group-append delete">
   		 <input class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" value="Delete">
  		</div>
	</div>
</div>

<!--  <script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>
 -->
 
 <script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>

</body>
</html>