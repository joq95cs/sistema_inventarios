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
    
    public void insertarObservacion() throws Errores.InsercionException {
        
        try {
            
            ProductoObservacion.session.beginTransaction();
            ProductoObservacion.session.persist(pobs);
            ProductoObservacion.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            if(ProductoObservacion.session.getTransaction() != null) {
                
                ProductoObservacion.session.getTransaction().rollback();
            }
            
            throw new Errores.InsercionException();
        }
    }
    
    public void buscarObservacion(String id_producto) throws Errores.BusquedaException {
        
        try {
            
            String hql = "FROM ProductoObservacion WHERE id_producto = :idProducto";
            Query query = ProductoObservacion.session.createQuery(hql);
            query.setParameter("idProducto", id_producto);
            ArrayList<ProductoObservacion> consulta = new ArrayList<>(query.list());
            
            if(consulta.isEmpty()) {
                
                throw new Exception("Registro no encontrado");
            }
            
            pobs = consulta.get(0);
            
        } catch(Exception ex) {
            
            throw new Errores.BusquedaException(ex.getMessage());
        }
    }
    
    public void eliminarObservacion(String id_producto) throws Errores.EliminacionException {
        
        try {
            
            ProductoObservacion.session.beginTransaction();
            
            String hql = "FROM ProductoObservacion WHERE id_producto = :idProducto";
            Query query = ProductoObservacion.session.createQuery(hql);
            query.setParameter("idProducto", id_producto);
            ArrayList<ProductoObservacion> consulta = new ArrayList<>(query.list());
            
            if(consulta.isEmpty()) {
                
                throw new Exception("Registro no encontrado");
            }
            
            pobs = consulta.get(0);
            ProductoObservacion.session.remove(pobs);
            ProductoObservacion.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            if(ProductoObservacion.session.getTransaction() != null) {
                
                ProductoObservacion.session.getTransaction().rollback();
            }
            
            throw new Errores.EliminacionException(ex.getMessage());
        }
    }
    
    public void actualizarObservacion(ProductoObservacion pobs) throws Errores.ActualizacionException {
        
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
            ProductoObservacion.session.getTransaction().commit();
            
        } catch(Exception ex) {
            
            if(ProductoObservacion.session.getTransaction() != null) {
                
                ProductoObservacion.session.getTransaction().rollback();
            }
            
            throw new Errores.ActualizacionException(ex.getMessage());
        }
    }
    
    private ProductoObservacion pobs;
}
