/**
 * Copyright(C) <2016> <BajaInTec>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
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

	
    public Usuario(String usuario, String contrasena, String sexo, String ocupacion, String correo, Date fechaNacimiento) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Usuario(String usuario, String contrasena, String sexo, String ocupacion, String correo, Date fechaNacimiento, Set evaluacionSeguridads, Set tokens, Set evaluacionServicios) {
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


