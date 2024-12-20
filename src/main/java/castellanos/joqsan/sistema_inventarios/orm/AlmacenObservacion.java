
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
@Table(name = "almacenes_observaciones")
public class AlmacenObservacion {
    
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(AlmacenObservacion.class).buildSessionFactory().openSession();
        
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException();
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
    }
    
    public AlmacenObservacion() {
    
        this.id = 0;
        this.id_almacen = 0;
        this.observaciones = null;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public AlmacenObservacion(int id_almacen, String observaciones, GregorianCalendar fecha_hora) {
        
        this.id_almacen = id_almacen;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public AlmacenObservacion(int id, int id_almacen, String observaciones, GregorianCalendar fecha_hora) {
        
        this.id = id;
        this.id_almacen = id_almacen;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_almacen() {
        
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        
        this.id_almacen = id_almacen;
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
        
        return "AlmacenObservacion{" + "id=" + id + ", id_almacen=" + id_almacen + ", observaciones=" + observaciones + ", fecha_hora=" + fecha_hora + '}';
    }
  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_almacen")
    private int id_almacen;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fecha_hora;
}