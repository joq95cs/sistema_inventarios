
package castellanos.joqsan.sistema_inventarios;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.logica.LogicaLogin;
import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import castellanos.joqsan.sistema_inventarios.orm.*;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
            
            ex.printStackTrace();
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
    
    @Test
    public void agregarUsuario() {
        
        boolean ok = false;
        
        try {
            
            Usuario.iniciar();
            Usuario.session.beginTransaction();
            Usuario usuario = new Usuario();
            usuario.setNombre("Adalid");
            usuario.setApellido_paterno("Castellanos");
            usuario.setUsername("joq");
            usuario.setPassword("123");
            usuario.setApellido_materno("No definido");
            Usuario.session.persist(usuario);
            Usuario.session.getTransaction().commit();
            
            ok = true;
            
        } catch(Exception ex) {
            
            ok = false;
            ex.printStackTrace();
            
        } finally {
            
            assertEquals(true, ok);
        }
    }
    
    @Test
    public void probarEditarExcel() {
        
        
    }       
}
