package com.bridgelabz.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorShow extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/**
		 *  These methods are available with HttpServletResponse object
		 *	public void setStatus ( int statusCode )
		 *	public void sendRedirect(String url)
		 *	public void sendError(int code, String message)
		 */
		
		//resp.setStatus(407);
		//resp.sendRedirect("https://www.tutorialspoint.com/servlets/servlets-http-status-codes.htm");
		
		resp.sendError(407, "Error Show !!!");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
	}
}
