/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bajaintec.services;

//import javax.ws.rs.Consumes;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    
    @POST
    @Path("/review_street")
//    @Consumes(MediaType.APPLICATION_JSON)
    public String reviewStreet(@FormParam("reviewData")String reviewData) {
        
        System.out.println(reviewData);
        
        return "message";
    }
    
    @POST
    @Path("/user")
    public void signUp(@FormParam(NAME_PARAM)String name, 
            @FormParam(USER_PARAM)String user,
            @FormParam(PASS_PARAM)String pass,
            @FormParam(GENDER_PARAM)String gender,
            @FormParam(OCCUPATION_PARAM)String occupation,
            @FormParam(EMAIL_PARAM)String email,
            @FormParam(BIRTHDATE_PARAM)String birthdate){
        
    }
    
    @GET
    @Path("/user")
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response login(@FormParam(USER_PARAM) String user,
            @FormParam(PASS_PARAM) String pass){
        //Verificar en base de datos
        String token = issueToken(user);
        return Response.ok(token).build();
    }
    
    private String issueToken(String user){
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        return token;
    }
    
    
}