package br.cesul.trabalhoB1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
        @Override
        public void start(Stage stage) throws Exception {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/br.cesul.trabalhoB1/OrcamentoView.fxml")

            );

            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.setTitle("Painel de orçamento reativo");
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
}
