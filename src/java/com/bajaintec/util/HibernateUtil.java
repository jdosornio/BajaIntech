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

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * La clase Hibernate Util es un método conveninente para mantener el
 * sessionFactory y obtenerlo
 * 
 * @author Jesus Donaldo Osornio Hernández
 * @version 1 18 Mayo 2015
 */
public class HibernateUtil {
    //Configuración basada en anotaciones
    private static SessionFactory sessionFactory;
    
    static {
        try {
            // Crea el SessionFactory desde el hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Annotation Configuration loaded");
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Annotation serviceRegistry created");
             
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch(Throwable ex) {
            // Log la excepción
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * 
     * @return el objeto SessionFactory de esta aplicación para abrir nuevas
     * sesiones con la base de datos
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
