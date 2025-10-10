package org.vetcare.controller;

import java.sql.*;
import java.util.*;
import org.vetcare.model.Facturacion;

public class FacturacionController {

    public List<Facturacion> getAll() {
        List<Facturacion> list = new ArrayList<>();
        String query = "SELECT * FROM facturacion";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Facturacion f = new Facturacion();
                f.setIdFactura(rs.getInt("id_factura"));
                f.setIdPaciente(rs.getInt("id_paciente"));
                f.setServicios(rs.getString("servicios"));
                f.setMedicamentos(rs.getString("medicamentos"));
                f.setTotal(rs.getDouble("total"));
                f.setFecha(rs.getString("fecha"));
                f.setMetodoPago(rs.getString("metodo_pago"));
                list.add(f);
            }
            rs.close(); ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save(Facturacion f) {
        String q = "INSERT INTO facturacion (id_paciente, servicios, medicamentos, total, fecha, metodo_pago) VALUES (?,?,?,?,?,?)";
        try {
            ConexionMysql cm = new ConexionMysql();
            Connection conn = cm.open();
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, f.getIdPaciente());
            ps.setString(2, f.getServicios());
            ps.setString(3, f.getMedicamentos());
            ps.setDouble(4, f.getTotal());
            ps.setString(5, f.getFecha());
            ps.setString(6, f.getMetodoPago());
            ps.executeUpdate();
            ps.close(); cm.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
