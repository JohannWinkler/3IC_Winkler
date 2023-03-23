package org.example;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseSearch databaseSearch = new DatabaseSearch();
        //databaseSearch.insertArbeiter(3, "Kapitän", "Kapitänöse");
        databaseSearch.search("");
    }
}