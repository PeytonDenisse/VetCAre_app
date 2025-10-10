package org.vetcare.controller;

import java.sql.*;
import java.util.*;
import org.vetcare.model.Tratamiento;

public class TratamientoController {

    public List<Tratamiento> getAll() {
        List<Tratamiento> list = new ArrayList<>();
        String query = "SELECT * FROM tratamientos";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tratamiento t = new Tratamiento();
                t.setIdTratamiento(rs.getInt("id_tratamiento"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setTipo(rs.getString("tipo"));
                t.setFecha(rs.getString("fecha"));
                t.setIdPaciente(rs.getInt("id_paciente"));
                list.add(t);
            }
            rs.close(); ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save(Tratamiento t) {
        String q = "INSERT INTO tratamientos (descripcion, tipo, fecha, id_paciente) VALUES (?,?,?,?)";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, t.getDescripcion());
            ps.setString(2, t.getTipo());
            ps.setString(3, t.getFecha());
            ps.setInt(4, t.getIdPaciente());
            ps.executeUpdate();
            ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
