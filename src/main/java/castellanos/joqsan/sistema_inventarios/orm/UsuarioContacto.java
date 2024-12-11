
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_contactos")
public class UsuarioContacto {
    
    public UsuarioContacto() {}

    public UsuarioContacto(int id_usuario, String tipo_contacto, String contacto) {
        
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
