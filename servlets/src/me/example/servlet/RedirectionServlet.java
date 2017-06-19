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
 * @author Chetan Gorkal<br>
 *
 *         Servlet to demo {@link HttpServletResponse#sendRedirect(String)}.
 *         http status code 302.
 * 
 *         Redirection works on response object and change is URL is observed at
 *         the client side. Whereas, {@link RequestDispatcher} works on request
 *         object and a single request is received from the client.
 */
@WebServlet("/redirect")
public class RedirectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Relative path works or provide complete relative path starting with
		 * '/'. In the case below, /servlets/hello or 'hello' works
		 */
		response.sendRedirect("/servlets/hello");
	}

}
