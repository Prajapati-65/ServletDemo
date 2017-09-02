package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitCounter1 extends HttpServlet {

	private int hitCount;

	@Override
	public void init() throws ServletException {
		hitCount = 0;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		hitCount++;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Welcome to Bridgelabz" + "<br>");
		out.println("Visits counts :" + hitCount);
	}

	public void destroy() {

	}
}
