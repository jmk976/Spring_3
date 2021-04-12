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
	#sample {
		display: none;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>



<div class ="container">
		<h2>${board} Update form</h2>
	<form id="frm" action="./${board}Update" method="post" enctype="multipart/form-data">
	
	  <input type="hidden" name="num" value="${param.num}">
	
	<div class="form-group">
      	<label for="writer"> 작성자: </label>
      	<input type="text" readonly="readonly" value="${dto.writer}" class="form-control" id="writer" name="writer">
    </div>
	
  	<div class="form-group">
      	<label for="title"> 제목: </label>
      	<input type="text" class="form-control" id="title" name="title" value="${dto.title}">
    </div>
  
   	<div class="form-group">
      	<label for="comment">내용:</label>
      	<textarea class="form-control" rows="5" id="comment" name="contents">${dto.contents}</textarea>
    </div>
    
    <c:forEach items="${dto.boardFiles}" var="file">
   	<div>
   		<span>${file.originName}</span> <span class="fileDelete" title="${file.fileNum}">X</span>
   	</div>
    
    </c:forEach>
		 <input type="button" id="add" value="ADD" class="btn btn-danger">
       	  
     			<div id="files" title="${dto.boardFiles.size()}"></div>
  
  
     	  <input type="submit" id="btn" value="WRITE" class="btn btn-dark">
     	  
	</form>
</div>
<div id="sample">
	<div class="input-group">
 		 <div class="custom-file">
    			<input type="file" class="form-control-file border" id="inputGroupFile04" name="files">
    		
 		 </div>
  		<div class="input-group-append delete">
   		 <input class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" value="Delete">
  		</div>
	</div>
</div>

<script type="text/javascript" src="../resources/jquery/boardUpdate.js"></script>
 <script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>
<!-- <script type="text/javascript" src="../resources/js/insertCheck.js"></script>
 -->

</body>
</html>