package com.edu.arf.liceo.repasocoches;

import com.edu.arf.liceo.repasocoches.util.AppShell;
import com.edu.arf.liceo.repasocoches.util.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AppShell.setPrimaryStage(stage);
        AppShell.loadView(View.LOGIN);
    }

    public static void main(String[] args) {
        launch();
    }
}