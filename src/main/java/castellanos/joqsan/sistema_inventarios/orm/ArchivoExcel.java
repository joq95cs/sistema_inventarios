
package castellanos.joqsan.sistema_inventarios.orm;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.GregorianCalendar;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

//Entidad correcta
@Entity
@Table(name = "archivos_excel")
public class ArchivoExcel {
    
    //Codigo de configuraciones
    public static Session session = null;
    public static Class type = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            type = Class.forName(Thread.currentThread().getStackTrace()[1].getClassName());
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(type).buildSessionFactory().openSession();
            System.out.println("---Entidad " + type.getSimpleName() + " iniciada---");
            
        } catch(ClassNotFoundException | HibernateException ex) {
            
            throw new Errores.ConexionException("Error de conexión");
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
        System.out.println("---Entidad " + type.getSimpleName() + " cerrada---");
    }
    
    public static void commit() {
        
        session.getTransaction().commit();
    }
    
    public static void rollback() {
        
        if(session.getTransaction() != null) {
                
            session.getTransaction().rollback();
        }
    }
    
    public static void limpiar() {
        
        session.clear();
    }
    
    //Codigo de entidad
    public ArchivoExcel() {
        
        this.id = 0;
        this.nombre = null;
        this.fecha_hora = null;
        this.tabla = null;
    }

    public ArchivoExcel(String nombre, String tabla) {
        
        this.id = 0;
        this.nombre = nombre;
        this.tabla = tabla;
        this.fecha_hora = new GregorianCalendar().getTime();
    }
    
    public ArchivoExcel(int id, String nombre, String tabla) {
        
        this.id = id;
        this.nombre = nombre;
        this.tabla = tabla;
        this.fecha_hora = new GregorianCalendar().getTime();
    }
    
    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }

    public Date getFecha_hora() {
        
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        
        this.fecha_hora = fecha_hora;
    }

    public String getTabla() {
        
        return tabla;
    }

    public void setTabla(String tabla) {
        
        this.tabla = tabla;
    }

    @Override
    public String toString() {
        
        return "ArchivoExcel{" + "id=" + id + ", nombre=" + nombre + ", tabla=" + tabla + ", fecha_hora=" + fecha_hora + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "tabla")
    private String tabla;
    
    @Column(name = "fecha_hora")
    private Date fecha_hora;
}