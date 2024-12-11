
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.GregorianCalendar;

@Entity
@Table(name = "entradas")
public class Entrada {
    
    public Entrada() {}

    public Entrada(String id_producto, int cantidad, int id_usuario, GregorianCalendar fecha_hora) {
        
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.fecha_hora = fecha_hora;
    }

    public Entrada(int id, String id_producto, int cantidad, int id_usuario, GregorianCalendar fecha_hora) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.fecha_hora = fecha_hora;
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

    public int getCantidad() {
        
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        
        this.cantidad = cantidad;
    }

    public int getId_usuario() {
        
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        
        this.id_usuario = id_usuario;
    }

    public GregorianCalendar getFecha_hora() {
        
        return fecha_hora;
    }

    public void setFecha_hora(GregorianCalendar fecha_hora) {
        
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        
        return "Entrada{" + "id=" + id + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", id_usuario=" + id_usuario + ", fecha_hora=" + fecha_hora + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "id_usuario")
    private int id_usuario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private GregorianCalendar fecha_hora;
}