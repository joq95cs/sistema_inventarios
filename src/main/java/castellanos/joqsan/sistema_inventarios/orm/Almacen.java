
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "almacenes")
public class Almacen {
    
    public Almacen() {}

    public Almacen(String almacen, int id_producto_stock, double costo_promedio, double costo_total) {
        
        this.almacen = almacen;
        this.id_producto_stock = id_producto_stock;
        this.costo_promedio = costo_promedio;
        this.costo_total = costo_total;
    }

    public Almacen(int id, String almacen, int id_producto_stock, double costo_promedio, double costo_total) {
        
        this.id = id;
        this.almacen = almacen;
        this.id_producto_stock = id_producto_stock;
        this.costo_promedio = costo_promedio;
        this.costo_total = costo_total;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public String getAlmacen() {
        
        return almacen;
    }

    public void setAlmacen(String almacen) {
        
        this.almacen = almacen;
    }

    public int getId_producto_stock() {
        
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        
        this.id_producto_stock = id_producto_stock;
    }

    public double getCosto_promedio() {
        
        return costo_promedio;
    }

    public void setCosto_promedio(double costo_promedio) {
        
        this.costo_promedio = costo_promedio;
    }

    public double getCosto_total() {
        
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        
        this.costo_total = costo_total;
    }

    @Override
    public String toString() {
        
        return "Almacen{" + "id=" + id + ", almacen=" + almacen + ", id_producto_stock=" + id_producto_stock + ", costo_promedio=" + costo_promedio + ", costo_total=" + costo_total + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "almacen")
    private String almacen;
    
    @Column(name = "id_producto_stock")
    private int id_producto_stock;
    
    @Column(name = "costo_promedio")
    private double costo_promedio;
    
    @Column(name = "costo_total")
    private double costo_total; 
}