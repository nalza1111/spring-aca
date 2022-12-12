<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
<!-- 검색조건 시작 -->
		<form name="searchFrm">
			title <input name="title" value="${boardVO.title }">
			writer <input name="writer" value="${boardVO.writer }">
			<input type="hidden" name="page" value="1">
			<button>검색</button>
		</form>
<!-- 검색조건 종료 -->
<!-- 목록 시작 -->
		<table>
			<thead>
				<tr>
				<th>Bno</th><th>Title</th><th>Content</th><th>Writer</th><th>RegDate</th><th>UpdateDate</th>
				</tr>
			</thead>
			<c:forEach items="${boards}" var="board">
				<tbody>
					 <tr>
						<td>${board.BNO}</td>
						<td>${board.TITLE }</td>
						<td><a href="./board?bno=${board.BNO}">${board.CONTENT }</a></td>
						<td>${board.WRITER }</td>
						<td>${board.REGDATE }</td>
						<td>${board.UPDATEDATE }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
<!-- 목록 종료 -->
<!-- 페이징 시작 -->
<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i">
	<a href="./list?page=${i}" >${i}</a>
</c:forEach>

<my:paging paging="${paging }" jsFunc="gopage"></my:paging>
<!-- 페이징 종료 -->
	<script>
		function gopage(i) {
			searchFrm.page.value = i;
			searchFrm.submit();
		}
	</script>
	</body>
</html>