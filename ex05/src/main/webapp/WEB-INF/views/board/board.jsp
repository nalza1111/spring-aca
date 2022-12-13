<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세페이지</title>
</head>
	<body>
	<h3>게시판 상세페이지</h3>
		<table>
			<thead>
				<tr>
				<th>Bno</th><th>Title</th><th>Content</th><th>Writer</th><th>RegDate</th><th>UpdateDate</th>
				</tr>
			</thead>
				<tbody>
					<tr>
						<td>${board.bno}</td>
						<td>${board.title }</td>
						<td>${board.content }</td>
						<td>${board.writer }</td>
						<td>${board.writer }</td>
						<td>${board.updateDate }</td>
					</tr>
				</tbody>
		</table>
		<h3>댓글</h3>
		<table>
			<c:forEach items="${replys}" var="reply">
				<tr>
					<td>${reply.replyer}</td>
					<td>${reply.reply}</td>
					<td><c:if test="${reply.replyDate>=reply.updateDate}">${reply.replyDate}</c:if></td>
					<td><c:if test="${reply.replyDate<reply.updateDate}">${reply.updateDate}</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>