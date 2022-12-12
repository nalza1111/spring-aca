<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>부서업데이트</h3>
	<form method="post" action="update" name="frm">
		departmentId: <input name="departmentId" readonly value="${dept.departmentId}"></br> <!--diabled =? 서버가 값을 서저에 안보냄  -->
		departmentName: <input name="departmentName" value="${dept.departmentName}"></br>
		managerId: <input name="managerId" value="${dept.managerId}"></br>
		locationId: <input name="locationId" value="${dept.locationId}"></br>
	<button>수정</button>
	<script type="text/javascript">
		frm.jobId.value = '${emp.jobId}';
	</script>
</body>
</html>