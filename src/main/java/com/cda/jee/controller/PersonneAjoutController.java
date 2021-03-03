package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Personne;
import com.cda.jee.service.IPersonneService;
import com.cda.jee.service.impl.PersonneServiceImpl;

@WebServlet("/ajout")
public class PersonneAjoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected IPersonneService personneService;

	
	@Override
	public void init() throws ServletException {
		this.personneService = new PersonneServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/ajout.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		
		Personne vPersonne = Personne.builder()
				.nom(nom)
				.prenom(prenom)
				.build();

		if (nom == null || nom.isBlank()) {
			req.setAttribute("msgErreur", "le parametre nom est obligatiore");
			req.setAttribute("personne", vPersonne);
			
			req.getRequestDispatcher("/WEB-INF/ajout.jsp").forward(req, resp);
			
		} else if (prenom == null || prenom.isBlank()) {
			req.setAttribute("msgErreur", "le parametre prenom est obligatiore");
			req.setAttribute("personne", vPersonne);
			
			req.getRequestDispatcher("/WEB-INF/ajout.jsp").forward(req, resp);
		
		} else {
			this.personneService.add(vPersonne);
				
			req.getRequestDispatcher("/liste").forward(req, resp);
		}
	}

}
