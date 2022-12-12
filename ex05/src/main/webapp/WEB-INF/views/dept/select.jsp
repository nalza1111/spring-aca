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
	<h3>부서 단건 조회</h3>
	<form name="frm" method="post" action="delete">
		<ul>
			<li>departmentId : ${dept.departmentId }</li>
			<li>departmentName : ${dept.departmentName }</li>
			<li>managerId : ${dept.managerId }</li>
			<li>locationId : ${dept.locationId }</li>
			<input type="hidden" name="departmentId" value="${dept.departmentId }">
			<button id="btnDelete">포스트 사원삭제</button>
		</ul>
	</form>
	<%-- <button onclick="location.href='/update?empId='${emp.employeeId}">사원수정페이지로 이동</button> --%>
	<%-- <button onclick="location.assign('update?empId=${emp.employeeId}'">사원수정페이지로 이동</button> --%>
	<button id="btn">부서 수정페이지로 이동</button>
	<script type="text/javascript">
		btn.addEventListener("click", ev => {
			 location.assign('update?departmentId=${dept.departmentId}');
		})
		btnDelete.addEventListener("click", ev => {
			 frm.submit();
		})
	</script>
</body>
</html>