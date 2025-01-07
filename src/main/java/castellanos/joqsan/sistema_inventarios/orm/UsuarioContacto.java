
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
@Table(name = "usuarios_contactos")
public class UsuarioContacto {
    
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
    
    public UsuarioContacto() {
    
        this.id = 0;
        this.id_usuario = 0;
        this.tipo_contacto = null;
        this.contacto = null;
    }

    public UsuarioContacto(int id_usuario, String tipo_contacto, String contacto) {
        
        this.id = 0;
        this.id_usuario = id_usuario;
        this.tipo_contacto = tipo_contacto;
        this.contacto = contacto;
    }

    public UsuarioContacto(int id, int id_usuario, String tipo_contacto, String contacto) {
        
        this.id = id;
        this.id_usuario = id_usuario;
        this.tipo_contacto = tipo_contacto;
        this.contacto = contacto;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_usuario() {
        
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        
        this.id_usuario = id_usuario;
    }

    public String getTipo_contacto() {
        
        return tipo_contacto;
    }

    public void setTipo_contacto(String tipo_contacto) {
        
        this.tipo_contacto = tipo_contacto;
    }

    public String getContacto() {
        
        return contacto;
    }

    public void setContacto(String contacto) {
        
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "UsuarioContacto{" + "id=" + id + ", id_usuario=" + id_usuario + ", tipo_contacto=" + tipo_contacto + ", contacto=" + contacto + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_usuario")
    private int id_usuario;
    
    @Column(name = "tipo_contacto")
    private String tipo_contacto;
    
    @Column(name = "contacto")
    private String contacto;
}