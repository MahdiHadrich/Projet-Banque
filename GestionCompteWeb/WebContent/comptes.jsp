<%@page import="tn.enis.entity.CompteBancaire"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajout de compte</h1>
	
	<form action="CompteServlet" method="post">
		<table>
			<tr>
				<td>Solde:</td>
				<td><input type="text" name="solde" /></td>
			</tr>
			<tr>
				<td>client:</td>
				<td><input type="text" name="client" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="add" /></td>
			</tr>
		</table>
	</form>
	<br />
<h1>Liste des comptes</h1>
	<% List<CompteBancaire>  comptes =(List <CompteBancaire>) request.getAttribute("comptes");
	%>

	<table BORDER=1 >
		<tr>
			<th>rip</th>
			<th>client</th>
			<th>solde</th>
		</tr>
		<% if(comptes!=null && !comptes.isEmpty()){
					for(CompteBancaire cb : comptes){
				
				%>
		<tr>
			<td><%=cb.getRib()%></td>
			<td><%=cb.getClient()%></td>
			<td><%=cb.getSolde()%></td>
			<td><a href="CompteServlet?delete=delete&rib=<%=cb.getRib()%>">Delete</a></td>
			<td><form action="CompteServlet" method="POST">
			<input type="hidden" name="rib" value="<%=cb.getRib()%>">
				<input type="submit" name="edit" value="edit">
				</form>
			</td>
		</tr>
		<%
				}}
%>

	</table>
</body>
</html>