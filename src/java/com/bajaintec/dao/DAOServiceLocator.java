/*
 * Copyright (C) 2015 Jesús Donaldo Osornio Hernández
 *
 * This file is part of MatExámenes.
 *
 * MatExámenes is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * MatExámenes is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package com.bajaintec.dao;

/**
 * Esta clase se encarga de implementar el patrón Singleton para asegurarse de
 * sólo tener una instancia de cada tipo en la aplicación, contiene todos los
 * tipos de daos de la aplicación.
 * 
 * @author Jesus Donaldo Osornio Hernández
 * @version 1 18 Mayo 2015
 */
public class DAOServiceLocator {
    
    private static BaseDAO baseDAO;
    
    /**
     * Obtiene la instancia única del BaseDAO
     * @return la única instancia del BaseDAO
     */
    public static BaseDAO getBaseDAO() {
        if(baseDAO == null) {
            baseDAO = new BaseDAO();
        }
        
        return baseDAO;
    }
}