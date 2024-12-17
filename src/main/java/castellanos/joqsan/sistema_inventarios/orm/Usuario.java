
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
@Table(name = "usuarios")
public class Usuario {
    
    public static Session session = null;
    
    public static void iniciar() throws Errores.ConexionException {
        
        try {
            
            session = new Configuration().configure("config/hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory().openSession();
            
        } catch(HibernateException ex) {
            
            throw new Errores.ConexionException();
        }
    }
    
    public static void cerrar() {
        
        session.getSessionFactory().close();
        session.close();
    }
    
    public Usuario() {
    
        this.id = 0;
        this.username = null;
        this.password = null;
        this.nombre = null;
        this.apellido_paterno = null;
        this.apellido_materno = null;
        this.tipo_usuario = null;
    }
    
    public Usuario(String username, String password, String nombre, String apellido_paterno, String apellido_materno, String tipo_usuario) {
        
        this.id = 0;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.tipo_usuario = tipo_usuario;
    }

    public Usuario(int id, String username, String password, String nombre, String apellido_paterno, String apellido_materno, String tipo_usuario) {
        
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.tipo_usuario = tipo_usuario;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public String getUsername() {
        
        return username;
    }

    public void setUsername(String username) {
        
        this.username = username;
    }

    public String getPassword() {
        
        return password;
    }

    public void setPassword(String password) {
        
        this.password = password;
    }

    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        
        this.apellido_materno = apellido_materno;
    }

    public String getTipo_usuario() {
        
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", tipo_usuario=" + tipo_usuario + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido_paterno")
    private String apellido_paterno;
    
    @Column(name = "apellido_materno")
    private String apellido_materno;
    
    @Column(name = "tipo_usuario")
    private String tipo_usuario;
}