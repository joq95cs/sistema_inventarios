/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castellanos.joqsan.sistema_inventarios;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.ArchivoExcel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 *
 * @author joqle
 */
public class Prueba {
    
    @Test
    public void saberClase() {
        
        try {
            ArchivoExcel.iniciar();
        } catch (Errores.ConexionException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
