<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
MemberPage

<table>

			<tr>
			 <td>Id : </td>
			 <td>${member.id}</td>
			</tr>
			
			<tr>
			 <td>Name : </td>
			 <td>${member.name}</td>
			</tr>
			
			<tr>
			 <td>Phone : </td>
			 <td>${member.phone}</td>
			</tr>
			
			<tr>
			 <td>E-mail : </td>
			 <td>${member.email}</td>
			</tr>
	
	</table>
	
	
	<a href="./memberDelete">탈퇴</a>





</body>
</html>