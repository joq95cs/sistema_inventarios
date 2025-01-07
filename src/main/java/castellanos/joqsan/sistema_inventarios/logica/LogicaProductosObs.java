package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.ProductoObservacion;
import java.util.ArrayList;
import org.hibernate.query.Query;

public class LogicaProductosObs {
    
    public static LogicaProductosObs crud = null;
    
    public LogicaProductosObs() throws Errores.ConexionException {
        
        if(ProductoObservacion.session == null) {
            
            ProductoObservacion.iniciar();
        }
        
        pobs = null;
        
    }
    
    public ProductoObservacion getPobs() {
        
        return pobs;
    }

    public void setPobs(ProductoObservacion pobs) {
        
        this.pobs = pobs;
    }
    
    public void insertarObservacion() throws Errores.InsertarPobsException  {
        
        try {
            
            ProductoObservacion.limpiar();
            ProductoObservacion.session.beginTransaction();
            ProductoObservacion.session.persist(pobs);
            ProductoObservacion.commit();
            
        } catch(Exception ex) {
            
            ProductoObservacion.rollback();
            throw new Errores.InsertarPobsException("Error de insercion");
        }
    }
    
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
                
                throw new Errores.BuscarPobsException("Registro no encontrado");
            }
            
            throw new Errores.BuscarPobsException("Error de búsqueda");
        }
    }
    
    public void eliminarObservacion(String id_producto) throws Errores.EliminarPobsException {
        
        try {
            
            ProductoObservacion.session.beginTransaction();
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
                
                throw new Errores.EliminarPobsException("Registro no encontrado");
            }
            
            ProductoObservacion.rollback();
            throw new Errores.EliminarPobsException("Error de eliminación");
        }
    }
    
    public void actualizarObservacion(ProductoObservacion pobs) throws Errores.ActualizarPobsException  {
        
        try {
            
            ProductoObservacion.session.beginTransaction();
            
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
            throw new Errores.ActualizarPobsException("Error de actualización");
        }
    }
    
    private ProductoObservacion pobs;
}
