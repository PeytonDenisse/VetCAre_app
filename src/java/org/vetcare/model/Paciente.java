package org.vetcare.model;

public class Paciente {
    private int idPaciente;
    private String nombreMascota;
    private String especie;
    private String raza;
    private int edad;
    private String historialMedico;
    private int idPropietario;

    public Paciente() {}

    public Paciente(int idPaciente, String nombreMascota, String especie, String raza, int edad, String historialMedico, int idPropietario) {
        this.idPaciente = idPaciente;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.historialMedico = historialMedico;
        this.idPropietario = idPropietario;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
}
