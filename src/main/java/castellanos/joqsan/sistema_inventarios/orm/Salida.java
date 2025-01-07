
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
@Table(name = "salidas")
public class Salida {
    
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(Salida.class).buildSessionFactory().openSession();
        
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException("Error de inicio de entidad Salida");
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
    }
    
    public Salida() {
    
        this.id = 0;
        this.id_producto = null;
        this.cantidad = 0;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public Salida(String id_producto, int cantidad) {
        
        this.id = 0;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.fecha_hora = new GregorianCalendar().getTime();
    }
    
    public Salida(int id, String id_producto, int cantidad) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
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

    public Date getFecha_hora() {
        
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        
        return "Salida{" + "id=" + id + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", fecha_hora=" + fecha_hora + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fecha_hora;
}