<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			width: 80%;
			margin : auto;
		}
		.form-group {
			margin : 0 auto;
		}
	</style>
</head>
<body>
	<div class="form-group">
		<form method="post" action="../update" class="form-group">
			bno  <input name="bno" value="${board.bno}"class="form-control" readonly>
			Title  <input name="title" value="${board.title}"class="form-control">
			Writer  <input name="Writer" readonly value="${board.writer}"class="form-control">
			Content <input name="Content" value="${board.content}"class="form-control">
			regDate  <input type="date" readonly name="RegDate" value="<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd" />" class="form-control">
			updateDate  <input type="date" name="updateDate" value="<fmt:formatDate value="${board.updateDate }" pattern="yyyy-MM-dd" />"class="form-control">
			<button>수정</button>
		</form>
	</div>
</body>
</html>