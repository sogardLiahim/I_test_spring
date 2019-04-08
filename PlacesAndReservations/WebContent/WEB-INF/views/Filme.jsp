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
      <a class="navbar-brand" href="#">Cinema Virtual</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Link</a></li>
    </ul>
    <button class="btn btn-danger navbar-btn">Button</button>
  </div>
</nav>




<div class="col-md-3">
  <div class="form-group">
     <div class="input-group date" id="datetimepicker1">
    <input type="text" id = "date" class="form-control" />	<span class="input-group-addon"><span class="glyphicon-calendar glyphicon"></span></span>
   </div>
 </div>
        
Nume Film: <input type = "text" class = "form-control" id="NumeFilm" />

Descriere Film: <input type = "text" class = "form-control" id="Descriere" />

Pret: <input type = "text" class = "form-control" id="Pret" />

Gen: <input type = "text" class = "form-control" id="Gen" />

IdSala: <input type = "text" class = "form-control" id="IdSala" />
</div>

<button type="button" onclick = "sendMovie()">Send !</button>


 	<form id="upload-file-form" enctype="multipart/form-data">
		<label for="upload-file-input">Upload your file:</label> <input
			id="upload-file-input" type="file" name="uploadFile" accept="*" />
		<button id="myButton">Send Photo</button>
	</form> 



</body>
<script>
$( function() {

	$('#datetimepicker1').datetimepicker({format : "DD/MM/YYYY hh:mm"});
  } );
  
  
$("#myButton").on('click',function(e){
	
e.preventDefault();
alert("intra");
var myData = new FormData();
var file = $( '#upload-file-input' )[0].files[0]
console.log(file);
myData.append("uploadFile",file);

alert("intra in functie");
	var ctx = "${pageContext.request.contextPath}";

  $.ajax({
  	url:ctx+"/upload/File/",
  	method:"POST",
  	data:myData,
  	enctype:'multipart/form-data',
  	processData:false,
  	contentType:false,
  	cache:false,
  	success : function(){
  		alert("uploaded successfully");
  	}
  })
});


function sendMovie() 
{
	var NumeFilm = $("#NumeFilm").val();
	var Descriere = $("#Descriere").val();
	var Pret = $("#Pret").val();
	var Data = $('#date').val();
	var Gen =  $('#Gen').val();
	var IdSala = $('#IdSala').val();
	
	var ctx = "${pageContext.request.contextPath}";
	
	$.ajax({
		method : "POST",
		url : ctx + "/api/UploadMovie/",
		data :{
			   "v1" : NumeFilm, 
			   "v2" : Descriere,
			   "v3" : Pret,
			   "v4" : Data,
			   "v5" : Gen,
			   "v6" : IdSala
	    },
		success : function(response) {
			alert(response);
		},
	});
}
  </script>
  
 </html>