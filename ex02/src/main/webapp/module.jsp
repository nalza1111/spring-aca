<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<button type="button" id="btnInsert">등록</button>
	<button type="button" id="btnInsert2">등록</button>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script type="text/javascript">
			
		//즉시실행함수
		(function test(greet) {
			console.log(greet)
		})('hello');
		
		var replyService = (function(){
			return{ name : 'AAAA',
					 add : function(){ console.log('add');},
					 upd : function(){ console.log('upd');},
					 del : function(){ console.log('del');},
					 msg : function(message){ console.log(message);}
					} //리턴값이 리플라이 서비스에 들어감
		})();
		$("#btnInsert").on("click", replyService.add)
		$("#btnInsert2").on("click", function(){
			replyService.msg('mm~')
		})
	</script>
</body>
</html>