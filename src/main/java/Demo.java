
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
  private static final String DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  private final Connection connection;

  public Demo(String msSqlServerUri) throws SQLException, ClassNotFoundException {
    Class.forName(DRIVER_CLASS_NAME);
    connection = DriverManager.getConnection(msSqlServerUri);
  }
}
