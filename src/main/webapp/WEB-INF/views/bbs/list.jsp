<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	${user.id}님 환영합니다! 이곳은 임시 보드입니다
	<a href="<%= request.getContextPath() %>/bbs/write">
		글쓰기
	</a>
<div>
	<a href="<%= request.getContextPath() %>/">
		<button type="button">Login</button>
	</a>
</div>
</body>
</html>