
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.logica.LogicaProductosObs;
import castellanos.joqsan.sistema_inventarios.orm.Producto;
import castellanos.joqsan.sistema_inventarios.orm.ProductoObservacion;
import java.awt.HeadlessException;
import javax.swing.JTextField;

public class MarcoObsProductos extends javax.swing.JFrame {
    
    public static MarcoObsProductos m = null;

    public MarcoObsProductos() throws Errores.IniciarEntidadException, Errores.ConexionException {
        
            
        initComponents();
        Utilidades.centrarMarco(this);
        setResizable(false);

        if(LogicaProductosObs.crud == null) {

            LogicaProductosObs.crud = new LogicaProductosObs();
        }

        if(LogicaProductos.crud == null) {

            LogicaProductos.crud = new LogicaProductos();
        }     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelId = new javax.swing.JLabel();
        labelObs = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        scrollObs = new javax.swing.JScrollPane();
        areaObs = new javax.swing.JTextArea();
        buttonInsertar = new javax.swing.JButton();
        buttonBuscar = new javax.swing.JButton();
        buttonActualizar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Observaciones de Productos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelId.setText("ID Producto");

        labelObs.setText("Observaciones");

        areaObs.setColumns(20);
        areaObs.setRows(5);
        scrollObs.setViewportView(areaObs);

        buttonInsertar.setText("INSERTAR");
        buttonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertarActionPerformed(evt);
            }
        });

        buttonBuscar.setText("BUSCAR");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        buttonActualizar.setText("ACTUALIZAR");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        buttonEliminar.setText("ELIMINAR");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelId)
                            .addComponent(labelObs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollObs, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(textId)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObs)
                    .addComponent(scrollObs, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsertar)
                    .addComponent(buttonBuscar)
                    .addComponent(buttonActualizar)
                    .addComponent(buttonEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertarActionPerformed

        insertar();
    }//GEN-LAST:event_buttonInsertarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
       
        buscar();
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed

        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try {
            
           Utilidades.cerrarEntidad(Producto.class);
           Utilidades.cerrarEntidad(ProductoObservacion.class);
           
        } catch(Exception ex) {
            
            Dialogos.d_error(this, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed

        actualizar();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void insertar() {
        
        try {
            
            String id_producto = textId.getText();
            String observaciones = areaObs.getText();
            
            if(id_producto.isEmpty() || observaciones.isEmpty()) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            LogicaProductos.crud.buscarProducto(id_producto);
            
            if(LogicaProductos.crud.getProducto() == null) {
                
                throw new Exception("Registro no encontrado");
            }
            
            ProductoObservacion pobs = new ProductoObservacion(id_producto, observaciones);
            LogicaProductosObs.crud.setPobs(pobs);
            LogicaProductosObs.crud.insertarObservacion();
            Utilidades.limpiarCampos(new JTextField[] {
                textId}, areaObs);
            LogicaProductosObs.crud.setPobs(null);
            
            Dialogos.d_clave(this, "insercion_pobs");
            
        } catch(Exception ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void buscar() {
    
        try {
            
            String id_producto = textId.getText();
            
            if(id_producto.isEmpty()) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            LogicaProductosObs.crud.buscarObservacion(id_producto);
            cargar();
            
        } catch(Errores.BuscarPobsException | Errores.CamposVaciosException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void actualizar() {
    
        try {
            
            String id_producto = textId.getText();
            String observaciones = areaObs.getText();
            
            if(id_producto.isEmpty() || observaciones.isEmpty()) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            LogicaProductosObs.crud.actualizarObservacion(new ProductoObservacion(id_producto, observaciones));
            Utilidades.limpiarCampos(new JTextField[] {
                textId}, areaObs);
            LogicaProductosObs.crud.setPobs(null);
            
            Dialogos.d_clave(this, "actualizacion_pobs");
            
        } catch(Errores.ActualizarPobsException | Errores.CamposVaciosException | HeadlessException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void eliminar() {
    
        try {
            
            String id_producto = textId.getText();
            
            if(id_producto.isEmpty()) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            LogicaProductosObs.crud.eliminarObservacion(id_producto);
            LogicaProductosObs.crud.setPobs(null);
            Utilidades.limpiarCampos(new JTextField[] {
                textId}, areaObs);
            
            Dialogos.d_clave(this, "eliminacion_pobs");
            
        } catch(Errores.CamposVaciosException | Errores.EliminarPobsException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void cargar() {
        
        textId.setText(LogicaProductosObs.crud.getPobs().getId_producto());
        areaObs.setText(LogicaProductosObs.crud.getPobs().getObservaciones());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObs;
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonInsertar;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelObs;
    private javax.swing.JScrollPane scrollObs;
    private javax.swing.JTextField textId;
    // End of variables declaration//GEN-END:variables
}
