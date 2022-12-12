<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update</title>
</head>
<body>
	<h3>사원업데이트</h3>
	<form method="post" action="update" name="frm">
		employeeId: <input name="employeeId" readonly value="${emp.employeeId}"></br> <!--diabled =? 서버가 값을 서저에 안보냄  -->
		firstName: <input name="firstName" value="${emp.firstName}"></br>
		lastName: <input name="lastName" value="${emp.lastName}"></br>
		email: <input name="email" value="${emp.email}"></br>
		${emp.hireDate}
		hireDate: <input name="hireDate" type="date" value="${emp.hireDate}"></br>
		<!-- 참조키 : select, radio, checkbox로 -->
		jobId: <select name="jobId">
					<c:forEach var="job" items="${jobs}">
						<option value="${job.jobId}">${job.jobTitle}</option>
					</c:forEach>
			   </select></br>
	<button>수정</button>
	<script type="text/javascript">
		frm.jobId.value = '${emp.jobId}';
	</script>
</body>
</html>