package org.vetcare.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.vetcare.controller.ConexionMysql;

import org.vetcare.model.ControlAcceso;

public class ControlAccessoController {

    public List<ControlAcceso> getAll() {
        List<ControlAcceso> list = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ControlAcceso u = new ControlAcceso();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombreUsuario(rs.getString("nombre_usuario"));
                u.setPassword(rs.getString("password"));
                u.setRol(rs.getString("rol"));
                list.add(u);
            }
            rs.close(); pstm.close(); connMysql.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save(ControlAcceso u) {
        String query = "INSERT INTO usuarios (nombre_usuario, password, rol) VALUES (?,?,?)";
        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, u.getNombreUsuario());
            pstm.setString(2, u.getPassword());
            pstm.setString(3, u.getRol());
            pstm.executeUpdate();
            pstm.close(); connMysql.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
