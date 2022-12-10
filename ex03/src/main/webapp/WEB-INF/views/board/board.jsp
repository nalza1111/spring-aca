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
						<td>${board.BNO}</td>
						<td>${board.TITLE }</td>
						<td>${board.CONTENT }</td>
						<td>${board.WRITER }</td>
						<td>${board.REGDATE }</td>
						<td>${board.UPDATEDATE }</td>
					</tr>
				</tbody>
		</table>
	</body>
</html>