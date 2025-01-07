
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.Producto;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class MarcoListaProductos extends javax.swing.JFrame {
    
    public static MarcoListaProductos m = null;

    public MarcoListaProductos() throws Errores.ConexionException, Errores.CargarListaException {
        
        initComponents();
        Utilidades.centrarMarco(this);
        setResizable(false);
        
        if(LogicaProductos.crud == null) {
            
            LogicaProductos.crud = new LogicaProductos();
        }
        
        cargar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelID = new javax.swing.JLabel();
        scrollLista = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        textID = new javax.swing.JTextField();
        buttonActualizar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Productos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelID.setText("ID (Clave)");

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollLista.setViewportView(tableProductos);

        textID.setColumns(10);

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
                    .addComponent(scrollLista, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelID)
                        .addGap(18, 18, 18)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelID)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonActualizar)
                        .addComponent(buttonEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        
        actualizar(Utilidades.obtenerCadena(textID));
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed

        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        if(Producto.session != null) {
                
            Producto.cerrar();
            System.out.println("---Entidad Producto cerrada---");
        }
        
        Utilidades.cerrarMarco(this);
    }//GEN-LAST:event_formWindowClosing

    private void actualizar(String id) {
        
        try {
            
            if(id == null) {

                throw new Errores.CamposVaciosException("Campo de ID vacío");
            }

            LogicaProductos.crud.cargarProducto(id);
            Utilidades.cerrarMarco(this);
        
        } catch(Errores.CamposVaciosException | Errores.CargarProductoException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eliminar() {
        
        try {
            
            if(Utilidades.obtenerCadena(textID) == null) {

                throw new Errores.CamposVaciosException("Campo de ID vacío");
            }
            
            LogicaProductos.crud.eliminarProducto(Utilidades.obtenerCadena(textID));
            JOptionPane.showMessageDialog(this, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            cargar();
            
        } catch(Errores.CamposVaciosException | Errores.CargarListaException | Errores.EliminarProductoException | HeadlessException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargar() throws Errores.CargarListaException {
        
        DefaultTableModel modelo = new DefaultTableModel() {
        
            @Override
            public boolean isCellEditable(int row, int column) {
                
                return false;
            }
        };
        
        modelo.addColumn("ID (Clave)");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Stock Mínimo");
        modelo.addColumn("Stock Máximo");
        modelo.addColumn("Stock Ideal");
        modelo.addColumn("Stock Reorden");
        modelo.addColumn("Stock Máximo Pedido");
        tableProductos.setModel(modelo);
        tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Se llama al metodo encargado de consultar la table y modificar el modelo
        LogicaProductos.crud.cargarLista(modelo);
        
        //Se agrega el evento para que se escriba el id al seleccionar la fila
        tableProductos.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
            
            if(!evt.getValueIsAdjusting() && tableProductos.getSelectedRow() != -1) {
                
                textID.setText(tableProductos.getValueAt(tableProductos.getSelectedRow(), 0) + "");
            }
        });
        
        //Se agrega el evento para hacer doble clic sobre la fila
        tableProductos.addMouseListener(new MouseAdapter() {
        
            @Override
            public void mouseClicked(MouseEvent evt) {
                
                if(evt.getClickCount() == 2) {
                   
                    if(tableProductos.getSelectedRow() != -1) {
                
                        actualizar(tableProductos.getValueAt(tableProductos.getSelectedRow(), 0) + "");
                    } 
                }
            }
        });
    }   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JLabel labelID;
    private javax.swing.JScrollPane scrollLista;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField textID;
    // End of variables declaration//GEN-END:variables
}