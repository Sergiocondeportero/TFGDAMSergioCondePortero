/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sergi
 */
public class UsuariosModelo {
    int idusuario;
    String nombre;
    String apellidos;
    String documentos; 
    String direccion;
    String telefono;
    String correo;
    String tipoUsuario;
    String usuario;
    String password;

    public UsuariosModelo() {
    }

    public UsuariosModelo(int idusuario, String nombre, String apellidos, String documentos, String direccion, String telefono, String correo, String tipoUsuario, String usuario, String password) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documentos = documentos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumentos() {
        return documentos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
