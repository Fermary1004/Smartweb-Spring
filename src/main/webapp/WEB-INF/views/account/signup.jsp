<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>회원가입</title>
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
</style>
</head>
<body>
	<h1>회 원 가 입</h1>
	<form action="<%= request.getContextPath() %>/signup" method="post">
		<div>
			<label>ID : </label>
			<input name="id" type="text" />
		</div>
		<div>
			<label>PASSWORD : </label>
			<input name="pw" type="password" />
		</div>
		<div>
			<label>E-MAIL : </label>
			<input name="email" type="email" />
		</div>
		<div>
			<button type="submit">sign up please</button>
		</div>
	</form>
	<script>
		var check = ${fail};
		if (check == true){
			alert("중복된 아이디 입니다!");
		}	
	</script>
</body>
</html>