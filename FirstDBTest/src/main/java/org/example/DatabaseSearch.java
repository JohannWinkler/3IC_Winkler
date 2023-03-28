package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSearch {
    private DatabaseLogger logger = new DatabaseLogger("database.log");
    private Connection connection = null;
    DBconnection dBconnection = new DBconnection();

    public void search(String searchTerm) throws SQLException {
        connection = dBconnection.openConnection();

        String query;
        if (searchTerm == null || searchTerm.isEmpty()) {
            query = "SELECT * FROM arbeiter";
            logger.logQuery(query);
        } else {
            query = "SELECT * FROM arbeiter WHERE vorname LIKE ?";
            logger.logQuery(query);
        }

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if (searchTerm != null && !searchTerm.isEmpty()) {
                statement.setString(1, "%" + searchTerm + "%");
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String vorname = resultSet.getString("vorname");
                    String nachname = resultSet.getString("nachname");
                    String id = resultSet.getString("ID");
                    System.out.println("ID: " + id + ", Arbeitername: " + vorname + " " + nachname);
                }
            }
        }
        connection = dBconnection.closeConnection();
    }

    public void insertArbeiter(int id, String vorname, String nachname) throws SQLException {
        connection = dBconnection.openConnection();

        String query = "INSERT INTO arbeiter (ID, vorname, nachname) VALUES (?, ?, ?)";
        logger.logQuery(query);

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setString(2, vorname);
            statement.setString(3, nachname);
            statement.executeUpdate();
        }
        connection = dBconnection.closeConnection();
    }
}