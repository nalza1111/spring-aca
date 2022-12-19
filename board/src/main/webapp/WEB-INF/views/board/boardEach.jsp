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
	<h3>게시판 상세페이지</h3>
	<form name="frm" method="post" action="delete">
		Bno <input type="text" class="form-control" name="bno" id="bno" value="${board.bno}" readonly>
		Title <input type="text" class="form-control" id="title" value="${board.title }"readonly>
		Writer <input type="text" class="form-control" id="writer" value="${board.writer }"readonly>
		RegDate <input type="text" class="form-control" id="RegDate" value="${board.regDate }"readonly>
		UpdateDate <input type="text" class="form-control" id="updateDate" value="${board.updateDate }"readonly>
		<div class="form-group">
			<label for="comment">Content:</label>
			<textarea class="form-control" rows="5" id="content" readonly>${board.content }</textarea>
		</div>
		<button id="del">포스트삭제</button>
	</form>
	<button id="delButton">삭제</button>
	<button id="upButton">수정</button>
	<script>
		delButton.addEventListener("click", ev => {
			location.assign('delete?bno=${board.bno}');
		})
		upButton.addEventListener("click", ev => {
			location.assign('update/${board.bno}');
		})
	</script>	
</body>
</html>