package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.Producto;
import castellanos.joqsan.sistema_inventarios.orm.ProductoObservacion;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import java.util.ArrayList;
import org.hibernate.query.Query;

//Esta clase sigue el mismo formato y es complementaria a la logica de productos
//Se usa para las operaciones de la las observaciones de los productos
public class LogicaProductosObs {
    
    
    public static LogicaProductosObs crud = null;
    
    public LogicaProductosObs() throws Errores.IniciarEntidadException  {
        
        Utilidades.iniciarEntidad(ProductoObservacion.class);
        pobs = null;
        
    }
    
    public ProductoObservacion getPobs() {
        
        return pobs;
    }

    public void setPobs(ProductoObservacion pobs) {
        
        this.pobs = pobs;
    }
    
    //Este metodo permite insertar una observacion
    public void insertarObservacion() throws Errores.InsertarPobsException  {
        
        try {
            
            ProductoObservacion.limpiar();
            ProductoObservacion.begin();
            ProductoObservacion.session.persist(pobs);
            ProductoObservacion.commit();
            
        } catch(Exception ex) {
            
            ProductoObservacion.rollback();
            throw new Errores.InsertarPobsException("Error de insercion", ex);
        }
    }
    
    //Este metodo permite buscar y cargar una observacion
    public void buscarObservacion(String id_producto) throws Errores.BuscarPobsException {
        
        try {
            
            ProductoObservacion.limpiar();
            String hql = "FROM ProductoObservacion WHERE id_producto = :idProducto";
            Query query = ProductoObservacion.session.createQuery(hql);
            query.setParameter("idProducto", id_producto);
            ArrayList<ProductoObservacion> consulta = new ArrayList<>(query.list());
            
            if(consulta.isEmpty()) {
                
                throw new Exception();
            }
            
            pobs = consulta.get(0);
            
        } catch(Exception ex) {
            
            if(ex.getClass().equals(Exception.class)) {
                
                throw new Errores.BuscarPobsException("Registro no encontrado", ex);
            }
            
            throw new Errores.BuscarPobsException("Error de búsqueda", ex);
        }
    }
    
    //Este metodo permite eliminar una observacion
    public void eliminarObservacion(String id_producto) throws Errores.EliminarPobsException {
        
        try {
            
            ProductoObservacion.begin();
            String hql = "FROM ProductoObservacion WHERE id_producto = :idProducto";
            Query query = ProductoObservacion.session.createQuery(hql);
            query.setParameter("idProducto", id_producto);
            ArrayList<ProductoObservacion> consulta = new ArrayList<>(query.list());
            
            if(consulta.isEmpty()) {
                
                throw new Exception();
            }
            
            pobs = consulta.get(0);
            ProductoObservacion.session.remove(pobs);
            ProductoObservacion.commit();
            
        } catch(Exception ex) {
            
            if(ex.getClass().equals(Exception.class)) {
                
                throw new Errores.EliminarPobsException("Registro no encontrado", ex);
            }
            
            ProductoObservacion.rollback();
            throw new Errores.EliminarPobsException("Error de eliminación", ex);
        }
    }
    
    //Este metodo permite actualizar una observacion
    public void actualizarObservacion(ProductoObservacion pobs) throws Errores.ActualizarPobsException  {
        
        try {
            
            ProductoObservacion.begin();
            
            if(this.pobs != null && !this.pobs.getId_producto().equals(pobs.getId_producto())) {
                  
                String hql = "UPDATE ProductoObservacion pobs SET pobs.id_producto = :idProducto2 WHERE pobs.id_producto = :idProducto1"; 
                Query query = ProductoObservacion.session.createQuery(hql);
                query.setParameter("idProducto2", pobs.getId_producto());
                query.setParameter("idProducto1", this.pobs.getId_producto());
                query.executeUpdate();
                
                hql = "FROM ProductoObservacion pobs WHERE pobs.id_producto = :idProducto";
                query = ProductoObservacion.session.createQuery(hql);
                query.setParameter("idProducto", pobs.getId_producto());
                ArrayList<ProductoObservacion> consulta = new ArrayList<>(query.list());
                this.pobs = consulta.get(0);
                
            } else {
                
                String hql = "FROM ProductoObservacion pobs WHERE pobs.id_producto = :idProducto";
                Query query = ProductoObservacion.session.createQuery(hql);
                query.setParameter("idProducto", pobs.getId_producto());
                ArrayList<ProductoObservacion> consulta = new ArrayList<>(query.list());
                this.pobs = consulta.get(0);
            }
            
            this.pobs.setId_producto(pobs.getId_producto());
            this.pobs.setObservaciones(pobs.getObservaciones());
            ProductoObservacion.commit();
            
        } catch(Exception ex) {
            
            ProductoObservacion.rollback();
            throw new Errores.ActualizarPobsException("Error de actualización", ex);
        }
    }
    
    //El objeto pobs es el campo de clase
    private ProductoObservacion pobs;
}
