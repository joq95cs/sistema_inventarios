
package castellanos.joqsan.sistema_inventarios.orm;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "productos")
public class Producto {
    
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(Producto.class).buildSessionFactory().openSession();
        
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException();
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
    }
    
    public Producto() {
        
        this.id = null;
        this.nombre = null;
        this.categoria = null;
        this.stock_min = 0;
        this.stock_max = 0;
        this.stock_ideal = 0;
        this.stock_reorden = 0;
        this.stock_max_pedido = 0;
    }

    public Producto(String id, String nombre, String categoria, int stock_min, int stock_max, int stock_ideal, int stock_reorden, int stock_max_pedido) {
        
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock_min = stock_min;
        this.stock_max = stock_max;
        this.stock_ideal = stock_ideal;
        this.stock_reorden = stock_reorden;
        this.stock_max_pedido = stock_max_pedido;
    }

    public String getId() {
        
        return id;
    }

    public void setId(String id) {
        
        this.id = id;
    }

    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }

    public String getCategoria() {
        
        return categoria;
    }

    public void setCategoria(String categoria) {
        
        this.categoria = categoria;
    }

    public int getStock_min() {
        
        return stock_min;
    }

    public void setStock_min(int stock_min) {
        
        this.stock_min = stock_min;
    }

    public int getStock_max() {
        
        return stock_max;
    }

    public void setStock_max(int stock_max) {
        
        this.stock_max = stock_max;
    }

    public int getStock_ideal() {
        
        return stock_ideal;
    }

    public void setStock_ideal(int stock_ideal) {
        
        this.stock_ideal = stock_ideal;
    }

    public int getStock_reorden() {
        
        return stock_reorden;
    }

    public void setStock_reorden(int stock_reorden) {
        
        this.stock_reorden = stock_reorden;
    }

    public int getStock_max_pedido() {
        
        return stock_max_pedido;
    }

    public void setStock_max_pedido(int stock_max_pedido) {
        
        this.stock_max_pedido = stock_max_pedido;
    }

    @Override
    public String toString() {
        
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", stock_min=" + stock_min + ", stock_max=" + stock_max + ", stock_ideal=" + stock_ideal + ", stock_reorden=" + stock_reorden + ", stock_max_pedido=" + stock_max_pedido + '}';
    }
    
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "stock_min")
    private int stock_min;
    
    @Column(name = "stock_max")
    private int stock_max;
    
    @Column(name = "stock_ideal")
    private int stock_ideal;
    
    @Column(name = "stock_reorden")
    private int stock_reorden;
    
    @Column(name = "stock_max_pedido")
    private int stock_max_pedido;
}