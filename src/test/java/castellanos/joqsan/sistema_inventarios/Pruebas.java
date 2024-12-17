
package castellanos.joqsan.sistema_inventarios;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.logica.Login;
import castellanos.joqsan.sistema_inventarios.logica.Productos;
import castellanos.joqsan.sistema_inventarios.orm.*;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Pruebas {
    
    @Test
    public void probarProducto() {
        
        try {
            
            Producto prod = new Producto();
            prod.setId("Hola a todos");
            prod.setNombre("Saludando");
            prod.setCategoria("Nada que decir");
            
            Productos.crud = new Productos();
            Productos.crud.setProducto(prod);
            Productos.crud.insertarProducto();
            
        } catch(Exception ex) {
            
            ex.printStackTrace();
        }
    } 
    
    @Test
    public void probarFechaHora() {
        
        
        try {
            
            //GregorianCalendar gc = new GregorianCalendar();
           
            
            ProductoObservacion.session.beginTransaction();
            
            ProductoObservacion pobs = new ProductoObservacion("p10", "jugando alto");
            //pobs.setFecha_hora(null);
            ProductoObservacion.session.persist(pobs);
            ProductoObservacion.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            
        }
    }
    
    @Test
    public void probarLogin() {
        
        try {
        
            String user = JOptionPane.showInputDialog("Ingresa usuario");
            String password = JOptionPane.showInputDialog("Ingresa contraseña");
            Login login = new Login(user, password);
            assertEquals(true, login.usuarioValido(), "Es valido");
        
        } catch(Errores.ConexionException | NoSuchAlgorithmException ex) {
            
            ex.printStackTrace();
        }
    }
}
