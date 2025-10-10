package org.vetcare.model;

public class Tratamiento {
    private int idTratamiento;
    private String descripcion;
    private String tipo;
    private String fecha;
    private int idPaciente;

    public Tratamiento() {}

    public Tratamiento(int idTratamiento, String descripcion, String tipo, String fecha, int idPaciente) {
        this.idTratamiento = idTratamiento;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.idPaciente = idPaciente;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
