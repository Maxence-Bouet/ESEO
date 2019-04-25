<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="eseo.dao.Ville"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="Header.jsp" />
	<%
		Ville ville = (Ville) request.getAttribute("ville");
	%>

	<form method="post" action="test">
		<div class="row w-80 justify-content-md-center" style="margin-top: 5%">
			<div class="col-md-3">
				<p>Code</p>
				<input type="text" class="form-control" name="code"
					value="<%=ville.getCode_commune_INSEE()%>">
			</div>

			<div class="col-md-3">
				<p>Nom</p>
				<input type="text" class="form-control" name="nom"
					value="<%=ville.getNom_commune()%>">
			</div>

			<div class="col-md-3">
				<p>Code postal</p>
				<input type="text" class="form-control" name="postal"
					value="<%=ville.getCode_postal()%>">
			</div>

			<div class="col-md-3">
				<p>Libelle</p>
				<input type="text" class="form-control" name="libelle"
					value="<%=ville.getLibelle_acheminement()%>">
			</div>

			<div class="col-md-3">
				<p>Ligne 5</p>
				<input type="text" class="form-control" name="ligne"
					value="<%=ville.getLigne_5()%>">
			</div>

			<div class="col-md-3">
				<p>Latitude</p>
				<input type="text" class="form-control" name="latitude"
					value="<%=ville.getLatitude()%>">
			</div>

			<div class="col-md-3">
				<p>Longitude</p>
				<input type="text" class="form-control" name="longitude"
					value="<%=ville.getLongitude()%>">
			</div>
		</div>
		<div class="text-center" style="margin-top: 40px">
			<input type="hidden" class="form-control" name="redirection"
							value="distance">
			<button type="submit" class="btn btn-primary">Modifier</button>
		</div>
	</form>
</body>
</html>