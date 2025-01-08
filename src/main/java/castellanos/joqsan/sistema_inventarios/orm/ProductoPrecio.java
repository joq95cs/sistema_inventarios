
package castellanos.joqsan.sistema_inventarios.orm;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

//Entidac correcta
@Entity
@Table(name = "productos_precios")
public class ProductoPrecio {
    
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
    public ProductoPrecio() {
    
        this.id = 0;
        this.id_producto = null;
        this.precio_venta = 0;
    }

    public ProductoPrecio(String id_producto, double precio_venta) {
        
        this.id = 0;
        this.id_producto = id_producto;
        this.precio_venta = precio_venta;
    }
    
    public ProductoPrecio(int id, String id_producto, double precio_venta) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.precio_venta = precio_venta;
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

    public double getPrecio_venta() {
        
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        
        this.precio_venta = precio_venta;
    }

    @Override
    public String toString() {
        
        return "ProductoPrecio{" + "id=" + id + ", id_producto=" + id_producto + ", precio_venta=" + precio_venta + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "precio_venta")
    private double precio_venta;
}
