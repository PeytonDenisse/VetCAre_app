package org.vetcare.controller;

import java.sql.*;
import java.util.*;
import org.vetcare.model.Cita;

public class CitaController {

    public List<Cita> getAll() {
        List<Cita> list = new ArrayList<>();
        String query = "SELECT * FROM citas";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cita c = new Cita();
                c.setIdCita(rs.getInt("id_cita"));
                c.setFecha(rs.getString("fecha"));
                c.setHora(rs.getString("hora"));
                c.setMotivo(rs.getString("motivo"));
                c.setIdVeterinario(rs.getInt("id_veterinario"));
                c.setIdPaciente(rs.getInt("id_paciente"));
                list.add(c);
            }
            rs.close(); ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save(Cita c) {
        String q = "INSERT INTO citas (fecha, hora, motivo, id_veterinario, id_paciente) VALUES (?,?,?,?,?)";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, c.getFecha());
            ps.setString(2, c.getHora());
            ps.setString(3, c.getMotivo());
            ps.setInt(4, c.getIdVeterinario());
            ps.setInt(5, c.getIdPaciente());
            ps.executeUpdate();
            ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
