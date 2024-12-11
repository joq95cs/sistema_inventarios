
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_stock")
public class ProductoStock {
    
    public ProductoStock() {}

    public ProductoStock(String id_producto, int stock_actual, String stock_estado) {
        
        this.id_producto = id_producto;
        this.stock_actual = stock_actual;
        this.stock_estado = stock_estado;
    }

    public ProductoStock(int id, String id_producto, int stock_actual, String stock_estado) {
        
        this.id = id;
        this.id_producto = id_producto;
        this.stock_actual = stock_actual;
        this.stock_estado = stock_estado;
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

    public int getStock_actual() {
        
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        
        this.stock_actual = stock_actual;
    }

    public String getStock_estado() {
        
        return stock_estado;
    }

    public void setStock_estado(String stock_estado) {
        
        this.stock_estado = stock_estado;
    }

    @Override
    public String toString() {
        
        return "ProductoStock{" + "id=" + id + ", id_producto=" + id_producto + ", stock_actual=" + stock_actual + ", stock_estado=" + stock_estado + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "stock_actual")
    private int stock_actual;
    
    @Column(name = "stock_estado")
    private String stock_estado;
}