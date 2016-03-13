package com.bajaintec.entities;
// Generated Mar 12, 2016 6:34:40 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ServicioPublico generated by hbm2java
 */
public class ServicioPublico  implements java.io.Serializable {


     private Integer idServicio;
     private String descripcion;
     private Set evaluacionServicios = new HashSet(0);

    public ServicioPublico() {
    }

	
    public ServicioPublico(String descripcion) {
        this.descripcion = descripcion;
    }
    public ServicioPublico(String descripcion, Set evaluacionServicios) {
       this.descripcion = descripcion;
       this.evaluacionServicios = evaluacionServicios;
    }
   
    public Integer getIdServicio() {
        return this.idServicio;
    }
    
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
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




}


