package org.vetcare.controller;

import java.sql.*;
import java.util.*;
import org.vetcare.model.Inventario;

public class InventarioController {

    public List<Inventario> getAll() {
        List<Inventario> list = new ArrayList<>();
        String query = "SELECT * FROM inventario";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inventario i = new Inventario();
                i.setIdItem(rs.getInt("id_item"));
                i.setNombreItem(rs.getString("nombre_item"));
                i.setCantidad(rs.getInt("cantidad"));
                i.setCategoria(rs.getString("categoria"));
                i.setFechaActualizacion(rs.getString("fecha_actualizacion"));
                list.add(i);
            }
            rs.close(); ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save(Inventario i) {
        String q = "INSERT INTO inventario (nombre_item, cantidad, categoria, fecha_actualizacion) VALUES (?,?,?,?)";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, i.getNombreItem());
            ps.setInt(2, i.getCantidad());
            ps.setString(3, i.getCategoria());
            ps.setString(4, i.getFechaActualizacion());
            ps.executeUpdate();
            ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
