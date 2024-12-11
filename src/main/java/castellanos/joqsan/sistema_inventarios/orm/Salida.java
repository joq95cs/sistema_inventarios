
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
@Table(name = "salidas")
public class Salida {
    
    public Salida() {}

    public Salida(String id_producto, int cantidad, GregorianCalendar fecha_hora) {
        
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.fecha_hora = fecha_hora;
    }
    
    public Salida(int id, String id_producto, int cantidad, GregorianCalendar fecha_hora) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
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

    public GregorianCalendar getFecha_hora() {
        
        return fecha_hora;
    }

    public void setFecha_hora(GregorianCalendar fecha_hora) {
        
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        
        return "Salida{" + "id=" + id + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", fecha_hora=" + fecha_hora + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private GregorianCalendar fecha_hora;
}