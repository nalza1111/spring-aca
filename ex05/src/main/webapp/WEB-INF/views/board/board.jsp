<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	${board }
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
	</body>
</html>