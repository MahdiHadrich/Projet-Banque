package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import tn.enis.entity.ClientBanque;
import tn.enis.service.ClientBanqueServiceLocal;


@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ClientBanqueServiceLocal clientService;

	
	public ClientServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("add".equals(request.getParameter("action"))) {
			Long cin = Long.valueOf(request.getParameter("cin"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");

			ClientBanque client = new ClientBanque(cin, nom, prenom, adresse);

			clientService.save(client);
		} else if ("delete".equals(request.getParameter("action"))) {
			Long cin = Long.valueOf(request.getParameter("cin"));
			clientService.delete(cin);

			return;

		} else if ("edit".equals(request.getParameter("action"))) {
			Long cin = Long.valueOf(request.getParameter("cin"));
			ClientBanque client = clientService.getById(cin);
			request.setAttribute("client", client);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editClient.jsp");
			dispatcher.forward(request, response);
			return;
		} else if ("update".equals(request.getParameter("action"))) {
			Long cin = Long.valueOf(request.getParameter("cin"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");

			ClientBanque client = new ClientBanque(cin, nom, prenom, adresse);

			clientService.update(client);

		} else if ("getClientDto".equals(request.getParameter("action"))) {
			String clientDto = clientService.clientAutoComplete();
			response.getWriter().println(clientDto);
			return;
		}
		
		List<ClientBanque> clients = clientService.getAll();

		request.setAttribute("clients", clients);

		RequestDispatcher dispatcher = request.getRequestDispatcher("clients.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
