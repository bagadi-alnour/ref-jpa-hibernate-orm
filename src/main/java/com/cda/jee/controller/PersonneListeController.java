package com.cda.jee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Personne;
import com.cda.jee.service.IPersonneService;
import com.cda.jee.service.impl.PersonneServiceImpl;

@WebServlet({"/liste","/index.html"})
public class PersonneListeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPersonneService personnesService;
	
	@Override
	public void init() throws ServletException {
		this.personnesService = new PersonneServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Personne> personnes = this.personnesService.getAll();
		req.setAttribute("personnes", personnes);
		req.getRequestDispatcher("/WEB-INF/liste.jsp").forward(req, resp);
	}
	
}
