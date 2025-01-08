
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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

//Entidad correcta
@Entity
@Table(name = "pedidos")
public class Pedido {
    
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
    public Pedido() {
        
        this.id = 0;
        this.fecha_pedido = null;
        this.fecha_llegada = null;
        this.costo_pedido = 0;
        this.id_proveedor_contacto = 0;
        this.estatus = null;
    }
    
    public Pedido(Date fecha_pedido, Date fecha_llegada, double costo_pedido, int id_proveedor_contacto, String estatus) {
        
        this.id = 0;
        this.fecha_pedido = fecha_pedido;
        this.fecha_llegada = fecha_llegada;
        this.costo_pedido = costo_pedido;
        this.id_proveedor_contacto = id_proveedor_contacto;
        this.estatus = estatus;
    }

    public Pedido(int id, Date fecha_pedido, Date fecha_llegada, double costo_pedido, int id_proveedor_contacto, String estatus) {
        
        this.id = 0;
        this.fecha_pedido = fecha_pedido;
        this.fecha_llegada = fecha_llegada;
        this.costo_pedido = costo_pedido;
        this.id_proveedor_contacto = id_proveedor_contacto;
        this.estatus = estatus;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public Date getFecha_pedido() {
        
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_llegada() {
        
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        
        this.fecha_llegada = fecha_llegada;
    }

    public double getCosto_pedido() {
        
        return costo_pedido;
    }

    public void setCosto_pedido(double costo_pedido) {
        
        this.costo_pedido = costo_pedido;
    }

    public int getId_proveedor_contacto() {
        
        return id_proveedor_contacto;
    }

    public void setId_proveedor_contacto(int id_proveedor_contacto) {
        
        this.id_proveedor_contacto = id_proveedor_contacto;
    }

    public String getEstatus() {
        
        return estatus;
    }

    public void setEstatus(String estatus) {
        
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        
        return "Pedido{" + "id=" + id + ", fecha_pedido=" + fecha_pedido + ", fecha_llegada=" + fecha_llegada + ", costo_pedido=" + costo_pedido + ", id_proveedor_contacto=" + id_proveedor_contacto + ", estatus=" + estatus + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_pedido")
    private Date fecha_pedido;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_llegada")
    private Date fecha_llegada;
    
    @Column(name = "costo_pedido")
    private double costo_pedido;
    
    @Column(name = "id_proveedor_contacto")
    private int id_proveedor_contacto;
    
    @Column(name = "estatus")
    private String estatus;
}
