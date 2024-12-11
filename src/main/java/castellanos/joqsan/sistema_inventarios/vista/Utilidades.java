
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Utilidades {
    
    public static void ejecutarMarco(JFrame marco) {
        
        EventQueue.invokeLater(() -> {
            
            marco.setVisible(true);
        });
    }
    
    public static void centrarMarco(JFrame marco) {
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        marco.setLocation(w/2 - marco.getWidth()/2, h/2 - marco.getHeight()/2);
    }
    
    public static void cerrarMarco(JFrame marco) {
        
        marco.dispose();
    }
    
    public static void setLookAndFeel() throws Errores.LookAndFeelException {
        
        try {
            
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                
                if ("Nimbus".equals(info.getName())) {

                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            
            throw new Errores.LookAndFeelException();
        }
    }
    
    public static void limpiarCampos(JTextField[] campos) {
        
        for(JTextField each: campos) {
            
            each.setText("");
        }
    }
}