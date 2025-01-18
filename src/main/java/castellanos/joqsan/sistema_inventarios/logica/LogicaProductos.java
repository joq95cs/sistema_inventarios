
package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.ArchivoExcel;
import castellanos.joqsan.sistema_inventarios.orm.Producto;
import castellanos.joqsan.sistema_inventarios.vista.MarcoFormProductos;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.query.Query;

//Esta clase contiene la logica que se utiliza en el formulario de productos y otras ventanas que manipuen los productos
public class LogicaProductos {
    
    //Al igual que los marcos, las logicas tienen campos estaticos para manipular sus metodos
    public static LogicaProductos crud = null;

    //El constructor hace la conexion a la base de datos de la entidad de productos
    public LogicaProductos() throws Errores.IniciarEntidadException  {
        
        Utilidades.iniciarEntidad(Producto.class); //Se inicia la entidad Producto
        producto = null; //Se fija en null el producto
    }

    //Se usa getter y setter para manipular el campo de clase desde fuera
    public Producto getProducto() {
        
        return producto;
    }

    public void setProducto(Producto producto) {
        
        this.producto = producto;
    }
    
    //Todos los metodos de esta clase tienen errores personalizados asociados
    //Cada metodo tiene un try catch que pemrite capturar errores y despues lanzar una excepcion propia del metodo
    //En todos los metodos que usan una transaccion se llama al rollback en el catch
    public void insertarProducto() throws Errores.InsertarProductoException {
        
        try {
        
            Producto.limpiar(); //Se limpia la sesion porque iniciamos desde cero
            Producto.begin(); //Se inicia la transaccion porque la operacion modifica la tabla
            Producto.session.persist(producto); //Se guarda el producto ya fijado en el campo
            Producto.commit(); //Se confirman los cambios
        
        } catch(Exception ex) {
            
            Producto.rollback();
            throw new Errores.InsertarProductoException("Error de inserción", ex); //Error personalizado
        } 
    }

    public void buscarProducto(String id) throws Errores.BuscarProductoException {
        
        try {
            
            Producto.limpiar(); //Se limpia la sesion porque iniciamos desde cero
            producto = Producto.session.get(Producto.class, id); //Se obtiene el producto por medio del id recibido y se fija en el campo de clase
            
            if(producto == null) { //Si el id no existe en la tabla, el producto se quedara en null
                
                throw new Exception(); //Se lanza una excepcion sencilla
            }
            
        } catch(Exception ex) {
            
            if(ex.getClass().equals(Exception.class)) { //Si se detecta la excepcion sencilla
                
                throw new Errores.BuscarProductoException("Registro no encontrado", ex); //Se indica que el registro no fue encontrado
            }
            
            throw new Errores.BuscarProductoException("Error de búsqueda", ex); //Error personalizado
        }
    }
    
    public void actualizarProducto(Producto producto) throws Errores.ActualizarProductoException {
        
        try {
            
            //No se limpia la sesion porque se pueden usar datos buscados
            Producto.begin();
            
            //En caso de que se haya llamado el metodo de buscar antes, el producto existe
            if(this.producto != null) { //
                
                //Esto permite modificar tambie el id
                if(!this.producto.getId().equals(producto.getId())) {
                
                    //Se usa una query para actualizar
                    String hql = "UPDATE Producto producto SET producto.id = :id2 WHERE producto.id = :id1"; 
                    Query query = Producto.session.createQuery(hql);
                    query.setParameter("id2", producto.getId());
                    query.setParameter("id1", this.producto.getId());
                    query.executeUpdate();
                    this.producto = Producto.session.get(Producto.class, producto.getId());
                }
 
            } else { //Si no se llamo al metodo de buscar antes, simplemente se usa el id ingresado para buscarlo
                
                //De esta manera no se puede actualizar el id, solo lo demas
                this.producto = Producto.session.get(Producto.class, producto.getId());
            }
            
            //Se hace la actualizacion del registro
            this.producto.setNombre(producto.getNombre());
            this.producto.setCategoria(producto.getCategoria());
            this.producto.setStock_min(producto.getStock_min());
            this.producto.setStock_max(producto.getStock_max());
            this.producto.setStock_ideal(producto.getStock_ideal());
            this.producto.setStock_reorden(producto.getStock_reorden());
            this.producto.setStock_max_pedido(producto.getStock_max_pedido());
            Producto.commit(); //Se confirman los cambios
            
        } catch(Exception ex) {
            
            Producto.rollback(); //Se deshacen los cambios si sucede un error
            throw new Errores.ActualizarProductoException("Error de actualización", ex);
        }
    }
    
    public void eliminarProducto(String id) throws Errores.EliminarProductoException {
        
        try {
            
            //No se limpia la sesion porque se pueden registros buscados previamente
            Producto.begin();
            producto = Producto.session.get(Producto.class, id); //Se guarda la el registro en base a su id
            
            if(producto == null) {
                
                throw new Exception(); //Significa que no se encontro un registro con ese id
            }
            
            Producto.session.remove(producto); //Se elimina el registro
            Producto.commit(); //Se confirman los cambios
            
        } catch(Exception ex) {
            
            if(ex.getClass().equals(Exception.class)) {
                
                throw new Errores.EliminarProductoException("Registro no encontrado", ex); //Se indica que el registro no existe
            }
            
            Producto.rollback();
            throw new Errores.EliminarProductoException("Error de eliminación", ex);
        }
    }
    
    public void cargarExcel(File excel, int opcion) throws Errores.CargarExcelException {
        
        try {
              
            //Se lee el archivo excel y se cargan los registros que contiene
            //El archivo debe tener la estructura correcta para que funcione
            //Si el archivo no tiene la estructura correcta se lanzara un error
            FileInputStream stream = new FileInputStream(excel); //Se crea un stream
            Workbook libro = new XSSFWorkbook(stream); //Se crea un libro
            Sheet hoja = libro.getSheetAt(0); //Se utilizara solamente la primera hoja del archivo
            ArrayList<Producto> registros = new ArrayList<>(); //Los registros se guardaran primero en un array

            //Se usa un ciclo que recorre todas las filas de la hoja
            for(int i=1; i<=hoja.getLastRowNum(); i++) {

                Row fila = hoja.getRow(i); //Se guarda la hoja en cada vuelta de ciclo

                if(fila != null) { //Se verifica que la fila exista

                    //Se capturan los datos de las celdas
                    String id = fila.getCell(0).getStringCellValue();
                    String nombre = fila.getCell(1).getStringCellValue();
                    String categoria = fila.getCell(2).getStringCellValue();
                    int stock_min = (int)fila.getCell(3).getNumericCellValue();
                    int stock_max = (int)fila.getCell(4).getNumericCellValue();
                    int stock_ideal = (int)fila.getCell(5).getNumericCellValue();
                    int stock_reorden = (int)fila.getCell(6).getNumericCellValue();
                    int stock_max_pedido = (int)fila.getCell(7).getNumericCellValue();

                    //Se guarda el registro en el array
                    registros.add(new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido));
                }
            }
            
            Producto.limpiar(); //Se limpia la sesion
            Producto.begin(); //Se inicia la transaccion
            
            //Si se eligio que el archivo reemplace la tabla
            if(opcion == 0) {
                
                String hql = "DELETE FROM Producto";
                Producto.session.createQuery(hql).executeUpdate(); //Se usa una query para eliminar todo primero
            }

            //Se guarda cada registro del array en la tabla
            for(Producto each : registros) {
                
                Producto.session.persist(each);
            }
            
            Producto.commit(); //Se confirman los cambios
            libro.close(); //Se cierra el libro
            stream.close(); //Se cierra el stream
            
        } catch(Exception ex) {
            
            Producto.rollback();
            throw new Errores.CargarExcelException("Error de carga de Excel", ex);
        }
    }
    
    public void exportarExcel(File excel, String tabla) throws Errores.ExportarExcelException {
        
        try {
            
            //Se definen los encabezados de las columnas
            Workbook libro = new XSSFWorkbook();
            Sheet hoja = libro.createSheet("Productos");
            String[] campos = {"ID (Clave)", "Nombre", "Categoría", "Stock Mínimo", "Stock Máximo", "Stock Ideal", "Stock Reorden", "Stock Máximo Pedido"};
            hoja.createRow(0); //Fila de encabezados
            
            //Estilo y fuente para encabezados
            CellStyle e1 = libro.createCellStyle();
            e1.setAlignment(HorizontalAlignment.CENTER);
            Font f1 = libro.createFont();
            f1.setFontName("Arial");
            f1.setFontHeightInPoints(Short.parseShort("10"));
            f1.setBold(true);
            e1.setFont(f1);
            
            //Con un bucle se fija el estilo a usar en los encabezados
            for(int i=0; i<campos.length; i++) {
                
                hoja.getRow(0).createCell(i);
                hoja.getRow(0).getCell(i).setCellValue(campos[i]);
                hoja.getRow(0).getCell(i).setCellStyle(e1); //Se fija el primer estilo
            }
            
            //Se consulta la base de datos para escribir los registros
            Producto.limpiar();
            String hql = "FROM Producto";
            ArrayList<Producto> consulta = new ArrayList<>(Producto.session.createQuery(hql).list()); //Se guardan los registros de la tabla en un array
            
            int x = 1; //Empieza por 1 porque 0 es la fila de encabezados
            
            for(Producto each: consulta) { //Por cada registro se crea una fila
                
                Row fila = hoja.createRow(x); //Se guarda la fila en cada vuelta de bucle
                
                //Se fijan los registros en cada fila
                fila.createCell(0).setCellValue(each.getId());
                fila.createCell(1).setCellValue(each.getNombre());
                fila.createCell(2).setCellValue(each.getCategoria());
                fila.createCell(3).setCellValue(each.getStock_min());
                fila.createCell(4).setCellValue(each.getStock_max());
                fila.createCell(5).setCellValue(each.getStock_ideal());
                fila.createCell(6).setCellValue(each.getStock_reorden());
                fila.createCell(7).setCellValue(each.getStock_max_pedido());
                
                x++; //Se aumenta el contador despues de agregar cada registro
            }
            
            //Estilo y fuente para registros
            CellStyle e2 = libro.createCellStyle();
            e2.setAlignment(HorizontalAlignment.CENTER);
            Font f2 = libro.createFont();
            f2.setFontName("Arial");
            f2.setFontHeightInPoints(Short.parseShort("10"));
            f2.setBold(false);
            e2.setFont(f2);
            
            //Se fijan con un bucle los estilos para los registros
            for(int i=1; i<=consulta.size(); i++) {
                
                Row fila = hoja.getRow(i); //Se guarda la fila en cada vuelta de ciclo
                
                //Se requieren bucles anidados para fijar en filas y celdas
                for(int j=0; j<=7; j++) {
                    
                    fila.getCell(j).setCellStyle(e2);
                }
            }
            
            //Fijar el tamagno de las columnas
            for(int i=0; i<campos.length; i++) {
                
                /*if(campos[i].equals("Nombre")) {
                    
                    hoja.autoSizeColumn(i);
                    
                } else {
                    
                   hoja.setColumnWidth(i, 20*256); //Para 20 caracteres 
                }*/
                
                hoja.setColumnWidth(i, 20*256); //Para 20 caracteres
            }
            
            //Se escribe el archivo usando el stream
            FileOutputStream stream = new FileOutputStream(excel);
            libro.write(stream);
            libro.close();
            stream.close();
            
            //Si el archivo fue creado correctamente
            if(excel.exists()) {
                
                //Ahora se llama a la logica de ArchivosExcel para agregar el registro a la tabla
                LogicaArchivosExcel.crud.setExcel(new ArchivoExcel(excel.getName(), tabla));
                LogicaArchivosExcel.crud.insertarArchivoExcel();
                Desktop.getDesktop().open(excel);
            }
                     
        } catch(Exception ex) { //Se queda la clase base para manejar todo tipo de errores            
            
            throw new Errores.ExportarExcelException("Error de exportación de Excel", ex);
        }
    }
    
    public void cargarListaProductos(DefaultTableModel modelo) throws Errores.CargarListaProductosException {
        
        try {
            
            //Se cargan todos los registros en un array
            Producto.limpiar();
            String hql = "FROM Producto";
            ArrayList<Producto> productos = new ArrayList<>(Producto.session.createQuery(hql).list());
            
            //Se lee el array y se agregan al modelo de la tabla
            for(Producto each: productos) {
                
                Object[] fila = {
                    
                    each.getId(),
                    each.getNombre(),
                    each.getCategoria(), 
                    each.getStock_min() + "",
                    each.getStock_max() + "",
                    each.getStock_ideal() + "",
                    each.getStock_reorden() + "",
                    each.getStock_max_pedido() + ""
                };
                
                modelo.addRow(fila);
            }
            
        } catch(Exception ex) {
            
            throw new Errores.CargarListaProductosException("Error de carga de lista", ex);
        }
    }
    
    public void cargarProducto(String id) throws Errores.CargarProductoException {
        
        try {
            
            //Se obtiene el objeto en base al id
            Producto.limpiar();
            producto = Producto.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception(); //Se lanza un error si no existe el registro
            }
            
            MarcoFormProductos.m = new MarcoFormProductos(true);
            Utilidades.ejecutarMarco(MarcoFormProductos.m);
            
        } catch(Exception ex) {
            
            if(ex.getClass().equals(Exception.class)) {
                
                throw new Errores.CargarProductoException("Registro no encontrado", ex); //Se indica que el registro no existe
            }
            
            throw new Errores.CargarProductoException("Error de carga de producto", ex);
        }
    }
    
    private Producto producto; //Campo de clase
    
    //La clase LogicaProductos contiene la logica relacionada a la entidad Producto
    //Cada entidad tiene su propia clase de logica
    //El campo de clase privado se usa como almacenamiento de las instancias usadas por la logica
    //Por ejemplo, para insertar un producto, primero se debe guardar un objeto de tipo Producto con setProducto
    //Una vez que el producto ya esta fijado, se puede llamar al metodo de que lo utilice
    //Todos los try catch usan la clase base para capturar cualquier error que suceda
}