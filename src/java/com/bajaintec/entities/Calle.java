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

