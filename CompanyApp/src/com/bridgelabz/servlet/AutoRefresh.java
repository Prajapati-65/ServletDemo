package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoRefresh extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setIntHeader("Refresh", 2);
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		String htmlRes = "<html>" + " <body>" +"<center>"+
			
				
				"<h1> Welcome to Bridgelabz </h1>" + " <h2>" + " Current Time is : "
				+ " <font color =\"red\"> " + hour + ":" + minute + ":" + second + " " + am_pm + " </font>"
				+ " </h2> " +"</center>"+ " </body> " + " </html> ";
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print(htmlRes);
	}
}
