<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 리스트</title>
</head>
<body>
	<script>
		$(function(){
			let result = '${result}'
			//debugger
			if(result) {
				$(".modal-body").html(result)
				$('#exampleModal').modal() //모달생성 modal(opti) opti는 옵션
				$("#exampleModal").modal('show');//4버전 주석은 5버전
		}})
	</script>
	<h3>부서리스트</h3>
	<div>결과${result }</div>
		<table class="table">
			<thead  class="thead-dark">
			<tr>
				<th>departmentId</th><th>departmentName</th><th>managerId</th><th>locationId</thead>
			<tbody>
				<c:forEach items="${depts}" var="dept">
					<tr>
						<!-- 상대경로 -->
						<td><a href="select?departmentId=${dept.departmentId }">${dept.departmentId }</a></td>
						<td><a href="../dept/select?departmentId=${dept.departmentId }">${dept.departmentName }</a></td>
						<!-- 절대경로 -->
						<td><a href="${pageContext.request.contextPath}/dept/select?departmentId=${dept.departmentId }"> ${dept.managerId }</a></td>
						<td>${dept.locationId }</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<a href="insert">입력</a>
<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
<form name="searchFrm">
		<input type="hidden" name="page" value="2">
	</form>
<my:paging paging="${paging }" jsFunc="gopage"></my:paging>
<!-- 모달 -->
<script>
		function gopage(i) {
			searchFrm.page.value = i;
			searchFrm.submit();
		}
</script>
</body>
</html>