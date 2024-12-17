
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
@Table(name = "productos_observaciones")
public class ProductoObservacion {
    
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(ProductoObservacion.class).buildSessionFactory().openSession();
        
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException();
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
    }

    public ProductoObservacion() {
    
        this.id = 0;
        this.id_producto = null;
        this.observaciones = null;
        this.fecha_hora = new GregorianCalendar().getTime();
    }
    
    public ProductoObservacion(String id_producto, String observaciones) {
        
        this.id = 0;
        this.id_producto = id_producto;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public ProductoObservacion(int id, String id_producto, String observaciones) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.observaciones = observaciones;
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

    public String getObservaciones() {
        
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        
        this.observaciones = observaciones;
    }

    public Date getFecha_hora() {
        
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        
        return "ProductoObservacion{" + "id=" + id + ", id_producto=" + id_producto + ", observaciones=" + observaciones + ", fecha_hora=" + fecha_hora + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fecha_hora;
}