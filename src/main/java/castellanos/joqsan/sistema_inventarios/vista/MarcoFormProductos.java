
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.Producto;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MarcoFormProductos extends javax.swing.JFrame {
    
    public static MarcoFormProductos m = null;

    public MarcoFormProductos(boolean cargar) throws Errores.LookAndFeelException, Errores.ConexionException {
        
        initComponents();
        Utilidades.centrarMarco(this);
        setResizable(false);
        
        if(LogicaProductos.crud == null) {
            
            LogicaProductos.crud = new LogicaProductos();
        }
        
        if(cargar) {
            
            cargar();
        }
        
        campos = new JTextField[] {
            textId,
            textNombre,
            textCategoria,
            textStockMin,
            textStockMax,
            textStockIdeal,
            textStockMaxPedido,
            textStockReorden
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelId = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelCategoria = new javax.swing.JLabel();
        textCategoria = new javax.swing.JTextField();
        labelStockMin = new javax.swing.JLabel();
        textStockMin = new javax.swing.JTextField();
        labelStockMax = new javax.swing.JLabel();
        textStockMax = new javax.swing.JTextField();
        labelStockIdeal = new javax.swing.JLabel();
        textStockIdeal = new javax.swing.JTextField();
        labelStockReorden = new javax.swing.JLabel();
        textStockReorden = new javax.swing.JTextField();
        labelStockMaxPedido = new javax.swing.JLabel();
        textStockMaxPedido = new javax.swing.JTextField();
        buttonInsertar = new javax.swing.JButton();
        buttonBuscar = new javax.swing.JButton();
        buttonActualizar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonCargarExcel = new javax.swing.JButton();
        buttonLista = new javax.swing.JButton();
        buttonEditarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Formulario Productos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelId.setText("ID (Clave)");

        labelNombre.setText("Nombre");

        labelCategoria.setText("Categoría");

        labelStockMin.setText("Stock Mínimo");

        labelStockMax.setText("Stock Máximo");

        labelStockIdeal.setText("Stock Ideal");

        labelStockReorden.setText("Stock Reorden");

        labelStockMaxPedido.setText("Stock Máximo Pedido");

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

        buttonCargarExcel.setText("CARGAR");
        buttonCargarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCargarExcelActionPerformed(evt);
            }
        });

        buttonLista.setText("LISTA");
        buttonLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListaActionPerformed(evt);
            }
        });

        buttonEditarExcel.setText("EDITAR");
        buttonEditarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelId)
                            .addComponent(labelNombre)
                            .addComponent(labelCategoria)
                            .addComponent(labelStockMin)
                            .addComponent(labelStockMax)
                            .addComponent(labelStockIdeal)
                            .addComponent(labelStockReorden)
                            .addComponent(labelStockMaxPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textStockReorden, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(textStockIdeal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textStockMax, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textStockMin, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textCategoria, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textStockMaxPedido)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonCargarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonEditarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCategoria)
                    .addComponent(textCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockMin)
                    .addComponent(textStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockMax)
                    .addComponent(textStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockIdeal)
                    .addComponent(textStockIdeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockReorden)
                    .addComponent(textStockReorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockMaxPedido)
                    .addComponent(textStockMaxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsertar)
                    .addComponent(buttonBuscar)
                    .addComponent(buttonActualizar)
                    .addComponent(buttonEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCargarExcel)
                    .addComponent(buttonLista)
                    .addComponent(buttonEditarExcel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertarActionPerformed

        insertar();   
    }//GEN-LAST:event_buttonInsertarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        
        buscar();
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed

        actualizar();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed

        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        if(Producto.session != null) {
                
            Producto.cerrar();
        }
        
        Utilidades.cerrarMarco(this);
    }//GEN-LAST:event_formWindowClosing

    private void buttonListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaActionPerformed

        lista();
    }//GEN-LAST:event_buttonListaActionPerformed

    private void buttonCargarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCargarExcelActionPerformed

        cargarExcel();
    }//GEN-LAST:event_buttonCargarExcelActionPerformed

    private void buttonEditarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarExcelActionPerformed
    
        editarExcel();
    }//GEN-LAST:event_buttonEditarExcelActionPerformed

    private void insertar() {
        
        try {
            
            if(Utilidades.obtenerCadena(textId) == null ||
               Utilidades.obtenerCadena(textNombre) == null) {
                
                throw new Errores.CamposVaciosException();
            }
            
            String id = Utilidades.obtenerCadena(textId);
            String nombre = Utilidades.obtenerCadena(textNombre);
            String categoria = "No definido";
            int stock_min = 0;
            int stock_max = 0;
            int stock_ideal = 0;
            int stock_reorden = 0;
            int stock_max_pedido = 0;
            
            if(Utilidades.obtenerCadena(textCategoria) != null) {
                
                categoria = Utilidades.obtenerCadena(textCategoria);
            }
            
            if(Utilidades.obtenerCadena(textStockMin) != null) {
                
                stock_min = Integer.parseInt(Utilidades.obtenerCadena(textStockMin));
            }
            
            if(Utilidades.obtenerCadena(textStockMax) != null) {
                
                stock_max = Integer.parseInt(Utilidades.obtenerCadena(textStockMax));
            }
            
            if(Utilidades.obtenerCadena(textStockIdeal) != null) {
                
                stock_ideal = Integer.parseInt(Utilidades.obtenerCadena(textStockIdeal));
            }
            
            if(Utilidades.obtenerCadena(textStockReorden) != null) {
                
                stock_reorden = Integer.parseInt(Utilidades.obtenerCadena(textStockReorden));
            }
            
            if(Utilidades.obtenerCadena(textStockMaxPedido) != null) {
                
                stock_max_pedido = Integer.parseInt(Utilidades.obtenerCadena(textStockMaxPedido));
            }
            
            Producto producto = new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido);
            LogicaProductos.crud.setProducto(producto);
            LogicaProductos.crud.insertarProducto();
            Utilidades.limpiarCampos(campos, null);
            LogicaProductos.crud.setProducto(null);
            JOptionPane.showMessageDialog(this, "Inserción exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            
        } catch(Errores.CamposVaciosException | Errores.InsercionException | HeadlessException | NumberFormatException ex) {
            
            if(ex.getClass().equals(NumberFormatException.class)) {
                
                JOptionPane.showMessageDialog(this, "Cadena ingresada", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else {
               
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }  
        }
    }
    
    private void buscar() {
        
        try {
            
            if(Utilidades.obtenerCadena(textId) == null) {
                
                throw new Errores.CamposVaciosException("Campo de ID vacío");
            }
            
            String id = Utilidades.obtenerCadena(textId);
            
            LogicaProductos.crud.buscarProducto(id);
            cargar();
            
        } catch(Errores.BusquedaException | Errores.CamposVaciosException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizar() {
        
        try {
            
            if(Utilidades.obtenerCadena(textId) == null ||
               Utilidades.obtenerCadena(textNombre) == null) {
                
                throw new Errores.CamposVaciosException();
            }
            
            String id = Utilidades.obtenerCadena(textId);
            String nombre = Utilidades.obtenerCadena(textNombre);
            String categoria = "No definido";
            int stock_min = 0;
            int stock_max = 0;
            int stock_ideal = 0;
            int stock_reorden = 0;
            int stock_max_pedido = 0;
            
            if(Utilidades.obtenerCadena(textCategoria) != null) {
                
                categoria = Utilidades.obtenerCadena(textCategoria);
            }
            
            if(Utilidades.obtenerCadena(textStockMin) != null) {
                
                stock_min = Integer.parseInt(Utilidades.obtenerCadena(textStockMin));
            }
            
            if(Utilidades.obtenerCadena(textStockMax) != null) {
                
                stock_max = Integer.parseInt(Utilidades.obtenerCadena(textStockMax));
            }
            
            if(Utilidades.obtenerCadena(textStockIdeal) != null) {
                
                stock_ideal = Integer.parseInt(Utilidades.obtenerCadena(textStockIdeal));
            }
            
            if(Utilidades.obtenerCadena(textStockReorden) != null) {
                
                stock_reorden = Integer.parseInt(Utilidades.obtenerCadena(textStockReorden));
            }
            
            if(Utilidades.obtenerCadena(textStockMaxPedido) != null) {
                
                stock_max_pedido = Integer.parseInt(Utilidades.obtenerCadena(textStockMaxPedido));
            }

            LogicaProductos.crud.actualizarProducto(new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido));
            Utilidades.limpiarCampos(campos, null);
            LogicaProductos.crud.setProducto(null);
            JOptionPane.showMessageDialog(this, "Actualización exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            
        } catch(Errores.ActualizacionException | Errores.CamposVaciosException | NumberFormatException ex) {
            
            if(ex.getClass().equals(NumberFormatException.class)) {
                
                JOptionPane.showMessageDialog(this, "Cadena ingresada", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else {
               
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } 
        } 
    }
    
    private void eliminar() {
        
        try {
            
            if(Utilidades.obtenerCadena(textId) == null) {
                
                throw new Errores.CamposVaciosException("Campo de ID vacío");
            }
            
            String id = Utilidades.obtenerCadena(textId);
            
            LogicaProductos.crud.eliminarProducto(id);
            Utilidades.limpiarCampos(campos, null);
            LogicaProductos.crud.setProducto(null);
            JOptionPane.showMessageDialog(this, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            
        } catch(Errores.CamposVaciosException | Errores.EliminacionException | HeadlessException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    private void cargarExcel() {

        try {
            
            File excel = new File("src/main/resources/excel/Productos.xlsx");
            
            if(excel.exists()) {
                
                if(JOptionPane.showConfirmDialog(this, "¿Cargar Excel editado?", "Elija una opción", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                
                    LogicaProductos.crud.cargarExcel(excel, 0);
                    JOptionPane.showMessageDialog(this, "Carga de Excel editado exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                    return; 
                }
                
                return;
            }
                        
            JFileChooser chooser = new JFileChooser();
            
            if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                
                String ruta = chooser.getSelectedFile().getAbsolutePath();
                
                int i = new File(ruta).getName().lastIndexOf(".");
                
                if(i > 0) {
                    
                    String ext = new File(ruta).getName().substring(i + 1);
                    
                    if(ext.equals("xlsx")) {
                        
                        JComboBox combo = new JComboBox<>();
                        combo.addItem("Reemplazar");
                        combo.addItem("Agregar");
                        int opcion = 0;

                        if(JOptionPane.showConfirmDialog(this, combo, "Elija una opción", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {

                            if(combo.getSelectedItem().equals("Agregar")) {

                                opcion = 1;
                            }

                        } else {

                            return;
                        }
                        
                        LogicaProductos.crud.cargarExcel(new File(ruta), opcion);
                        JOptionPane.showMessageDialog(this, "Carga de Excel exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                
                throw new Errores.ExcelException("Archivo incorrecto");
            }
            
        } catch (Errores.ExcelException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void editarExcel() {
        
        try {
            
            LogicaProductos.crud.editarExcel(new File("src/main/resources/excel/Productos.xlsx"));
            
        } catch(Errores.ExcelException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void lista() {
        
        try {
            
            MarcoListaProductos.m = new MarcoListaProductos();
            Utilidades.ejecutarMarco(MarcoListaProductos.m);
            Utilidades.cerrarMarco(this);
            
        } catch(Errores.ConexionException | Errores.ListaException | Errores.LookAndFeelException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargar() {
        
        textId.setText(LogicaProductos.crud.getProducto().getId());
        textNombre.setText(LogicaProductos.crud.getProducto().getNombre());
        textCategoria.setText(LogicaProductos.crud.getProducto().getCategoria());
        textStockMin.setText(LogicaProductos.crud.getProducto().getStock_min() + "");
        textStockMax.setText(LogicaProductos.crud.getProducto().getStock_max() + "");
        textStockIdeal.setText(LogicaProductos.crud.getProducto().getStock_ideal() + "");
        textStockReorden.setText(LogicaProductos.crud.getProducto().getStock_reorden() + "");
        textStockMaxPedido.setText(LogicaProductos.crud.getProducto().getStock_max_pedido() + "");
    }
    
    public static void main(String args[]) {
        
        try {
            
            Utilidades.setLookAndFeel();
            MarcoFormProductos.m = new MarcoFormProductos(false);
            Utilidades.ejecutarMarco(MarcoFormProductos.m);
            
        } catch(Errores.ConexionException | Errores.LookAndFeelException ex) {
            
            ex.printStackTrace();
        }
    }
    
    private final JTextField[] campos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonCargarExcel;
    private javax.swing.JButton buttonEditarExcel;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonInsertar;
    private javax.swing.JButton buttonLista;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelStockIdeal;
    private javax.swing.JLabel labelStockMax;
    private javax.swing.JLabel labelStockMaxPedido;
    private javax.swing.JLabel labelStockMin;
    private javax.swing.JLabel labelStockReorden;
    private javax.swing.JTextField textCategoria;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textStockIdeal;
    private javax.swing.JTextField textStockMax;
    private javax.swing.JTextField textStockMaxPedido;
    private javax.swing.JTextField textStockMin;
    private javax.swing.JTextField textStockReorden;
    // End of variables declaration//GEN-END:variables
}