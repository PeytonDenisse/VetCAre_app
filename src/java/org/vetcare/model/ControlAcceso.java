package org.vetcare.model;

public class ControlAcceso {
    private int idUsuario;
    private String nombreUsuario;
    private String password;
    private String rol;

    // 🔹 nuevos campos
    private String email;
    private boolean esGoogle;

    public ControlAcceso() {}

    public ControlAcceso(int idUsuario, String nombreUsuario, String password,
                         String rol, String email, boolean esGoogle) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
        this.email = email;
        this.esGoogle = esGoogle;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEsGoogle() {
        return esGoogle;
    }

    public void setEsGoogle(boolean esGoogle) {
        this.esGoogle = esGoogle;
    }
}
