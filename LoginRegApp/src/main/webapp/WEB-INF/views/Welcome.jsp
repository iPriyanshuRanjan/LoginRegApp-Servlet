<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h2>Welcome to JSP Page</h2>
	<hr>
	<form action="saveReg" method="post">
		<pre>
			Name<input type="text" name="name" />
			City<input type="text" name="city" />
			Mobile<input type="text" name="mobile" />
			Email ID<input type="text" name="email" />
			<input type="submit" value="Save" />


		</pre>
	</form>

</body>
</html>