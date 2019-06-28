package pathsensitive;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathSensitive_2 extends HttpServlet {

  java.sql.Statement statement;

  public static String getTheParameter(String p, HttpServletRequest request) {
    return request.getParameter(p);
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String param = getTheParameter("MyParamId", request);
    if (param == null) {
      param = "";
    }
   
    if ( param.length() >= 2 ) { 
      param = param.substring(0, 1);
      
      String sql21 = "INSERT INTO users (username, password) VALUES ('foo','" + param + "')";
      try {
        int notexpectedissue_2 = statement.executeUpdate(sql21, new int[]{1, 2});
      } catch (java.sql.SQLException e) {
        throw new ServletException(e);
      }
    } else { 
      String sql22 = "INSERT INTO users (username, password) VALUES ('foo','" + param + "')";
      try {
        int expectedissue = statement.executeUpdate(sql22, new int[]{1, 2});
      } catch (java.sql.SQLException e) {
        throw new ServletException(e);
      }
    }

  }

}