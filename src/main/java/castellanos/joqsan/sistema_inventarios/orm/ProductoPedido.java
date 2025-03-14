
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
@Table(name = "productos_pedidos")
public class ProductoPedido {
    
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
    public ProductoPedido() {
    
        this.id = 0;
        this.id_producto_stock = 0;
        this.unidades_pedidas = 0;
        this.kilos_pedidos = 0;
        this.costo_total = 0;
        this.costo_total = 0;
        this.id_pedido = 0;
    }

    public ProductoPedido(int id_producto_stock, int unidades_pedidas, double kilos_pedidos, double costo_unitario, double costo_total, int id_pedido) {
        
        this.id = 0;
        this.id_producto_stock = id_producto_stock;
        this.unidades_pedidas = unidades_pedidas;
        this.kilos_pedidos = kilos_pedidos;
        this.costo_unitario = costo_unitario;
        this.costo_total = costo_total;
        this.id_pedido = id_pedido;
    }

    public ProductoPedido(int id, int id_producto_stock, int unidades_pedidas, double kilos_pedidos, double costo_unitario, double costo_total, int id_pedido) {
        
        this.id = id;
        this.id_producto_stock = id_producto_stock;
        this.unidades_pedidas = unidades_pedidas;
        this.kilos_pedidos = kilos_pedidos;
        this.costo_unitario = costo_unitario;
        this.costo_total = costo_total;
        this.id_pedido = id_pedido;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_producto_stock() {
        
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        
        this.id_producto_stock = id_producto_stock;
    }

    public int getUnidades_pedidas() {
        
        return unidades_pedidas;
    }

    public void setUnidades_pedidas(int unidades_pedidas) {
        
        this.unidades_pedidas = unidades_pedidas;
    }

    public double getKilos_pedidos() {
        
        return kilos_pedidos;
    }

    public void setKilos_pedidos(double kilos_pedidos) {
        
        this.kilos_pedidos = kilos_pedidos;
    }

    public double getCosto_unitario() {
        
        return costo_unitario;
    }

    public void setCosto_unitario(double costo_unitario) {
        
        this.costo_unitario = costo_unitario;
    }

    public double getCosto_total() {
        
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        
        this.costo_total = costo_total;
    }

    public int getId_pedido() {
        
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        
        this.id_pedido = id_pedido;
    }

    @Override
    public String toString() {
        
        return "ProductoPedido{" + "id=" + id + ", id_producto_stock=" + id_producto_stock + ", unidades_pedidas=" + unidades_pedidas + ", kilos_pedidos=" + kilos_pedidos + ", costo_unitario=" + costo_unitario + ", costo_total=" + costo_total + ", id_pedido=" + id_pedido + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto_stock")
    private int id_producto_stock;
    
    @Column(name = "unidades_pedidas")
    private int unidades_pedidas;
    
    @Column(name = "kilos_pedidos")
    private double kilos_pedidos;
    
    @Column(name = "costo_unitario")
    private double costo_unitario;
    
    @Column(name = "costo_total")
    private double costo_total;
    
    @Column(name = "id_pedido")
    private int id_pedido;
}