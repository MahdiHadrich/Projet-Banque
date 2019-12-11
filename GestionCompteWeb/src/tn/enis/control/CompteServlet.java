package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.entity.ClientBanque;
import tn.enis.entity.CompteBancaire;
import tn.enis.service.ClientBanqueServiceLocal;
import tn.enis.service.CompteBancaireServiceLocal;



@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CompteBancaireServiceLocal serviceCompte;

	@EJB
	private ClientBanqueServiceLocal serviceClient;

	
	public CompteServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("add".equals(request.getParameter("action"))) {
			Long cin = Long.valueOf(request.getParameter("cin"));
			float solde = Float.parseFloat(request.getParameter("solde"));

			serviceCompte.save(solde, cin);

		} else if ("delete".equals(request.getParameter("action"))) {
			Long rib = Long.valueOf(request.getParameter("rib"));
			serviceCompte.delete(rib);

			return;

		} else if ("edit".equals(request.getParameter("action"))) {
			Long rib = Long.valueOf(request.getParameter("rib"));
			CompteBancaire compte = serviceCompte.getById(rib);
			request.setAttribute("compte", compte);

			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
			return;
		} else if ("update".equals(request.getParameter("action"))) {
			Long rib = Long.valueOf(request.getParameter("rib"));
			String client = request.getParameter("client");
			float solde = Float.parseFloat(request.getParameter("solde"));

			CompteBancaire compte = new CompteBancaire(null, solde);
			compte.setRib(rib);

			serviceCompte.update(compte);

		}

		request.setAttribute("comptes", serviceCompte.getAll());

		RequestDispatcher dispatcher = request.getRequestDispatcher("comptes.jsp");
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



