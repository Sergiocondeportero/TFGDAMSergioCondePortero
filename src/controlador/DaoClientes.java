/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import modelo.Conexion;
import modelo.clientes;

/**
 *
 * @author sergi
 */
public class DaoClientes {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(clientes c){
    String SQL = "INSERT INTO `clientes` (nombre,apellido,documento,direccion,telefono,correo) VALUES (?,?,?,?,?,?)";
    try{
    con= (Connection) cn.conectar();
    ps=con.prepareStatement(SQL);
    ps.setString(1, c.getNombre());
    ps.setString(2, c.getApellido());
    ps.setString(3, c.getDocumento());
    ps.setString(4, c.getDireccion());
    ps.setString(5, c.getTelefono());
    ps.setString(6, c.getCorreo());
    int n= ps.executeUpdate();
    if(n!=0){
    return true;
    }else{
    return false;
    }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
}
    public List listar() {
        List<clientes> lista = new ArrayList<>();
        String SQL = "SELECT * FROM clientes"; 
        try {
            con = (Connection) cn.conectar(); 
            ps = con.prepareStatement(SQL); 
            rs = ps.executeQuery(); 
            while (rs.next()) {
                clientes c = new clientes();
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDocumento(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                lista.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar categorías: " + e.getMessage());
        }
        return lista;
    }
    public boolean editar(clientes c){
    String SQL = "UPDATE clientes SET nombre=?,apellido=?,documento=?,direccion=?,telefono=?,correo=? WHERE idCliente=?";
    try{
    con= (Connection) cn.conectar();
    ps=con.prepareStatement(SQL);
        ps.setString(1, c.getNombre());    
        ps.setString(2, c.getApellido());    
        ps.setString(3, c.getDocumento());   
        ps.setString(4, c.getDireccion());   
        ps.setString(5, c.getTelefono());    
        ps.setString(6, c.getCorreo());      
        ps.setInt(7, c.getIdCliente());     

        int n = ps.executeUpdate();
    
    if(n!=0){
    return true;
    }else{
    return false;
    }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
   }
     public boolean eliminar(clientes c){ 
     String SQL = "DELETE FROM clientes WHERE idCliente=?";
    try{
    con= (Connection) cn.conectar();
    ps=con.prepareStatement(SQL);
    ps.setInt(1,c.getIdCliente());
    int n= ps.executeUpdate();
    if(n!=0){
    return true;
    }else{
    return false;
    }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
 }
public boolean buscar(clientes c){ 
        String SQL = "SELECT * FROM clientes WHERE documento=?";
        try{
            con = (Connection) cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setString(1, c.getDocumento());
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setIdCliente(rs.getInt(1));   
                c.setNombre(rs.getString(2));  
                c.setApellido(rs.getString(3));
                c.setDocumento(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                return true;
            } else {
                return false;  // No se encontró la categoría
            }
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}