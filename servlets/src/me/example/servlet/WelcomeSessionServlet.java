package me.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Chetan Gorkal <br/>
 *         Demo of {@link HttpSession#getAttribute(String)}<br/>
 *         Demo of {@link Cookie}<br/>
 *         URL re writing
 */
@WebServlet("/session/welcome")
public class WelcomeSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeSessionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("Printing from servlet: " + this.getServletName() + "<br/><br/><br/>");

		// httpSession attributes received from the other servlet.
		response.getWriter().println(request.getSession().getAttribute("sessionAttribute") + "<br/>");

		// cookies received from the other servlet.
		response.getWriter().println("Cookie received: " + request.getCookies()[0].getValue() + "<br/>");

		// url re-writing
		response.getWriter()
				.println("Param received from url (re written): " + request.getParameter("urlParam") + "<br/>");

		// hidden input
		response.getWriter().println("Hidden param received: " + request.getParameter("hiddenParam") + "<br/>");

		response.getWriter().println("<br/><br/><br/> Printing from servlet: " + this.getServletName() + " completed.");

		// remove session attribute so that multiple tries work.
		request.getSession().removeAttribute("sessionAttribute");
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
