package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateAndTime extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException 
	{
		Date date = new Date();
		String currDate =date.toString();
		String htmlRes = "<html>"
						+" <body>"
						+"<h1> Welcome to Bridgelabz </h1>"
						+" <h2>"
						+" Current Data and Time : "
						+" <font color =\"green\"> "
						+currDate
						+" </font>"
						+" </h2> "
						+" </body> "
						+" </html> ";
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print(htmlRes);
	}
	
}
