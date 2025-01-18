
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.*;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//Esta clase contiene metodos estaticos de utilidades
public class Utilidades {
    
    //Este metodo se utiliza para llamar y ejecutar un marco o ventana
    public static void ejecutarMarco(JFrame marco) {
        
        EventQueue.invokeLater(() -> {
            
            marco.setVisible(true);
        });
    }
    
    //Este metodo centra el marco automaticamente sin importar su tamagno o el de la pantalla
    public static void centrarMarco(JFrame marco) {
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        marco.setLocation(w/2 - marco.getWidth()/2, h/2 - marco.getHeight()/2);
    }
    
    //Este metodo se utiliza para cerrar un marco y liberar sus recursos de memoria
    public static void cerrarMarco(JFrame marco) {
        
        marco.dispose();
    }
    
    //Este metodo permite generar un estilo visual para la aplicacion
    public static void setLookAndFeel() throws Errores.LookAndFeelException {
        
        try {
            
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                
                if ("Nimbus".equals(info.getName())) {

                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            
            throw new Errores.LookAndFeelException("Error de look and feel", ex);
        }
    }
    
    //Este metodo limpia los campos y el area de texto recibidos
    public static void limpiarCampos(JTextField[] campos, JTextArea area) {
        
        for(JTextField each: campos) {
            
            each.setText("");
        }
        
        if(area != null) {
            
            area.setText("");
        }
    }
    
    //Este metodo se usa para obtener la caden util de un campo de texto
    public static String obtenerCadena(JTextField campo) {
        
        if(campo.getText().isEmpty() || campo.getText().isBlank()) {
            
            return null;
        }
        
        return campo.getText().trim();
    }
    
    public static void iniciarEntidad(Class<?> type) throws Errores.IniciarEntidadException  {
        
        try {
            
            if (type.equals(Usuario.class) || type.equals(Producto.class)) {
            
                //Se obtiene el campo estatico con el nombre
                if(type.getField("session").get(null) == null) { //Si la sesion no ha sido iniciada

                    type.getMethod("iniciar").invoke(null); //Se invoca al metodo para iniciarla
                }
            }
            
        } catch(IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            
            throw new Errores.IniciarEntidadException("Error de conexion a la base de datos", ex);
        }
    }
    
    public static void cerrarEntidad(Class<?> type) throws Errores.CerrarEntidadException  {
        
        try {
            
            if (type.equals(Usuario.class) || type.equals(Producto.class)) {
            
                //Se obtiene el campo estatico con el nombre
                if(type.getField("session").get(null) != null) { //Si la sesion ya ha sido iniciada

                    type.getMethod("cerrar").invoke(null); //Se invoca al metodo para cerrarla
                    type.getField("session").set(null, null); //Se fija la sesion en null de nuevo
                }
            }
            
        } catch(IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            
            throw new Errores.CerrarEntidadException("Error de cierre de entidad", ex);
        }
    }
}