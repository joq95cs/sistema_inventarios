
package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.ArchivoExcel;
import castellanos.joqsan.sistema_inventarios.orm.Producto;
import castellanos.joqsan.sistema_inventarios.vista.MarcoFormProductos;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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

public class LogicaProductos {
    
    public static LogicaProductos crud = null;

    public LogicaProductos() throws Errores.ConexionException {
        
        if(Producto.session == null) {
            
            Producto.iniciar();
        }
        
        producto = null;
    }

    public Producto getProducto() {
        
        return producto;
    }

    public void setProducto(Producto producto) {
        
        this.producto = producto;
    }
    
    public void insertarProducto() throws Errores.InsertarProductoException {
        
        try {
        
            Producto.limpiar(); //Se limpia la sesion porque iniciamos desde cero
            Producto.session.beginTransaction();
            Producto.session.persist(producto);
            Producto.commit();
        
        } catch(Exception ex) {
            
            Producto.rollback();
            throw new Errores.InsertarProductoException("Error de inserción");
        } 
    }

    public void buscarProducto(String id) throws Errores.BuscarProductoException {
        
        try {
            
            Producto.limpiar(); //Se limpia la sesion porque iniciamos desde cero
            producto = Producto.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception();
            }
            
        } catch(Exception ex) {
            
            if(ex.getClass().equals(Exception.class)) {
                
                throw new Errores.BuscarProductoException("Registro no encontrado");
            }
            
            throw new Errores.BuscarProductoException("Error de búsqueda");
        }
    }
    
    public void actualizarProducto(Producto producto) throws Errores.ActualizarProductoException {
        
        try {
            
            //No se limpia la sesion porque se pueden usar datos buscados
            Producto.session.beginTransaction();
            
            if(this.producto != null) {
                
                if(!this.producto.getId().equals(producto.getId())) {
                
                    String hql = "UPDATE Producto producto SET producto.id = :id2 WHERE producto.id = :id1"; 
                    Query query = Producto.session.createQuery(hql);
                    query.setParameter("id2", producto.getId());
                    query.setParameter("id1", this.producto.getId());
                    query.executeUpdate();
                    this.producto = Producto.session.get(Producto.class, producto.getId());
                }
 
            } else {
                
                this.producto = Producto.session.get(Producto.class, producto.getId());
            }
            
            this.producto.setNombre(producto.getNombre());
            this.producto.setCategoria(producto.getCategoria());
            this.producto.setStock_min(producto.getStock_min());
            this.producto.setStock_max(producto.getStock_max());
            this.producto.setStock_ideal(producto.getStock_ideal());
            this.producto.setStock_reorden(producto.getStock_reorden());
            this.producto.setStock_max_pedido(producto.getStock_max_pedido());
            Producto.commit();
            
        } catch(Exception ex) {
            
            Producto.rollback();
            throw new Errores.ActualizarProductoException("Error de actualización");
        }
    }
    
    public void eliminarProducto(String id) throws Errores.EliminarProductoException {
        
        try {
            
            //No se limpia la sesion porque se pueden usar datos buscados
            Producto.session.beginTransaction();
            producto = Producto.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception();
            }
            
            Producto.session.remove(producto);
            Producto.commit();
            
        } catch(Exception ex) {
            
            if(ex.getClass().equals(Exception.class)) {
                
                throw new Errores.EliminarProductoException("Registro no encontrado");
            }
            
            Producto.rollback();
            throw new Errores.EliminarProductoException("Error de eliminación");
        }
    }
    
    public void cargarExcel(File excel, int opcion) throws Errores.CargarExcelException {
        
        try {
                       
            FileInputStream stream = new FileInputStream(excel);
            Workbook libro = new XSSFWorkbook(stream);
            Sheet hoja = libro.getSheetAt(0);
            ArrayList<Producto> registros = new ArrayList<>();

            for(int i=1; i<=hoja.getLastRowNum(); i++) {

                Row fila = hoja.getRow(i);

                if(fila != null) {

                    String id = fila.getCell(0).getStringCellValue();
                    String nombre = fila.getCell(1).getStringCellValue();
                    String categoria = fila.getCell(2).getStringCellValue();
                    int stock_min = (int)fila.getCell(3).getNumericCellValue();
                    int stock_max = (int)fila.getCell(4).getNumericCellValue();
                    int stock_ideal = (int)fila.getCell(5).getNumericCellValue();
                    int stock_reorden = (int)fila.getCell(6).getNumericCellValue();
                    int stock_max_pedido = (int)fila.getCell(7).getNumericCellValue();

                    registros.add(new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido));
                }
            }
            
            Producto.limpiar();
            Producto.session.beginTransaction();
            
            if(opcion == 0) {
                
                String hql = "DELETE FROM Producto";
                Producto.session.createQuery(hql).executeUpdate();
            }

            for(Producto each : registros) {
                
                Producto.session.persist(each);
            }
            
            Producto.commit();
            libro.close();
            stream.close();
            
        } catch(Exception ex) {
            
            Producto.rollback();
            throw new Errores.CargarExcelException("Error de carga de Excel");
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
            
            for(int i=0; i<campos.length; i++) {
                
                hoja.getRow(0).createCell(i);
                hoja.getRow(0).getCell(i).setCellValue(campos[i]);
                hoja.getRow(0).getCell(i).setCellStyle(e1); //Se fija el primer estilo
            }
            
            //Se consulta la base de datos para escribir los registros
            String hql = "FROM Producto";
            ArrayList<Producto> consulta = new ArrayList<>(Producto.session.createQuery(hql).list());
            
            int x = 1; //Empieza por 1 porque 0 es la fila de encabezados
            
            for(Producto each: consulta) { //Por cada registro se crea una fila
                
                Row fila = hoja.createRow(x);
                
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
            
            for(int i=1; i<=consulta.size(); i++) {
                
                Row fila = hoja.getRow(i);
                
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
                
                hoja.setColumnWidth(i, 20*256);
            }
            
            FileOutputStream stream = new FileOutputStream(excel);
            libro.write(stream);
            libro.close();
            stream.close();
            
            if(excel.exists()) {
                
                ArchivoExcel.iniciar();
                ArchivoExcel.session.beginTransaction();
                
                hql = "DELETE FROM ArchivoExcel excel WHERE excel.nombre = :nombre";
                Query query = ArchivoExcel.session.createQuery(hql);
                query.setParameter("nombre", excel.getName());
                query.executeUpdate();
                
                ArchivoExcel.session.persist(new ArchivoExcel(excel.getName(), tabla));
                ArchivoExcel.commit();
                ArchivoExcel.cerrar();
                
                Desktop.getDesktop().open(excel);
            }
                     
        } catch(Exception ex) { //Se queda la clase base para manejar todo tipo de errores            
            
            ArchivoExcel.rollback();
            throw new Errores.ExportarExcelException("Error de exportación de Excel");
        }
    }
    
    public void cargarArchivosExcel(DefaultTableModel modelo) throws Errores.CargarArchivosExcelException {
        
        try {
            
            ArchivoExcel.iniciar(); //Se debe conectar la entidad, no es necesario limpiar porque se esta iniciando
            
            //Se hace la consulta a la tabla y se guardan los resultados en el array
            String hql = "FROM ArchivoExcel";
            ArrayList<ArchivoExcel> archivos = new ArrayList<>(ArchivoExcel.session.createQuery(hql).list()); 
            
            for(ArchivoExcel each: archivos) {
                
                Object[] fila = {
                
                    each.getNombre(),
                    each.getTabla(),
                    each.getFecha_hora()
                };
                
                modelo.addRow(fila);
            }
            
        } catch(Exception ex) {
            
            throw new Errores.CargarArchivosExcelException("Error de carga de archivos Excel");
        }
    }
    
    public void cargarLista(DefaultTableModel modelo) throws Errores.CargarListaException {
        
        try {
            
            Producto.limpiar();
            String hql = "FROM Producto";
            ArrayList<Producto> productos = new ArrayList<>(Producto.session.createQuery(hql).list());
            
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
            
            throw new Errores.CargarListaException("Error de carga de lista");
        }
    }
    
    public void cargarProducto(String id) throws Errores.CargarProductoException {
        
        try {
            
            producto = Producto.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception();
            }
            
            MarcoFormProductos.m = new MarcoFormProductos(true);
            Utilidades.ejecutarMarco(MarcoFormProductos.m);
            
        } catch(Exception ex) {
            
            if(ex.getClass().equals(Exception.class)) {
                
                throw new Errores.CargarProductoException("Registro no encontrado"); 
            }
            
            throw new Errores.CargarProductoException("Error de carga de producto");
        }
    }
    
    public void eliminarExcel(File excel) throws Errores.EliminarExcelException {
        
        try {
            
            //Primero se elimina el archivo 
            excel.delete();
            
            //Despues se elimina el registro de la tabla
            ArchivoExcel.iniciar();
            ArchivoExcel.session.beginTransaction();
            String hql = "DELETE FROM ArchivoExcel excel WHERE excel.nombre = :nombre";
            Query query = ArchivoExcel.session.createQuery(hql);
            query.setParameter("nombre", excel.getName());
            query.executeUpdate();
            ArchivoExcel.commit();
            ArchivoExcel.cerrar();
            
        } catch(Exception ex) {
            
            ArchivoExcel.rollback();
            throw new Errores.EliminarExcelException("Error de eliminación de Excel");
        }
    }
    
    public void agregarExcel(Path origen, Path destino, String tabla) throws Errores.AgregarExcelException {
        
        try {
            
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            
            ArchivoExcel.iniciar();
            ArchivoExcel.session.beginTransaction();
            ArchivoExcel.session.persist(new ArchivoExcel(
            
                new File(destino.toString()).getName(),
                tabla
            ));
            
            ArchivoExcel.commit();
            ArchivoExcel.cerrar();
            
        } catch(Exception ex) {
            
            throw new Errores.AgregarExcelException("Error de copiado de Excel");
        }
    }
    
    private Producto producto;
}