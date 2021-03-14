package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String nameValue = request.getParameter("fname");
    String replyValue = request.getParameter("reply");
    System.out.println("Form from: " + nameValue);
    System.out.println("You submitted: " + replyValue);
    
    response.setContentType("text/html;");
    response.getWriter().println("You submitted: " + nameValue);
    response.getWriter().println("You submitted: " + replyValue);
    response.sendRedirect("/");
  }
}
