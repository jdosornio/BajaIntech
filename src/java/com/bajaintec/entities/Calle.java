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
 * Calle generated by hbm2java
 */
public class Calle  implements java.io.Serializable {


     private Integer idCalle;
     private String descripcion;
     private Set evaluacionServicios = new HashSet(0);
     private Set evaluacionSeguridads = new HashSet(0);

    public Calle() {
    }

	
    public Calle(String descripcion) {
        this.descripcion = descripcion;
    }
    public Calle(String descripcion, Set evaluacionServicios, Set evaluacionSeguridads) {
       this.descripcion = descripcion;
       this.evaluacionServicios = evaluacionServicios;
       this.evaluacionSeguridads = evaluacionSeguridads;
    }
   
    public Integer getIdCalle() {
        return this.idCalle;
    }
    
    public void setIdCalle(Integer idCalle) {
        this.idCalle = idCalle;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getEvaluacionServicios() {
        return this.evaluacionServicios;
    }
    
    public void setEvaluacionServicios(Set evaluacionServicios) {
        this.evaluacionServicios = evaluacionServicios;
    }
    public Set getEvaluacionSeguridads() {
        return this.evaluacionSeguridads;
    }
    
    public void setEvaluacionSeguridads(Set evaluacionSeguridads) {
        this.evaluacionSeguridads = evaluacionSeguridads;
    }




}


