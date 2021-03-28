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



<div class="container">

  <h2>NOTICE</h2>
  <table class="table border">
    <thead class="thead-dark">
      <tr>
        <th>제목</th>
        <th>작성자</th>
        <th>작성날짜</th>
         <th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${dto.title}</td>
        <td>${dto.writer}</td>
        <td>${dto.regDate}</td>
        <td>${dto.hit}</td>
      </tr>
      </tbody>
      </table>
      
      <div class="container p-3 my-3 border">
  
 		 <p> ${dto.contents}</p>           
		</div>
        
        
  </div>
  
  <div class="container">
      <a href="./noticeUpdate?num=${dto.num}"> <button type="button" class="btn btn-dark"> 수정 </button></a>
      <a href="./noticeDelete?num=${dto.num}"> <button type="button" class="btn btn-dark"> 삭제 </button></a>
      
	</div>


</body>
</html>