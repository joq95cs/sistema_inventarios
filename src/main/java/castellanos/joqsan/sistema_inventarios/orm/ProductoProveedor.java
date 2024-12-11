
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "productos_proveedores")
public class ProductoProveedor {
    
    public ProductoProveedor() {}

    public ProductoProveedor(String id_producto, double precio_compra) {
        
        this.id_producto = id_producto;
        this.precio_compra = precio_compra;
    }

    public ProductoProveedor(int id, String id_producto, double precio_compra) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.precio_compra = precio_compra;
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

    public double getPrecio_compra() {
        
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        
        this.precio_compra = precio_compra;
    }

    @Override
    public String toString() {
        
        return "ProductoProveedor{" + "id=" + id + ", id_producto=" + id_producto + ", precio_compra=" + precio_compra + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "precio_compra")
    private double precio_compra;
}