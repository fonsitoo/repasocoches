package com.edu.arf.liceo.repasocoches.dao;

import com.edu.arf.liceo.repasocoches.db.DatabaseConnection;
import com.edu.arf.liceo.repasocoches.model.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CocheDAO {

    public List<Coche> getCoches() {
        List<Coche> Coche = new ArrayList<>();
        String sql = "SELECT * FROM Coche";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            ResultSet rs = preparedstatement.executeQuery()){

            while (rs.next()){
                Coche.add(new Coche(rs.getString("matricula"),
                        rs.getString("marca"), rs.getBoolean("electrico")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Coche;
    }
}
