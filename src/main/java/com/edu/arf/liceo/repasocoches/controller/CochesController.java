package com.edu.arf.liceo.repasocoches.controller;

import com.edu.arf.liceo.repasocoches.dao.CocheDAO;
import com.edu.arf.liceo.repasocoches.model.Coche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CochesController {
    @FXML private TableView<Coche> coches;
    @FXML private TableColumn<Coche, String> matricula;
    @FXML private TableColumn<Coche, String> marca;
    @FXML private TableColumn<Coche, Boolean> electrico;

    private CocheDAO cocheDAO = new CocheDAO();

    @FXML private void initialize() {
        matricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        electrico.setCellValueFactory(new PropertyValueFactory<>("electrico"));

        cargarDatos();
    }
    private void cargarDatos() {
        ObservableList<Coche> lista = FXCollections.observableArrayList(cocheDAO.getCoches());
        coches.setItems(lista);
    }
}
