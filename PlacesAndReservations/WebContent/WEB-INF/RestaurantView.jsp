<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron" style="background-color:black;color:white;font-weight:bold;font-size:20pt">
			<span class="glyphicon glyphicon-glass"> Places & Reservations</span>
	</div>
	
	<h3>Restaurant View</h3>
	
	<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-4">
		<div class="form-group">
  	<label for="usr">Numele :</label>
 	 <input type="text" class="form-control" id="nume">
	</div>
	<div class="form-group">
	  <label for="mese">Numar de mese:</label>
  		<input type="text" class="form-control" id="mese">
	</div>
	
	<button class="btn btn-primary">Trimite</button>
	<button class="btn btn-danger" onclick="getDataFromServer()">Test</button>
		<button class="btn btn-danger" onclick="getUsersFromServer()">get users from server!</button>
	
	
	<div id="test">
		here:<!--  Text will be generated here-->
	</div>
	
		<div class="panel-default">
			<div class="panel-heading">Users List</div>
			<div class="panel-body" id="usersList">
				
			</div>
		</div>
		
</div>

<div class="col-md-2"></div>
<div class="col-md-4">
		<h3>Afacerea ta conteaza pentru noi!</h3>
</div>
	</div>
	
	
	
</body>

<script>
	

	function sendDataToServer() {
		var ctx = "${pageContext.request.contextPath}";

		var obj = {
			nume : $("#nume").val(),
			mese : $("#mese").val()
		};
		
		alert("daa");
		
		$.ajax({
			type : "POST",
			url : ctx + "/rest/receive/",
			data : JSON.stringify(obj),
			success : function(data) {
				alert("data has been sent");
			},
			error : function() {
				alert("error");
			}

		});
	}

	function getDataFromServer() {
		var ctx = "${pageContext.request.contextPath}";

		$.ajax({
			method : "GET",
			url : ctx + "/api/test/",
			success : function(response) {
				$("#test").append(response);
			},
			error : function() {
				alert("eroare");
			}
		});
		
	}
	
	
		function getUsersFromServer() {
		var ctx = "${pageContext.request.contextPath}";

		$.ajax({
			method : "GET",
			url : ctx + "/api/getUsers/",
			success : function(response) {
			alert("succes");
/* 				$("#usersList").append(response.nume+" varsta:"+response.varsta);
 */			},
			error : function() {
				alert("eroare");
			}
		});
		
	}
</script>
</html>