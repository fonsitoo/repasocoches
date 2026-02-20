package com.edu.arf.liceo.repasocoches.dao;

import com.edu.arf.liceo.repasocoches.db.DatabaseConnection;
import com.edu.arf.liceo.repasocoches.model.Usuario;
import javafx.scene.chart.PieChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public Usuario login(String username, String password) {
        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
            preparedstatement.setString(1,username);
            preparedstatement.setString(2,password);
            ResultSet rs = preparedstatement.executeQuery();
            if(rs.next()) {
                return new Usuario(rs.getString("username"), rs.getString("password"), rs.getString("role"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public boolean registrar(Usuario usuario) {
        String checkSql = "SELECT username FROM usuario WHERE username = ?";
        String insertSql = "INSERT INTO usuario (username, password, role) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection()) {
            try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
                checkStmt.setString(1, usuario.getUsername());
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) return false;
            }
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                insertStmt.setString(1, usuario.getUsername());
                insertStmt.setString(2, usuario.getPassword());
                insertStmt.setString(3, usuario.getRole());
                insertStmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
