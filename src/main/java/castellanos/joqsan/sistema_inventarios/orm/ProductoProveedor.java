
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


@Entity
@Table(name = "productos_proveedores")
public class ProductoProveedor {
    
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
    public ProductoProveedor() {
    
        this.id = 0;
        this.id_producto = null;
        this.precio_compra = 0;
    }

    public ProductoProveedor(String id_producto, double precio_compra) {
        
        this.id = 0;
        this.id_producto = id_producto;
        this.precio_compra = precio_compra;
    }

    public ProductoProveedor(int id, String id_producto, double precio_compra) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.precio_compra = precio_compra;
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

    public double getPrecio_compra() {
        
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        
        this.precio_compra = precio_compra;
    }

    @Override
    public String toString() {
        
        return "ProductoProveedor{" + "id=" + id + ", id_producto=" + id_producto + ", precio_compra=" + precio_compra + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "precio_compra")
    private double precio_compra;
}