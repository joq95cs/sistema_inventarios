
package castellanos.joqsan.sistema_inventarios.logica;

//Todos las clases imprimen la pila de errores
public class Errores {
    
    public static class InsertarProductoException extends Exception {
        
        public InsertarProductoException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public InsertarProductoException() {
            
            super(InsertarProductoException.class.toString());
            printStackTrace();
        }
    }
    
    public static class BuscarProductoException extends Exception {
        
        public BuscarProductoException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public BuscarProductoException() {
            
            super(BuscarProductoException.class.toString());
            printStackTrace();
        }
    }

    public static class ActualizarProductoException extends Exception {

        public ActualizarProductoException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public ActualizarProductoException() {
            
            super(ActualizarProductoException.class.toString());
            printStackTrace();
        }
    }

    public static class EliminarProductoException extends Exception {

        public EliminarProductoException(String m ) {
            
            super(m);
            printStackTrace();
        }
        
        public EliminarProductoException() {
            
            super(EliminarProductoException.class.toString());
            printStackTrace();
        }
    }

    public static class CargarExcelException extends Exception {

        public CargarExcelException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public CargarExcelException() {
            
            super(CargarExcelException.class.toString());
            printStackTrace();
        }
    }

    public static class ExportarExcelException extends Exception {
        
        public ExportarExcelException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public ExportarExcelException() {
            
            super(ExportarExcelException.class.toString());
            printStackTrace();
        }
    }
    
    public static class CargarArchivosExcelException extends Exception {
        
        public CargarArchivosExcelException (String m) {
            
            super(m);
            printStackTrace();
        }
        
        public CargarArchivosExcelException () {
            
            super(CargarArchivosExcelException .class.toString());
            printStackTrace();
        }
    }
    
    public static class CargarListaException extends Exception {
        
        public CargarListaException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public CargarListaException() {
            
            super(CargarListaException.class.toString());
            printStackTrace();
        }
    }

    public static class CargarProductoException extends Exception {
        
        public CargarProductoException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public CargarProductoException() {
            
            super(CargarProductoException.class.toString());
            printStackTrace();
        }
    }
    
    //Todas las entidades lanzan esta excepcion cuando sucede un error de conexion
    public static class ConexionException extends Exception { 
        
        public ConexionException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public ConexionException() {
            
            super(ConexionException.class.toString());
            printStackTrace();
        }
    }
    
    public static class LookAndFeelException extends Exception {
        
        public LookAndFeelException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public LookAndFeelException() {
            
            super(LookAndFeelException.class.toString());
            printStackTrace();
        }
    }
    
    public static class CamposVaciosException extends Exception {
        
        public CamposVaciosException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public CamposVaciosException() {
            
            super(CamposVaciosException.class.toString());
            printStackTrace();
        }
    }
    
    public static class ArchivoIncorrectoException extends Exception {
        
        public ArchivoIncorrectoException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public ArchivoIncorrectoException() {
            
            super(ArchivoIncorrectoException.class.toString());
            printStackTrace();
        }
    }
    
    public static class InsertarPobsException extends Exception {
        
        public InsertarPobsException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public InsertarPobsException() {
            
            super(InsertarPobsException.class.toString());
            printStackTrace();
        }
    }
    
    public static class BuscarPobsException extends Exception {
        
        public BuscarPobsException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public BuscarPobsException() {
            
            super(BuscarPobsException.class.toString());
            printStackTrace();
        }
    }
    
    public static class EliminarPobsException extends Exception {
        
        public EliminarPobsException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public EliminarPobsException() {
            
            super(EliminarPobsException.class.toString());
            printStackTrace();
        }
    }
    
    public static class ActualizarPobsException extends Exception {
        
        public ActualizarPobsException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public ActualizarPobsException() {
            
            super(ActualizarPobsException.class.toString());
            printStackTrace();
        }
    }
    
    public static class LogicaProductosException extends Exception {
        
        public LogicaProductosException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public LogicaProductosException() {
            
            super(LogicaProductosException.class.toString());
            printStackTrace();
        }
    }
    
    public static class UsuarioValidoException extends Exception {
        
        public UsuarioValidoException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public UsuarioValidoException() {
            
            super(UsuarioValidoException.class.toString());
            printStackTrace();
        }
    }
    
    public static class LoginException extends Exception {
        
        public LoginException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public LoginException() {
            
            super(LoginException.class.toString());
            printStackTrace();
        }
    }
    
    public static class EliminarExcelException extends Exception {
        
        public EliminarExcelException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public EliminarExcelException() {
            
            super(EliminarExcelException.class.toString());
            printStackTrace();
        }
    }
    
    public static class AgregarExcelException extends Exception {
        
        public AgregarExcelException(String m) {
            
            super(m);
            printStackTrace();
        }
        
        public AgregarExcelException() {
            
            super(AgregarExcelException.class.toString());
            printStackTrace();
        }
    }
}