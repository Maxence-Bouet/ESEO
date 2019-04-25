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
	<form method="get" action="DistanceVilleServlet">
		<div class="row justify-content-md-center col-md-12"
			style="margin-top: 10%; margin-bottom: 40px">
			<div class="col-md-3">
				<select class="custom-select" name="ville1">
					<option selected>-- Choisir une ville --</option>
					<%
						List<Ville> villes = (List<Ville>) request.getAttribute("villes");
						for (Ville ville : villes) {
					%>
					<option value="<%=ville.getLatitude()%>,<%=ville.getLongitude()%>"><%=ville.getNom_commune()%></option>
					<%
						}
					%>
				</select>
			</div>
			<div class="col-md-3">
				<select class="custom-select" name="ville2">
					<option selected>-- Choisir une ville --</option>
					<%
						for (Ville ville : villes) {
					%>
					<option value="<%=ville.getLatitude()%>,<%=ville.getLongitude()%>"><%=ville.getNom_commune()%></option>
					<%
						}
					%>
				</select>
			</div>
		</div>
		<div class="text-center" style="margin-bottom: 60px">
			<input type="hidden" class="form-control" name="redirection"
							value="distance">
			<button type="submit" class="btn btn-primary">Calculer la
				distance entre ces deux villes</button>
		</div>
	</form>

	<%
		if (request.getAttribute("distance") != null) {
	%>
	<div class="text-center">
		<h3><%=request.getAttribute("distance")%></h3>
	</div>
	<%
		}
	%>
	
	<%
		if (request.getAttribute("test") != null) {
	%>
	<div class="text-center">
		<h3><%=request.getAttribute("test")%></h3>
	</div>
	<%
		}
	%>
</body>
</html>