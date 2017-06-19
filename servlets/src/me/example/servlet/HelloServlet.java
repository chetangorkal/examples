package me.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Chetan Gorkal<br/>
 * 
 *         Hello world example.<br/>
 * 
 *         Demo of {@link ServletConfig} - params available only to this
 *         servlet. <br/>
 *         Demo of {@link ServletContext} - params available to complete web
 *         app. One context per web app. No annotation is available as logically
 *         we cant associate it to a servlet class. Hence, these params should
 *         be set in deployment descriptor. <br/>
 *         Context params could be used by servlets to share data. <br/>
 *         Demo of {@link ServletRequest#getAttribute(String)} and likes.
 */

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setAttribute("requestAttributeName", "requestAttributeValue");
		request.getSession().setAttribute("sessionAttributeName", "sessionAttributeValue");
		getServletContext().setAttribute("contextAttributeName", "contextAttributeValue");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Hello World</h1>");
		// init params
		out.println(getServletConfig().getInitParameter("myConfigParam") + "<br/>");
		// context params
		out.println(getServletContext().getInitParameter("myContextParam") + "<br/>");
		// attributes
		out.println(request.getAttribute("requestAttributeName") + "<br/>");
		out.println(request.getSession().getAttribute("sessionAttributeName") + "<br/>");
		out.println(getServletContext().getAttribute("contextAttributeName") + "<br/>");
		out.println("</body></html>");
	}
}
