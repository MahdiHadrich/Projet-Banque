<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="tn.enis.entity.CompteBancaire"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CompteBancaire compte= (CompteBancaire)request.getAttribute("compte");%>
<h1>Modifier un compte dont le rib=<%=compte.getRib()%></h1>
	
	<form action="CompteServlet" method="post">
	<input type="hidden" name="rib" value="<%=compte.getRib()%>"/>
		<table>
		<tr>
				<td>client:</td>
				<td><input type="text" name="client" value="<%=compte.getClient()%>"/></td>
			</tr>
			<tr>
				<td>Solde:</td>
				<td><input type="text" name="solde" value="<%=compte.getSolde()%>"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" name="update" value="Modifier"/></td>
			</tr>
		</table>
	</form>
</body>
</html>