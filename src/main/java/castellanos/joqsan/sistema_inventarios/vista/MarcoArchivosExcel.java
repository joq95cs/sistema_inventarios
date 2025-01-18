
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.logica.LogicaArchivosExcel;
import castellanos.joqsan.sistema_inventarios.orm.ArchivoExcel;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class MarcoArchivosExcel extends javax.swing.JFrame {
    
    public static MarcoArchivosExcel m = null;

    public MarcoArchivosExcel() throws Errores.IniciarEntidadException, Errores.CargarArchivosExcelException  {
            
        initComponents();
        Utilidades.centrarMarco(this);
        setResizable(false);

        if(LogicaArchivosExcel.crud == null) {

            LogicaArchivosExcel.crud = new LogicaArchivosExcel();
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
        buttonAgregar = new javax.swing.JButton();
        buttonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
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
                        .addComponent(buttonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
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

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
    
        agregar();
    }//GEN-LAST:event_buttonAgregarActionPerformed

    private void buttonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegresarActionPerformed

        Utilidades.ejecutarMarco(MarcoFormProductos.m);
        Utilidades.cerrarMarco(this);
    }//GEN-LAST:event_buttonRegresarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try {
            
            Utilidades.cerrarEntidad(ArchivoExcel.class);
            
        } catch(Errores.CerrarEntidadException ex) {
            
            Dialogos.d1(this, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void abrir() {
        
        try {
            
            String nombre = tableExcel.getValueAt(tableExcel.getSelectedRow(), 0).toString();
            String tabla = tableExcel.getValueAt(tableExcel.getSelectedRow(), 1).toString();
            LogicaArchivosExcel.crud.abrirArchivoExcel(nombre, tabla);
            
        } catch(Errores.AbrirArchivoExcelException ex) {
            
            Dialogos.d1(this, ex);
        }
    }
    
    private void eliminar() {
        
        try {
            
            String nombre = tableExcel.getValueAt(tableExcel.getSelectedRow(), 0).toString();
            
            if(Dialogos.d20(this, nombre) == JOptionPane.NO_OPTION) {
                
                return;
            }
            
            File archivo = new File("storage/excel/productos/" + nombre);
            LogicaArchivosExcel.crud.eliminarExcel(archivo);
            
            Dialogos.d21(this);
            
            cargar();
            
        } catch(Errores.CargarArchivosExcelException | Errores.EliminarExcelException | HeadlessException ex) {
            
            Dialogos.d1(this, ex);
        }
    }
        
    private void agregar() {
        
        try {
            
            LogicaArchivosExcel.Copiador copiador = new LogicaArchivosExcel.Copiador();
            
            if(copiador.elegirOrigen("xlsx", this)) {
                
                JComboBox combo = new JComboBox();
                combo.addItem("Productos");
                combo.addItem("Usuarios");

                if(Dialogos.d22(this, combo) == JOptionPane.CANCEL_OPTION) {

                    return;
                }

                String tabla = combo.getSelectedItem().toString();

                if(!copiador.elegirDestino("excel/" + tabla.toLowerCase(), new File(copiador.getRutaOrigen()).getName()) || !copiador.copiar()) {
                    
                    throw new Errores.CopiadorException("Error de copiado", null);
                }
                
                LogicaArchivosExcel.crud.setExcel(new ArchivoExcel(
                        
                    new File(copiador.getRutaOrigen()).getName(),
                    tabla
                ));
                
                LogicaArchivosExcel.crud.insertarArchivoExcel();
                
                Dialogos.d23(this);
                
                cargar();
                
            } else {
                
                throw new Errores.ArchivoIncorrectoException("Archivo incorrecto", null);
            }
            
        } catch(Errores.ArchivoIncorrectoException | Errores.CargarArchivosExcelException | Errores.CopiadorException | Errores.InsertarArchivoExcelException | HeadlessException ex) {
            
            Dialogos.d1(this, ex);
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
        LogicaArchivosExcel.crud.cargarArchivosExcel(modelo);
        
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
    private javax.swing.JButton buttonRegresar;
    private javax.swing.JScrollPane scrollExcel;
    private javax.swing.JTable tableExcel;
    // End of variables declaration//GEN-END:variables
}
