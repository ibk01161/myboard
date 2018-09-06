<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="app" value="${pageContext.request.contextPath}"/>
<c:set var="vo" value="${articleVO}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
<!-- <script src="../js/xhr.js"></script> -->
<script src="${app}/resources/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="${app}/resources/js/jquery-ui-1.12.1/jquery-ui.js"></script>
<script>
var goodbad_count;
var type;

function confirm_delete() {
	if(confirm('정말로 삭제하시겠습니까?')) {
		location.href='delete';
	}
}

function goodbad(t) {
	type = t;
	new ajax.xhr.Request('goodbad', 'type=' + type + '&art_no=${vo.art_no}', callback, 'POST');
}

function callback(xhr) {
	if (xhr.readyState == 4) {
		if (xhr.status == 200) {
			goodbad_count = parseInt(xhr.responseText.trim());
			if (goodbad_count === -1) {
				alert('이미 추천/비추천 함');
				return;
			}
			else if(type === 'g') {
				document.getElementById('good_count').innerHTML = goodbad_count;
				return;
			} else if (type === 'b') {
				document.getElementById('bad_count').innerHTML = goodbad_count;
				return;
			} else {
				alert('시스템 오류');
				return;
			}
		}
	}
}

window.onload = function() {
	document.getElementById('good').onclick = function() {
		goodbad('g');
	}
	document.getElementById('bad').onclick = function() {
		goodbad('b');
	}
}
// 댓글
function selectComment() {
	$.ajax({
		method : 'GET',
     	url : "1/",	
     	data : {com_content : $('#com_content').val()}
	  }).done(function(data) {
		  displayCommentList(data);
		  // 댓글 리스트가 만들어진 후 삭제 이벤트 처리

     });
}

// 댓글 삭제
function myCommentEvent() {
	$('.btnDeleteOK').click(function(){
		if (confirm('정말로 삭제 하시겠습니까?')){
			let my_com_val = '1/' + $(this).attr('myval');
			$.ajax({
	    		method : 'DELETE',
	         	url : my_com_val,
	    	  }).done(function(data) {
	    		  displayCommentList(data);
	         });	
		}
	});
	
	// 댓글 수정
	$('.btnUpdateOK').click(function(){
		let com_id = 'com_' + $(this).attr('myval');
		let com_id_content = $('#' + com_id).html();
		$('#' + com_id).html('<textarea rows="3" cols="40" id="' + com_id + '_content">' + com_id_content + '</textarea><br/>' + 
		'<input type="button" id="goUpdate_' + com_id + '" value="수정완료" myval="'+ $(this).attr('myval') + '"/>' 
		+ '<input type="button" id="cancleUpdate_' + com_id + '" value="수정취소" />');
		$('#goUpdate_' + com_id).click(function(){
			if ($('#' + com_id + '_content').val() == "") {
			alert('내용을 적어주세요');
			$('#' + com_id + '_content').focus();
			return;
		}
			let my_com_val = '1/' + $(this).attr('myval');
			$.ajax({
	    		method : 'POST',
	         	url : my_com_val,
	         	data : {com_content : $('#' + com_id + '_content').val()}		// 텍스트박스 안에 있는 아이디를 보내야됨
	    	  }).done(function(data) {
	    		  displayCommentList(data);
	         });	
		});
		$('#cancleUpdate_' + com_id).click(function(){
			$('#' + com_id).html(com_id_content);
		});
		
	});
}


function displayCommentList(data) {
	 var mytable = "<table border='1'><tr><td>";
		$.each(data, function(key, val) {
			mytable += "<table><tr><td>" + val['com_no'] + "," + val['userVO']['usr_id'];
			mytable += "(" + val['userVO']['usr_name']+ ")";
			if(val['userVO']['usr_id'] == '${sessionScope.userInfo.usr_id}'){
				mytable += "<span class='ui-icon ui-icon-closethick btnDeleteOK' myval='" + val['com_no'] + "'style='cursor:pointer'/>";
				mytable += "<span class='ui-icon ui-icon-pencil 	btnUpdateOK' myval='" + val['com_no'] + "'style='cursor:pointer'/>";
				}
			mytable += "</td></tr>";
			mytable += "<tr><td><span id='com_"+ val['com_no'] +"'>" + val['com_content'] + "</span></td></tr></table><br/>";
		});
			mytable += "</td></tr></table>";

	 $('#commentDisplay').html(mytable);
	 myCommentEvent();
}

$(document).ready(function(){
	selectComment();
	
	$('#btnCommentOK').click(function(){
		$(this).unbind('click');
		let com_content = $('#com_content').val();
		if (com_content == "") {
			alert('먼저 댓글을 입력하세요.');
			$('#com_content').focus();
			return;
		}
		$.ajax({
    		method : 'POST',
         	url : "1/",	
         	data : {com_content : $('#com_content').val()}
    	  }).done(function(data) {
    		  displayCommentList(data);
        	 $('#com_content').val('');
         });		
	});
	
 
});

</script>
</head>
<body>
<table border="1">
	<caption>게시물 상세보기</caption>
<tr>
	<th>글번호</th>
	<td>${vo.art_no}</td>
</tr>
<tr>
	<th>제목</th>
	<td>${vo.art_title}</td>
</tr>
<tr>
	<th>작성자</th>
	<td>${vo.userVO.usr_name}(${vo.userVO.usr_id})</td>
</tr>
<tr>
	<th>작성일</th>
	<td><fmt:formatDate value="${vo.art_regdate}" pattern = "yyyy-MM-dd HH:mm:ss"/></td>
</tr>
<tr>
	<th>조회수</th>
	<td>${vo.art_readcnt}</td>
</tr>

<tr>
	<th>내용</th>
	<td>${vo.art_content}</td>
</tr>
<tr>
	<th>추천</th>
	<td><span id="good_count">${vo.art_like}</span><img src="${app}/resources/img/good.png" id="good"/></td>
</tr>
<tr>
	<th>비추천</th>
	<td><span id="bad_count">${vo.art_dislike}</span><img src="${app}/resources/img/bad.png" id="bad"/></td>
</tr>
<tr>
	<th>작성자ip</th>
	<td>${vo.art_ip}</td>
</tr>
<tr>
	<td colspan="2">
		<a href="list">[리스트]</a>
		<c:if test="${vo.userVO.usr_id == sessionScope.userInfo.usr_id}">
		<a href="update?art_no=${vo.art_no}">[수정]</a>
		<a href="javascript:;" onclick="confirm_delete()">[삭제]</a>
		</c:if>
	</td>
</tr>
<tr>
	<td colspan="2">
	<table>
		<tr>
			<td>
			
				<textarea id="com_content" name="com_content" style="width:400px;height:60px;"></textarea><br/>
				<input type="button" id="btnCommentOK" value="댓글등록"  />
				
				
			</td>
		</tr>
	</table>
	<br/>
	
	<div id="commentDisplay"></div>
	
	
	</td>
</tr>


</table><br/>
</body>
</html>