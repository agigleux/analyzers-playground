package S4925;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class S4925_ExpectedIssue {

  private final Connection connection;
  
  private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";

  public S4925_ExpectedIssue(String serverURI) throws SQLException, ClassNotFoundException {
    Class.forName(DRIVER_CLASS_NAME); // Noncompliant; no longer required to load the JDBC Driver using Class.forName()
    connection = DriverManager.getConnection(serverURI);
  }

}
