package castellanos.joqsan.sistema_inventarios;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.Usuario;
import castellanos.joqsan.sistema_inventarios.vista.MarcoPanel;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        
        try {
            
            Utilidades.setLookAndFeel();
            
            //Probar conexion
            Utilidades.iniciarEntidad(Usuario.class);
            Utilidades.cerrarEntidad(Usuario.class);
            
            MarcoPanel.m = new MarcoPanel();
            Utilidades.ejecutarMarco(MarcoPanel.m);
            
        } catch(Errores.CerrarEntidadException | Errores.IniciarEntidadException | Errores.LookAndFeelException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        /*try {
            
            Utilidades.setLookAndFeel();
            MarcoLogin.m = new MarcoLogin();
            Utilidades.ejecutarMarco(MarcoLogin.m);
            
        } catch(Errores.ConexionException | Errores.LookAndFeelException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
        }*/
    }
}