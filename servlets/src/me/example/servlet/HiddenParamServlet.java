package me.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Chetan Gorkal
 *
 *         <br/>
 *         Session management using hidden params.
 */
@WebServlet("/session/hidden_param")
public class HiddenParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HiddenParamServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// creating a new hidden form field
		response.setContentType("text/html");
		response.getWriter().println("<form action='welcome'>");
		response.getWriter().println("<input type='hidden' name='hiddenParam' value='hiddenParamValue'>");
		response.getWriter().println("<input type='submit' value='submit' >");
		response.getWriter().println("</form>");

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
