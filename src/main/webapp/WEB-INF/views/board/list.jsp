<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="app" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${sessionScope.userInfo.usr_name}(${sessionScope.userInfo.usr_id})님이 로그인 됨<br/>
<a href="${app}user/logout">로그아웃</a><br/>
<table border="1">
<caption>${boardVO.boa_name}</caption>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<c:forEach items="${list}" var="vo">
<tr>
	<td>${vo.art_no}</td>
	<td><a href="${vo.art_no}/">${vo.art_title}</a></td>
	<td>${vo.userVO.usr_name}(${vo.userVO.usr_id})</td>
	<td><fmt:formatDate value="${vo.art_regdate}" pattern = "yyyy-MM-dd"/></td>
	<td>${vo.art_readcnt}</td>
</tr>
	</c:forEach>
</table>
<a href="insert">게시물 입력</a>
<hr/>
<a href="${app}/board/">게시판 리스트로</a>
</body>
</html>