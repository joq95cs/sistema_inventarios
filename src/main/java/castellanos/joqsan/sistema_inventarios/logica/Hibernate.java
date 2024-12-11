
package castellanos.joqsan.sistema_inventarios.logica;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Hibernate {
    
    public static <T> void iniciar(Class<T> type) throws Errores.ConexionException {
        
        try {
        
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(type).buildSessionFactory().openSession();
            Hibernate.type = type;
        
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException();
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
        Hibernate.type = null;
    }
    
    public static Session session = null;
    public static Class type = null;
}