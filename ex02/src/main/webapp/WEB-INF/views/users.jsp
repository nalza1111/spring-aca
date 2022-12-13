<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./resources/json.min.js"></script>
<script type="text/javascript">
	//ready 이벤트
	let path = '${pageContext.request.contextPath}';
	$(function(){
		userList();
		userDelete();
		userSelecte();
		userUpdate();
		userInsert();
	/* 	function userInsert(){//update와 같지만 requestbody가 없음
			$("#btnInsert").on("click", function() {
				let id = $('[name=id]').val();
				let tr = $('[data-id='+id+']');
				$.ajax({
					url : path + '/users',
					method : "post",
					data : $('#form1').serializeObject(), //리퀘스트바디가있음->json화->스트링화
					//contentType : "application/json;"//보내는 파일은 json입니다 data와 세트->서비스에 리퀘스트바디가없음
				}).then( res =>{
					// jquery의 replaceWith이용
					console.log(res);
					$("tbody").append(makeTr(res));
				})
			})
		} */
		/* function userInsert(){//requestbody가 있음
			$("#btnInsert").on("click", function() {
				let id = $('[name=id]').val();
				let tr = $('[data-id='+id+']');
				$.ajax({
					url : path + '/users',
					method : "post", // 기본contentType은 application/url...
					data : JSON.stringify($('#form1').serializeObject()), //리퀘스트바디가있음->json화->스트링화
					contentType : "application/json;"//보내는 파일은 json입니다 data와 세트->서비스에 리퀘스트바디가없음
				}).then( res =>{
					console.log(res);
					$("tbody").append(makeTr(res));
				})
			})
		} */
		function userInsert(){//위와 동일한데 배열을 만들어 보낼 시 + 데이터타입이 json이기 때문에 리퀘스트바디 뗀거 쓰기
			$("#btnInsert").on("click", function() {
				let id = $('[name=id]').val();
				let name = $('[name=name]').val();
				let password = $('[name=password]').val();
				let role = $('[name=role]').val();
				$.ajax({
					url : path + '/users',
					method : "post",
					data : {id, password, name, role}, //==$('#form1').serializeObject()
					//data : {id:id, password:password, name:name, role:role} 위와 같음,
					dataType : "json"//응답결과 json=res 타입같음
				}).then( res =>{
					console.log(res);
					$("tbody").append(makeTr(res));
				})
			})
		}
		/*{id:'text10', password:'1111', name:'홍길동', role:'Admin'} = 쿼리스트링으로 넘어감*/
		/*{id:'text10', password:'1111', name:'홍길동', role:'Admin'} = 만약*/
		function userUpdate(){
			$("#btnUpdate").on("click", function() {
				let id = $('[name=id]').val();
				let tr = $('[data-id='+id+']');
				$.ajax({
					url : path + '/users',
					method : "put",
					data : JSON.stringify($('#form1').serializeObject()), //리퀘스트바디가있음->json화->스트링화
					contentType : "application/json;"//보내는 파일은 json입니다 data와 세트
				}).then( res =>{
					// jquery의 replaceWith이용
					console.log(res);
					tr.replaceWith(makeTr(res));
				})
			})
		}
		//동적생성 버튼의 이벤트
		function userDelete(){
			$("tbody").on("click", "#btnDelete", function(){
				let tr = $(this).closest('tr'); 
				let id = $(this).closest("tr").data("id");
				$.ajax({
					url: path + "/users/" + encodeURIComponent(id),
					method: "delete",//소대문자상관x
					//data:
					contentType : "application/text; charset=utf-8;"
				}).then(res=>{
					tr.remove();
				})
			})
		}
		function userSelecte(){ //한글은 안됨
			$("tbody").on("click", "#btnSelecte", function(){
				let id = $(this).closest("tr").data("id");
				console.log(encodeURIComponent(id));
				$.ajax({
					url: path + "/users/" + encodeURIComponent(id),//한글인코딩 없어도 작동잘되네?
					method: "get",//소대문자상관x
					//data:
					contentType : "application/text; charset=utf-8;"
				}).then(res=>{
					console.log(res);
					$('[name="id"]').val(res.id);
					$('[name="name"]').val(res.name);
					$('[name="password"]').val(res.password);
					$('[name="password"]').val(res.role);
				})
			})
		}
		function userList(){
			$.ajax({
				url : path+'/users'
				//method, method는 겟타입생략가능,
				//data:, 매개변수없어서 안적어도 됨
				//dataType, 데이터타입은 생략가능(리퀘스트바디가 있으면 꼭 적기)
				//contentType 서버에서 어떤 타입을 받을 것인지
			}).then( res => {
				/* for(user of res){
					$("<tr>").append($("<td>").html(user.id))
							 .append($("<td>").html(user.password))
						 	 .append($("<td>").html(user.name))
							 .append($("<td>").html(user.role))
							 .appendTo("tbody");
						} */
						
					for(user of res){
						let tag = makeTr(user);
							//자바스크립트에서 써는 el표시 \해줘야함 jsp와 다름 주석에 달러넣으면 안됨
						$("tbody").append(tag);
					}
				})
		}
		function makeTr(user){
			let tag = `<tr  data-id="\${user.id}">
				<td>\${user.id}</td>
				<td>\${user.password}</td>
				<td>\${user.name}</td>
				<td>\${user.role}</td>
				<td><button type="button" id="btnDelete">삭제</button>
				<td><button type="button" id="btnSelecte">조회</button>
			</tr>`;
			return tag;
		}	
	})
	
</script>
</head>
<body>
	<div class="container">
		<form id="form1" class="form-horizontal" >
			<h2>사용자 등록 및 수정</h2>
			<div class="form-group">
				<label>아이디:</label> <input type="text" class="form-control"
					name="id">
			</div>
			<div class="form-group">
				<label>패스워드:</label> <input type="text" class="form-control"
					name="password">
			</div>
			<div class="form-group">
				<label>이름:</label> <input type="text" class="form-control"
					name="name">
			</div>
			
			<!-- 		<div class="form-group">
			<label >성별:</label>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="남">남</label>
			</div>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="여">여</label>
			</div>	
		</div>	 -->
			<div class="form-group">
				<label>역할:</label> <select class="form-control" name="role">
					<option value="Admin">관리자</option>
					<option value="User">사용자</option>
				</select>
			</div>
			<div class="btn-group">
				<input type="button" class="btn btn-primary" value="등록"
					id="btnInsert" /> <input type="button" class="btn btn-primary"
					value="수정" id="btnUpdate" /> <input type="button"
					class="btn btn-primary" value="초기화" id="btnInit" />
			</div>
		</form>
	</div>
	<hr />
	<div class="container">
		<h2>사용자 목록</h2>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="text-center">아이디</th>
					<th class="text-center">패스워드</th>
					<th class="text-center">이름</th>
					<th class="text-center">역할</th>
				</tr>
			</thead>
			<tbody>
				<!-- 
			<tr>
				<td>아이디</td>
				<td>아이디</td>
				<td>아이디</td>
				<td>아이디</td>
				<td><button type="button" id="btnDelete"></button>//버툰이 하나면 서브밋되어버림
				<td><button type="button" id="btnSelect"></button>
			</tr>
		 -->
			</tbody>
		</table>
	</div>
</body>
</html>