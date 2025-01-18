
package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.ArchivoExcel;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.hibernate.query.Query;

//Corresponde a la entidad de ArchivoExcel
public class LogicaArchivosExcel {
    
    public static LogicaArchivosExcel crud = null;
    
    public LogicaArchivosExcel() throws Errores.IniciarEntidadException {
        
        Utilidades.iniciarEntidad(ArchivoExcel.class);
        excel = null;
    }

    public ArchivoExcel getExcel() {
        
        return excel;
    }

    public void setExcel(ArchivoExcel excel) {
        
        this.excel = excel;
    }
    
    public void insertarArchivoExcel() throws Errores.InsertarArchivoExcelException {
        
        try {
            
            //Este metodo inserta y reemplaza cualquier registro previo que use el mismo nombre
            ArchivoExcel.limpiar();
            ArchivoExcel.begin();
            String hql = "DELETE FROM ArchivoExcel excel WHERE nombre = :nombre";
            Query query = ArchivoExcel.session.createQuery(hql);
            query.setParameter("nombre", excel.getNombre());
            query.executeUpdate();
            ArchivoExcel.session.persist(excel);
            ArchivoExcel.commit(); //Se confirman los cambios
            
        } catch(Exception ex) {
            
            ArchivoExcel.rollback(); //Se hace rollback si sucede un error
            throw new Errores.InsertarArchivoExcelException("Error de inserción", ex);
        }
    }
    
    public void abrirArchivoExcel(String nombre, String tabla) throws Errores.AbrirArchivoExcelException {
        
        try {
            
            //Se abre el archivo especificado
            File archivo = new File("storage/excel/" + tabla.toLowerCase() + "/" + nombre);
            Desktop.getDesktop().open(archivo);
        
        } catch(Exception ex) {
            
            throw new Errores.AbrirArchivoExcelException("Error de apertura de archivo", ex);
        }
    } 
    
    public void eliminarExcel(File archivo) throws Errores.EliminarExcelException {
        
        try {
            
            //Primero se elimina el archivo 
            archivo.delete();
            
            //Despues se elimina el registro de la tabla
            ArchivoExcel.limpiar();
            ArchivoExcel.begin();
            String hql = "DELETE FROM ArchivoExcel excel WHERE excel.nombre = :nombre";
            Query query = ArchivoExcel.session.createQuery(hql);
            query.setParameter("nombre", archivo.getName());
            query.executeUpdate();
            ArchivoExcel.commit(); //Se confirman los cambios
            
        } catch(Exception ex) {
            
            ArchivoExcel.rollback(); //Se hace rollback si sucede un error
            throw new Errores.EliminarExcelException("Error de eliminación de Excel", ex);
        }
    }
    
    public void cargarArchivosExcel(DefaultTableModel modelo) throws Errores.CargarArchivosExcelException {
        
        try {
            
            //Se hace la consulta a la tabla y se guardan los resultados en el array
            String hql = "FROM ArchivoExcel";
            ArrayList<ArchivoExcel> archivos = new ArrayList<>(ArchivoExcel.session.createQuery(hql).list()); 
            
            //Se recorre el array y se agregan los archivos al modelo de la tabla
            for(ArchivoExcel each: archivos) {
                
                Object[] fila = {
                
                    each.getNombre(),
                    each.getTabla(),
                    each.getFecha_hora()
                };
                
                modelo.addRow(fila);
            }
            
        } catch(Exception ex) {
            
            throw new Errores.CargarArchivosExcelException("Error de carga de archivos Excel", ex);
        }
    }
    
    private ArchivoExcel excel; //Campo de clase
    
    //Esta clase contiene una clase estatica que permite copiar mas facilmente los archivos
    public static class Copiador {
    
        public Copiador() {
            
            //El constructor fija las rutas en null e incia el chooser
            rutaOrigen = null;
            rutaDestino = null;
            chooser = new JFileChooser();
        }

        //Este metodo permite elegir una ruta de origen usando un chooser
        //Tambien se puede fijar el origen por medio del setter
        public boolean elegirOrigen(String formato, Component parent) throws Errores.CopiadorException {

            //Si el metodo termina correctamente regresara un true
            //Si sucede un error regresara un false
            boolean correcto = false;

            try {

                //Si el usuario eligio un archivo
                if(chooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {

                    //Se guarda la ruta en la variable
                    String ruta = chooser.getSelectedFile().getAbsolutePath();

                    //Se revisa que el formato corresponda con el indicado al llamar el metodo
                    int index = new File(ruta).getName().lastIndexOf(".");

                    if(index > 0) {

                        String ext = new File(ruta).getName().substring(index + 1);

                        if(ext.equals(formato)) {

                            //Si todo sale bien se fija la ruta y se indica que un true
                            rutaOrigen = ruta;
                            correcto = true;
                        } 
                    }

                } else {

                    return true; //En caso de que el usuario cancele el chooser tambien regresa true
                    //Para verificar que el archivo haya sido elegido y que la ruta haya sido fijada se puede usar el getter
                }

            } catch(Exception ex) {

                throw new Errores.CopiadorException("Error al elegir origen", ex);
            }

            return correcto; //Se regresa el estado guardado previamente
        }

        //Este metodo permite elegir el destino para el archivo copiado
        public boolean elegirDestino(String carpetaDestino, String nombreDestino) throws Errores.CopiadorException {

            boolean correcto = false;

            try {

                //Se guarda la carpeta de destino
                File carpeta = new File("storage/" + carpetaDestino);

                //Si la carpeta de destino no existe se crea
                if(!carpeta.exists()) {

                    carpeta.mkdirs();
                }

                //Se guarda la ruta de destino
                rutaDestino = "storage/" + carpetaDestino + "/" + nombreDestino;
                correcto = true; //Si todo salio bien se regresa un true

            } catch(Exception ex) {

                throw new Errores.CopiadorException("Error al elegir origen", ex);
            }

            return correcto;
        }

        //Este metodo permite hacer el copiado del archivo desde el origen hacia el destino
        public boolean copiar() throws Errores.CopiadorException {

            boolean correcto = false;

            try {

                //Se fijan los paths de origen y de destino
                Path origen = Paths.get(rutaOrigen);
                Path destino = Paths.get(rutaDestino);

                //Se llama al metodo para copiar y se indica que se debe reemplazar si tiene el mismo nombre
                Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                correcto = true; //Si todo salio bien se regresa true

            } catch(Exception ex) {

                throw new Errores.CopiadorException("Error al elegir origen", ex);
            }

            return correcto;
        }

        //Tambien se pueden usar los setters para fijar el origen y destino
        //Se pueden usar los getters para comprobar que hayan sido fijados
        public String getRutaOrigen() {

            return rutaOrigen;
        }

        public void setRutaOrigen(String rutaOrigen) {

            this.rutaOrigen = rutaOrigen;
        }

        public String getRutaDestino() {

            return rutaDestino;
        }

        public void setRutaDestino(String rutaDestino) {

            this.rutaDestino = rutaDestino;
        }

        @Override
        public String toString() {

            return "Copiador{" + "rutaOrigen=" + rutaOrigen + ", rutaDestino=" + rutaDestino + ", chooser=" + chooser + '}';
        }

        private String rutaOrigen;
        private String rutaDestino;
        private final JFileChooser chooser;
    }
}
