
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
@Table(name = "entradas_pedidos")
public class EntradaPedido {
    
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
    public EntradaPedido() {
    
        this.id = 0;
        this.id_entrada = 0;
        this.id_pedido = 0;
    }

    public EntradaPedido(int id_entrada, int id_pedido) {
        
        this.id = 0;
        this.id_entrada = id_entrada;
        this.id_pedido = id_pedido;
    }

    public EntradaPedido(int id, int id_entrada, int id_pedido) {
        
        this.id = id;
        this.id_entrada = id_entrada;
        this.id_pedido = id_pedido;
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

    public int getId_pedido() {
        
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        
        this.id_pedido = id_pedido;
    }

    @Override
    public String toString() {
        
        return "EntradaPedido{" + "id=" + id + ", id_entrada=" + id_entrada + ", id_pedido=" + id_pedido + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_entrada")
    private int id_entrada;
    
    @Column(name = "id_pedido")
    private int id_pedido;
}
