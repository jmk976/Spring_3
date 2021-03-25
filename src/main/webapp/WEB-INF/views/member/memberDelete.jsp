<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


 
 <h1>Member delete Page</h1>
  ${member.id}님 탈퇴하시겠습니까?
	 <form action="memberDelete" method="post">
	 
     
	 <button ><a href="./memberDelete?id=${member.id}">탈퇴</a> </button>
	 </form>


</body>
</html>