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
package com.bajaintec.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.hibernate.Transaction;
import com.bajaintec.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.criterion.Restrictions;


/**
 * Esta clase es una generalización del dao para los métodos básicos del CRUD
 * para cualquier entidad dto de la aplicación. 
 * 
 * @param <T> la entidad
 * @param <ID> el id de la entidad
 * 
 * @author Jesus Donaldo Osornio Hernández
 * @version 1 18 Mayo 2015
 */
public class BaseDAO<T, ID extends Serializable> {
    
    /**
     * Método para obtener una nueva sesión de hibernate
     * 
     * @return una nueva sesión de hibernate
     */
    protected Session getSession() {
        Session session = null;
        
        if(HibernateUtil.getSessionFactory() != null) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        
        return session;
    }

    /**
     * Obtiene el total de entidades existentes de la clase especificada
     * 
     * @param clazz la clase de la entidad que se quiere obtener
     * @return la lista de entidades que se obtuvieron, null en caso de no
     * obtener nada
     */
    public List<T> getAll(Class<T> clazz) {
       
        //Abrir nueva sesión e iniciar la transacción
        Session s = getSession();
        Transaction tx = null;
        List<T> entidades;
        
        if(s == null) {
            System.out.println("Session nula, regresando null....");
            return null;
        }
        
        try {
            tx = s.beginTransaction();
            //Obtiene todos los objetos de la clase, sin sus relaciones
            Criteria c = s.createCriteria(clazz);
            entidades = c.list();
            tx.commit();
        } catch (Exception e) {
            //Si hay error hacer rollback
            if (tx != null) {
                tx.rollback();
            }
            entidades = null;
        } finally {
            s.close();
            System.out.println("Session cerrada");
        }
        
        return entidades;
    }
    
    public List<T> getEq(Class<T> clazz, Map<String, Object> whereClause) {
       
        //Abrir nueva sesión e iniciar la transacción
        Session s = getSession();
        Transaction tx = null;
        List<T> entidades;
        
        if(s == null) {
            System.out.println("Session nula, regresando null....");
            return null;
        }
        
        try {
            tx = s.beginTransaction();
            //Obtiene todos los objetos de la clase, sin sus relaciones
            Criteria c = s.createCriteria(clazz);
            
            //Where clauses
            //WHERE clauses...
            if (whereClause != null && !whereClause.isEmpty()) {
                List<String> attrs = new ArrayList<>(whereClause.keySet());
                
                for (String column : attrs) {
                    c.add(Restrictions.eq(column, whereClause.get(column)));
                }
            }
            
            entidades = c.list();
            tx.commit();
        } catch (Exception e) {
            //Si hay error hacer rollback
            if (tx != null) {
                tx.rollback();
            }
            entidades = null;
        } finally {
            s.close();
            System.out.println("Session cerrada");
        }
        
        return entidades;
    }
    
    /**
     * Inserta la entidad ingresada y la vuelve persistente
     * 
     * @param entidad el objeto a ser persistido
     * @return el id resultante del registro de la nueva entidad
     */
    public ID add(T entidad) {  
        
        Session s = getSession();
        Transaction tx = null;
        
        ID id;
        if(s == null) {
            System.out.println("Session nula, regresando null....");
            return null;
        }
        
        try {
            tx = s.beginTransaction();
            //Persiste la entidad en la base de datos
            id = (ID) s.save(entidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            id = null;
        } finally {
            s.close();
            System.out.println("Session cerrada");
        }

        return id;
    }
  
    /**
     * Actualiza la entidad ingresada en la persistencia
     * 
     * @param entidad el objeto a actualizar
     * @return true si la operación se realizó exitosamente, false si ocurrió
     * un error
     */
    public boolean update(T entidad) {  
        
        Session s = getSession();
        Transaction tx = null;
        boolean ok = true;
        
        if(s == null) {
            System.out.println("Session nula, regresando null....");
            return false;
        }
        
        try {
            tx = s.beginTransaction();
            //Modifica la entidad en la base de datos
            s.update(entidad);
            tx.commit();
        } catch(StaleStateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ID id = add(entidad);
            if(id == null) {
                ok = false;
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            ok = false;
        } finally {
            s.close();
            System.out.println("Session cerrada");
        }
        
        return ok;
    }
  
    /**
     * Elimina la entidad ingresada de la persistencia
     * 
     * @param entidad el objeto a eliminar
     * @return true si la operación se realizó exitosamente, false si ocurrió
     * un error
     */
    public boolean delete(T entidad) {  
        
        Session s = getSession();
        Transaction tx = null;
        boolean ok = true;
        
        if(s == null) {
            System.out.println("Session nula, regresando null....");
            return false;
        }
        
        try {
            tx = s.beginTransaction();
            //Elimina la entidad de la base de datos
            s.delete(entidad);
            tx.commit();
        } catch(StaleStateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            ok = false;
        } finally {
            s.close();
            System.out.println("Session cerrada");
        }
        
        return ok;
    }
}