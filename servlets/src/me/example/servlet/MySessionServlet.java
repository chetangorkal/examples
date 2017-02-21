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
 * @author Chetan Gorkal
 * 
 *         <br/>
 *         Servlet to demo {@link HttpSession} <br/>
 *         Demo of {@link Cookie} <br/>
 *         URL re writing
 */
@WebServlet("/session/hello")
public class MySessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MySessionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("sessionAttribute", this.getServletName() + " sessionAttributeValue");
		Cookie cookie = new Cookie("cookieName", "cookieValue");
		response.addCookie(cookie);

		response.sendRedirect("welcome?urlParam=urlParamValue");
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
