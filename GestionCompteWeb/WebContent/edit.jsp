<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@page import="tn.enis.entity.CompteBancaire"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/jquery-ui.min.css" />
    <title>Insert title here</title>
  </head>
  <body class="col px-md-2">
    <% CompteBancaire compte= (CompteBancaire)request.getAttribute("compte");%>
    <h1>Modifier un compte dont le rib=<%=compte.getRib()%></h1>

    <form action="CompteServlet" method="post">
      <table>
        <tr>
          <td>client:</td>
          <td>
            <input type="text" name="client" value="<%=compte.getClient()%>" />
          </td>
        </tr>
        <tr>
          <td>Solde:</td>
          <td>
            <input type="text" name="solde" value="<%=compte.getSolde()%>" />
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
