package fr.miage.toulouse.maven.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Request {

    private Connection conn;

    public Request() {
        try {
            this.conn = Connexion.getConnexion();

        } catch (SQLException e) {
            System.out.println("Erreur lors du chargement des données : " + e.getMessage());
        }
    }

    public ResultSet recupEtudiant() {
        try {
            String sql = "SELECT distinct E.num_etu, E.nom, E.prenom, E.id_parcours, P.id_mention, I.semestre FROM etudiant E INNER JOIN parcours P ON E.id_parcours = P.id_parcours INNER JOIN inscription I ON I.num_etu = E.num_etu WHERE I.statut_validation = 'en_cours'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            return rs;
        }catch (SQLException e){
            System.out.println("Erreur lors du chargement des données : " + e.getMessage());
            return null;
        }
    }

}
