package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTrack extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Date createTime = new Date(session.getCreationTime());
		Date lastAccessTime = new Date(session.getLastAccessedTime());

		Integer visitCount = new Integer(1);
		String visitKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("ABCD");
		String title = "-----Welcome to Bridgelabz-----";
		if (session.isNew()) {
			title = "Welcome to Bridgelabz";
			session.setAttribute(userIDKey, userID);
		} else {
			visitCount = (Integer) session.getAttribute(visitKey);
			visitCount = visitCount + 1;
			userID = (String) session.getAttribute(userIDKey);
		}
		session.setAttribute(visitKey, visitCount);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<html>\n" + "<head><title>" + title + "</title></head>\n"

				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n"

				+ "<h2 align = \"center\">Session Infomation</h2>\n" + "<table border = \"1\" align = \"center\">\n"

				+ "<tr bgcolor = \"green\">\n" + "<th>Session Info</th><th>value</th>" + "</tr>\n" + "<tr>\n"

				+ "  <td>ID</td>\n" + "  <td>" + session.getId() + "</td>" + "</tr>\n" + "<tr>\n"

				+ "  <td>Creation Time</td>\n" + "  <td>" + createTime + "  </td>" + "</tr>\n"

				+ "<tr>\n" + "  <td>Time of Last Access</td>\n" + "  <td>" + lastAccessTime + "  </td>" + "</tr>\n"

				+ "<tr>\n" + "  <td>User ID</td>\n" + "  <td>" + userID + "  </td>" + "</tr>\n"

				+ "<tr>\n" + "  <td>Number of visits</td>\n" + "  <td>" + visitCount + "</td>" + "</tr>\n"

				+ "</table>\n" + "</body>" + "</html>");
	}
}
