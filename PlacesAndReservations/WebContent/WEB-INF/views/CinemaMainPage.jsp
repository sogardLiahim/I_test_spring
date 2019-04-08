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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js
"></script>

<style>
.backgroundColorByMe {
	background-color: black;
}

.textSpecs {
	color: white;
	text-align: left;
	margin-left: 5%;
}
</style>


<!-- 

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" />

</head>



<body class="backgroundColorByMe">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Cinema Virtual</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="rezerva">Rezerva</a></li>
			</ul>
			<button class="btn btn-danger navbar-btn" onclick="moviesShow()">Button</button>
		</div>
	</nav>
	<div id="containerMovies">
		<h1>March 2019 Wed 20</h1>
	</div>
</body>


<script>

$(document).ready(function(){
	moviesShow();
});

var genreMovies = new Array();
	function moviesShow() {
		var ctx = "${pageContext.request.contextPath}";
		$.ajax({
			method : "GET",
			url : ctx + "/api/getFilme",
			success : function(response) {
				console.log(response[0]);
				
				// Array Movies
			  for (i = 0; i < response.length; i++) {
				var verifyMovie = true;
				
				for (var x in genreMovies){
					if (genreMovies[x] == response[i].genFilm){
						verifyMovie = false;
					}
				}
					
				if (verifyMovie) {	
					populateContainerMovie(response[i].genFilm);
					genreMovies.push(response[i].genFilm);
				  }	
				}
				
				// Output Movies
				
				console.log(genreMovies);
				
				for (i = 0; i < response.length; i++) {
					var sala = response[i].idSala;
					var descriere = response[i].descriere;
					var numeFilm = response[i].numeFilm;
					var genFilm = response[i].genFilm;
					//   var ora = new Date(response[i].dataSiOra *1000);
					var ora = new Date(response[i].dataSiOra);
					$("#Ora"+genFilm).append("<p>" + ora.getHours() + "</p>");
					$("#Titlu"+genFilm ).append("<p>" + numeFilm + "</p>");
					$("#Descriere"+genFilm).append("<p>" + descriere + "</p>"); 
					
					

				}
			},
		});
	}

	function populateContainerMovie(genID) {
	var genre ="<p class='h3' class='textMovieTitle' style='color: rgb(255, 65, 17)'>"+genID+"</p>"
		       +"<div class='container-fluid' style='background-color: rgb(78, 67, 72)'>"
		       +"<div class='col-sm-2'>"
		       +"<h4>Ora</h4>"
		       +"</div>"
		       +"<div class='col-sm-4'>"
		       +"<h4>Titlu</h4>"
		       +"</div>"
		       +"<div class='col-sm-6'>"
		       +"<h4>Desciere</h4>"
		       +"</div>"
		       +"<div class='row'>"
		       +"<div class='col-sm-2'>"
		       +"<p class='textSpecs' id='Ora"+genID+"'></p>"
		       +"</div>"
		       +"<div class='col-sm-4'>"
		       +"	<p class='textSpecs ' id='Titlu"+genID+"'></p>"
		       +"</div>"
		       +"<div class='col-sm-6'>"
		       +"	<p class='textSpecs ' id='Descriere"+genID+"'> </p>"
		       +"</div>"
		       +"</div>"
		       +"</div>";
	$("#containerMovies").append(genre);     
		
	}
	

	
</script>

</html>