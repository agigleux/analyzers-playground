package fieldsensitive;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FieldSensitive extends HttpServlet {

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
    
    SimplePOJO bean = new SimplePOJO(param, "safe");

    String sql = "INSERT INTO users (username, password) VALUES ('foo','" + bean.getField1() + "')";
    try {
      int expectedissue = statement.executeUpdate(sql, new int[] {1, 2});
    } catch (java.sql.SQLException e) {
      throw new ServletException(e);
    }
    
    String sql2 = "INSERT INTO users (username, password) VALUES ('foo','" + bean.getField2() + "')";
    try {
      int noexpectedissue = statement.executeUpdate(sql2, new int[] {1, 2});
    } catch (java.sql.SQLException e) {
      throw new ServletException(e);
    }
    
    String sql3 = "INSERT INTO users (username, password) VALUES ('foo','" + bean.getTableau1()[0] + "')";
    try {
      int noexpectedissue = statement.executeUpdate(sql3, new int[] {1, 2});
    } catch (java.sql.SQLException e) {
      throw new ServletException(e);
    }
    
    String sql4 = "INSERT INTO users (username, password) VALUES ('foo','" + bean.getTableau1()[8] + "')";
    try {
      int expectedissue = statement.executeUpdate(sql4, new int[] {1, 2});
    } catch (java.sql.SQLException e) {
      throw new ServletException(e);
    }

  }

}
