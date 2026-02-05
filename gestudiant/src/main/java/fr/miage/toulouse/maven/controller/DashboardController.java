package fr.miage.toulouse.maven.controller;

import fr.miage.toulouse.maven.cours.Etudiant;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import fr.miage.toulouse.maven.database.Connexion;
import fr.miage.toulouse.maven.database.Convertion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;


public class DashboardController {
    @FXML private TableView<Etudiant> tableEtudiants;
    @FXML private TableColumn<Etudiant, String> colNom;
    @FXML private TableColumn<Etudiant, String> colPrenom;
    @FXML private TableColumn<Etudiant, String> colNumEtudiant;
    @FXML private TableColumn<Etudiant, String> colMention;
    @FXML private TableColumn<Etudiant, String> colParcours;
    @FXML private TableColumn<Etudiant, String> colSemestre;

    private ObservableList<Etudiant> listeEtudiants = FXCollections.observableArrayList();

    /**
     * Lie les colonnes du tableau aux attributs de la classe Etudiant puis appel chargerTableeau()
     */
    @FXML
    public void initialize() {
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colNumEtudiant.setCellValueFactory(new PropertyValueFactory<>("numEtudiant"));
        colParcours.setCellValueFactory(new PropertyValueFactory<>("id_parcours"));
        colMention.setCellValueFactory(new PropertyValueFactory<>("id_mention"));
        colSemestre.setCellValueFactory(new PropertyValueFactory<>("semestreActuel"));


        chargerTableau();
    }

    private void chargerTableau() {

        listeEtudiants.clear();

        try (Connection db = Connexion.getConnexion()) {

            String sql = "SELECT distinct E.num_etu, E.nom, E.prenom, E.id_parcours, P.id_mention, I.semestre FROM etudiant E INNER JOIN parcours P ON E.id_parcours = P.id_parcours INNER JOIN inscription I ON I.num_etu = E.num_etu WHERE I.statut_validation = 'en_cours'";
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                listeEtudiants.add(Convertion.toEtudiant(rs));
            }

            tableEtudiants.setItems(listeEtudiants);

        } catch (SQLException e) {
            System.out.println("Erreur lors du chargement des données : " + e.getMessage());
        }
    }
}
