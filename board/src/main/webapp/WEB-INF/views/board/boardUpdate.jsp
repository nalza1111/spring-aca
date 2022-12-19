<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>게시판수정</h3>
	${board.regDate}
	${board.updateDate}
	<form method="post" action="../update"></br>
		bno : <input name="bno" value="${board.bno}"></br>
		Title : <input name="title" value="${board.title}"></br>
		Writer : <input name="Writer" value="${board.writer}"></br>
		Content: <input name="Content" value="${board.content}"></br>
		regDate : <input type="date" name="RegDate" value="<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd" />"></br>
		updateDate : <input type="date" name="updateDate" value="<fmt:formatDate value="${board.updateDate }" pattern="yyyy-MM-dd" />"></br>
		<button>수정</button>
	</form>
</body>
</html>