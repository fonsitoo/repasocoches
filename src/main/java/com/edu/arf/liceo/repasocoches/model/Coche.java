package com.edu.arf.liceo.repasocoches.model;

public class Coche {
    private String matricula;
    private String marca;
    private boolean electrico;

    public Coche(String matricula, String marca, boolean electrico) {
        this.matricula = matricula;
        this.marca = marca;
        this.electrico = electrico;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", electrico=" + electrico +
                '}';
    }
}
