
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

//Entidad correcta
@Entity
@Table(name = "costos")
public class Costos {
    
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
    public Costos() {
    
        this.id = 0;
        this.id_productos_stock = 0;
        this.costo_promedio = 0;
        this.costo_total = 0;
        this.id_productos_proveedores = 0;
        this.id_productos_precios = 0;
    }

    public Costos(int id_productos_stock, double costo_promedio, double costo_total, int id_productos_proveedores, int id_productos_precios) {
        
        this.id = 0;
        this.id_productos_stock = id_productos_stock;
        this.costo_promedio = costo_promedio;
        this.costo_total = costo_total;
        this.id_productos_proveedores = id_productos_proveedores;
        this.id_productos_precios = id_productos_precios;
    }

    public Costos(int id, int id_productos_stock, double costo_promedio, double costo_total, int id_productos_proveedores, int id_productos_precios) {
        
        this.id = id;
        this.id_productos_stock = id_productos_stock;
        this.costo_promedio = costo_promedio;
        this.costo_total = costo_total;
        this.id_productos_proveedores = id_productos_proveedores;
        this.id_productos_precios = id_productos_precios;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_productos_stock() {
        
        return id_productos_stock;
    }

    public void setId_productos_stock(int id_productos_stock) {
        
        this.id_productos_stock = id_productos_stock;
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

    public int getId_productos_proveedores() {
        
        return id_productos_proveedores;
    }

    public void setId_productos_proveedores(int id_productos_proveedores) {
        
        this.id_productos_proveedores = id_productos_proveedores;
    }

    public int getId_productos_precios() {
        
        return id_productos_precios;
    }

    public void setId_productos_precios(int id_productos_precios) {
        
        this.id_productos_precios = id_productos_precios;
    }

    @Override
    public String toString() {
        
        return "Costos{" + "id=" + id + ", id_productos_stock=" + id_productos_stock + ", costo_promedio=" + costo_promedio + ", costo_total=" + costo_total + ", id_productos_proveedores=" + id_productos_proveedores + ", id_productos_precios=" + id_productos_precios + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_productos_stock")
    private int id_productos_stock;
    
    @Column(name = "costo_promedio")
    private double costo_promedio;
    
    @Column(name = "costo_total")
    private double costo_total;
    
    @Column(name = "id_productos_proveedores")
    private int id_productos_proveedores;
    
    @Column(name = "id_productos_precios")
    private int id_productos_precios;
}