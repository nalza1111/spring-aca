<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	* {
	  box-sizing: border-box;
	}
	
	body {
	  font-family: Arial;
	  padding: 10px;
	  background: #f1f1f1;
	}
	
	/* Header/Blog Title */
	.header {
	  padding: 30px;
	  text-align: center;
	  background: white;
	}
	
	.header h1 {
	  font-size: 50px;
	}
	
	/* Style the top navigation bar */
	.topnav {
	  overflow: hidden;
	  background-color: #333;
	}
	
	/* Style the topnav links */
	.topnav a {
	  float: left;
	  display: block;
	  color: #f2f2f2;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	}
	
	/* Change color on hover */
	.topnav a:hover {
	  background-color: #ddd;
	  color: black;
	}
	
	/* Create two unequal columns that floats next to each other */
	/* Left column */
	.leftcolumn {   
	  float: left;
	  width: 75%;
	}
	
	/* Right column */
	.rightcolumn {
	  float: left;
	  width: 25%;
	  background-color: #f1f1f1;
	  padding-left: 20px;
	}
	
	/* Fake image */
	.fakeimg {
	  background-color: #aaa;
	  width: 100%;
	  padding: 20px;
	}
	
	/* Add a card effect for articles */
	.card {
	  background-color: white;
	  padding: 20px;
	  margin-top: 20px;
	}
	
	/* Clear floats after the columns */
	.row:after {
	  content: "";
	  display: table;
	  clear: both;
	}
	
	/* Footer */
	.footer {
	  padding: 20px;
	  text-align: center;
	  background: #ddd;
	  margin-top: 20px;
	}
	
	/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
	@media screen and (max-width: 800px) {
	  .leftcolumn, .rightcolumn {   
	    width: 100%;
	    padding: 0;
	  }
	}
	
	/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
	@media screen and (max-width: 400px) {
	  .topnav a {
	    float: none;
	    width: 100%;
	  }
	}
	</style>
</head>
<body>
<body>
	<div class="header">
	  <h1>My Website</h1>
	  <p>Resize the browser window to see the effect.</p>
	</div>
	
	<div class="topnav">
	  <a href="${pageContext.request.contextPath }/board/boardList">Board</a>
	  <a href="#">모할까</a>
	  <a href="#">모할까2</a>
	  <a href="#" style="float:right">모할까3</a>
	</div>
	
	<div class="row">
	  <tiles:insertAttribute name="content" />
	</div>
	
	<div class="footer">
	  <h2>Footer</h2>
	</div>

</body>
</html>