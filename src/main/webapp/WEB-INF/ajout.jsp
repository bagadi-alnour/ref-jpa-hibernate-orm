<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edition</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<c:url value="/index.html" var="lienAccueil"></c:url>
	<a href="${lienAccueil }"><i class="bi bi-arrow-left-square-fill"
		style="font-size: 40px !important;"></i></a>

	<c:url value="/ajout" var="lienAjout"></c:url>

	<form method="post" action="${lienAjout}">
		<div class="form-group">
			<label for="personneNom">nom</label> <input type="text"
				class="form-control" name="nom" id="personneNom"
				value="${personne.nom}">
		</div>
		<div class="form-group">
			<label for="personnePrenom">prenom</label> <input type="text"
				class="form-control" id="personnePrenom" name="prenom"
				value="${personne.prenom}">
		</div>
		<button type="submit" class="btn btn-primary">valider</button>
	</form>
</body>
</html>