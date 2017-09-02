package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloForm extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie firstName = new Cookie("firstname", req.getParameter("firstname"));
		Cookie lastName = new Cookie("lastname", req.getParameter("lastname"));
		firstName.setMaxAge(60 * 60 * 24);
		lastName.setMaxAge(60 * 60 * 24);
		resp.addCookie(firstName);
		resp.addCookie(lastName);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = "Welcome to Cookies";
		out.println("<html>\n" + "<head>" + "<title>" + title + "</title>" + "</head>\n"
				+ "<body bgcolor = \"red\">\n" + "<h1 align = \"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "<li><b>First Name</b>: " + req.getParameter("firstname") + "\n"
				+ "<li><b>Last Name</b>: "+ req.getParameter("lastname") + "\n" + "</ul>\n" + "</body>" + "</html>");
	}
}
