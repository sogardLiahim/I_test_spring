<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"  
href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js
"></script> 



<!-- 

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
 
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Link</a></li>
      <li><a href="#">Link</a></li>
    </ul>
    <button class="btn btn-danger navbar-btn">Button</button>
  </div>
</nav>

<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6" style="background-color:black;height:200px;color:white">My Text</div>
	<div class="col-md-3"></div>
</div>

<br/>
<div class="row">
<div class="col-md-3">
<input type = "button" onclick = "ajaxProduse()" value="aduce date" class="btn btn-primary"> 
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Introduce</button>
</div>
<div class="col-md-6">

<table class="table table-bordered">
	<thead>
			<tr>
				<th>Nume</th>
				<th>Cantitate</th>
				<th>Pret</th>
				<th>ID</th>
				<th>Serie</th>
				<th>Tara</th>
			</tr>
	</thead>
	<tbody id ="SectiuneNoua">
	
	</tbody>
</table>
</div>
<div class="col-md-3"></div>

</div>



<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Inputs</h4>
      </div>
      <div class="modal-body">
        Nume:     <br> <input type="text" id = "val1M"> </br>
  	    Cantitate:<br> <input type="text" id = "val2M"> </br>
  		Pret:     <br> <input type="text" id = "val3M"> </br>
  		ID:       <br> <input type="text" id = "val4M"> </br>
  		Serie:    <br> <input type="text" id = "val5M"> </br>
  		Tara:     <br> <input type="text" id = "val6M"> </br>
           <!-- 6 inputuri si un buton cu id pe ele  -->
<!--            nume produs: <input type="text" id="input1">
           <button class="asdsa" onclick="add=============" -->
           
           
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
<!--        // <button type="button" class="btn btn-primary" onclick = "addToTable()" data-dismiss = "modal" >Introduce</button>-->      
      <button type="button" class="btn btn-primary" onclick = "addToTableJSON()" data-dismiss = "modal" >Introduce</button>
      </div>
    </div>

  </div>
</div>


Calendar test: <p>Date: <input type="text" id="datepicker"></p>



testing calendar 2:
<div class="row">
    <div class="col-md-12">
         <h6>datetimepicker1</h6>

        <div class="form-group">
            <div class="input-group date" id="datetimepicker1">
                <input type="text" class="form-control" />	<span class="input-group-addon"><span class="glyphicon-calendar glyphicon"></span></span>
            </div>
        </div>
         <h6>datetimepicker2</h6>

        <input type="text" class="form-control" id="datetimepicker2" />
    </div>
</div>
</body>
<script>
$( function() {

	$('#datetimepicker1').datetimepicker({format : "DD/MM/YYYY hh:mm"});
	$('#datetimepicker2').datetimepicker({format : "DD/MM/YYYY hh:mm"});
  } );

var value1;

function sendToDB() 
{
	var value1 = $("#val1M").val();
	var value2 = $("#val2M").val();
	var value3 = $("#val3M").val();
	var value4 = $("#val4M").val();
	var value5 = $("#val5M").val();
	var value6 = $("#val6M").val();	
	
	var ctx = "${pageContext.request.contextPath}";
	$.ajax({
		method : "POST",
		url : ctx + "/api/trimiteProduse/",
		data :{"v1" : value1, 
			   "v2" : value2,
			   "v3" : value3,
			   "v4" : value4,
			   "v5" : value5,
			   "v6" : value6
	    },
		success : function(response) {
			alert(response);
		},
	});
}

function addToTable(){
	
	$("#SectiuneNoua").empty();
		var value1 = $("#val1M").val();
  		var value2 = $("#val2M").val();
  		var value3 = $("#val3M").val();
  		var value4 = $("#val4M").val();
  		var value5 = $("#val5M").val();
  		var value6 = $("#val6M").val();
  		sendToDB();
	$("#SectiuneNoua").append("<tr>");
	$("#SectiuneNoua").append("<td>"+value1+"</td>");
	$("#SectiuneNoua").append("<td>"+value2+"</td>");
	$("#SectiuneNoua").append("<td>"+value3+"</td>");
	$("#SectiuneNoua").append("<td>"+value4+"</td>");
	$("#SectiuneNoua").append("<td>"+value5+"</td>");
	$("#SectiuneNoua").append("<td>"+value6+"</td>");
	$("#SectiuneNoua").append("</tr>");
	
	$("#val1M").val("");
	$("#val2M").val("");
	$("#val3M").val("");
	$("#val4M").val("");
	$("#val5M").val("");
	$("#val6M").val("");

}

function addToTableJSON() 
{
	var ctx = "${pageContext.request.contextPath}";
	var Nume = $("#val1M").val();
	var Cantitate = $("#val2M").val();
	var Pret = $("#val3M").val();
	var ID = $("#val4M").val();
	var Serie = $("#val5M").val();
	var Tara = $("#val6M").val();
	
	var ProdusClient = {"Nume":Nume,
			            "Cantitate": Cantitate, 
			            "Pret": Pret,
			            "ID": ID, 
			            "Serie": Serie, 
			            "Tara": Tara};
	
	$.ajax({url:ctx +"/api/trimiteProduseJSON",
			method: "POST",
			contentType: 'application/json',
			data: JSON.stringify(ProdusClient),
			success:function(response){alert(response);
			}})
	
}

function ajaxTest() 
{
	var ctx = "${pageContext.request.contextPath}";
	$.ajax({
		method : "GET",
		url : ctx + "/api/UserData/",
		success : function(response) {
			//$("#UserData").alert(response);
			alert(response);
		},
	});
}



function ajaxProduse() 
{
	var ctx = "${pageContext.request.contextPath}";
	$.ajax({
		method : "GET",
		url : ctx + "/api/produse/",
		success : function(response) {
			 var produse = response.colectieProduse;
			 $("#SectiuneNoua").empty();
			for (var i=0;i<produse.length;i++){
				$("#SectiuneNoua").append("<tr>");
				 $("#SectiuneNoua").append("<td>"+produse[i].numeProdus+"</td>");
				 $("#SectiuneNoua").append("<td>"+produse[i].cantitate+"</td>");
				 $("#SectiuneNoua").append("<td>"+produse[i].pret+"</td>");
		        $("#SectiuneNoua").append("</tr>");
			}
			console.log(response);
			
		},
		error : function() {
			alert("eroare");
		}
	});
}



</script>

</html>