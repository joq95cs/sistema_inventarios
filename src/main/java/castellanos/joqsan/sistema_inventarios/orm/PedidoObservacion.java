
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

//Entidad correcta
@Entity
@Table(name = "pedidos_observaciones")
public class PedidoObservacion {
    
    //Codigo de configuraciones
    public static Session session = null;
    public static Class type = null;
    
    //Este metodo estatico permite conectar la sesion a la tabla de productos
    public static void iniciar() throws Errores.ConexionException {
        
        try {
            
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(type).buildSessionFactory().openSession();
            System.out.println(("---Entidad " + type.getSimpleName() + " iniciada---".toUpperCase()).toUpperCase());
            
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException("Error de conexión", ex); //Se lanza una excepcion en caso de que no se pueda conectar a la tabla
        }
    }
    
    //Este metodo permite cerrar la sesion y el factory
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
        System.out.println(("---Entidad " + type.getSimpleName() + " cerrada---".toUpperCase()).toUpperCase());
    }
    
    //Este metodo permite hacer commit en la sesion
    public static void commit() {
        
        session.getTransaction().commit();
    }
    
    //Este metodo permite hacer rollback en la sesion
    public static void rollback() {
        
        if(session.getTransaction() != null) {
                
            session.getTransaction().rollback();
        }
    }
    
    //Este metodo permite limpiar la sesion
    //No se llama en caso de que los datos consultados previamente se vayan a usar
    public static void limpiar() {
        
        session.clear();
    }
    
    //Este metodo permite iniciar la transaccion para operaciones que modifiquen la tabla
    //No se necesita para leer la tabla
    public static void begin() {
        
        session.beginTransaction();
    }
    
    //Codigo de entidad
    public PedidoObservacion() {
    
        this.id = 0;
        this.id_pedido = 0;
        this.observaciones = null;
        this.fecha_hora = null;
    }

    public PedidoObservacion(int id_pedido, String observaciones, GregorianCalendar fecha_hora) {
        
        this.id = 0;
        this.id_pedido = id_pedido;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public PedidoObservacion(int id, int id_pedido, String observaciones, GregorianCalendar fecha_hora) {
        
        this.id = id;
        this.id_pedido = id_pedido;
        this.observaciones = observaciones;
        this.fecha_hora = new GregorianCalendar().getTime();
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_pedido() {
        
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        
        this.id_pedido = id_pedido;
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
        
        return "PedidoObservacion{" + "id=" + id + ", id_pedido=" + id_pedido + ", observaciones=" + observaciones + ", fecha_hora=" + fecha_hora + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_pedido")
    private int id_pedido;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fecha_hora;
}