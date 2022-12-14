<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="../resources/json.min.js"></script>
<script>
		$(function(){
			
			bookInsert();
			
			let path = "${pageContext.request.contextPath}"
			
			function bookInsert(){
				$("#btnInsert").on("click", function() {
					let plus = 0;
					$('input').each(function (idx, item){
						console.log(item);
						console.log(item.value);
						
						if(item.value==''){
							alert('항목이 입력되지 않았습니다');
							$('[name="bookName"]').focus();
							return false;
						} else {
							plus++;
						}})
					if(plus==7){
						$.ajax({
							url : path+'/book/insertbook',
							method : "post",
							data : $('#form1').serializeObject()
							}).then( res =>{
								console.log(res);
								alert('등록완료')
							})
						}
				})
			}
			})
	</script>
</head>
<body>
	<form id="form1">
		도서번호:<input type="number" name="bookNum" value="${bookNum}" readonly><br />
		도서명::<input type="text" name="bookName"><br /> 도서표지:<input
			type="text" name="bookCoverimg"><br /> 출판일자(yyyy/MM/dd):<input
			type="text" name="bookDate"><br /> 금액:<input type="text"
			name="bookPrice"><br /> 출판사:<input type="text"
			name="bookPublisher"><br /> 도서소개:<input type="text"
			name="bookInfo"><br />
		<button type=button id="btnInsert">등록</button>
	</form>
</body>
</html>