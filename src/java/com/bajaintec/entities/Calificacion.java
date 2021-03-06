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
 * Calificacion generated by hbm2java
 */
public class Calificacion  implements java.io.Serializable {


     private int idCalificacion;
     private String descripcion;
     private String color;
     private int valor;
     private Set evaluacionSeguridads = new HashSet(0);

    public Calificacion() {
    }

	
    public Calificacion(int idCalificacion, String descripcion, String color, int valor) {
        this.idCalificacion = idCalificacion;
        this.descripcion = descripcion;
        this.color = color;
        this.valor = valor;
    }
    public Calificacion(int idCalificacion, String descripcion, String color, int valor, Set evaluacionSeguridads) {
       this.idCalificacion = idCalificacion;
       this.descripcion = descripcion;
       this.color = color;
       this.valor = valor;
       this.evaluacionSeguridads = evaluacionSeguridads;
    }
   
    public int getIdCalificacion() {
        return this.idCalificacion;
    }
    
    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public int getValor() {
        return this.valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Set getEvaluacionSeguridads() {
        return this.evaluacionSeguridads;
    }
    
    public void setEvaluacionSeguridads(Set evaluacionSeguridads) {
        this.evaluacionSeguridads = evaluacionSeguridads;
    }




}


