package tn.enis.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.dao.CompteDao;
import tn.enis.entity.CompteBancaire;
import tn.enis.service.CompteService;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CompteService compteService;

	public CompteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("add") != null) {
			String client = request.getParameter("client");
			float solde = Float.parseFloat(request.getParameter("solde"));
			CompteBancaire compte = new CompteBancaire(client, solde);
			compteService.save(compte);
			
			// response.getWriter().append("<h1>Ajout effectu� avec succ�s</h1>");
		}
		else if(request.getParameter("delete") != null) {
			Long rib=Long.valueOf(request.getParameter("rib"));
			compteService.delete(rib);
		}
		else if(request.getParameter("edit") != null) {
			Long rib =Long.valueOf(request.getParameter("rib"));
			CompteBancaire compte= compteService.getById(rib);
			request.setAttribute("compte", compte);
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit-compte.jsp");
			dispatcher.forward(request, response);
			return ;
			
		}
		else if(request.getParameter("update") != null) {
			Long rib =Long.valueOf(request.getParameter("rib"));
			String client= request.getParameter("client");
			float solde= Float.parseFloat(request.getParameter("solde"));
			CompteBancaire compte=new CompteBancaire(rib,client,solde);
			compteService.update(compte);
			
		}

		List<CompteBancaire> comptes = compteService.getAll();
		request.setAttribute("comptes", comptes);

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


