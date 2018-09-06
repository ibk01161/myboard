<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
var user_id_count = -1;
var user_id = '';
// -1 : 체크하지 않은 경우 (맨처음)
// 0  : 사용 가능 아이디
// 1  : 사용 불가능 아이디
function openIpcode() {
	window.open('zipcode','confirm','toolbar=no,location=no,status=no,menubar=no,scrollbar=yes,resizeable=no,width=400,height=400');
}


function validate() {				// 마지막으로 검사
	let f = document.regist;
	if (f.user_id.value.length < 4 || f.user_id.value.length > 13) {
		alert('아이디는 4 ~ 12글자로');
		f.user_id.focus();
		return;
	}
	if (f.user_name.value.length < 2 || f.user_name.value.length > 6) {
		alert('이름은 2 ~ 6 자로');
		f.user_name.focus();
		return;
	}
	if (f.user_pw.value.length < 4 || f.user_pw.value.length > 20) {
		alert('비번은 4 ~ 20 자로');
		f.user_pw.focus();
		return;
	}
	if (f.user_pw.value != f.user_pw2.value) {
		alert('비밀번호와 비밀번호 확인이 일치X');
		f.user_pw.focus();
		return;
	}
	if (f.user_birth.value == "") {
		alert('생년월일을 입력하세요');
		f.user_birth.focus();
		return;
	}
	if (f.user_phone.value == "") {
		alert('전화번호를 입력하세요');
		f.user_phone.focus();
		return;
	}
	if (f.zipcode.value == "") {
		alert('우편번호를 입력하세요');
		f.btnzipcode.focus();
		return;
	}
	if (f.address1.value == "") {
		alert('주소를 입력하세요');
		f.address1.focus();
		return;
	}
	if (f.address2.value == "") {
		alert('상세주소를 입력하세요');
		f.address2.focus();
		return;
	}
	
	if(user_id_count != 0) {
		alert('사용할 수 있는 아이디가 아닙니다.');
		return;
	}
	f.method = 'POST';		// 메소드 강제로 주기
	f.action = 'regist';
	f.submit()
	
	
} 
/* function callback(xhr) {
	if (xhr.readyState == 4) {
		if (xhr.status == 200) {
			user_id_count = parseInt(xhr.responseText.trim())
			if (user_id_count === 1) {
				document.getElementById('check_id_result').innerHTML = user_id + '는 이미 사용중인 아이디 입니다.';
				return;
			} else if (user_id_count === 0) {
				document.getElementById('check_id_result').innerHTML = user_id + '는 사용 가능 아이디';
				return;
			} else {
				alert('시스템 오류');
			}
		}
	}
} */

$(document).ready(function(){
	$('#user_id').on('keyup',function(){
		user_id_count = -1;
		let f = document.regist;
		user_id = document.regist.user_id.value;
		if (user_id.length < 4 || user_id.length > 13) {
			document.getElementById('check_id_result').innerHTML = '아이디는 4~ 12글자로';
			return;
		}
		
		$.post("checkID",{"user_id" : user_id})
		.done(function( data ) {
			user_id_count = parseInt(data)
			if (user_id_count === 1) {
				$('#check_id_result').html(user_id + '는 이미 사용중인 아이디 입니다.');
				return;
			} else if (user_id_count === 0) {
				$('#check_id_result').html(user_id + '는 사용 가능 아이디');
				return;
			} else {
				alert('시스템 오류');
			}
		});
	});
});

</script>
</head>
<body>
<form name="regist" method="post" >
<table border="1">
	<caption>회원 가입</caption>
<tr>
	<th>아이디</th>
	<td><input type="text" name="user_id" id="user_id" />
		<div id="check_id_result">4~ 12글자로<br/></div>
	</td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" name="user_name" id="user_name" /> 2 ~ 6 글자
	</td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="user_pw" id="user_pw" /> 4 ~ 20 문자</td>
</tr>
<tr>
	<th>비밀번호 확인</th>
	<td><input type="password" name="user_pw2" id="user_pw2" /></td>
</tr>
<tr>
	<th>생일</th>
	<td><input type="date" name="user_birth" id="user_birth" /></td>
</tr>
<tr>
	<th>전화</th>
	<td><input type="text" name="user_phone" id="user_phone" /></td>
</tr>
<tr>
	<th>우편번호</th>
	<td>
		<input type="text" name="zipcode" readonly="readonly" 
		onclick="alert('검색버튼을 이용하여 입력하세요');" 
		style="width:55px;"/>
		<input type="button" value="검색" name="btnzipcode"
		onclick="openIpcode()"/>
	</td>
</tr>
<tr>
	<th>주소</th>
	<td>
		<input type="text" name="address1" style="width:250px;"/><br/>
	</td>
</tr>
<tr>
	<th>상세 주소</th>
	<td>
		<input type="text" name="address2" /><br/>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="button" value="완료" onclick="validate()"/>
	</td>
</tr>
</table>
</form>
</body>
</html>