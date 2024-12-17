
package castellanos.joqsan.sistema_inventarios.logica;

public class Errores {
    
    public static class LoginException extends Exception {
        
        public LoginException(String m) {
            
            super(m);
        }
        
        public LoginException() {
        
            super("Error de login");
        }
    }
    
    public static class CamposVaciosException extends Exception {
        
        public CamposVaciosException(String m) {
            
            super(m);
        }
        
        public CamposVaciosException() {
            
            super("Error de campos vacíos");
        }
    }
    
    public static class ConexionException extends Exception {
        
        public ConexionException(String m) {
            
            super(m);
        }
        
        public ConexionException() {
            
            super("Error de conexión a la base de datos");
        }
    }
    
    public static class InsercionException extends Exception {
        
        public InsercionException(String m) {
            
            super(m);
        }
        
        public InsercionException() {
            
            super("Error de inserción");
        }
    }
    
    public static class BusquedaException extends Exception {
        
        public BusquedaException(String m) {
            
            super(m);
        }

        public BusquedaException() {
            
            super("Error de búsqueda");
        }
    }

    public static class ActualizacionException extends Exception {
        
        public ActualizacionException(String m) {
            
            super(m);
        }

        public ActualizacionException() {
            
            super("Error de actualización");
        }
    }

    public static class EliminacionException extends Exception {

        public EliminacionException(String m) {
            
            super(m);
        }
        
        public EliminacionException() {
            
            super("Error de eliminación");
        }
    }
    
    public static class ExcelException extends Exception {
        
        public ExcelException(String m) {
            
            super(m);
        }

        public ExcelException() {
            
            super("Error de Excel");
        }
    }
    
    public static class ListaException extends Exception {
        
        public ListaException(String m) {
            
            super(m);
        }
        
        public ListaException() {
            
            super("Error de lista");
        }
    }
    
    public static class LookAndFeelException extends Exception {
        
        public LookAndFeelException(String m) {
            
            super(m);
        }
        
        public LookAndFeelException() {
            
            super("Error de Look And Feel");
        }
    }
    
    public static class CargarException extends Exception {
        
        public CargarException(String m) {
            
            super(m);
        }
        
        public CargarException() {
            
            super("Error al cargar registro");
        }
    }
}