package org.vetcare.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                // 🔹 nuevos campos (pueden ser null)
                u.setEmail(rs.getString("email"));
                u.setEsGoogle(rs.getBoolean("es_google"));

                list.add(u);
            }

            rs.close();
            pstm.close();
            connMysql.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save(ControlAcceso u) {
        String query = "INSERT INTO usuarios (nombre_usuario, password, rol, email, es_google) VALUES (?,?,?,?,?)";

        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);

            pstm.setString(1, u.getNombreUsuario());
            pstm.setString(2, u.getPassword());
            pstm.setString(3, u.getRol());
            pstm.setString(4, u.getEmail());
            pstm.setBoolean(5, u.isEsGoogle());

            pstm.executeUpdate();

            pstm.close();
            connMysql.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =============================================================
    //                           UPDATE
    // =============================================================
    public void update(ControlAcceso u) {
        String query = "UPDATE usuarios " +
                       "SET nombre_usuario=?, password=?, rol=?, email=?, es_google=? " +
                       "WHERE id_usuario=?";

        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);

            pstm.setString(1, u.getNombreUsuario());
            pstm.setString(2, u.getPassword());
            pstm.setString(3, u.getRol());
            pstm.setString(4, u.getEmail());
            pstm.setBoolean(5, u.isEsGoogle());
            pstm.setInt(6, u.getIdUsuario());

            pstm.executeUpdate();

            pstm.close();
            connMysql.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =============================================================
    //                           DELETE
    // =============================================================
    public void delete(int idUsuario) {
        String query = "DELETE FROM usuarios WHERE id_usuario=?";

        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);

            pstm.setInt(1, idUsuario);
            pstm.executeUpdate();

            pstm.close();
            connMysql.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =============================================================
    //                  BUSCAR POR EMAIL (GOOGLE)
    // =============================================================
    public ControlAcceso findByEmail(String email) throws Exception {
        ControlAcceso u = null;
        String query = "SELECT * FROM usuarios WHERE email = ? LIMIT 1";

        ConexionMysql connMysql = new ConexionMysql();
        Connection conn = connMysql.open();
        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setString(1, email);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            u = new ControlAcceso();
            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNombreUsuario(rs.getString("nombre_usuario"));
            u.setPassword(rs.getString("password"));
            u.setRol(rs.getString("rol"));
            u.setEmail(rs.getString("email"));
            u.setEsGoogle(rs.getBoolean("es_google"));
        }

        rs.close();
        pstm.close();
        connMysql.close();
        conn.close();

        return u;
    }
}
