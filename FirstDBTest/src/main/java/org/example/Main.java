package org.example;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseSearch databaseSearch = new DatabaseSearch();
        //databaseSearch.insertArbeiter(3, "Kapitän", "Kapitänöse");
        // searchTerm leer lassen damit alles selected wird, einen name einfügen um einen spezifischen Eintrag zu selecten
        databaseSearch.search("");
    }
}
