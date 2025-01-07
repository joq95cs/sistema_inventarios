
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
@Table(name = "salidas_observaciones")
public class SalidaObservacion {
    
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(SalidaObservacion.class).buildSessionFactory().openSession();
        
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException("Error de inicio de entidad SalidaObservacion");
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
    }

    public SalidaObservacion() {
    
        this.id = 0;
        this.id_salida = 0;
        this.observaciones = null;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public SalidaObservacion(int id_salida, String observaciones) {
        
        this.id = 0;
        this.id_salida = id_salida;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public SalidaObservacion(int id, int id_salida, String observaciones) {
        
        this.id = id;
        this.id_salida = id_salida;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_salida() {
        
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        
        this.id_salida = id_salida;
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
        
        return "SalidaObservacion{" + "id=" + id + ", id_salida=" + id_salida + ", observaciones=" + observaciones + ", fecha_hora=" + fecha_hora + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_salida")
    private int id_salida;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fecha_hora;
}