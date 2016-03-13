/**
 * <!--Copyright(C) <2016> <BajaInTec>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.-->
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
}