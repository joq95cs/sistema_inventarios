
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "entradas_pedidos")
public class EntradaPedido {
    
    public EntradaPedido() {}

    public EntradaPedido(int id_entrada, int id_pedido) {
        
        this.id_entrada = id_entrada;
        this.id_pedido = id_pedido;
    }

    public EntradaPedido(int id, int id_entrada, int id_pedido) {
        
        this.id = id;
        this.id_entrada = id_entrada;
        this.id_pedido = id_pedido;
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

    public int getId_pedido() {
        
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        
        this.id_pedido = id_pedido;
    }

    @Override
    public String toString() {
        
        return "EntradaPedido{" + "id=" + id + ", id_entrada=" + id_entrada + ", id_pedido=" + id_pedido + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_entrada")
    private int id_entrada;
    
    @Column(name = "id_pedido")
    private int id_pedido;
}
