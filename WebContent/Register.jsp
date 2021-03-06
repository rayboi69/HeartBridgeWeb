<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
p {
	color: red;
}
</style>


</head>
<body>
	<script>
		function validate(form) {
			if (form.user_name.value == "") {
				document.getElementById("errorMessage").innerHTML = "Username can't be empty";
				form.user_name.focus();
			} else if (form.password == "") {
				document.getElementById("errorMessage").innerHTML = "Password can't be empty";
				form.password.focus();
			} else {
				form.submit();
			}
		}
	</script>

	<%
		String message = (String) request.getAttribute("message");

		if (message == null) {
			message = "";
		}
	%>


	<%@ include file="header.html"%>
	<p><%=message%></p>
	<form role="form" action="RegisterController" method="post">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<div class="form-group">
					<label for="userName">User Name:</label> <input type="text"
						class="form-control" name="user_name">
				</div>

				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" name="password">
				</div>

				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" name="email">
				</div>

				<div class="form-group">
					<label for="gender">Gender:</label> <select class="form-control"
						name="gender">
						<option value="gender">Gender</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				<div class="form-group">
					<label for="age">Age:</label> <input type="text"
						class="form-control" name="age">
				</div>

				<button type="submit">Register</button>

			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-4"></div>
		</div>
	</form>

	<%@ include file="footer.html"%>

</body>
</html>