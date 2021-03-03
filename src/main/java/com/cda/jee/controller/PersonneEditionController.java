package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.exception.PersonneIntrouvableException;
import com.cda.jee.model.Personne;

@WebServlet("/edition")
public class PersonneEditionController extends PersonneDetailController {
	private static final long serialVersionUID = 1L;

	public void initVueLien() {
		this.vueLien = "/WEB-INF/edition.jsp";
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		
		int id = 0;
		if (idStr == null || idStr.isBlank()) {
			req.setAttribute("msgErreur", "le parametre id est obligatoire");
			req.getRequestDispatcher("/liste").forward(req, resp);
			return;
		} else {
			try {
				id = Integer.parseInt(idStr);
			} catch (NumberFormatException e) {
				req.setAttribute("msgErreur", "le parametre id n'est pas au bon format");
				req.getRequestDispatcher("/liste").forward(req, resp);
				return;
			}
		}
		
		Personne vPersonne = Personne.builder()
				.id(id)
				.nom(nom)
				.prenom(prenom)
				.build();

		if (nom == null || nom.isBlank()) {
			req.setAttribute("msgErreur", "le parametre nom est obligatiore");
			req.setAttribute("personne", vPersonne);
			
			req.getRequestDispatcher(this.vueLien).forward(req, resp);
			
		} else if (prenom == null || prenom.isBlank()) {
			req.setAttribute("msgErreur", "le parametre prenom est obligatiore");
			req.setAttribute("personne", vPersonne);
			
			req.getRequestDispatcher(this.vueLien).forward(req, resp);
		} else {
			try {
				this.personneService.update(vPersonne);
				
			} catch(PersonneIntrouvableException me) {
				req.setAttribute("msgErreur", "cette personne est introuvable");
			}
			req.getRequestDispatcher("/liste").forward(req, resp);
		}
	}
}
