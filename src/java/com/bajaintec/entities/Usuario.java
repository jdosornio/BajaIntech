package com.bajaintec.entities;
// Generated Mar 12, 2016 6:34:40 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private String nombre;
     private String usuario;
     private String contrasena;
     private String sexo;
     private String ocupacion;
     private String correo;
     private Date fechaNacimiento;
     private Set evaluacionSeguridads = new HashSet(0);
     private Set tokens = new HashSet(0);
     private Set evaluacionServicios = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nombre, String usuario, String contrasena, String sexo, String ocupacion, String correo, Date fechaNacimiento) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Usuario(String nombre, String usuario, String contrasena, String sexo, String ocupacion, String correo, Date fechaNacimiento, Set evaluacionSeguridads, Set tokens, Set evaluacionServicios) {
       this.nombre = nombre;
       this.usuario = usuario;
       this.contrasena = contrasena;
       this.sexo = sexo;
       this.ocupacion = ocupacion;
       this.correo = correo;
       this.fechaNacimiento = fechaNacimiento;
       this.evaluacionSeguridads = evaluacionSeguridads;
       this.tokens = tokens;
       this.evaluacionServicios = evaluacionServicios;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getOcupacion() {
        return this.ocupacion;
    }
    
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Set getEvaluacionSeguridads() {
        return this.evaluacionSeguridads;
    }
    
    public void setEvaluacionSeguridads(Set evaluacionSeguridads) {
        this.evaluacionSeguridads = evaluacionSeguridads;
    }
    public Set getTokens() {
        return this.tokens;
    }
    
    public void setTokens(Set tokens) {
        this.tokens = tokens;
    }
    public Set getEvaluacionServicios() {
        return this.evaluacionServicios;
    }
    
    public void setEvaluacionServicios(Set evaluacionServicios) {
        this.evaluacionServicios = evaluacionServicios;
    }




}


