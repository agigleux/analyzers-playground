package sql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class VulnerableServletBis extends HttpServlet {

    private static VulnerableParams vulnerableParams = new VulnerableParams();

    private static String alex;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String queryParam = request.getParameter("query");
        if (queryParam != null) {
            vulnerableParams.query = queryParam;          
            alex = queryParam;
        }
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("Connection");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(vulnerableParams.query); // VULNERABILITY EXPECTED HERE
            rs = stmt.executeQuery(alex); // VULNERABILITY EXPECTED HERE
        } catch (SQLException e) {
            /* ignored */} finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    /* ignored */}
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    /* ignored */}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    /* ignored */}
            }
        }
    }
}
