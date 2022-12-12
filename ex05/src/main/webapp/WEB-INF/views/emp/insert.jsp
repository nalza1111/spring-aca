<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert</title>
</head>
<body>
	<h3>사원등록</h3>
	<form method="post" action=""></br>
		firstName: <input name="firstName"></br>
		lastName: <input name="lastName"></br>
		email: <input name="email"></br>
		hireDate: <input name="hireDate"></br>
		<!-- 참조키 : select, radio, checkbox로 -->
		jobId: <select name="jobId">
					<c:forEach var="job" items="${jobs}">
						<option value="${job.jobId}">${job.jobTitle}</option>
					</c:forEach>
			   </select></br>
		departmentId: <input name="departmentId"></br>
		<button>등록</button>
	</form>
</body>
</html>