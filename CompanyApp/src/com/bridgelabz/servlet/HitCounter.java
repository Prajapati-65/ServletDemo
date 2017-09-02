package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitCounter extends HttpServlet {

	private int hitCount;

	@Override
	public void init() throws ServletException {
		hitCount = 0;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		hitCount++;
		PrintWriter out = resp.getWriter();
		String html = "<html>" + "<head><title>" + "bridgeit" + "</title></head>\n" + "<body bgcolor = \"red\">\n"
				+ "<h1 align = \"center\">" + "Total Number of hits :" + "</h1>\n" + "<h2 align = \"center\">"
				+ hitCount + "</h2>\n" + "</body>" + "</html>";
		out.print(html);
	}

	@Override
	public void destroy() {

	}
}
