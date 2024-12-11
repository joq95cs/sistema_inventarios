
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_precios")
public class ProductoPrecio {
    
    public ProductoPrecio() {}

    public ProductoPrecio(String id_producto, double precio_venta) {
        
        this.id_producto = id_producto;
        this.precio_venta = precio_venta;
    }
    
    public ProductoPrecio(int id, String id_producto, double precio_venta) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.precio_venta = precio_venta;
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

    public double getPrecio_venta() {
        
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        
        this.precio_venta = precio_venta;
    }

    @Override
    public String toString() {
        
        return "ProductoPrecio{" + "id=" + id + ", id_producto=" + id_producto + ", precio_venta=" + precio_venta + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "precio_venta")
    private double precio_venta;
}
