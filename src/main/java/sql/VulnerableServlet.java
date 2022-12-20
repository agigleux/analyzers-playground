package sql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class VulnerableServlet extends HttpServlet {

    private static VulnerableParams vulnerableParams = new VulnerableParams();

    public static String getTheParameter(String p, HttpServletRequest request) {
        return request.getParameter(p);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String queryParam = VulnerableServlet.getTheParameter("query", request);
        if (queryParam != null) {
            vulnerableParams.query = queryParam;
        }
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("Connection");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(vulnerableParams.query);
        } catch (SQLException e) {
            // ...
        }
    }
}
