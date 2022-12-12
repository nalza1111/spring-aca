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
	<h3>부서등록</h3>
	<form method="post" action="insert"></br>
		departmentName: <input name="departmentName"></br>
		managerId: <input name="managerId"></br>
		locationId: <input name="locationId"></br>
		<button>등록</button>
	</form>
</body>
</html>