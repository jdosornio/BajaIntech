/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bajaintec.services;

//import javax.ws.rs.Consumes;
import com.bajaintec.dao.DAOServiceLocator;
import com.bajaintec.entities.Calificacion;
import com.bajaintec.entities.Calle;
import com.bajaintec.entities.EvaluacionSeguridad;
import com.bajaintec.entities.Incidente;
import com.bajaintec.entities.Motivo;
import com.bajaintec.entities.Usuario;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
//import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.MediaType;

/**
 *
 * @author jdosornio
 */
@Path("/StreetSecurity")
public class StreetSecurityService {
    
    public static final String NAME_PARAM = "name";
    public static final String USER_PARAM = "user";
    public static final String PASS_PARAM = "pass";
    public static final String GENDER_PARAM = "gender";
    public static final String OCCUPATION_PARAM = "occupation";
    public static final String EMAIL_PARAM = "email";
    public static final String BIRTHDATE_PARAM = "birthdate";
    
    //Parámetros de json
    private static final String PRIMERA_LOCALIZACION_N = "primera_localizacion_n";
    private static final String PRIMERA_LOCALIZACION_W = "primera_localizacion_w";
    private static final String SEGUNDA_LOCALIZACION_N = "segunda_localizacion_n";
    private static final String SEGUNDA_LOCALIZACION_W = "segunda_localizacion_w";
    
    private static final String CALLE = "calle";
    private static final String CALIFICACION = "calificacion";
    private static final String ID_USUARIO = "idUsuario";
    
    private static final String ID_MOTIVO = "idMotivo";
    private static final String ID_INCIDENTE = "idIncidente";
    
    
    @POST
    @Path("/review_street")
//    @Consumes(MediaType.APPLICATION_JSON)
    public void reviewStreet(@FormParam(PRIMERA_LOCALIZACION_N)
            BigDecimal primeraLocalizacionN, @FormParam(PRIMERA_LOCALIZACION_W)
            BigDecimal primeraLocalizacionW, @FormParam(SEGUNDA_LOCALIZACION_N)
            BigDecimal segundaLocalizacionN, @FormParam(SEGUNDA_LOCALIZACION_W)
            BigDecimal segundaLocalizacionW, @FormParam(CALIFICACION)
                    Integer idCalificacion,
            @FormParam(ID_USUARIO)Integer idUsuario,
                    @FormParam(ID_MOTIVO)Integer idMotivo,
                    @FormParam(ID_INCIDENTE)Integer idIncidente) {
//        JsonObject obj;
//        try (JsonReader reader = Json.createReader(new StringReader(reviewData))) {
//            obj = reader.readObject();
//        }
//        
//        EvaluacionSeguridad evaluacion = new EvaluacionSeguridad();
//        
//        //Set points
//        evaluacion.setPrimeraLocalizacionN(obj
//                .getJsonNumber(PRIMERA_LOCALIZACION_N).bigDecimalValue());
//        evaluacion.setPrimeraLocalizacionW(obj
//                .getJsonNumber(PRIMERA_LOCALIZACION_W).bigDecimalValue());
//        evaluacion.setPrimeraLocalizacionW(obj
//                .getJsonNumber(SEGUNDA_LOCALIZACION_N).bigDecimalValue());
//        evaluacion.setPrimeraLocalizacionW(obj
//                .getJsonNumber(SEGUNDA_LOCALIZACION_W).bigDecimalValue());
//        
//        //Obtener el nombre de la calle si ya existe...
//        String calle = obj.getString(CALLE);
//        //Select * from calle where descripcion = ?
//        HashMap<String, Object> attrWhere = new HashMap<>();
//        
//        attrWhere.put("descripcion", calle);
//        
//        List objCalles = DAOServiceLocator.getBaseDAO()
//                .getEq(Calle.class, attrWhere);
//        Integer idCalle;
//        
//        if (objCalles != null && objCalles.isEmpty()) {
//            //Si existe entonces obtener el id
//            idCalle = ((Calle)objCalles.get(0)).getIdCalle();
//        } else {
//            //Registrar la calle
//            Calle objCalle = new Calle();
//            
//            objCalle.setDescripcion(calle);
//            
//            idCalle = (Integer) DAOServiceLocator.getBaseDAO()
//                    .add(Calle.class);
//        }
//        //Set calle
//        Calle objCalle = new Calle();
//        objCalle.setIdCalle(idCalle);
//        evaluacion.setCalle(objCalle);
//        
//        //Set calificacion
//        Calificacion objCalif = new Calificacion();
//        objCalif.setIdCalificacion(obj.getInt(CALIFICACION));
//        evaluacion.setCalificacion(objCalif);
//        
//        //Set usuario
//        Usuario objUsuario = new Usuario();
//        objUsuario.setIdUsuario(obj.getInt(ID_USUARIO));
//        evaluacion.setUsuario(objUsuario);
//        
//        //Save motivo and incidente...
//        if (!obj.isNull(ID_MOTIVO)) {
//            Motivo objMotivo = new Motivo();
//            objMotivo.setIdMotivo(obj.getInt(ID_MOTIVO));
//            evaluacion.addMotivo(objMotivo);
//        }
//        
//        if (!obj.isNull(ID_INCIDENTE)) {
//            Incidente objIncidente = new Incidente();
//            objIncidente.setIdIncidente(obj.getInt(ID_INCIDENTE));
//            evaluacion.addIncidente(objIncidente);
//        }
//        
//        //Save data
//        DAOServiceLocator.getBaseDAO().add(evaluacion);
//
////        System.out.println(reviewData);
////        
////        return "sap";
        
        EvaluacionSeguridad evaluacion = new EvaluacionSeguridad();
        
        //Set points
        evaluacion.setPrimeraLocalizacionN(primeraLocalizacionN);
        evaluacion.setPrimeraLocalizacionW(primeraLocalizacionW);
        evaluacion.setPrimeraLocalizacionW(segundaLocalizacionN);
        evaluacion.setPrimeraLocalizacionW(segundaLocalizacionW);
        
        //Obtener la calle del servicio de google.
        String calle = null;
        
        //Select * from calle where descripcion = ?
        HashMap<String, Object> attrWhere = new HashMap<>();
        
        attrWhere.put("descripcion", calle);
        
        List objCalles = DAOServiceLocator.getBaseDAO()
                .getEq(Calle.class, attrWhere);
        Integer idCalle;
        
        if (objCalles != null && objCalles.isEmpty()) {
            //Si existe entonces obtener el id
            idCalle = ((Calle)objCalles.get(0)).getIdCalle();
        } else {
            //Registrar la calle
            Calle objCalle = new Calle();
            
            objCalle.setDescripcion(calle);
            
            idCalle = (Integer) DAOServiceLocator.getBaseDAO()
                    .add(Calle.class);
        }
        //Set calle
        Calle objCalle = new Calle();
        objCalle.setIdCalle(idCalle);
        evaluacion.setCalle(objCalle);
        
        //Set calificacion
        Calificacion objCalif = new Calificacion();
        objCalif.setIdCalificacion(idCalificacion);
        evaluacion.setCalificacion(objCalif);
        
        //Set usuario
        Usuario objUsuario = new Usuario();
        objUsuario.setIdUsuario(idUsuario);
        evaluacion.setUsuario(objUsuario);
        
        //Save motivo and incidente...
        if (idMotivo != null) {
            Motivo objMotivo = new Motivo();
            objMotivo.setIdMotivo(idMotivo);
            evaluacion.addMotivo(objMotivo);
        }
        
        if (idIncidente != null) {
            Incidente objIncidente = new Incidente();
            objIncidente.setIdIncidente(idIncidente);
            evaluacion.addIncidente(objIncidente);
        }
        
        //Save data
        DAOServiceLocator.getBaseDAO().add(evaluacion);
    }
    
    @GET
    @Path("/view_street_safety")
    public String viewStreetSafety() {
        String response = null;
        
        
        return response;
    }
    
    @POST
    @Path("/sign_up")
    public String signUp(@FormParam(USER_PARAM)String user,
            @FormParam(PASS_PARAM)String pass,
            @FormParam(GENDER_PARAM)String gender,
            @FormParam(OCCUPATION_PARAM)String occupation,
            @FormParam(EMAIL_PARAM)String email,
            @FormParam(BIRTHDATE_PARAM)String birthdate){
        
        Usuario objUsuario = new Usuario();

        objUsuario.setUsuario(user);
        objUsuario.setContrasena(pass);
        objUsuario.setSexo(gender);
        objUsuario.setOcupacion(occupation);
        objUsuario.setCorreo(email);
        objUsuario.setFechaNacimiento(Date.valueOf(birthdate));
        
        DAOServiceLocator.getBaseDAO().add(objUsuario);
        
        System.out.println(user);
        
        return "todo bien";
    }
    
    @POST
    @Path("/sign_in")
//    @Produces("application/json")
//    @Consumes("application/x-www-form-urlencoded")
    public Response login(@FormParam(USER_PARAM) String user,
            @FormParam(PASS_PARAM) String pass){
        //Verificar en base de datos
        String token = issueToken(user);
        return Response.ok(token).build();
    }
      
    private String issueToken(String user){
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        //Almacenar token-user
        return token;
    }    
    
}
