package S2139;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S2139 {

  private static final Logger LOGGER = LoggerFactory.getLogger(S2139.class);

  public void executeSQL(Connection con, String sqlQuery) throws MySQLException {
    Statement stmt = null;
    try {
      stmt = con.createStatement();
      stmt.execute(sqlQuery);
    } catch (SQLException e) {
      LOGGER.error("SQLException", e);
      throw new MySQLException(e);
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          LOGGER.error("SQLException", e);
          throw new MySQLException(e);
        }
      }
    }
  }
  
  public class MySQLException extends Exception {

    public MySQLException(SQLException e) {
    }

  }

}
