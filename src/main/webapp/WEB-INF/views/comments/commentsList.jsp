<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-hover">
	<c:forEach items="${list}" var="comments">
		<tr>
			<td>${comments.writer}</td>
			<td>${comments.contents}</td>
			<td>${comments.regDate}</td>
			<td><input type="checkbox" class="del" value ="${comments.commentNum}"></td>
		</tr>
		
	 </c:forEach>
</table>

<button type="button" class="btn btn-danger" id="remove">Delete</button>

