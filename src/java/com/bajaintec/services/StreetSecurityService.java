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
import com.bajaintec.entities.Colonia;
import com.bajaintec.entities.Delegacion;
import com.bajaintec.entities.EvaluacionSeguridad;
import com.bajaintec.entities.EvaluacionServicio;
import com.bajaintec.entities.Incidente;
import com.bajaintec.entities.Motivo;
import com.bajaintec.entities.ServicioPublico;
import com.bajaintec.entities.Usuario;
import com.bajaintec.util.GeocoderUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

/**
 *
 * @author jdosornio
 */
@Path("/StreetSecurity")
public class StreetSecurityService {
    
//    public static final String NAME_PARAM = "name";
    public static final String USER_PARAM = "user";
    public static final String PASS_PARAM = "pass";
    public static final String GENDER_PARAM = "gender";
    public static final String OCCUPATION_PARAM = "occupation";
    public static final String EMAIL_PARAM = "email";
    public static final String BIRTHDATE_PARAM = "birthday";
    
    //Parámetros de json
    private static final String PRIMERA_LOCALIZACION_N = "primera_localizacion_n";
    private static final String PRIMERA_LOCALIZACION_W = "primera_localizacion_w";
    private static final String SEGUNDA_LOCALIZACION_N = "segunda_localizacion_n";
    private static final String SEGUNDA_LOCALIZACION_W = "segunda_localizacion_w";
     public static final String LOCALIZACION_N = "localizacion_n";
    public static final String LOCALIZACION_W = "localizacion_w";
    public static final String COMENTARIO = "comentario";
    
    private static final String CALLE = "calle";
    private static final String CALIFICACION = "calificacion";
    private static final String ID_USUARIO = "idUsuario";
    private static final String ID_SERVICIO = "idServicio";
    private static final String ID_DELEGACION = "idDelegacion";
    
    private static final String ID_MOTIVO = "idMotivo";
    private static final String ID_INCIDENTE = "idIncidente";
    private static final String NUMERO_POSTE = "noPoste";
    
    private static final String LAT = "lat";
    private static final String LON = "lon";
    private static final String ORIGEN = "origen";
    private static final String DESTINO = "destino";
    private static final String ID_COLOR = "idColor";
    
    @POST
    @Path("/review_street")
//    @Consumes(MediaType.APPLICATION_JSON)
    public void reviewStreet(@FormParam(PRIMERA_LOCALIZACION_N)
            BigDecimal primeraLocalizacionN, @FormParam(PRIMERA_LOCALIZACION_W)
            BigDecimal primeraLocalizacionW, @FormParam(SEGUNDA_LOCALIZACION_N)
            BigDecimal segundaLocalizacionN, @FormParam(SEGUNDA_LOCALIZACION_W)
            BigDecimal segundaLocalizacionW, @FormParam(CALLE) String calle,
            @FormParam(CALIFICACION)Integer idCalificacion,
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
        
        //Select * from calle where descripcion = ?
        HashMap<String, Object> attrWhere = new HashMap<>();
        
        attrWhere.put("descripcion", calle);
        
        List objCalles = DAOServiceLocator.getBaseDAO()
                .getEq(Calle.class, attrWhere);
        Calle objCalle;
        
        if (objCalles != null && !objCalles.isEmpty()) {
            //obtener objeto
            objCalle = (Calle)objCalles.get(0);
        } else {
            //Registrar la calle
            objCalle = new Calle();
            
            objCalle.setDescripcion(calle);
            
            DAOServiceLocator.getBaseDAO()
                    .add(objCalle);
        }
        //Set calle
        evaluacion.setCalle(objCalle);
        
        //set date
        evaluacion.setTsCreacion(new Date());
        
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
        
        //Obtener todos los registros de las rutas
        List evaluaciones = DAOServiceLocator.getBaseDAO()
                .getAll(EvaluacionSeguridad.class);
        
        
        if (evaluaciones != null && !evaluaciones.isEmpty()) {
            //Existen evaluaciones
            JSONArray segmentos = new JSONArray();
             for(EvaluacionSeguridad eval : (List<EvaluacionSeguridad>)evaluaciones) {            
                JSONObject segmento = new JSONObject();
                JSONObject punto = new JSONObject();
                punto.put(LAT, eval.getPrimeraLocalizacionN());
                punto.put(LON, eval.getPrimeraLocalizacionW());
                 
                segmento.put(ORIGEN, punto);
                
                punto.put(LAT, eval.getSegundaLocalizacionN());
                punto.put(LON, eval.getSegundaLocalizacionW());
                
                segmento.put(DESTINO, punto);
                segmento.put(ID_COLOR, eval.getCalificacion().getIdCalificacion());
                
                //Agregar
                segmentos.add(segmento);
             }
            
            response = segmentos.toString();
        }
        
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
        System.out.println("Fecha: " + birthdate.replaceAll("/", "-"));
        objUsuario.setFechaNacimiento(java.sql.Date.valueOf(birthdate
                .replaceAll("/", "-")));
        
        Integer id = (Integer) DAOServiceLocator.getBaseDAO().add(objUsuario);
        
        if (id == null) {
            return "No se pudo registrar al usuario. El usuario o el correo ya "
                    + "están registrados";
        }
        
        return "ok";
    }
    
    @POST
    @Path("/sign_in")
//    @Produces("application/json")
//    @Consumes("application/x-www-form-urlencoded")
    public String login(@FormParam(USER_PARAM) String user,
            @FormParam(PASS_PARAM) String pass) {
        
        //Verificar que el usuario exista
        //Select * from usuario where usuario = ?
        HashMap<String, Object> attrWhere = new HashMap<>();
        attrWhere.put("usuario", user);
        
        List usuarios = DAOServiceLocator.getBaseDAO()
                .getEq(Usuario.class, attrWhere);
        
        Integer idUsuario = null;
        
        if (usuarios != null && !usuarios.isEmpty()) {
            Usuario usuario = (Usuario) usuarios.get(0);
            idUsuario = usuario.getIdUsuario();
        }
        
        return String.valueOf(idUsuario);
        //Verificar en base de datos
//        String token = issueToken(user);
//        return Response.ok(token).build();
    }
 
    @POST
    @Path("/review_services")
    public void reviewServices(@FormParam(ID_USUARIO)Integer idUsuario,
            @FormParam(ID_SERVICIO) Integer idServicio,
            @FormParam(ID_DELEGACION) Integer idDelegacion,
            @FormParam(LOCALIZACION_N) BigDecimal localizacionN,
            @FormParam(LOCALIZACION_W) BigDecimal localizacionW,
            @FormParam(COMENTARIO) String comentario,
            @FormParam(NUMERO_POSTE) Integer noPoste
            ) {
        
        try {
            EvaluacionServicio evaluacion = new EvaluacionServicio();
            
            Usuario objUsuario = new Usuario();
            objUsuario.setIdUsuario(idUsuario);
            evaluacion.setUsuario(objUsuario);
            
            ServicioPublico objServicio = new ServicioPublico();
            objServicio.setIdServicio(idServicio);
            evaluacion.setServicioPublico(objServicio);
            
            Delegacion objDelegacion = new Delegacion();
            objDelegacion.setIdDelegacion(idDelegacion);
            evaluacion.setDelegacion(objDelegacion);
            
            //Set points
            evaluacion.setLocalizacionN(localizacionN);
            evaluacion.setLocalizacionW(localizacionW);
            
            //Obtener nombre de la calle y colonia, si no existe crearlo
            String[] calleColonia = GeocoderUtil.getCalleColonia(localizacionN,
                    localizacionW);
            
            //Set calle
            HashMap<String, Object> attrWhere = new HashMap<>();

            attrWhere.put("descripcion", calleColonia[0]);

            List objCalles = DAOServiceLocator.getBaseDAO()
                    .getEq(Calle.class, attrWhere);
            
            Calle objCalle;

            if (objCalles != null && !objCalles.isEmpty()) {
                //obtener objeto
                objCalle = (Calle)objCalles.get(0);
            } else {
                //Registrar la calle
                objCalle = new Calle();

                objCalle.setDescripcion(calleColonia[0]);

                DAOServiceLocator.getBaseDAO()
                        .add(objCalle);
            }
            //Set calle
            evaluacion.setCalle(objCalle);
        
            
            
            //Guardar colonia
            attrWhere.clear();
            attrWhere.put("descripcion", calleColonia[1]);

            List objColonias = DAOServiceLocator.getBaseDAO()
                    .getEq(Colonia.class, attrWhere);
            
            Colonia objColonia;

            if (objColonias != null && !objColonias.isEmpty()) {
                //obtener objeto
                objColonia = (Colonia)objColonias.get(0);
            } else {
                //Registrar la colonia
                objColonia = new Colonia();

                objColonia.setDescripcion(calleColonia[1]);

                DAOServiceLocator.getBaseDAO()
                        .add(objColonia);
            }
            //Set calle
            evaluacion.setColonia(objColonia);
        
            if(comentario.isEmpty()){
                evaluacion.setComentario(comentario);
            }
            
            //Set date
            evaluacion.setTsCreacion(new Date());
            
            //TODO: Subir foto
            evaluacion.setUrlFoto("NONE");
            
            if(idServicio == 1){
                evaluacion.setNoPoste(noPoste);
            }
            
            //Save data
            DAOServiceLocator.getBaseDAO().add(evaluacion);
        } catch (Exception ex) {
            Logger.getLogger(StreetSecurityService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String issueToken(String user){
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        //Almacenar token-user
        return token;
    }    
    
}