package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.Producto;
import castellanos.joqsan.sistema_inventarios.orm.ProductoObservacion;
import java.util.ArrayList;
import org.hibernate.query.Query;

public class ProductosObs {
    
    public static ProductosObs crud = null;
    
    public ProductosObs() throws Errores.ConexionException {
        
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
            
            if(Producto.session.getTransaction() != null) {
                
                Producto.session.getTransaction().rollback();
            }
            
            throw new Errores.EliminacionException(ex.getMessage());
        }
    }
    
    private ProductoObservacion pobs;

    
}
