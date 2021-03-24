<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Bank Update page</h1>

<form action="./bankbookUpdate" method="post">
	<%-- <input type ="hidden" name="booknumber" value="${dto.bookname}"> --%>
	Number <input type="text" readonly="readonly" name="booknumber" value="${dto.booknumber}"><br>

	Name <input type="text" name="bookname" value="${dto.bookname}"><br>
	Rate <input type="text" name="bookrate" value="${dto.bookrate}"><br>
	Sale <input type="text" name="booksale" value="${dto.booksale}"><br>
	<button> Update </button>
	</form>
	

</body>
</html>