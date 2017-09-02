package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayHeader extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String docType = "<html>" + "<head>" + "<title>" + "httpRequest " + "</title>" + "</head>" + " <body>" + " <h1>"
				+ " <font color =\"red\"> " + " Welcome to Bridgelabz " + " </font>" + " </h1> " + " </body> "
				+ " </html> ";
		PrintWriter out = resp.getWriter();
		out.println(docType);

		Enumeration headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String paramName = (String) headerNames.nextElement();
			out.println("<br>" + paramName + "<br>");
			String paramValue = req.getHeader(paramName);
			out.println("<br>" + paramValue + "<br>");
		}
	}
}
