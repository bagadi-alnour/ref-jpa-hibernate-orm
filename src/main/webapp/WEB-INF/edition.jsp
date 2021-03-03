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
	<a href="${lienAccueil }"><i class="bi bi-arrow-left-square-fill" style="font-size: 40px !important;"></i></a>

	<c:url value="/edition" var="lienEdition"></c:url>
	
	<c:if test="${not empty msgErreur}">
		<div>
			<c:out value="${msgErreur }"></c:out>
		</div>
	</c:if>
	
	<c:choose>
		<c:when test="${empty personne}">
			aucune personne
		</c:when>
		<c:otherwise>
			<form method="post" action="${lienEdition}">
				<div class="form-group">
					<label for="personneId">id</label> <input type="text"
						class="form-control" id="personneId" value="${personne.id}"
						name="id" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="personneNom">nom</label> <input type="text"
						class="form-control" name="nom" id="personneNom" value="${personne.nom}">
				</div>
				<div class="form-group">
					<label for="personnePrenom">prenom</label> <input type="text"
						class="form-control" id="personnePrenom"
						name="prenom" value="${personne.prenom}" >
				</div>
				<button type="submit" class="btn btn-primary">valider</button>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>