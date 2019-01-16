<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form method="post" action="<%= request.getContextPath() %>/">
	<!-- 컨트롤러에서 받을 매개변수와 같은 name을 지정해야함을 주의
		 request.getContextPath()는 기본 url이 저장되어있는 변수 -->
	<input type="text" name="name" />
	<button>제출</button>
</form>

</body>
</html>
