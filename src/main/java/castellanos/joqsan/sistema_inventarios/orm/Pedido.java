
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    public Pedido() {}

    public Pedido(String fecha_pedido, String fecha_llegada, double costo_pedido, int id_proveedor_contacto, String estatus) {
        
        this.fecha_pedido = fecha_pedido;
        this.fecha_llegada = fecha_llegada;
        this.costo_pedido = costo_pedido;
        this.id_proveedor_contacto = id_proveedor_contacto;
        this.estatus = estatus;
    }

    public Pedido(int id, String fecha_pedido, String fecha_llegada, double costo_pedido, int id_proveedor_contacto, String estatus) {
        
        this.id = id;
        this.fecha_pedido = fecha_pedido;
        this.fecha_llegada = fecha_llegada;
        this.costo_pedido = costo_pedido;
        this.id_proveedor_contacto = id_proveedor_contacto;
        this.estatus = estatus;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public String getFecha_pedido() {
        
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        
        this.fecha_pedido = fecha_pedido;
    }

    public String getFecha_llegada() {
        
        return fecha_llegada;
    }

    public void setFecha_llegada(String fecha_llegada) {
        
        this.fecha_llegada = fecha_llegada;
    }

    public double getCosto_pedido() {
        
        return costo_pedido;
    }

    public void setCosto_pedido(double costo_pedido) {
        
        this.costo_pedido = costo_pedido;
    }

    public int getId_proveedor_contacto() {
        
        return id_proveedor_contacto;
    }

    public void setId_proveedor_contacto(int id_proveedor_contacto) {
        
        this.id_proveedor_contacto = id_proveedor_contacto;
    }

    public String getEstatus() {
        
        return estatus;
    }

    public void setEstatus(String estatus) {
        
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        
        return "Pedido{" + "id=" + id + ", fecha_pedido=" + fecha_pedido + ", fecha_llegada=" + fecha_llegada + ", costo_pedido=" + costo_pedido + ", id_proveedor_contacto=" + id_proveedor_contacto + ", estatus=" + estatus + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "fecha_pedido")
    private String fecha_pedido;
    
    @Column(name = "fecha_llegada")
    private String fecha_llegada;
    
    @Column(name = "costo_pedido")
    private double costo_pedido;
    
    @Column(name = "id_proveedor_contacto")
    private int id_proveedor_contacto;
    
    @Column(name = "estatus")
    private String estatus;
}
