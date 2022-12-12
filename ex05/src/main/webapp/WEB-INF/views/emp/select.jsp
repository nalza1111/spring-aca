<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Select</title>
</head>
<body>
	<h3>사원단건조회</h3>
	<form name="frm" method="post" action="delete">
		<ul>
			<li>사번 : ${emp.employeeId }</li>
			<li>이름 : ${emp.firstName }</li>
			<li>부서 : ${emp.jobId }</li>
			<!-- 주위!! 네임이 employeeId VO랑 같아야 포스트로 넘겼을 때 값이 제대로 들어감 -->
			<input type="hidden" name="employeeId" value="${emp.employeeId }">
			<button id="btnDelete">포스트 사원삭제</button>
		</ul>
	</form>
	<%-- <button onclick="location.href='/update?empId='${emp.employeeId}">사원수정페이지로 이동</button> --%>
	<%-- <button onclick="location.assign('update?empId=${emp.employeeId}'">사원수정페이지로 이동</button> --%>
	<button id="btn">사원수정페이지로 이동</button>
	<button id="del">사원삭제</button>
	<script type="text/javascript">
		btn.addEventListener("click", ev => {
			 location.assign('update?id=${emp.employeeId}');
		})
		del.addEventListener("click", ev => {
			 location.assign('delete?id=${emp.employeeId}');
		})
		frm.addEventListener("click", ev => {
			 frm.submit();
		})
	</script>
</body>
</html>