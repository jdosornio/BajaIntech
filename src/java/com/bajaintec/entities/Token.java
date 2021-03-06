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

/**
 * Token generated by hbm2java
 */
public class Token  implements java.io.Serializable {


     private String idToken;
     private Usuario usuario;
     private Date tsCreacion;

    public Token() {
    }

    public Token(String idToken, Usuario usuario, Date tsCreacion) {
       this.idToken = idToken;
       this.usuario = usuario;
       this.tsCreacion = tsCreacion;
    }
   
    public String getIdToken() {
        return this.idToken;
    }
    
    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getTsCreacion() {
        return this.tsCreacion;
    }
    
    public void setTsCreacion(Date tsCreacion) {
        this.tsCreacion = tsCreacion;
    }




}


