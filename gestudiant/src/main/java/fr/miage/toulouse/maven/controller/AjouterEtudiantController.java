package fr.miage.toulouse.maven.controller;

import fr.miage.toulouse.maven.cours.Etudiant;
import fr.miage.toulouse.maven.database.Connexion;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AjouterEtudiantController {

    @FXML private TextField fieldNumEtudiant;
    @FXML private TextField fieldPrenom;
    @FXML private TextField fieldNom;
    @FXML private TextField fieldDataNaissance;
    @FXML private ComboBox comboBoxMention;
    @FXML private ComboBox comboBoxParcours;
    @FXML private Button buttonValider;

    @FXML
    public void initialize(){
        chargerMention();

        comboBoxMention.setOnAction(e -> chargerParcours(String) comboBoxMention.getValue());
    }

    private void chargerMentions() {
        try (Connection db = Connexion.getConnexion()) {
            String sql = "SELECT id_mention FROM mention";
            ResultSet rs = db.createStatement().executeQuery(sql);
            while (rs.next()) {
                comboBoxMention.getItems().add(rs.getString("id_mention"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAjouter(){
        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        String numEtu = fieldNumEtudiant.getText();
        String parcours = (String) comboBoxParcours.getValue();
    }

}
