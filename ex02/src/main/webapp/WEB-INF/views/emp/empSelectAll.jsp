<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empSelectAll</title>
</head>
<body>
<!-- 검색조건 시작 -->
	<form name="searchFrm"><!-- 액션생략하면 자기를 부름 -->
		부서 <my:select/>
		<%-- <my:select2/> --%>
		<%-- <input name="departmentId" value="${empVO.departmentId}"> --%>
		firstName<input  name="firstName" value="${empVO.firstName}">
		<input type="hidden" name="page" value="1">
		<button>검색</button>
	</form>
<!-- 검색조건 종료 -->
<!-- 목록 시작 -->
	<table  class="table table-dark">
		<tr><th>employeeId</th><th>departmentId</th><th>firstName</th><th>lastName</th></tr>
		<c:forEach var="emp" items="${emps}">
			<tr>
				<%-- <td>${st.employeeId}</td> 상태변수 이것저것 알려줌 last 등등등--%>
				<td>${emp.employeeId }</td>
				<td>${emp.departmentId }</td>
				<td><a href="./empSelect?id=${emp.employeeId }">${emp.firstName }</a></td>
				<td>${emp.lastName }</td>
			</tr>
		</c:forEach>
	</table>
<!-- 목록 끝 -->
<!-- 페이징 시작 -->
<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i">
	<!-- <a href="./empSelectAll?page=${i}" >${i}</a> -->
	<!-- 검색조건도 페이지에 넣어주기 위해 -->
	<a href="#" onclick="javascript:gopage(${i})" >${i}</a>
</c:forEach>

<!-- 페이징 끝 -->
<my:paging paging="${paging}" jsFunc="gopage"></my:paging>
<script>
	function gopage(i) {
		//폼태그 정보랑 같이 넘겨야 검색 페이지가 됨
		searchFrm.page.value = i;
		searchFrm.submit();
	}
</script>
</body>
</html>