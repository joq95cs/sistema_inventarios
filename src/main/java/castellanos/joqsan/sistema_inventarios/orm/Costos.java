
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "costos")
public class Costos {
    
    public Costos() {}

    public Costos(int id_productos_stock, double costo_promedio, double costo_total, int id_productos_proveedores, int id_productos_precios) {
        
        this.id_productos_stock = id_productos_stock;
        this.costo_promedio = costo_promedio;
        this.costo_total = costo_total;
        this.id_productos_proveedores = id_productos_proveedores;
        this.id_productos_precios = id_productos_precios;
    }

    public Costos(int id, int id_productos_stock, double costo_promedio, double costo_total, int id_productos_proveedores, int id_productos_precios) {
        
        this.id = id;
        this.id_productos_stock = id_productos_stock;
        this.costo_promedio = costo_promedio;
        this.costo_total = costo_total;
        this.id_productos_proveedores = id_productos_proveedores;
        this.id_productos_precios = id_productos_precios;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_productos_stock() {
        
        return id_productos_stock;
    }

    public void setId_productos_stock(int id_productos_stock) {
        
        this.id_productos_stock = id_productos_stock;
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

    public int getId_productos_proveedores() {
        
        return id_productos_proveedores;
    }

    public void setId_productos_proveedores(int id_productos_proveedores) {
        
        this.id_productos_proveedores = id_productos_proveedores;
    }

    public int getId_productos_precios() {
        
        return id_productos_precios;
    }

    public void setId_productos_precios(int id_productos_precios) {
        
        this.id_productos_precios = id_productos_precios;
    }

    @Override
    public String toString() {
        
        return "Costos{" + "id=" + id + ", id_productos_stock=" + id_productos_stock + ", costo_promedio=" + costo_promedio + ", costo_total=" + costo_total + ", id_productos_proveedores=" + id_productos_proveedores + ", id_productos_precios=" + id_productos_precios + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_productos_stock")
    private int id_productos_stock;
    
    @Column(name = "costo_promedio")
    private double costo_promedio;
    
    @Column(name = "costo_total")
    private double costo_total;
    
    @Column(name = "id_productos_proveedores")
    private int id_productos_proveedores;
    
    @Column(name = "id_productos_precios")
    private int id_productos_precios;
}