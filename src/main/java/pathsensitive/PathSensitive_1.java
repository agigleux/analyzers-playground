package pathsensitive;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathSensitive_1 extends HttpServlet {

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
    
    int i = 42;
    if ( i < 42 ) { 
      String sql = "INSERT INTO users (username, password) VALUES ('foo','" + param + "')";
      try {
        int notexpectedissue = statement.executeUpdate(sql, new int[]{1, 2});
      } catch (java.sql.SQLException e) {
        throw new ServletException(e);
      }
    }

  }

}