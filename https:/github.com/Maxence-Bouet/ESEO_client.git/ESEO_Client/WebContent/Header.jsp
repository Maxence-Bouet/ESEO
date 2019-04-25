<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Ville</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<form method="get" action="allVilles">
						<input type="hidden" class="form-control" name="redirection"
							value="distance">
						<button type="submit" class="btn btn-light">Distance</button>
					</form>
				</li>
				<li class="nav-item active">
					<form method="get" action="allVilles">
						<input type="hidden" class="form-control" name="redirection"
							value="gerer">
						<button type="submit" class="btn btn-light">Afficher</button>
					</form>
				</li>
			</ul>
		</div>
	</nav>

</body>
</html>