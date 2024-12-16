
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.Productos;
import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.ProductoObservacion;

public class MarcoObsProductos extends javax.swing.JFrame {
    
    public static MarcoObsProductos m = null;

    public MarcoObsProductos() throws Errores.ConexionException {
        
        initComponents();
        Utilidades.centrarMarco(this);
        setResizable(false);
        
        if(Productos.crud == null) {
            
            Productos.crud = new Productos();
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

        buttonActualizar.setText("ACTUALIZAR");

        buttonEliminar.setText("ELIMINAR");

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

    private void insertar() {
        
        try {
            
            String id = textId.getText();
            String obs = areaObs.getText();
            
            if(id.isEmpty() || obs.isEmpty()) {
                
                throw new Errores.CamposVaciosException();
            }
            
            Productos.crud.buscarProducto(id);
            ProductoObservacion pobs = new ProductoObservacion(id, obs);
            
        } catch(Exception ex) {
            
            
        }
    }
    
    private void buscar() {}
    
    private void actualizar() {}
    
    private void eliminar() {}
    
    public static void main(String[] args) {
        
        try {
            
            Utilidades.setLookAndFeel();
            MarcoObsProductos.m = new MarcoObsProductos();
            Utilidades.ejecutarMarco(MarcoObsProductos.m);
            
        } catch (Errores.ConexionException | Errores.LookAndFeelException ex) {
            
            ex.printStackTrace();
        }
        
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
