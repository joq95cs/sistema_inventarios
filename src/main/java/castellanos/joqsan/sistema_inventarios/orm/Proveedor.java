
package castellanos.joqsan.sistema_inventarios.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {
    
    public Proveedor() {}

    public Proveedor(String nombre, String direccion) {
        
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Proveedor(int id, String nombre, String direccion) {
        
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }

    public String getDireccion() {
        
        return direccion;
    }

    public void setDireccion(String direccion) {
        
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        
        return "Proveedores{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;
}