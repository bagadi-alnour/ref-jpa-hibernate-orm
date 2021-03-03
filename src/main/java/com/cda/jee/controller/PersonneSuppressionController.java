package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.exception.PersonneIntrouvableException;
import com.cda.jee.service.IPersonneService;
import com.cda.jee.service.impl.PersonneServiceImpl;

@WebServlet("/suppression")
public class PersonneSuppressionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected IPersonneService personneService;

	@Override
	public void init() throws ServletException {
		this.personneService = new PersonneServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		
		String messageErreur = null;
		int id = 0;
		if(idStr == null || idStr.isBlank()) {
			messageErreur = "le parametre id est obligatoire";
		} else {
			try {
				id = Integer.parseInt(idStr);
			} catch (NumberFormatException e) {
				messageErreur = "le parametre id n'est pas au bon format";
			}
		}
		
		if(messageErreur != null) {
			req.setAttribute("msgErreur", messageErreur);
			req.getRequestDispatcher("/liste").forward(req, resp);

			
		} else {
			try {
				this.personneService.deleteById(id);
				resp.sendRedirect(req.getContextPath()+ "/liste");
				
			} catch(PersonneIntrouvableException exc) {
				req.setAttribute("msgErreur", "aucune personne n'a l'id : "+id);
				req.getRequestDispatcher("/liste").forward(req, resp);
				
			}
		}
		
	}
}
