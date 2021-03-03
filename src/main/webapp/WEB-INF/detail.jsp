<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>detail</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>

	<c:url value="/index.html" var="lienAccueil"></c:url>
	<a href="${lienAccueil }">
		<i class="bi bi-arrow-left-square-fill" style="font-size: 40px !important;"></i>
	</a>
	<c:choose>
		<c:when test="${empty personne}">
			aucune personne
		</c:when>
		<c:otherwise>
			<form>
				<div class="form-group">
					<label for="personneId">id</label>
					 <input
						type="text" class="form-control" id="personneId" value="${personne.id}" readonly="readonly"> 
				</div>
				<div class="form-group">
					<label for="personneNom">nom</label>
					 <input
						type="text" class="form-control" id="personneNom" value="${personne.nom}" readonly="readonly"> 
				</div>
				<div class="form-group">
					<label for="personnePrenom">prenom</label>
					 <input
						type="text" class="form-control" id="personnePrenom" value="${personne.prenom}" readonly="readonly"> 
				</div>
			</form>
		</c:otherwise>
	</c:choose>

</body>
</html>