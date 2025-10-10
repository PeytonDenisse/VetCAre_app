package org.vetcare.model;

public class Facturacion {
    private int idFactura;
    private int idPaciente;
    private String servicios;
    private String medicamentos;
    private double total;
    private String fecha;
    private String metodoPago;

    public Facturacion() {}

    public Facturacion(int idFactura, int idPaciente, String servicios, String medicamentos, double total, String fecha, String metodoPago) {
        this.idFactura = idFactura;
        this.idPaciente = idPaciente;
        this.servicios = servicios;
        this.medicamentos = medicamentos;
        this.total = total;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
