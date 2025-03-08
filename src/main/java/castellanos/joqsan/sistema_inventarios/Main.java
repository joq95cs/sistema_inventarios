package castellanos.joqsan.sistema_inventarios;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.Usuario;
import castellanos.joqsan.sistema_inventarios.vista.Dialogos;
import castellanos.joqsan.sistema_inventarios.vista.MarcoLogin;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;

public class Main {
    
    public static void main(String[] args) {
        
        try {
            
            //Fijar look and feel
            Utilidades.setLookAndFeel();
            
            //Probar conexion
            Utilidades.iniciarEntidad(Usuario.class);
            Utilidades.cerrarEntidad(Usuario.class);
            
            MarcoLogin.m = new MarcoLogin();
            Utilidades.ejecutarMarco(MarcoLogin.m);
            
        } catch(Errores.CerrarEntidadException | Errores.IniciarEntidadException | Errores.LookAndFeelException ex) {
            
            Dialogos.d_error(null, ex);
        }
    }
}