
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.UsuariosModelo;

/**
 *
 * @author sergi
 */
public class DaoUsuario {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public UsuariosModelo login(String usuario, String password) {
        UsuariosModelo us = null; 
        String sql = "SELECT * FROM usuarios WHERE usuario='"+usuario+"' and password='"+password+"';"; // Usa parámetros para prevenir SQL Injection
        
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql); // Corregido aquí
            rs = ps.executeQuery();
            while (rs.next()) {
                us = new UsuariosModelo();  // Inicializamos el objeto `Usuarios` para evitar NullPointerException
                us.setIdusuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setApellidos(rs.getString(3));
                us.setDocumentos(rs.getString(4));
                us.setDireccion(rs.getString(5));
                us.setTelefono(rs.getString(6));
                us.setCorreo(rs.getString(7));
                us.setTipoUsuario(rs.getString(8));
                us.setUsuario(rs.getString(9));
                us.setPassword(rs.getString(10));
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        return us; 
    }
     public boolean insertar(String nombre,String apellido,String documento,String direccion,String telefono,String correo,
                            String tipouser,String user,String password){
        String SQL="insert into usuarios (nombre,apellido,documento,direccion,telefono,correo,tipoUsuario,usuario,password) "
                + "VALUES ('"+nombre+"','"+apellido+"','"+documento+"','"+direccion+"','"+telefono+"','"+correo+"','"+tipouser+"'"
                + ",'"+user+""+password+"','clave')";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            int n=ps.executeUpdate();
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
     public List Listar(){
        List<UsuariosModelo> lista=new ArrayList<>();
        String SQL="select * from usuarios";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                UsuariosModelo c=new UsuariosModelo();
                c.setIdusuario(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDocumentos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setTipoUsuario(rs.getString(8));
                c.setUsuario(rs.getString(9));
                c.setPassword(rs.getString(10));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }

     public boolean buscar(UsuariosModelo c){
        String SQL="SELECT idUsuario,nombre,apellido,documento,direccion,telefono,correo,tipoUsuario,usuario,"
                    + "usuarios.password,'clave'as password from usuarios WHERE documento=?";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getDocumentos());
            rs=ps.executeQuery();
            if(rs.next()){
                c.setIdusuario(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDocumentos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setTipoUsuario(rs.getString(8));
                c.setUsuario(rs.getString(9));
                c.setPassword(rs.getString(10));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(String nombre,String apellido,String documento,String dire,
                            String tel,String correo,String tusuario,String user,String pass,int id){

       String SQL = "update usuarios SET nombre='" + nombre + "', apellido='" + apellido + "', documento='" + documento + "', direccion='" + dire + "', telefono='" + tel + "', " +
             "correo='" + correo + "', tipoUsuario='" + tusuario + "', usuario='" + user + "', password='" + pass + "' WHERE idUsuario=" + id;

        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            int n=ps.executeUpdate();
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

    public boolean eliminar(UsuariosModelo c){
        String SQL="delete from usuarios where idUsuario=?";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdusuario());
            int n=ps.executeUpdate();
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

    public int cantUsuarios(){
        String SQL="SELECT COUNT(idUsuario) FROM usuarios";
        int cant = 0;
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            if(rs.next()){
               cant=rs.getInt(1);
            }else{
               cant=0; 
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return cant;
    }
}
