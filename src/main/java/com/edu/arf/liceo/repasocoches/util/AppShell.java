package com.edu.arf.liceo.repasocoches.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppShell {
    private static Stage primaryStage;
    public static void setPrimaryStage(Stage stage) {
        AppShell.primaryStage = stage;
    }
    public static void loadView(View view) {
        try {
            FXMLLoader loader = new FXMLLoader(AppShell.class.getResource("/com/edu/arf/liceo/repasocoches/" + view.getFileName()));
            Parent root = loader.load();

            if (primaryStage.getScene() == null) {
                primaryStage.setScene(new Scene(root,600,400));
            }
            else{
                primaryStage.getScene().setRoot(root);
            }
            primaryStage.setTitle("Repaso coches -" + view.name());
            primaryStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
