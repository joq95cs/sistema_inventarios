
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import castellanos.joqsan.sistema_inventarios.logica.Errores;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MarcoListaProductos extends javax.swing.JFrame {
    
    public static MarcoListaProductos m = null;

    public MarcoListaProductos() throws Errores.ConexionException, Errores.LookAndFeelException, Errores.ListaException {
        
        initComponents();
        Utilidades.centrarMarco(this);
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID (Clave)");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Stock Mínimo");
        modelo.addColumn("Stock Máximo");
        modelo.addColumn("Stock Ideal");
        modelo.addColumn("Stock Reorden");
        modelo.addColumn("Stock Máximo Pedido");
        tableProductos.setModel(modelo);
        
        if(LogicaProductos.crud == null) {
            
            LogicaProductos.crud = new LogicaProductos();
        }
        
        LogicaProductos.crud.cargarLista(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollLista = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        p1 = new javax.swing.JPanel();
        labelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        buttonActualizar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Productos");

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

        getContentPane().add(scrollLista, java.awt.BorderLayout.CENTER);

        labelID.setText("ID (Clave)");
        p1.add(labelID);

        textID.setColumns(10);
        p1.add(textID);

        buttonActualizar.setText("EDITAR");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });
        p1.add(buttonActualizar);

        buttonEliminar.setText("ELIMINAR");
        p1.add(buttonEliminar);

        getContentPane().add(p1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        
        editar();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void editar() {
        
        try {
            
            if(textID.getText().isEmpty()) {

                throw new Errores.CamposVaciosException();
            }

            LogicaProductos.crud.cargarProducto(textID.getText());
            Utilidades.cerrarMarco(this);
        
        } catch(Errores.CamposVaciosException | Errores.CargarException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
            
        try {
                
            Utilidades.setLookAndFeel();
            MarcoListaProductos.m = new MarcoListaProductos();
            Utilidades.ejecutarMarco(MarcoListaProductos.m);
                
        } catch (Errores.ConexionException | Errores.ListaException | Errores.LookAndFeelException ex) {
                
            ex.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JLabel labelID;
    private javax.swing.JPanel p1;
    private javax.swing.JScrollPane scrollLista;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField textID;
    // End of variables declaration//GEN-END:variables
}