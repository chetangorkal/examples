package me.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

/**
 * 
 * @author Chetan Gorkal Servlet to demonstrate
 *         {@link RequestDispatcher#forward(javax.servlet.ServletRequest, javax.servlet.ServletResponse)}
 *         and
 *         {@link RequestDispatcher#include(javax.servlet.ServletRequest, javax.servlet.ServletResponse)}
 */
@WebServlet("/validate")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("name").equals("Chetan")) {
			request.getRequestDispatcher("welcome").forward(request, response);
		} else {
			response.setContentType("text/html");
			response.getWriter().println("Unknown user: " + request.getParameter("name"));
			request.getRequestDispatcher("index.html").include(request, response);
		}
	}

}
