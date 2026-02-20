package com.edu.arf.liceo.repasocoches.controller;

import com.edu.arf.liceo.repasocoches.dao.UsuarioDAO;
import com.edu.arf.liceo.repasocoches.model.Usuario;
import com.edu.arf.liceo.repasocoches.util.AppShell;
import com.edu.arf.liceo.repasocoches.util.View;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;
    @FXML private PasswordField txtConfirmPass;

    @FXML
    public void onRegisterAction() {
        String user = txtUser.getText();
        String pass = txtPass.getText();
        String confirm = txtConfirmPass.getText();

        if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            mostrarAlerta("Error", "Alguno de los campos está vacío.");
            return;
        }

        if (!pass.equals(confirm)) {
            mostrarAlerta("Error", "Las contraseñas no coinciden.");
            return;
        }

        Usuario nuevoUsuario = new Usuario(user, pass, "user");
        boolean exito = usuarioDAO.registrar(nuevoUsuario);

        if (exito) {
            mostrarAlerta("Éxito", "Usuario registrado correctamente.");
            AppShell.loadView(View.LOGIN);
        } else {
            mostrarAlerta("Error", "El nombre de usuario ya está en uso.");
        }
    }

    @FXML
    public void onGoToLoginAction() {
        AppShell.loadView(View.LOGIN);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}