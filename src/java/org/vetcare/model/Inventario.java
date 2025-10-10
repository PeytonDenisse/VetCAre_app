package org.vetcare.model;

public class Inventario {
    private int idItem;
    private String nombreItem;
    private int cantidad;
    private String categoria;
    private String fechaActualizacion;

    public Inventario() {}

    public Inventario(int idItem, String nombreItem, int cantidad, String categoria, String fechaActualizacion) {
        this.idItem = idItem;
        this.nombreItem = nombreItem;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
