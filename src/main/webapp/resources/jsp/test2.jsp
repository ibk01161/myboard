<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function add_div(){

    var div = document.createElement('div');



    div.innerHTML = document.getElementById('room_type').innerHTML;

    document.getElementById('field').appendChild(div);

}
</script>



</head>
<body>
<input type="button" value="추가" onclick="add_div()"><br/>

<div id="room_type">

<div class="form-group">

	<label for="image">제목</label>

	<input type="text" id="title" name="title" class="form-control" ></input>

</div>

<input type="button" value="삭제" onclick="remove_div(this)">

</div>

</body>
</html>