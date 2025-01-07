
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class MarcoArchivosExcel extends javax.swing.JFrame {
    
    public static MarcoArchivosExcel m = null;

    public MarcoArchivosExcel() throws Errores.ConexionException, Errores.CargarArchivosExcelException {
        
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

        scrollExcel = new javax.swing.JScrollPane();
        tableExcel = new javax.swing.JTable();
        buttonAbrir = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonReemplazar = new javax.swing.JButton();
        buttonAgregar = new javax.swing.JButton();
        buttonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableExcel.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollExcel.setViewportView(tableExcel);

        buttonAbrir.setText("ABRIR");
        buttonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbrirActionPerformed(evt);
            }
        });

        buttonEliminar.setText("ELIMINAR");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonReemplazar.setText("REEMPLAZAR");
        buttonReemplazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReemplazarActionPerformed(evt);
            }
        });

        buttonAgregar.setText("AGREGAR");
        buttonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarActionPerformed(evt);
            }
        });

        buttonRegresar.setText("REGRESAR");
        buttonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonReemplazar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAbrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonReemplazar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(buttonRegresar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbrirActionPerformed

        abrir();
    }//GEN-LAST:event_buttonAbrirActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        
        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonReemplazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReemplazarActionPerformed
       
        reemplazar();
    }//GEN-LAST:event_buttonReemplazarActionPerformed

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
    
        agregar();
    }//GEN-LAST:event_buttonAgregarActionPerformed

    private void buttonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegresarActionPerformed

        Utilidades.ejecutarMarco(MarcoFormProductos.m);
        Utilidades.cerrarMarco(this);
    }//GEN-LAST:event_buttonRegresarActionPerformed

    private void abrir() {
        
        try {
            
            String nombre = tableExcel.getValueAt(tableExcel.getSelectedRow(), 0).toString();
            Desktop.getDesktop().open(new File("src/main/resources/excel/productos/" + nombre));
            
        } catch(IOException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eliminar() {
        
        try {
            
            String nombre = tableExcel.getValueAt(tableExcel.getSelectedRow(), 0).toString();
            
            if(JOptionPane.showConfirmDialog(null, "¿Eliminar " + nombre + "?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.NO_OPTION) {
                
                return;
            }
            
            File excel = new File("src/main/resources/excel/productos/" + nombre);
            LogicaProductos.crud.eliminarExcel(excel);
            JOptionPane.showMessageDialog(this, "Eliminación de Excel exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            cargar();
            
        } catch(Errores.CargarArchivosExcelException | Errores.EliminarExcelException | HeadlessException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void reemplazar() {
        
        try {
            
            
        } catch(Exception ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void agregar() {
        
        try {
            
            
        } catch(Exception ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargar() throws Errores.CargarArchivosExcelException {
        
        //Se crea el modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel() {
        
            //Se sobreescribe el metodo para no permitir que se editen las celdas
            @Override
            public boolean isCellEditable(int row, int column) {
                
                return false; //Regresa false para no permitir
            }
        };
        
        //Se agregan las columnas
        modelo.addColumn("Nombre");
        modelo.addColumn("Tabla");
        modelo.addColumn("Fecha de modificación");
        
        //Se agrega el modelo a la tabla
        tableExcel.setModel(modelo);
        tableExcel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //No se permite la seleccion multiple
        
        //Se llama al metodo encargado de consultar la table y modificar el modelo
        LogicaProductos.crud.cargarArchivosExcel(modelo);
        
        tableExcel.addMouseListener(new MouseAdapter() {
        
            @Override
            public void mouseClicked(MouseEvent evt) {
                
                if(evt.getClickCount() == 2) {
                   
                    if(tableExcel.getSelectedRow() != -1) {
                
                        abrir();
                    } 
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbrir;
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonReemplazar;
    private javax.swing.JButton buttonRegresar;
    private javax.swing.JScrollPane scrollExcel;
    private javax.swing.JTable tableExcel;
    // End of variables declaration//GEN-END:variables
}
