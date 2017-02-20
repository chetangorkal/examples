package me.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

/**
 * 
 * @author Chetan Gorkal
 * 
 *         Hello world example.<br/>
 * 
 *         Demo of {@link ServletConfig} - params available only to this
 *         servlet. <br/>
 *         {@link ServletContext} - params available to complete web app. One
 *         context per web app. No annotation is available as logically we cant
 *         associate it to a servlet class. Hence, these params should be set in
 *         deployment descriptor.
 */

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Hello World</h1>");
		// init params
		out.println(getServletConfig().getInitParameter("email") + "<br/>");
		// context params
		out.println(getServletContext().getInitParameter("myContextParam") + "<br/>");
		out.println("</body></html>");
	}
}
