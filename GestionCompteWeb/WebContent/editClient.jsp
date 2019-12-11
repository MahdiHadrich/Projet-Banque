<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@page import="tn.enis.entity.ClientBanque"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/jquery-ui.min.css" />
    <title>Insert title here</title>
  </head>
  <body class="col px-md-2">
    <% ClientBanque client= (ClientBanque)request.getAttribute("client");%>

    <h1>Modifier le client: cin=<%=client.getCin()%></h1>
    <form action="ClientServlet" method="POST">
      <table>
        <tr>
          <td>Cin</td>
          <td><input type="text" name="cin" value="<%=client.getCin()%>" /></td>
        </tr>
        <tr>
          <td>nom</td>
          <td><input type="text" name="nom" value="<%=client.getNom()%>" /></td>
        </tr>
        <tr>
          <td>prenom</td>
          <td>
            <input type="text" name="prenom" value="<%=client.getPrenom()%>" />
          </td>
        </tr>
        <tr>
          <td>adresse</td>
          <td>
            <input
              type="text"
              name="adresse"
              value="<%=client.getAdresse()%>"
            />
          </td>
        </tr>
        <tr>
          <td></td>
          <td>
            <input
              type="submit"
              name="action"
              value="update"
              class="btn btn-primary"
            />
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>
