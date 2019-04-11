import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDriverLoad {

  private static final String DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

  public static Connection loadJDBCOldWay(String msSqlServerUri) throws SQLException, ClassNotFoundException {
    Class.forName(DRIVER_CLASS_NAME);
    return DriverManager.getConnection(msSqlServerUri);
  }

  public static Connection loadJDBCNewWay(String msSqlServerUri) throws SQLException {
    return DriverManager.getConnection(msSqlServerUri);
  }

}
