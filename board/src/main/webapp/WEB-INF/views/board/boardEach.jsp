<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<style>
		body {
			width: 80%;
			margin : auto;
		}
		.form-group {
			margin : 0 auto;
		}
	</style>
	<script>
		let path = '${pageContext.request.contextPath}'+'/board';
		$(function(){
			//댓글리스트
			replyList();
			function replyList(){
				$.ajax({
					url : path + '/reply',
					method : 'get',
					data : {bno:$("#bno").val()},
					dataType: 'json'
				}).then( res => {
					for(reply of res){
						let tag = makeTr(reply);
						$("#replybody").append(tag);						
					}
				})
			}
			//makeTr
			function makeTr(reply){
				let tag = `<tr data-id="\${reply.rno}">
					<td>\${reply.replyer}</td>
					<td>\${reply.reply}</td>
					<td>\${reply.replydate}</td>
					<td>\${reply.updatedate}</td>
					<td><button type="button" id="btnDelete" class="btn btn-primary mb-2">삭제</button></td>
					<td><button type="button" id="btnSelect" class="btn btn-primary mb-2">조회</button></td>
					<td><button type="button" id="btnReployUpdate" class="btn btn-primary mb-2">수정</button></td>
				</tr>`;
				return tag;
			}
			//댓글입력
			replyInsert();
			function replyInsert(){
				$("#btnReployInsert").on('click', function(){
					let bno = $('#bno').val();
					let reply = $("#reply").val();
					let replyer = $("#replyer").val();
					$.ajax({
						url : path + '/reply',
						method : 'post',
						data : {bno, reply, replyer},
						dataType: 'json'
					}).then( res => {
						console.log(res)
						$("#replybody").append(makeTr(res));
					})
				})
			}
		})
	</script>
</head>
<body>
	<div class="form-group">
		<form name="frm" method="post" action="delete" class="form-group">
			Bno  <input type="text" class="form-control" name="bno" id="bno" value="${board.bno}" readonly>
			Title <input type="text" class="form-control" id="title" value="${board.title }"readonly>
			Writer <input type="text" class="form-control" id="writer" value="${board.writer }"readonly>
			RegDate <input type="text" class="form-control" id="RegDate" value="<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd" />"readonly>
			UpdateDate  <input type="text" class="form-control" id="updateDate" value="<fmt:formatDate value="${board.updateDate }" pattern="yyyy-MM-dd" />"readonly>
			<div class="form-group">
				<label for="comment">Content:</label>
				<textarea class="form-control" rows="5" id="content" readonly>${board.content }</textarea>
			</div>
			<button id="del">포스트삭제</button>
		</form>
		<button id="delButton">삭제</button>
		<button id="upButton">수정</button>
		<h3>댓글</h3>
		<table class="table" id="replybody">
				<%-- <tr>
					<td>${reply.replyer}</td>
					<td>${reply.reply}</td>
					<td><c:if test="${reply.replyDate>=reply.updateDate}">${reply.replyDate}</c:if></td>
					<td><c:if test="${reply.replyDate<reply.updateDate}">${reply.updateDate}</c:if></td>
				</tr> --%>
		</table> 
		<form id="frmRe">
			<div class="form-group">
				<label for="reply">Content:</label>
				<textarea class="form-control" rows="5" id="reply"></textarea>
				replyer <input type="text" class="form-control" id="replyer">
				<button type="button" id="btnReployInsert" class="btn btn-primary mb-2">댓글작성</button>
			</div>
		</form>
	</div>
	<script>
		delButton.addEventListener("click", ev => {
			location.assign('delete?bno=${board.bno}');
		})
		upButton.addEventListener("click", ev => {
			location.assign('update/${board.bno}');
		})
	</script>	
</body>
</html>