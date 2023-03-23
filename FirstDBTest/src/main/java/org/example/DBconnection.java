package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private Connection connection = null;
    private final String url = "jdbc:mysql://localhost:3306/fertigung";
    private final String user = "root";
    private final String password = "";
    private DatabaseLogger logger = new DatabaseLogger("database.log");

    public Connection openConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            logger.logConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            if (connection.isClosed()) {
                logger.logConnection(connection);
            } else {
                // Anweisungen
            }
        }
        return connection;
    }
}
