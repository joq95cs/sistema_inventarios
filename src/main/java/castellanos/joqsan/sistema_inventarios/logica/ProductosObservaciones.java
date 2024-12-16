package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.ProductoObservacion;

public class ProductosObservaciones {
    
    public static ProductosObservaciones crud = null;
    
    public ProductosObservaciones() throws Errores.ConexionException {
        
        if(Hibernate.type == null || !Hibernate.type.equals(ProductoObservacion.class)) {
            
            Hibernate.iniciar(ProductoObservacion.class);
        }
        
        pobs = null;
        
    }
    
    public ProductoObservacion getPobs() {
        
        return pobs;
    }

    public void setPobs(ProductoObservacion pobs) {
        
        this.pobs = pobs;
    }
    
    public void insertarObservacion() {
        
        try {
            
            
            
        } catch(Exception ex) {
            
            
        }
    }
    
    private ProductoObservacion pobs;
}
