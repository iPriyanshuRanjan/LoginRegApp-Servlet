<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<h2>Welcome to JSP Page</h2>
	<form action="update" method="post">
		<pre>
			Mobile<input type="text" name="mobile"
				value="<%=request.getAttribute("mobile")%>" />
			Email<input type="text" name="email"
				value="<%=request.getAttribute("email")%>" />
			
			
			<input type="submit" value="update" />


		</pre>
	</form>

</body>
</html>