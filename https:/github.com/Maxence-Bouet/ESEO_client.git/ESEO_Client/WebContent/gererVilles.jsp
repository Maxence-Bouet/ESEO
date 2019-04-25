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

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">INSEE</th>
				<th scope="col">Nom</th>
				<th scope="col">Code postal</th>
				<th scope="col">Libelle</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Ville> villes = (List<Ville>) request.getAttribute("villes");
				for (Ville ville : villes) {
			%>
			<tr>
				<th scope="row"><%=ville.getCode_commune_INSEE()%></th>
				<td><%=ville.getNom_commune()%></td>
				<td><%=ville.getCode_postal()%></td>
				<td><%=ville.getLibelle_acheminement()%></td>
				<td>
					<form method="get" action="allVilles">
						<input type="hidden" class="form-control" name="redirection"
							value="unique">
						<input type="hidden" class="form-control" name="code"
							value="<%=ville.getCode_commune_INSEE()%>">
						<button type="submit" class="btn btn-outline-dark">Modifier</button>
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>