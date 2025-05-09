package com.uts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
  private static final String URL = "jdbc:mysql://localhost:3306/sistem_transportasi";
  private static final String USER = "ben";
  private static final String PASSWORD = "pwd";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }
}
