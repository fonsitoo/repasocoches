package com.edu.arf.liceo.repasocoches.controller;

import com.edu.arf.liceo.repasocoches.dao.UsuarioDAO;
import com.edu.arf.liceo.repasocoches.model.Usuario;
import com.edu.arf.liceo.repasocoches.util.AppShell;
import com.edu.arf.liceo.repasocoches.util.View;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;

    @FXML
    public void onLoginAction() {
        String user = txtUser.getText();
        String pass = txtPass.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            mostrarAlerta("Error", "Alguno de los campos está vacío.");
            return;
        }

        Usuario usuarioLogueado = usuarioDAO.login(user, pass);

        if (usuarioLogueado != null) {
            // ¡LOGIN CORRECTO! Le mandamos a la pantalla de la tabla
            AppShell.loadView(View.COCHES);
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos.");
        }
    }

    @FXML
    public void onRegisterLinkAction() {
        AppShell.loadView(View.REGISTRO);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}