
package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.Producto;
import castellanos.joqsan.sistema_inventarios.vista.MarcoFormProductos;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    
    public void insertarProducto() throws Errores.InsercionException {
        
        try {
        
            Producto.session.clear();
            Producto.session.beginTransaction();
            Producto.session.persist(producto);
            Producto.session.getTransaction().commit();
        
        } catch(Exception ex) {
            
            if(Producto.session.getTransaction() != null) {
                
                Producto.session.getTransaction().rollback();
            }
            
            throw new Errores.InsercionException();
        } 
    }

    public void buscarProducto(String id) throws Errores.BusquedaException {
        
        try {
            
            Producto.session.clear();
            producto = Producto.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception("Registro no encontrado");
            }
            
        } catch(Exception ex) {
            
            throw new Errores.BusquedaException(ex.getMessage());
        }
    }
    
    public void actualizarProducto(Producto producto) throws Errores.ActualizacionException {
        
        try {
            
            //Producto.session.clear();
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
            Producto.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            if(Producto.session.getTransaction() != null) {
                
                Producto.session.getTransaction().rollback();
            }
            
            throw new Errores.ActualizacionException();
        }
    }
    
    public void eliminarProducto(String id) throws Errores.EliminacionException {
        
        try {
            
            //Producto.session.clear();
            Producto.session.beginTransaction();
            producto = Producto.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception("Registro no encontrado");
            }
            
            Producto.session.remove(producto);
            Producto.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            if(Producto.session.getTransaction() != null) {
                
                Producto.session.getTransaction().rollback();
            }
            
            throw new Errores.EliminacionException(ex.getMessage());
        }
    }
    
    public void cargarExcel(File excel, int opcion) throws Errores.ExcelException {
        
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
            
            Producto.session.clear();
            Producto.session.beginTransaction();
            
            if(opcion == 0) {
                
                String hql = "DELETE FROM Producto";
                Producto.session.createQuery(hql).executeUpdate();
            }

            for(Producto each : registros) {
                
                Producto.session.persist(each);
            }
            
            Producto.session.getTransaction().commit();
            libro.close();
            stream.close();
            
        } catch(Exception ex) {
            
            if(Producto.session.getTransaction() != null) {
                
                Producto.session.getTransaction().rollback();
            }
            
            ex.printStackTrace();
            throw new Errores.ExcelException();
        }
    }
    
    public void editarExcel(File excel) throws Errores.ExcelException {
        
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
                
                if(campos[i].equals("Nombre")) {
                    
                    hoja.autoSizeColumn(i);
                    break;
                }
                
                hoja.setColumnWidth(i, 20*256); //Para 20 caracteres
            }
            
            FileOutputStream stream = new FileOutputStream(excel);
            libro.write(stream);
            libro.close();
            stream.close();
            
            if(excel.exists()) {
                
                Desktop.getDesktop().open(excel);
            }
                     
        } catch(Exception ex) { //Se queda la clase base para manejar todo tipo de errores
            
            if(Producto.session.getTransaction() != null) {
                
                Producto.session.getTransaction().rollback();
            }
            
            if(ex.getClass().equals(FileNotFoundException.class)) {
                
                throw new Errores.ExcelException("Archivo abierto");
            }
            
            throw new Errores.ExcelException();
        }
    }
    
    public void cargarLista(DefaultTableModel modelo) throws Errores.ListaException {
        
        try {
            
            Producto.session.clear();
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
            
            throw new Errores.ListaException();
        }
    }
    
    public void cargarProducto(String id) throws Errores.CargarException {
        
        try {
            
            producto = Producto.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception("Registro no encontrado");
            }
            
            MarcoFormProductos.m = new MarcoFormProductos(true);
            Utilidades.ejecutarMarco(MarcoFormProductos.m);
            
        } catch(Exception ex) {
            
            throw new Errores.CargarException();
        }
    }
    
    private Producto producto;
}