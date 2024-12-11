
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
@Table(name = "entradas_observaciones")
public class EntradaObservacion {
    
    public EntradaObservacion() {}

    public EntradaObservacion(int id_entrada, String observaciones, GregorianCalendar fecha_hora) {
        
        this.id_entrada = id_entrada;
        this.observaciones = observaciones;
        this.fecha_hora = fecha_hora;
    }

    public EntradaObservacion(int id, int id_entrada, String observaciones, GregorianCalendar fecha_hora) {
        
        this.id = id;
        this.id_entrada = id_entrada;
        this.observaciones = observaciones;
        this.fecha_hora = fecha_hora;
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
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_entrada")
    private int id_entrada;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private GregorianCalendar fecha_hora;
}