package fr.miage.toulouse.maven.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_formation";
    private static final String USER = "Marius";
    private static final String PASSWORD = "fr.miage.toulouse";

    public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
