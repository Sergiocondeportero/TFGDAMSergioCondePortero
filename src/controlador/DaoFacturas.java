package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.productos;

public class DaoFacturas {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertarFactura(int idFactura, int idProducto, int cantidad, double precio) {
        String SQL = "INSERT INTO factura (idFactura, idProducto, cantidad, precio) VALUES (?, ?, ?, ?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setInt(1, idFactura);
            ps.setInt(2, idProducto);
            ps.setInt(3, cantidad);
            ps.setDouble(4, precio);
            int n = ps.executeUpdate();
            return n != 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public List<productos> listarProductosFactura(int idFactura) {
        List<productos> lista = new ArrayList<>();
        String SQL = "SELECT p.idproducto, p.nombre, f.cantidad, f.precio FROM factura f INNER JOIN productos p ON f.idproducto = p.idproducto WHERE f.idFactura = ?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setInt(1, idFactura);
            rs = ps.executeQuery();
            while (rs.next()) {
                productos p = new productos();
                p.setIdproducto(rs.getInt(1));
                p.setNomProd(rs.getString(2));
                p.setStock(rs.getInt(3));
                p.setPrecioV(rs.getDouble(4));
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

    public double calcularTotalFactura(int idFactura) {
        String SQL = "SELECT SUM(cantidad * precio) FROM factura WHERE idFactura = ?";
        double total = 0;
        try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setInt(1, idFactura);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return total;
    }
}

