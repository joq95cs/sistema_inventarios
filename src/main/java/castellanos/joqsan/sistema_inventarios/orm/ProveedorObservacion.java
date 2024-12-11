
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
@Table(name = "proveedores_observaciones")
public class ProveedorObservacion {
    
    public ProveedorObservacion() {}

    public ProveedorObservacion(int id_proveedor, String observaciones, GregorianCalendar fecha_hora) {
        
        this.id_proveedor = id_proveedor;
        this.observaciones = observaciones;
        this.fecha_hora = fecha_hora;
    }

    public ProveedorObservacion(int id, int id_proveedor, String observaciones, GregorianCalendar fecha_hora) {
        
        this.id = id;
        this.id_proveedor = id_proveedor;
        this.observaciones = observaciones;
        this.fecha_hora = fecha_hora;
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

    public String getObservaciones() {
        
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        
        this.observaciones = observaciones;
    }

    public GregorianCalendar getFecha_hora() {
        
        return fecha_hora;
    }

    public void setFecha_hora(GregorianCalendar fecha_hora) {
        
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        
        return "ProveedorObservacion{" + "id=" + id + ", id_proveedor=" + id_proveedor + ", observaciones=" + observaciones + ", fecha_hora=" + fecha_hora + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_proveedor")
    private int id_proveedor;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private GregorianCalendar fecha_hora;
}