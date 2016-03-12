/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bajaintec.services;

import javax.json.JsonObject;
//import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.core.MediaType;

/**
 *
 * @author jdosornio
 */
@Path("/StreetSecurity")
public class StreetSecurityService {
    
    @POST
    @Path("/review_street")
//    @Consumes(MediaType.APPLICATION_JSON)
    public String reviewStreet(@FormParam("reviewData")String reviewData) {
        
        System.out.println(reviewData);
        
        return "message";
    }
}