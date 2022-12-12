<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List</title>
</head>
<body>
	<script>
		$(function(){
			let result = '${result}'
			//debugger
			if(result) {
				//alert('${result}')
				$(".modal-body").html(result)
				//모달 생성
				/* const myModal = new bootstrap.Modal('#exampleModal', {
					  keyboard: false
					}) */
				// show
				/* let exampleModal = document.querySelector("#exampleModal"); */
				/* myModal.show(exampleModal)  *///layout.jsp에서 js 파일들 바디에서 헤더안으로 올리기
				$('#exampleModal').modal() //모달생성 modal(opti) opti는 옵션
				$("#exampleModal").modal('show');//4버전 주석은 5버전
		}})
	</script>
	<h3>사원리트스</h3>
	<div> 결과 ${ result}</div>
	<table>
		<thead>
		<th>
		</thead>
		<tbody>
			<c:forEach items="${emps}" var="emp">
				<tr>
					<!-- 상대경로 -->
					<td><a href="select?empId=${emp.employeeId }">${emp.employeeId }</a></td>
					<td><a href="../emp/select?empId=${emp.employeeId }">${emp.employeeId }</a></td>
					<!-- 절대경로 -->
					<td><a href="${pageContext.request.contextPath}/emp/select?empId=${emp.employeeId }"> ${emp.firstName } ${emp.lastName }</a></td>
					<td>${emp.departmentId }</td>
					<td>${emp.hireDate }</td>
					<td>${emp.jobId }</td>
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
<!-- 모달 -->
</body>
</html>