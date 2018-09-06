<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<script>
		function inst()
		{
			var div = document.getElementById("target");
			var txt = prompt("새문단에 추가할 텍스트 입력","");
			var oldpara = div.getElementsByTagName("p")[0];	//첫번째로 만나는 p
			var txtNode = document.createTextNode(txt);
			var para = document.createElement("h1");
			para.appendChild(txtNode);

			div.insertBefore(para,oldpara);
		}//insert함수 

		function dele(){
			alert("제거 할 문단을 클릭하세요.");
			var paras = document.getElementsByTagName("p");
			for (var i = 0; i < paras.length; i++)
			{
				paras[i].onclick = ddel;
			}
		}

		function ddel(){
			var parent = this.parentNode;
			parent.removeChild(this);
		}
	</script>
</head>
<body>
<div id = target>
<p>aaaaaaaaaa</p>
<p>bbbbbbbbbb</p>
<p>cccccccccc</p>
</div>
<input type = "button" value = "추가하기" onclick = "inst()">
<input type = "button" value = "삭제하기" onclick = "dele()">
</body>
</html>