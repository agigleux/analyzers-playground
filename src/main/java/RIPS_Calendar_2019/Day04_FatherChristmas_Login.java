package RIPS_Calendar_2019;

import java.io.IOException;

import javax.servlet.http.*;

public class Day04_FatherChristmas_Login extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String url = request.getParameter("url");
    //only relative urls are allowed!
    if (url.startsWith("/")) {
      response.sendRedirect(url); // TP S5146
    }
  }
}