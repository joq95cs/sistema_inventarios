
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
@Table(name = "entradas_observaciones")
public class EntradaObservacion {
    
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(EntradaObservacion.class).buildSessionFactory().openSession();
        
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException("Error de inicio de entidad EntradaObservacion");
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
    }
    
    public EntradaObservacion() {
    
        this.id = 0;
        this.id_entrada = 0;
        this.observaciones = null;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public EntradaObservacion(int id_entrada, String observaciones) {
        
        this.id = 0;
        this.id_entrada = id_entrada;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public EntradaObservacion(int id, int id_entrada, String observaciones) {
        
        this.id = 0;
        this.id = id;
        this.id_entrada = id_entrada;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }
    
    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_entrada() {
        
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        
        this.id_entrada = id_entrada;
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
        
        return "EntradaObservacion{" + "id=" + id + ", id_entrada=" + id_entrada + ", observaciones=" + observaciones + ", fecha_hora=" + fecha_hora + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_entrada")
    private int id_entrada;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fecha_hora;
}