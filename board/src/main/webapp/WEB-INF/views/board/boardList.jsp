<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
	<form name="searchFrm"  class="form-inline" >
			title <input name="title" value="${boardVO.title }" class="form-control mb-2 mr-sm-2">
			writer <input name="writer" value="${boardVO.writer }" class="form-control mb-2 mr-sm-2">
			<input type="hidden" name="page" value="1">
			<button class="btn btn-primary mb-2">검색</button>
		</form>
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
					<td><a href="boardEach?bno=${board.BNO}">${board.TITLE }</a></td>
					<td>${board.CONTENT }</td>
					<td>${board.WRITER }</td>
					<td><fmt:formatDate value="${board.REGDATE }" pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${board.UPDATEDATE }" pattern="yyyy-MM-dd" /></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<my:paging paging="${paging }" jsFunc="gopage"></my:paging>
	<a href="boardInsert">글쓰기</a>
	<!-- 페이징 종료 -->
	<script>
		function gopage(i) {
			searchFrm.page.value = i;
			searchFrm.submit();
		}
	</script>
</body>
</html>