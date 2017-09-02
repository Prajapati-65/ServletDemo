package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "welcomr to ErrorHandler";
		}

		String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "It can be stored and analysed after storing";
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		if (throwable == null && statusCode == null) {
			out.println(resp.encodeURL("Welcome to Bridgeit"));
		} else if (statusCode != null) {
			out.println("The status code : " + statusCode);
		} else {
			out.println("Servlet Name : " + servletName);
			out.println("Exception Type : " + throwable.getClass().getName());
			out.println("The request URI: " + requestUri);
			out.println("The exception message: " + throwable.getMessage());
		}
	}
}
