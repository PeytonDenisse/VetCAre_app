package org.vetcare.controller;

import java.sql.*;
import java.util.*;
import org.vetcare.model.Paciente;

public class PacienteController {

    public List<Paciente> getAll() {
        List<Paciente> list = new ArrayList<>();
        String query = "SELECT * FROM pacientes";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setIdPaciente(rs.getInt("id_paciente"));
                p.setNombreMascota(rs.getString("nombre_mascota"));
                p.setEspecie(rs.getString("especie"));
                p.setRaza(rs.getString("raza"));
                p.setEdad(rs.getInt("edad"));
                p.setHistorialMedico(rs.getString("historial_medico"));
                p.setIdPropietario(rs.getInt("id_propietario"));
                list.add(p);
            }
            rs.close(); ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save(Paciente p) {
        String q = "INSERT INTO pacientes (nombre_mascota, especie, raza, edad, historial_medico, id_propietario) VALUES (?,?,?,?,?,?)";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, p.getNombreMascota());
            ps.setString(2, p.getEspecie());
            ps.setString(3, p.getRaza());
            ps.setInt(4, p.getEdad());
            ps.setString(5, p.getHistorialMedico());
            ps.setInt(6, p.getIdPropietario());
            ps.executeUpdate();
            ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
