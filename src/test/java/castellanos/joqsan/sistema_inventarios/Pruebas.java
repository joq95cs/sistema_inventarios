
package castellanos.joqsan.sistema_inventarios;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.logica.LogicaLogin;
import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
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
            
            LogicaProductos.crud = new LogicaProductos();
            LogicaProductos.crud.setProducto(prod);
            LogicaProductos.crud.insertarProducto();
            
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
            LogicaLogin login = new LogicaLogin(user, password);
            assertEquals(true, login.usuarioValido(), "Es valido");
        
        } catch(Errores.ConexionException | NoSuchAlgorithmException ex) {
            
            ex.printStackTrace();
        }
    }
}
