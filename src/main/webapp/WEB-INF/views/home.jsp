<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form method="post" action="<%= request.getContextPath() %>/"
	style="<c:if test="${user != null}">display:none</c:if>">
	<div>
		<label>ID : </label>
		<input name="id" type="text" />
	</div>
	<div>
		<label>PASSWORD : </label>
		<input name="pw" type="password" />
	</div>
	<div>
		<button class="btn btn-primary col-sm-2" type="submit">Login</button>
	</div>
</form>
<div>
	<a href="<%= request.getContextPath() %>/signup">
		<button class="btn btn-danger col-sm-2" type="button">Sign up</button>
	</a>
</div>
<div>
	<a href="<%= request.getContextPath() %>/bbs/list">
		<button class="btn btn-secondary col-sm-2" type="button">BBS</button>
	</a>
</div>
</body>
</html>
