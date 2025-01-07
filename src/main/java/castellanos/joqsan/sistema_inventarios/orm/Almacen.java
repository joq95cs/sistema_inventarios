
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
@Table(name = "almacenes")
public class Almacen {
    
    //Codigo de configuraciones
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            Class type = Class.forName(Thread.currentThread().getStackTrace()[1].getClassName());
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(type).buildSessionFactory().openSession();
        
        } catch(ClassNotFoundException | HibernateException ex) {
            
            throw new Errores.ConexionException("Error de conexión");
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
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
    
    public Almacen() {
    
        this.id = 0;
        this.almacen = null;
        this.id_producto_stock = 0;
        this.costo_promedio = 0;
        this.costo_total = 0;
    }

    public Almacen(String almacen, int id_producto_stock, double costo_promedio, double costo_total) {
        
        this.id = 0;
        this.almacen = almacen;
        this.id_producto_stock = id_producto_stock;
        this.costo_promedio = costo_promedio;
        this.costo_total = costo_total;
    }

    public Almacen(int id, String almacen, int id_producto_stock, double costo_promedio, double costo_total) {
        
        this.id = id;
        this.almacen = almacen;
        this.id_producto_stock = id_producto_stock;
        this.costo_promedio = costo_promedio;
        this.costo_total = costo_total;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public String getAlmacen() {
        
        return almacen;
    }

    public void setAlmacen(String almacen) {
        
        this.almacen = almacen;
    }

    public int getId_producto_stock() {
        
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        
        this.id_producto_stock = id_producto_stock;
    }

    public double getCosto_promedio() {
        
        return costo_promedio;
    }

    public void setCosto_promedio(double costo_promedio) {
        
        this.costo_promedio = costo_promedio;
    }

    public double getCosto_total() {
        
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        
        this.costo_total = costo_total;
    }

    @Override
    public String toString() {
        
        return "Almacen{" + "id=" + id + ", almacen=" + almacen + ", id_producto_stock=" + id_producto_stock + ", costo_promedio=" + costo_promedio + ", costo_total=" + costo_total + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "almacen")
    private String almacen;
    
    @Column(name = "id_producto_stock")
    private int id_producto_stock;
    
    @Column(name = "costo_promedio")
    private double costo_promedio;
    
    @Column(name = "costo_total")
    private double costo_total; 
}