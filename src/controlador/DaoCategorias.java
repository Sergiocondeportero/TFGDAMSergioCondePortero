/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mysql.jdbc.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Categorias;
import modelo.Conexion;
import vista.Categoria;

/**
 *
 * @author sergi
 */
public class DaoCategorias {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(Categorias c){
    String SQL = "INSERT INTO `categorías` (`categoria`) VALUES (?)";
    try{
    con= (Connection) cn.conectar();
    ps=con.prepareStatement(SQL);
    ps.setString(1, c.getNomCategoria());
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
public List<Categorias> listar() {
        List<Categorias> lista = new ArrayList<>();
        String SQL = "SELECT * FROM categorías"; 
        try {
            con = (Connection) cn.conectar(); 
            ps = con.prepareStatement(SQL); 
            rs = ps.executeQuery(); 
            while (rs.next()) {
                Categorias c = new Categorias();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNomCategoria(rs.getString("categoria"));
                lista.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar categorías: " + e.getMessage());
        }
        return lista;
    }

   public boolean editar(Categorias c){
    String SQL = "UPDATE categorías SET categoria=? WHERE idCategoria=?";
    try{
    con= (Connection) cn.conectar();
    ps=con.prepareStatement(SQL);
    ps.setString(1, c.getNomCategoria());
    ps.setInt(2,c.getIdCategoria());
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
 public boolean eliminar(Categorias c){ 
     String SQL = "DELETE FROM categorías WHERE idCategoria=?";
    try{
    con= (Connection) cn.conectar();
    ps=con.prepareStatement(SQL);
    ps.setInt(1,c.getIdCategoria());
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

 public boolean buscar(Categorias c){ 
        String SQL = "SELECT * FROM categorías WHERE idCategoria=?";
        try{
            con = (Connection) cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setInt(1, c.getIdCategoria());
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setIdCategoria(rs.getInt(1));   // Establece el idCategoria
                c.setNomCategoria(rs.getString(2));  // Establece el nombre de la categoría
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
     
    
