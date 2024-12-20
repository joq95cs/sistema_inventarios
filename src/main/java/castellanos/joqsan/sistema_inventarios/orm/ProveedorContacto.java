
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
@Table(name = "proveedores_contactos")
public class ProveedorContacto {
    
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
        
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(ProveedorContacto.class).buildSessionFactory().openSession();
        
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException();
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
    }
    
    public ProveedorContacto() {
    
        this.id = 0;
        this.id_proveedor = 0;
        this.contacto = null;
    }

    public ProveedorContacto(int id_proveedor, String tipo_contacto, String contacto) {
        
        this.id_proveedor = id_proveedor;
        this.tipo_contacto = tipo_contacto;
        this.contacto = contacto;
    }

    public ProveedorContacto(int id, int id_proveedor, String tipo_contacto, String contacto) {
        
        this.id = id;
        this.id_proveedor = id_proveedor;
        this.tipo_contacto = tipo_contacto;
        this.contacto = contacto;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_proveedor() {
        
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        
        this.id_proveedor = id_proveedor;
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
        
        return "ProveedorContacto{" + "id=" + id + ", id_proveedor=" + id_proveedor + ", tipo_contacto=" + tipo_contacto + ", contacto=" + contacto + '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_proveedor")
    private int id_proveedor;
    
    @Column(name = "tipo_contacto")
    private String tipo_contacto;
    
    @Column(name = "contacto")
    private String contacto;
}