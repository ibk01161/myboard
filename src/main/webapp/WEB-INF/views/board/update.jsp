<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method ="post">
<table border="1">
	<caption>게시물 수정</caption>
<tr>
	<th>제목</th>
	<td><input type="text" name="art_title" value = "${articleVO.art_title}" 
	required="required" autofocus="autofocus"/></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="art_content" rows="5" cols="60">${articleVO.art_content}</textarea></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="입력 완료"/>
	</td>
</tr>
</table>
</form>
</body>
</html>