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


import java.util.HashSet;
import java.util.Set;

/**
 * Motivo generated by hbm2java
 */
public class Motivo  implements java.io.Serializable {


     private int idMotivo;
     private String descripcion;
     private Set evaluacionSeguridads = new HashSet(0);

    public Motivo() {
    }

	
    public Motivo(int idMotivo, String descripcion) {
        this.idMotivo = idMotivo;
        this.descripcion = descripcion;
    }
    public Motivo(int idMotivo, String descripcion, Set evaluacionSeguridads) {
       this.idMotivo = idMotivo;
       this.descripcion = descripcion;
       this.evaluacionSeguridads = evaluacionSeguridads;
    }
   
    public int getIdMotivo() {
        return this.idMotivo;
    }
    
    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getEvaluacionSeguridads() {
        return this.evaluacionSeguridads;
    }
    
    public void setEvaluacionSeguridads(Set evaluacionSeguridads) {
        this.evaluacionSeguridads = evaluacionSeguridads;
    }




}


