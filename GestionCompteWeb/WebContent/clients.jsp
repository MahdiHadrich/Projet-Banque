<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="tn.enis.entity.ClientBanque"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<title>Insert title here</title>
</head>
<body class="col px-md-2">

<h1>Ajout des clients</h1>
	<form action="ClientServlet" method="POST">

		<table>
			<tr>
				<td>cin</td>
				<td><input type="text" name="cin"></td>
			</tr>
			<tr>
				<td>nom</td>
				<td><input type="text" name="nom"></td>
			</tr>
			<tr>
				<td>prenom</td>
				<td><input type="text" name="prenom"></td>
			</tr>
			<tr>
				<td>adresse</td>
				<td><input type="text" name="adresse"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="add"
					class="btn btn-primary"></td>
			</tr>
		</table>

	</form>
	<h1>Liste des clients</h1>
	
		<% List<ClientBanque>  clients =(List <ClientBanque>) request.getAttribute("clients");%>
	
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Cin</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Adresse</th>
				<th scope="col">Delete</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		
			<% if(clients!=null && !clients.isEmpty()){
					for(ClientBanque cb : clients){
				
				%>
			
			<tr id="tr<%=cb.getCin()%>">
				<td><%=cb.getCin()%></td>
				<td><%=cb.getNom()%></td>
				<td><%=cb.getPrenom()%></td>
				<td><%=cb.getAdresse()%></td>
				<td><a href="#" onclick="deleteClient(<%=cb.getCin()%>)">delete</a></td>
				<td>
					<form action="ClientServlet" method="POST">
						<input type="hidden" name="cin"  value="<%=cb.getCin()%>"> 
						<input type="submit" name="action" value="edit" class="btn btn-danger">
					</form>
				</td>
			</tr>
			
					<%
				}}
%>


	</table>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script src="js/sweetalert.min.js"></script>

	<script src="js/clients.js"></script>


</body>
</html>