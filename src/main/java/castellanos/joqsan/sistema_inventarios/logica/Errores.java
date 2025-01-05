
package castellanos.joqsan.sistema_inventarios.logica;

//Todos las clases imprimen la pila de errores
public class Errores {
    
    public static class LoginException extends Exception {
        
        public LoginException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public LoginException() {
        
            super("Error de login");
            printStackTrace();
        }
    }
    
    public static class CamposVaciosException extends Exception {
        
        public CamposVaciosException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public CamposVaciosException() {
            
            super("Error de campos vacíos");
            printStackTrace();
        }
    }
    
    public static class ConexionException extends Exception {
        
        public ConexionException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public ConexionException() {
            
            super("Error de conexión a la base de datos");
            printStackTrace();
        }
    }
    
    public static class InsercionException extends Exception {
        
        public InsercionException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public InsercionException() {
            
            super("Error de inserción");
            printStackTrace();
        }
    }
    
    public static class BusquedaException extends Exception {
        
        public BusquedaException(String m) {
            
            super(m);
            printStackTrace();
        }

        public BusquedaException() {
            
            super("Error de búsqueda");
            printStackTrace();
        }
    }

    public static class ActualizacionException extends Exception {
        
        public ActualizacionException(String m) {
            
            super(m);
            printStackTrace();
        }

        public ActualizacionException() {
            
            super("Error de actualización");
            printStackTrace();
        }
    }

    public static class EliminacionException extends Exception {

        public EliminacionException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public EliminacionException() {
            
            super("Error de eliminación");
            printStackTrace();
        }
    }
    
    public static class ExcelException extends Exception {
        
        public ExcelException(String m) {
            
            super(m);
            printStackTrace();
        }

        public ExcelException() {
            
            super("Error de Excel");
            printStackTrace();
        }
    }
    
    public static class ListaException extends Exception {
        
        public ListaException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public ListaException() {
            
            super("Error de lista");
            printStackTrace();
        }
    }
    
    public static class LookAndFeelException extends Exception {
        
        public LookAndFeelException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public LookAndFeelException() {
            
            super("Error de Look And Feel");
            printStackTrace();
        }
    }
    
    public static class CargarException extends Exception {
        
        public CargarException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public CargarException() {
            
            super("Error al cargar registro");
            printStackTrace();
        }
    }
}