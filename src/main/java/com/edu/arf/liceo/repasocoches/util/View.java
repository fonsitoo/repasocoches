package com.edu.arf.liceo.repasocoches.util;

public enum View {
    LOGIN("login.fxml"),
    REGISTRO("register.fxml"),
    COCHES("coches.fxml");

    private String fileName;
    View(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }
    public String setFileName(String fileName) {
        return fileName;
    }
}
