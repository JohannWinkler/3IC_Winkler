package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DatabaseLogger {
    private String logFile;

    public DatabaseLogger(String logFile) {
        this.logFile = logFile;
    }

    public void logConnection(Connection connection) throws SQLException {
        try (PrintWriter out = new PrintWriter(new FileWriter(logFile, true))) {
            LocalDateTime now = LocalDateTime.now();
            if (connection != null && !connection.isClosed()) {
                out.println(now + " - Verbindung hergestellt: " + connection.getMetaData().getURL());
            } else {
                out.println(now + " - Verbindung geschlossen");
                out.println(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logQuery(String query) {
        try (PrintWriter out = new PrintWriter(new FileWriter(logFile, true))) {
            LocalDateTime now = LocalDateTime.now();
            out.println(now + " - Abfrage ausgeführt: " + query);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
