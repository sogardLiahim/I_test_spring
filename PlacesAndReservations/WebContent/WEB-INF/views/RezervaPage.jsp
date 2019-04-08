<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>

</head>
<body>
rqwrqrwqrqrqr

<select id = "selectDate" onchange="test()"></select>
<div id = "container">
<table>
	<thead>
	</thead>
	<tbody id="table-body">
	</tbody>
</table>
</div>

<div class="form-group">
  <label for="usr">nume: </label>
  <input type="text" class="form-control" id="nume">
</div>
<div class="form-group">
  <label for="pwd">email: </label>
  <input type="email" class="form-control" id="email">
</div>

    <br><br>
 <button class='btn btn-success' onclick=sendData()> trimite</button>


  <div id = "insert"  style =  "border: 1px solid black; width : 50% ; margin-top : 20px; height: 50px" class="col-md-6" >Insert : 
  </div>
</body>

<script>

$(document).ready(function(){
    saliCount();
 });	

function sendData()
{
	var email = $("#email").val() ;
	var nume = $("#nume").val();
	if(!(email == "") && !(nume == "")) 
	{ 
	console.log(email +""+ nume);
	}
	else 
	{
		alert("completati campurile");
	}
}

function submitValues() {
	  alert.log(firstname);
	}
 
 function saliCount() {
		var ctx = "${pageContext.request.contextPath}";
		$.ajax({
			method : "GET",
			url : ctx + "/api/getSaliId",
			success : function(response) {
				console.log(response);
				for (i = 0; i <= response.length; i++)
				{

				 	$("#selectDate").append("<option value='"+i+"' id = '"+response[i]+"' > Sala " +i+ "</option>");
				}
			},
		});

 }
 
 var randuri = new Array();
 function test() {
	 	var id = $("#selectDate").val();
		var ctx = "${pageContext.request.contextPath}";
		$.ajax({
			method : "POST",
			data :{"v1" : id},
			url : ctx + "/api/getSalaLocuri",
			success : function(response) {
				drawSites(response);
			},
		});
		
		

 }
 
 function drawSites(randuri){
	 console.log(randuri);		
	 
	 $("#table-body").empty();
	 
	 for (i = 0; i < randuri.length;i++)
	 {
		 var row = $("<tr></tr>");
		 for(j = 0 ; j < randuri[i]; j++)
		 {

			row.append("<td><button id='"+i+"-"+j+"'"
			    +"style='height:40px;width:40px;margin-left:5px;margin-top:50px;background-color:blue;display:inline-block' onclick='addSite("+i+","+j+")'>" 
				+ "<h3> "+j+" </h3>"
				+ "</button></td>");
			
		 }
			 $("#table-body").append(row);
	 }
 }
 
 function addSite(i,j)
 {console.log(i,j); $("#insert").append(" R: " + i +  " L: " + j + ";");}
</script>

</html>