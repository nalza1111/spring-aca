<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			width: 80%;
			margin : auto;
		}
		.form-group {
			margin : 0 auto;
		}
	</style>
</head>
<body>
	<div class="form-group">
		<form method="post" action="insert"class="form-group">
			Title : <input name="title"class="form-control">
			Writer : <input name="Writer"class="form-control">
			Content: <input name="Content" class="form-control">
			<div class="form-group">
				<label for="comment">Content:</label>
				<textarea class="form-control" rows="5" name="Content"></textarea>
			</div>
			RegDate : <input type="date" name="RegDate"class="class="form-control"">
			<button>등록</button>
		</form>
	</div>
</body>
</html>