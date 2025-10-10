package org.vetcare.controller;

import java.sql.*;
import java.util.*;
import org.vetcare.model.Propietario;

public class PropietarioController {

    public List<Propietario> getAll() {
        List<Propietario> list = new ArrayList<>();
        String query = "SELECT * FROM propietarios";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Propietario p = new Propietario();
                p.setIdPropietario(rs.getInt("id_propietario"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                p.setDireccion(rs.getString("direccion"));
                list.add(p);
            }
            rs.close(); ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save(Propietario p) {
        String q = "INSERT INTO propietarios (nombre, telefono, direccion) VALUES (?,?,?)";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            ps.executeUpdate();
            ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
