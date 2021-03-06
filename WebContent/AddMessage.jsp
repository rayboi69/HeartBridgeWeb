<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Message</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<%
		String userName = (String) request.getSession(true).getAttribute("name").toString();

		if (userName == null) {
			userName = "N/A";
		}
	%>
	<%@ include file="header.html"%>

	<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8">
		    <div style="color:cornflowerblue;font-weight: bold; margin-left: 20px;font-size: 20px; margin-top: 100px">
		    	<h1> Create Message </h1>
			<form action="AddMessageServlet" method="post">
				<table class= "table table-hover">
					<tr>
						<td>To</td>
						<td><select id="friendId" name="friendId">
								<c:forEach var="friends" items="${friendshipList}">
									<option value="${friends.friend.getUserId()}">${friends.friend.getUserName()}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>From</td>
						<td><%=userName%></td>
					</tr>
					<tr>
						<td>Subject</td>
						<td><input name="subject" /></td>
					</tr>
					<tr>
						<td>Body</td>
						<td><TEXTAREA NAME="body" ROWS="5"></TEXTAREA></td>
					</tr>


				</table>
				<input type="hidden" name="pageFrom" value="AddMessage"> 
				<input type="submit" />
			</form>
		</div>
	</div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>