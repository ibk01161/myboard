<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<script>
function setZipcode(zip1,zip2,addr1) {
	let f = opener.document.regist; 
	f.zipcode.value = zip1 + '-' + zip2;
	f.address1.value = addr1;
	self.close();
}
</script>
</head>
<body>
<form method="POST">
<table>
	<caption>우편번호 검색</caption>
<tr>
	<th colspan="2"> 동 : 
		<input type="text" name="area" 
		autofocus="autofocus" required="required" 
		style="width:100px;" value="${area}" />
		<input type="submit" value="검색" />
	</th>
</tr>

<c:if test="${area != null && zipcodeList.size() == 0}">		<!-- 검색했는지 확인 (첫값은 널값) -->
<tr>
	<td colsapn="2">검색한 [${area}]동을 포함한 주소는 존재 하지 않습니다.</td>
</tr>
</c:if>

<c:if test="${zipcodeList != null}">
<tr>
	<c:forEach items="${zipcodeList}"  var="vo">
	<tr>
		<td width = "65" >
		<a href = "javascript:;" onclick="setZipcode('${vo.zipcode1}','${vo.zipcode2}','${vo.address1}')">${vo.zipcode1}-${vo.zipcode2}</a></td>
		<td>${vo.address1}</td>
	</tr>
	</c:forEach>
</c:if>
</table>
</form>
</body>
</html>