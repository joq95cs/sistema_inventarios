
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
@Table(name = "productos_stock")
public class ProductoStock {
    
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
    public ProductoStock() {
    
        this.id = 0;
        this.id_producto = null;
        this.stock_actual = 0;
        this.stock_estado = null;
    }

    public ProductoStock(String id_producto, int stock_actual, String stock_estado) {
        
        this.id = 0;
        this.id_producto = id_producto;
        this.stock_actual = stock_actual;
        this.stock_estado = stock_estado;
    }

    public ProductoStock(int id, String id_producto, int stock_actual, String stock_estado) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.stock_actual = stock_actual;
        this.stock_estado = stock_estado;
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

    public int getStock_actual() {
        
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        
        this.stock_actual = stock_actual;
    }

    public String getStock_estado() {
        
        return stock_estado;
    }

    public void setStock_estado(String stock_estado) {
        
        this.stock_estado = stock_estado;
    }

    @Override
    public String toString() {
        
        return "ProductoStock{" + "id=" + id + ", id_producto=" + id_producto + ", stock_actual=" + stock_actual + ", stock_estado=" + stock_estado + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "stock_actual")
    private int stock_actual;
    
    @Column(name = "stock_estado")
    private String stock_estado;
}