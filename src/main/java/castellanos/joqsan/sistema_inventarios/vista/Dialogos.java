
package castellanos.joqsan.sistema_inventarios.vista;

import java.awt.Component;
import javax.swing.JOptionPane;

//Esta clase se utiliza para definir los dialogos a utilizar en el programa
public class Dialogos {
        
    public static void d_error(Component parent, Exception ex) {
        
        JOptionPane.showMessageDialog(parent, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void d_clave(Component parent, String clave) {
        
        switch (clave) {
            
            case "valor_numerico" -> JOptionPane.showMessageDialog(parent, "Valor numérico requerido", "Error", JOptionPane.ERROR_MESSAGE);
            case "insercion_productos" -> JOptionPane.showMessageDialog(parent, "Inserción exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            case "actualizacion_productos" -> JOptionPane.showMessageDialog(parent, "Actualización exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            case "eliminacion_productos" -> JOptionPane.showMessageDialog(parent, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            case "inicio_sesion" -> JOptionPane.showMessageDialog(parent, "Inicio de sesión exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            case "insercion_pobs" -> JOptionPane.showMessageDialog(parent, "Inserción exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            case "actualizacion_pobs" -> JOptionPane.showMessageDialog(parent, "Actualización exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            case "eliminacion_pobs" -> JOptionPane.showMessageDialog(parent, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            case "importacion_productos" -> JOptionPane.showMessageDialog(parent, "Importación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            case "exportacion_productos" -> JOptionPane.showMessageDialog(parent, "Exportación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}