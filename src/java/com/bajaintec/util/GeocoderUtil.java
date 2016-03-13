/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bajaintec.util;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * @author Alex
 */
public class GeocoderUtil {
    
    private static final GeoApiContext CONTEXT = 
            new GeoApiContext().setApiKey("AIzaSyC2GG9X_PmqhTdWAE1_qBGeEf07FDHiP8A");
    
    public static String[] getCalleColonia(BigDecimal lat,
            BigDecimal lng) throws Exception{
        String[] calleColonia = new String[2];
        try{
            LatLng coords = new LatLng(lat.doubleValue(), lng.doubleValue());
            GeocodingResult[] results =  GeocodingApi.reverseGeocode(CONTEXT, coords).await();
            calleColonia[0] = results[0].addressComponents[1].longName;
            calleColonia[1] = results[0].addressComponents[2].longName;
        } catch (IOException e){
            e.printStackTrace();
        }
        return calleColonia;
    }
    
    public static DirectionsApiRequest getDirection(String origin,
            String destination) {
        
        DirectionsApiRequest request = DirectionsApi
                .getDirections(CONTEXT, origin, destination);
        
        return request;
    }
    
    public static void main(String[] args) throws Exception {
        String[] ars = new GeocoderUtil().getCalleColonia(new BigDecimal(32.595081), new BigDecimal(-115.482477));
    
        System.out.println(ars[0] + " ----- " + ars[1]);
    }
}
