package fr.miage.toulouse.maven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main extends Application {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainLayout.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 1000, 700);

            primaryStage.setTitle("Système de Gestion Étudiante - MIAGE");
            primaryStage.setScene(scene);

            primaryStage.setMaximized(true);

            primaryStage.show();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,"Erreur lors du lancement de l'application : {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}