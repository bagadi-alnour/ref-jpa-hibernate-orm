<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>liste</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>

	<c:if test="${not empty msgErreur}">
		<div>
			<c:out value="${msgErreur }"></c:out>
		</div>
	</c:if>

	<c:url value="/detail" var="lienDetail"></c:url>
	<c:url value="/edition" var="lienEdition"></c:url>
	<c:url value="/suppression" var="lienSuppression"></c:url>
	<c:url value="/ajout" var="lienAjout"></c:url>

	<a href="${lienAjout }">
		<i class="bi bi-plus-square-fill" style="font-size: 40px !important;"></i>
	</a>

	<c:choose>
		<c:when test="${empty personnes or personnes.size() == 0 }">
			aucune personne
		</c:when>
		<c:otherwise>
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>nom</th>
						<th>actions</th>
					</tr>
				</thead>
				<c:forEach items="${personnes}" var="personne">
					<tr>
						<td>${personne.id }</td>
						<td>${personne.nom}</td>
						<td>
							<a href="${lienDetail}?id=${personne.id }"><i style="font-size:10px" class="bi bi-search"></i></a>
							<a href="${lienEdition}?id=${personne.id }"><i style="font-size:10px" class="bi bi-pencil-square"></i></a>
							<a href="${lienSuppression}?id=${personne.id }"><i style="font-size:10px" class="bi bi-x-square-fill"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>