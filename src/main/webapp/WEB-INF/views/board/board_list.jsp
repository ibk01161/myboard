<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${sessionScope.userInfo.usr_name}(${sessionScope.userInfo.usr_id})님이 로그인 됨<br/>
<a href="../user/logout">로그아웃</a><br/>
<table border="1">
	<caption>게시판 리스트</caption>
	<tr>
		<th>게시판 명</th>
		<th>관리자</th>
	</tr>
	<c:forEach items="${list}" var="vo">
	<tr>
		<td><a href="./${vo.boa_no}/1/">${vo.boa_name}</a></td>
		<td>${vo.userVO.usr_name}(${vo.userVO.usr_id})</td>
	</tr>
	</c:forEach>
</table><br/>
<a href="insert">게시판 생성</a>

</body>
</html>