
package castellanos.joqsan.sistema_inventarios.orm;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.GregorianCalendar;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "entradas")
public class Entrada {
    
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
    public Entrada() {
    
        this.id = 0;
        this.id_producto = null;
        this.cantidad = 0;
        this.id_usuario = 0;
        this.fecha_hora = null;
    }

    public Entrada(String id_producto, int cantidad, int id_usuario) {
        
        this.id = 0;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public Entrada(int id, String id_producto, int cantidad, int id_usuario) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public String getId_producto() {
        
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        
        this.cantidad = cantidad;
    }

    public int getId_usuario() {
        
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        
        this.id_usuario = id_usuario;
    }

    public Date getFecha_hora() {
        
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        
        return "Entrada{" + "id=" + id + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", id_usuario=" + id_usuario + ", fecha_hora=" + fecha_hora + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "id_usuario")
    private int id_usuario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fecha_hora;
}