<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>book</title>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
		let path = "${pageContext.request.contextPath}"
		$(function() {
			bookList();
			bookSelecte();
			
			function bookList(){
				$.ajax({
					url : path+'/book/bookList'
				}).then( res => {
						console.log(res);
						for(book of res){
							let tag = makeTr(book);
							$("tbody").append(tag);
						}
					})
			}
			function makeTr(book){
				let result = (book.bookPrice).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
				let tag = `<tr  data-id="\${book.bookNo}">
					<td>\${book.bookNo}</td>
					<td>\${book.bookName}</td>
					<td>\${book.bookCoverimg}</td>
					<td>\${book.bookDate}</td>
					<td>##<fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd" />##</td>
					<td>\${result}</td>
					<td>\${book.bookPublisher}</td>
					<td>\${book.bookInfo}</td>
				</tr>`;
				return tag;
			}
			function bookSelecte(){ //한글은 안됨
				$("table").on("click", "tr", function(){
					let id = $(this).closest("tr").data("id");
					console.log(encodeURIComponent(id));
					location.href="../book/bookSelect?bookNo="+id;
				})
			}
			
		})
	</script>
</head>
<body>
	<h4>도서 조회/수정</h4>
	<table>
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			
			</tr>
		</tbody>
	</table>
</body>
</html>