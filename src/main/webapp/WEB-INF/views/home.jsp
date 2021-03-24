<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./bankbook/bankbookList"> BankBook List</a>
<a href="./member/memberJoin">Join</a>
<a href="./member/memberLogin">Login</a>

<a href="./member/memberPage">My Page</a>
<a href="./member/memberLogout">Log out</a>
</body>
</html>
