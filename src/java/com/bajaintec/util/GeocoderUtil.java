/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bajaintec.util;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.io.IOException;

/**
 *
 * @author Alex
 */
public class GeocoderUtil {
    
    public String getCalle() throws Exception{
        GeocodingResult[] results = {};
        try{
            GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyC2GG9X_PmqhTdWAE1_qBGeEf07FDHiP8A");
            results =  GeocodingApi.geocode(context,
                "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
            System.out.println(results[0].formattedAddress);
        } catch (IOException e){
            e.printStackTrace();
        }
        return results[0].formattedAddress;
    }
    
    public static void main(String[] args) throws Exception {
        new GeocoderUtil().getCalle();
    }
}
