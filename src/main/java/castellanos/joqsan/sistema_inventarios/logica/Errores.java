
package castellanos.joqsan.sistema_inventarios.logica;

//CLASE CONTENEDORA GENERAL DE ERRRORES
public class Errores extends Exception {
    
    public Errores(String m, Exception ex, Class tipo) {
        
        //ARGUMENTOS RECIBIDOS
        //m: Mensaje personalizado
        //ex: Objeto de error original que causo el error
        //tipo: Clase relacionada al error original sucedido
        
        super(m); //Se llama al constructor padre y se le pasa el mensaje recibido
        System.err.println("---ERROR---");
        System.err.println("Tipo: " + tipo.getSimpleName()); //Se imprime el nombre de la clase recibida
        
        if(ex != null) { //Se verifica que el objeto de error recibido exista
            
            System.err.println("Causa: " + ex.getClass().toString() + " -> " + ex.getMessage()); //Se imprime informacion del error original
        }
        
        System.err.println("---STACK TRACE---");
        printStackTrace(); //Se imprime la pila de ejecucion
    }
    
    //CLASES DE ERRORES ESPECIFICOS
    public static class InsertarProductoException extends Errores {
        
        public InsertarProductoException(String m, Exception ex) {
            
            super(m, ex, InsertarProductoException.class);
        }
    }
    
    public static class BuscarProductoException extends Errores {
        
        public BuscarProductoException(String m, Exception ex) {
            
            super(m, ex, BuscarProductoException.class);
        }
    }

    public static class ActualizarProductoException extends Errores {

        public ActualizarProductoException(String m, Exception ex) {
            
            super(m, ex, ActualizarProductoException.class);
        }
    }

    public static class EliminarProductoException extends Errores {

        public EliminarProductoException(String m, Exception ex) {
            
            super(m, ex, EliminarProductoException.class);
        }
    }

    public static class ImportarExcelException extends Errores {

        public ImportarExcelException(String m, Exception ex) {
            
            super(m, ex, ImportarExcelException.class);
        }
    }

    public static class ExportarExcelException extends Errores {
        
        public ExportarExcelException(String m, Exception ex) {
            
            super(m, ex, ExportarExcelException.class);
        }
    }
    
    public static class CargarArchivosExcelException extends Errores {
        
        public CargarArchivosExcelException (String m, Exception ex) {
            
            super(m, ex, CargarArchivosExcelException.class);
        }
    }
    
    public static class CargarListaProductosException extends Errores {
        
        public CargarListaProductosException(String m, Exception ex) {
            
            super(m, ex, CargarListaProductosException.class);
        }
    }

    public static class CargarProductoException extends Errores {
        
        public CargarProductoException(String m, Exception ex) {
            
            super(m, ex, CargarProductoException.class);
        }
    }
    
    public static class ConexionException extends Errores { 
        
        public ConexionException(String m, Exception ex) {
            
            super(m, ex, ConexionException.class);
        }
    }
    
    public static class LookAndFeelException extends Errores {
        
        public LookAndFeelException(String m, Exception ex) {
            
            super(m, ex, LookAndFeelException.class);
        }
    }
    
    public static class CamposVaciosException extends Errores {
        
        public CamposVaciosException(String m, Exception ex) {
            
            super(m, ex, CamposVaciosException.class);
        }
    }
    
    public static class ArchivoIncorrectoException extends Errores {
        
        public ArchivoIncorrectoException(String m, Exception ex) {
            
            super(m, ex, ArchivoIncorrectoException.class);
        }
    }
    
    public static class InsertarPobsException extends Errores {
        
        public InsertarPobsException(String m, Exception ex) {
            
            super(m, ex, InsertarPobsException.class);
        }
    }
    
    public static class BuscarPobsException extends Errores {
        
        public BuscarPobsException(String m, Exception ex) {
            
            super(m, ex, BuscarPobsException.class);
        }
    }
    
    public static class EliminarPobsException extends Errores {
        
        public EliminarPobsException(String m, Exception ex) {
            
            super(m, ex, EliminarPobsException.class);
        }
    }
    
    public static class ActualizarPobsException extends Errores {
        
        public ActualizarPobsException(String m, Exception ex) {
            
            super(m, ex, ActualizarPobsException.class);
        }
    }
    
    public static class LogicaProductosException extends Errores {
        
        public LogicaProductosException(String m, Exception ex) {
            
            super(m, ex, LogicaProductosException.class);
        }
    }
    
    public static class UsuarioValidoException extends Errores {
        
        public UsuarioValidoException(String m, Exception ex) {
            
            super(m, ex, UsuarioValidoException.class);
        }
    }
    
    public static class LoginException extends Errores {
        
        public LoginException(String m, Exception ex) {
            
            super(m, ex, LoginException.class);
        }
    }
    
    public static class EliminarExcelException extends Errores {
        
        public EliminarExcelException(String m, Exception ex) {
            
            super(m, ex, EliminarExcelException.class);
        }
    }
    
    public static class AgregarExcelException extends Errores {
        
        public AgregarExcelException(String m, Exception ex) {
            
            super(m, ex, AgregarExcelException.class);
        }
    }
    
    public static class InsertarArchivoExcelException extends Errores {
        
        public InsertarArchivoExcelException(String m, Exception ex) {
            
            super(m, ex, InsertarArchivoExcelException.class);
        }
    }
    
    public static class AbrirArchivoExcelException extends Errores {
        
        public AbrirArchivoExcelException(String m, Exception ex) {
            
            super(m, ex, AbrirArchivoExcelException.class);
        }
    }
    
    public static class CopiadorException extends Errores {
        
        public CopiadorException(String m, Exception ex) {
            
            super(m, ex, CopiadorException.class);
        }
    }
    
    public static class CerrarEntidadException extends Errores {
        
        public CerrarEntidadException(String m, Exception ex) {
            
            super(m, ex, CopiadorException.class);
        }
    }
    
    public static class IniciarEntidadException extends Errores {
        
        public IniciarEntidadException(String m, Exception ex) {
            
            super(m, ex, IniciarEntidadException.class);
        }
    }
    
    public static class CadenaIngresadaException extends Errores {
        
        public CadenaIngresadaException(String m, Exception ex) {
            
            super(m, ex, CadenaIngresadaException.class);
        }
    }
    
    //Todos los metodos de las clases de logica tiene errores personalizados asociados
    //Tambien existen errores personalizados para cosas como campos vacios y otros escenarios especificos
    //Todas las clases estaticas de errores heredan a la clase contenedora
}