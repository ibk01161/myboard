<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
   $(document).ready(function() {
      $('#mybutton').click(function() {
    	  $.ajax({
    		  method: $('#mymethod').val(),
    		  url: '<c:url value="/rest/" />'
    		})
    		  .done(function( msg ) {
    		    alert( "Data Saved: " + msg );
    		  });
   });
</script>
</head>
<body>
<form id="myform">
<select id="mymethod">
	<option>Get</option>
	<option>Post</option>
	<option>Put</option>
	<option>Delete</option>

</select>
<input type="button" value="ok" id="mybutton"/>
</form>

</body>
</html>