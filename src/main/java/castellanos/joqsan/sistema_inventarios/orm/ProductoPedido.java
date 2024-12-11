
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_pedidos")
public class ProductoPedido {
    
    public ProductoPedido() {}

    public ProductoPedido(int id_producto_stock, int unidades_pedidas, double kilos_pedidos, double costo_unitario, double costo_total, int id_pedido) {
        
        this.id_producto_stock = id_producto_stock;
        this.unidades_pedidas = unidades_pedidas;
        this.kilos_pedidos = kilos_pedidos;
        this.costo_unitario = costo_unitario;
        this.costo_total = costo_total;
        this.id_pedido = id_pedido;
    }

    public ProductoPedido(int id, int id_producto_stock, int unidades_pedidas, double kilos_pedidos, double costo_unitario, double costo_total, int id_pedido) {
        
        this.id = id;
        this.id_producto_stock = id_producto_stock;
        this.unidades_pedidas = unidades_pedidas;
        this.kilos_pedidos = kilos_pedidos;
        this.costo_unitario = costo_unitario;
        this.costo_total = costo_total;
        this.id_pedido = id_pedido;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public int getId_producto_stock() {
        
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        
        this.id_producto_stock = id_producto_stock;
    }

    public int getUnidades_pedidas() {
        
        return unidades_pedidas;
    }

    public void setUnidades_pedidas(int unidades_pedidas) {
        
        this.unidades_pedidas = unidades_pedidas;
    }

    public double getKilos_pedidos() {
        
        return kilos_pedidos;
    }

    public void setKilos_pedidos(double kilos_pedidos) {
        
        this.kilos_pedidos = kilos_pedidos;
    }

    public double getCosto_unitario() {
        
        return costo_unitario;
    }

    public void setCosto_unitario(double costo_unitario) {
        
        this.costo_unitario = costo_unitario;
    }

    public double getCosto_total() {
        
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        
        this.costo_total = costo_total;
    }

    public int getId_pedido() {
        
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        
        this.id_pedido = id_pedido;
    }

    @Override
    public String toString() {
        
        return "ProductoPedido{" + "id=" + id + ", id_producto_stock=" + id_producto_stock + ", unidades_pedidas=" + unidades_pedidas + ", kilos_pedidos=" + kilos_pedidos + ", costo_unitario=" + costo_unitario + ", costo_total=" + costo_total + ", id_pedido=" + id_pedido + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_producto_stock")
    private int id_producto_stock;
    
    @Column(name = "unidades_pedidas")
    private int unidades_pedidas;
    
    @Column(name = "kilos_pedidos")
    private double kilos_pedidos;
    
    @Column(name = "costo_unitario")
    private double costo_unitario;
    
    @Column(name = "costo_total")
    private double costo_total;
    
    @Column(name = "id_pedido")
    private int id_pedido;
}