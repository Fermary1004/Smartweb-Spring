<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
	div {
		width: 280px;
		height: 22px;
		margin-bottom: 10px;
		background-color: #66CCCC;
	}
	label {
		color: #FFFFFF;
		padding-left: 5px;
	}
	input {
		float: right;
	}
	button {
		width: 100%;
		background-color: #FFFFFF;
		border: 1px solid #000000;
	}
	.radio {
		float : none;
	}
</style>
<body>
<h1>
	Hello world!  
</h1>
<form method="post" action="<%= request.getContextPath() %>/">
	<div>
		<label>ID : </label>
		<input name="id" type="text" />
	</div>
	<div>
		<label>PASSWORD : </label>
		<input name="pw" type="password" />
	</div>
	<div>
		<button type="submit">Login</button>
	</div>
</form>
<a href="<%= request.getContextPath() %>/signup">
	회원가입
</a>
<script>
	var check = ${login};
	if (check == "fail"){
		alert("아이디 및 패스워드가 다릅니다!");
	}	
</script>
</body>
</html>
