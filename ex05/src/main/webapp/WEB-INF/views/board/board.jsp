<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 상세페이지</title>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	//ready이벤트
	let path = '${pageContext.request.contextPath}';
	$(function(){
		replyList();
		replyInsert();
		replySelect();
		replyUpdate();
		replyDelete();
		//댓글 삭제
		function replyDelete() {
			$("table").on("click", "#btnDelete", function(){
				let rno = $(this).closest("tr").data("id");
				let tr = $(this).closest("tr");
				$.ajax({
					url :  path + "/board/reply/" + rno,
					method : "delete"
				}).then( res => {
					tr.remove();
				})
			})
		}
		//댓글 수정
		function replyUpdate(){
			$("table").on("click", "#btnReployUpdate", function(){
				let rno = $(this).closest("tr").data("id");
				let tr = $('[data-id='+rno+']');
				let reply = $("#reply").val();
				let replyer = $("#replyer").val();
				$.ajax({
					url : path + "/board/reply",
					method: "put",
					data : JSON.stringify({ rno, reply, replyer}),
					contentType : "application/json;"
				}).then( res=> {
					console.log(res)
					tr.replaceWith(makeTr(res));
				})
			})
		}
		//댓글 확인
		function replySelect(){
			$("table").on("click", "#btnSelect", function(){
				console.log($(this).closest("tr").data("id"));
				let rno = $(this).closest("tr").data("id");
				$.ajax({
					url: path + "/board/reply/"+rno,
					method: "get",
				}).then( res => {
					console.log(res);
					$("#reply").val(res.reply);
					$("#replyer").val(res.replyer);
				})
			})
		}
		//댓글리스트
		function replyList(){
			$.ajax({
				url : path + '/board/reply',
				data : { bno:$("#bno").val() }
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
		function replyInsert(){
			$("#btnReployInsert").on("click", function(){
				let bno = $('#bno').val()
				let reply = $("#reply").val();
				let replyer = $("#replyer").val();
				console.log("bno"+bno);
				console.log(reply);
				$.ajax({
					url : path + "/board/reply",
					method: "post",
					data : { bno, reply, replyer},
					dataType : "json"
				}).then( res=> {
					console.log(res)
					$("#replybody").append(makeTr(res));
				})
			})
		}
	})
	</script>
</head>
	<body>
		<h3>게시판 상세페이지</h3>
			<div class="form-group">
				Bno <input type="text" class="form-control" name="bno" id="bno" value="${board.bno}" readonly>
				Title <input type="text" class="form-control" id="title" value="${board.title }"readonly>
				Writer <input type="text" class="form-control" id="writer" value="${board.writer }"readonly>
				RegDate <input type="text" class="form-control" id="RegDate" value="${board.regDate }"readonly>
				UpdateDate <input type="text" class="form-control" id="updateDate" value="${board.updateDate }"readonly>
				<div class="form-group">
					<label for="comment">Content:</label>
					<textarea class="form-control" rows="5" id="content" readonly>${board.content }</textarea>
				</div>
			</div>
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
	</body>
</html>