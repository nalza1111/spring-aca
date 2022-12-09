<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empSelectAll</title>
</head>
<body>
	<form><!-- 액션생략하면 자기를 부름 -->
		부서<input name="departmentId" value="${empVo.departmentId}">
		firstName<input  name="firstName" value="${empVo.firstName}">
		<button>검색</button>
	</form>
	<table>
		<tr><th>employeeId</th><th>departmentId</th><th>firstName</th><th>lastName</th></tr>
		<c:forEach var="emp" items="${emps}">
			<tr>
				<%-- <td>${st.employeeId}</td> 상태변수 이것저것 알려줌 last 등등등--%>
				<td>${emp.employeeId }</td>
				<td>${emp.departmentId }</td>
				<td>${emp.firstName }</td>
				<td>${emp.lastName }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>