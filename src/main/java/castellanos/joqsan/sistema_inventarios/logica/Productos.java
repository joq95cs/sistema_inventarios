
package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.Producto;
import castellanos.joqsan.sistema_inventarios.vista.MarcoFormProductos;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.query.Query;

public class Productos {
    
    public static Productos crud = null;

    public Productos() throws Errores.ConexionException {
        
        if(Hibernate.type == null || !Hibernate.type.equals(Producto.class)) {
            
            Hibernate.iniciar(Producto.class);
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
        
            Hibernate.session.beginTransaction();
            Hibernate.session.persist(producto);
            Hibernate.session.getTransaction().commit();
        
        } catch(Exception ex) {
            
            if(Hibernate.session.getTransaction() != null) {
                
                Hibernate.session.getTransaction().rollback();
            }
            
            throw new Errores.InsercionException();
        } 
    }

    public void buscarProducto(String id) throws Errores.BusquedaException {
        
        try {
            
            producto = Hibernate.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception("Registro no encontrado");
            }
            
        } catch(Exception ex) {
            
            throw new Errores.BusquedaException(ex.getMessage());
        }
    }
    
    public void actualizarProducto(Producto producto) throws Errores.ActualizacionException {
        
        try {
            
            Hibernate.session.beginTransaction();
            
            if(this.producto != null) {
                
                if(!this.producto.getId().equals(producto.getId())) {
                
                    String hql = "UPDATE Producto p1 SET p1.id = :id2 WHERE p1.id = :id1"; 
                    Query query = Hibernate.session.createQuery(hql);
                    query.setParameter("id2", producto.getId());
                    query.setParameter("id1", this.producto.getId());
                    query.executeUpdate();
                    
                    this.producto = Hibernate.session.get(Producto.class, producto.getId());
                    
                }
 
            } else {
                
                this.producto = Hibernate.session.get(Producto.class, producto.getId());
            }
            
            this.producto.setNombre(producto.getNombre());
            this.producto.setCategoria(producto.getCategoria());
            this.producto.setStock_min(producto.getStock_min());
            this.producto.setStock_max(producto.getStock_max());
            this.producto.setStock_ideal(producto.getStock_ideal());
            this.producto.setStock_reorden(producto.getStock_reorden());
            this.producto.setStock_max_pedido(producto.getStock_max_pedido());

            Hibernate.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            if(Hibernate.session.getTransaction() != null) {
                
                Hibernate.session.getTransaction().rollback();
            }
            
            throw new Errores.ActualizacionException();
        }
    }
    
    public void eliminarProducto(String id) throws Errores.EliminacionException {
        
        try {
            
            Hibernate.session.beginTransaction();
            producto = Hibernate.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception("Registro no encontrado");
            }
            
            Hibernate.session.remove(producto);
            Hibernate.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            if(Hibernate.session.getTransaction() != null) {
                
                Hibernate.session.getTransaction().rollback();
            }
            
            throw new Errores.EliminacionException(ex.getMessage());
        }
    }
    
    public void cargarExcel(String ruta) throws Errores.ExcelException {
        
        try {
            
            Workbook workbook = new XSSFWorkbook(new FileInputStream(ruta));
            Sheet sheet = workbook.getSheetAt(0);
            ArrayList<Producto> registros = new ArrayList<>();

            for(int i=1; i<=sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                if(row != null) {

                    String id = row.getCell(0).getStringCellValue();
                    String nombre = row.getCell(1).getStringCellValue();
                    String categoria = row.getCell(2).getStringCellValue();
                    int stock_min = (int)row.getCell(3).getNumericCellValue();
                    int stock_max = (int)row.getCell(4).getNumericCellValue();
                    int stock_ideal = (int)row.getCell(5).getNumericCellValue();
                    int stock_reorden = (int)row.getCell(6).getNumericCellValue();
                    int stock_max_pedido = (int)row.getCell(7).getNumericCellValue();

                    registros.add(new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido));
                }
            }
            
            Hibernate.session.beginTransaction();

            for(Producto each : registros) {
                
                Hibernate.session.persist(each);
            }
            
            Hibernate.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            if(Hibernate.session.getTransaction() != null) {
                
                Hibernate.session.getTransaction().rollback();
            }
            
            throw new Errores.ExcelException();
        }
    }
    
    public void cargarLista(DefaultTableModel modelo) {
        
        try {
            
            String hql = "FROM Producto";
            ArrayList<Producto> productos = new ArrayList<>(Hibernate.session.createQuery(hql).list());
            
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
            
        } catch(Exception ex) {}
    }
    
    public void cargarProducto(String id) {
        
        try {
            
            producto = Hibernate.session.get(Producto.class, id);
            
            if(producto == null) {
                
                throw new Exception("Registro no encontrado");
            }
            
            MarcoFormProductos.m = new MarcoFormProductos(true);
            Utilidades.ejecutarMarco(MarcoFormProductos.m);
            
        } catch(Exception ex) {
            
            
        }
    }
    
    private Producto producto;
}