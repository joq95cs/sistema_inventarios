
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.Producto;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class MarcoListaProductos extends javax.swing.JFrame {
    
    public static MarcoListaProductos m = null;

    public MarcoListaProductos() throws Errores.IniciarEntidadException, Errores.CargarListaProductosException  {

        initComponents();
        Utilidades.centrarMarco(this);

        if(LogicaProductos.crud == null) {

            LogicaProductos.crud = new LogicaProductos();
        }

        cargar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll1 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        panel1 = new javax.swing.JPanel();
        buttonVolver = new javax.swing.JButton();
        buttonActualizar = new javax.swing.JButton();
        labelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        buttonEliminar = new javax.swing.JButton();
        buttonFiltrar = new javax.swing.JButton();
        buttonImportar = new javax.swing.JButton();
        buttonRecargar = new javax.swing.JButton();
        buttonExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Productos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        scroll1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        tableProductos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
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
        scroll1.setViewportView(tableProductos);

        buttonVolver.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonVolver.setText("VOLVER");
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        buttonActualizar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonActualizar.setText("ACTUALIZAR");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        labelID.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelID.setText("ID (Clave)");

        textID.setColumns(10);
        textID.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textIDKeyPressed(evt);
            }
        });

        buttonEliminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonEliminar.setText("ELIMINAR");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonFiltrar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonFiltrar.setText("FILTRAR");
        buttonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltrarActionPerformed(evt);
            }
        });

        buttonImportar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonImportar.setText("IMPORTAR");
        buttonImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportarActionPerformed(evt);
            }
        });

        buttonRecargar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonRecargar.setText("RECARGAR");
        buttonRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecargarActionPerformed(evt);
            }
        });

        buttonExportar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonExportar.setText("EXPORTAR");
        buttonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelID))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        
        actualizar();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed

        
    }//GEN-LAST:event_buttonVolverActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try {
            
            Utilidades.cerrarEntidad(Producto.class);
            Utilidades.cerrarMarco(this);
            
        } catch (Errores.CerrarEntidadException ex) {
           
            Dialogos.d_error(this, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        
        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltrarActionPerformed

        filtrar();
    }//GEN-LAST:event_buttonFiltrarActionPerformed

    private void textIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textIDKeyPressed

        atajo(evt);
    }//GEN-LAST:event_textIDKeyPressed

    private void buttonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportarActionPerformed
       
        importar();
    }//GEN-LAST:event_buttonImportarActionPerformed

    private void buttonRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecargarActionPerformed
      
        recargar();
    }//GEN-LAST:event_buttonRecargarActionPerformed

    private void buttonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportarActionPerformed
        
        exportar();
    }//GEN-LAST:event_buttonExportarActionPerformed

    private void importar() {
        
        try {
           
            JPanel panel = new JPanel(); //Se crea primero el panel contenedor
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //Se le asigna el layout de caja

            JLabel label = new JLabel("¿Reemplazar o agregar los registros?"); //Se crea la label para el texto
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            JComboBox<String> combo = new JComboBox<>(); //Se crea el combo con los items
            combo.setAlignmentX(Component.LEFT_ALIGNMENT); //Se alinea a la izquierda
            combo.addItem("Reemplazar");
            combo.addItem("Agregar");
            
            //Se agregan los componentes al panel
            panel.add(label);
            panel.add(Box.createVerticalStrut(5)); //Espacio vertical
            panel.add(combo);

            //Se muestra el dialogo de confirmacion
            if(JOptionPane.showConfirmDialog(this, panel, "Importar desde Excel", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.CANCEL_OPTION) {

                return; //Si se elige la opcion de cancelar se termina el metodo
            }

            //Si se presiono el ok continua la ejecucion
            //Opcion 0 para reemplazar
            //Opcion 1 para agregar
            int opcion = combo.getSelectedIndex(); //Se guarda la opcion

            JFileChooser chooser = new JFileChooser(); //Se crea el chooser

            if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { //Se abre el chooser

                //Si se presiono la opcion correcta
                File excel = chooser.getSelectedFile(); //Se guarda el archivo

                if(!excel.getName().toLowerCase().endsWith(".xlsx")) { //Se comprueba que la extension sea la correcta
                    
                    //Se lanza el error en caso de que el archivo no sea del formato correcto
                    throw new Errores.ArchivoIncorrectoException("Error de archivo incorrecto", null);
                }
                
                //Si la extension es correcta continua la ejecucion
                LogicaProductos.crud.importarExcel(excel, opcion); //Se llama la logica para importar el archivo
                
                Dialogos.d_clave(this, "importacion_productos"); //Se muestra el dialogo de confirmacion
                
                //Se recarga la lista finalmente
                recargar();
            }
            
        } catch(Errores.ArchivoIncorrectoException | Errores.ImportarExcelException | HeadlessException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void exportar() {
        
        try {
            
            //Se crea un panel con etiqueta y campo
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            JLabel label = new JLabel("Ingrese nombre de archivo");
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(label);
            panel.add(Box.createVerticalStrut(5));
            JTextField tf = new JTextField("Productos.xlsx");
            tf.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(tf);
            
            //Se muestra un dialogo con el panel creado anteriormente
            if(JOptionPane.showConfirmDialog(this, panel, "Exportar a Excel", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.CANCEL_OPTION) {
                
                return;
            }
            
            //Se fija el nombre a utilizar para crear el archivo
            //En caso de que se ingrese un nombre que ya existe, el archivo reemplazara al anterior
            String nombre = Utilidades.obtenerCadena(tf);
            
            if(nombre == null) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se verifica si se escribio la extension, si no, se agrega
            if(!nombre.endsWith(".xlsx")) {
                
                nombre += ".xlsx";
            }
            
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            if(chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
                
                return;
            }
            
            File excel = new File(chooser.getSelectedFile().getPath() + "\\" + nombre);
            LogicaProductos.crud.exportarExcel(excel);
            
            //Si el archivo fue creado correctamente
            if(excel.exists()) {
                
                Dialogos.d_clave(this, "exportacion_productos");
                Desktop.getDesktop().open(excel);
            }
            
        } catch(Errores.CamposVaciosException | Errores.ExportarExcelException | HeadlessException | IOException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void actualizar() {
        
        try {
            
            String id = Utilidades.obtenerCadena(textID);
            
            if(id == null) {

                throw new Errores.CamposVaciosException("Campo de ID vacío", null);
            }

            LogicaProductos.crud.cargarProducto(id);
            Utilidades.cerrarMarco(this);
        
        } catch(Errores.CamposVaciosException | Errores.CargarProductoException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void eliminar() {
        
        try {
            
            if(Utilidades.obtenerCadena(textID) == null) {

                throw new Errores.CamposVaciosException("Campo de ID vacío", null);
            }
            
            LogicaProductos.crud.eliminarProducto(Utilidades.obtenerCadena(textID));
            
            Dialogos.d_clave(this, "eliminacion_productos");
            
            cargar();
            
        } catch(Errores.CamposVaciosException | Errores.CargarListaProductosException | Errores.EliminarProductoException | HeadlessException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void cargar() throws Errores.CargarListaProductosException {
        
        //Las celdas no se pueden editar
        modelo = new DefaultTableModel() {
        
            @Override
            public boolean isCellEditable(int row, int column) {
                
                return false;
            }
        };
        
        //Se fijan las columnas del modelo
        modelo.addColumn("ID (Clave)");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Stock Mínimo");
        modelo.addColumn("Stock Máximo");
        modelo.addColumn("Stock Ideal");
        modelo.addColumn("Stock Reorden");
        modelo.addColumn("Stock Máximo Pedido");
        
        //Se fija el modelo a la tabla
        tableProductos.setModel(modelo);
        tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //No se permite la multiseleccion
        
        //Se llama al metodo encargado de consultar la table y modificar el modelo
        LogicaProductos.crud.cargarListaProductos(modelo, null);
        
        //Se agrega el evento para que se escriba el id al seleccionar la fila
        tableProductos.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
            
            if(!evt.getValueIsAdjusting() && tableProductos.getSelectedRow() != -1) {
                
                //Se fija el id de la fila seleccionada
                textID.setText(tableProductos.getValueAt(tableProductos.getSelectedRow(), 0) + "");
            }
        });
        
        //Se agrega el evento para hacer doble clic sobre la fila
        tableProductos.addMouseListener(new MouseAdapter() {
        
            @Override
            public void mouseClicked(MouseEvent evt) {
                
                if(evt.getClickCount() == 2) { //Al hacer doble clic
                   
                    if(tableProductos.getSelectedRow() != -1) {
                
                        actualizar(); //Se llama al metodo actualizar para el id
                    } 
                }
            }
        });
    }
    
    private void filtrar() {
        
        try {
            
            //Se crea el panel contenedor
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
            //Se crea la label para el texto
            JLabel label = new JLabel("Criterio para filtrar");
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            //Se crea el combo con los items
            JComboBox<String> combo = new JComboBox<>();
            combo.setAlignmentX(Component.LEFT_ALIGNMENT);
            combo.addItem("Nombre");
            combo.addItem("Categoría");
            combo.addItem("Stock Mínimo");
            combo.addItem("Stock Máximo");
            combo.addItem("Stock Ideal");
            combo.addItem("Stock Reorden");
            combo.addItem("Stock Máximo Pedido");
            
            //Se agregan los componentes al panel
            panel.add(label);
            panel.add(Box.createVerticalStrut(5));
            panel.add(combo);

            //Se llama al dialogo
            if (JOptionPane.showConfirmDialog(this, panel, "Elija una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.CANCEL_OPTION) {
                
                return; //Si se cancela se regresa el metodo
            }
            
            //Se guarda la cadena a usar como criterio
            String criterio = JOptionPane.showInputDialog(this, "Criterio de búsqueda", "Ingrese valor", JOptionPane.QUESTION_MESSAGE);
            
            //Se verifica que el criterio no sea vacio ni blanco
            if(criterio.isEmpty() || criterio.isBlank()) {
                
                //Se lanza el error de campos vacios
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se crea el hashmap con el index y el criterio
            HashMap map = new HashMap();
            map.put(combo.getSelectedIndex(), criterio); //El index se usa como criterio
            
            if(combo.getSelectedIndex() > 1) { //Se evaluan que no haya cadenas en los campos numericos a partir del index 2
                
                Utilidades.obtenerEntero(criterio.trim()); //Se limpia de espacios en blanco y se llama al metodo para verificar entero
            }
            
            //Se llama a la logica para cargar la lista
            LogicaProductos.crud.cargarListaProductos(modelo, map);
            
        } catch(Errores.CadenaIngresadaException | Errores.CamposVaciosException | Errores.CargarListaProductosException | HeadlessException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void recargar() {
        
        try {
           
            cargar();
            
        } catch(Errores.CargarListaProductosException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    private void atajo(KeyEvent evt) {
        
        if(evt.isControlDown()) {
            
            switch (evt.getKeyCode()) {
                
                case KeyEvent.VK_A -> actualizar();
                case KeyEvent.VK_E -> eliminar();
            }
        }
    }
    
    public static void main(String[] args) {
        
        try {
            
            Utilidades.setLookAndFeel();
            m = new MarcoListaProductos();
            Utilidades.ejecutarMarco(m);
        
        } catch(Errores.CargarListaProductosException | Errores.IniciarEntidadException | Errores.LookAndFeelException ex) {
            
            Dialogos.d_error(m, ex);
        }
    }
    
    private DefaultTableModel modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonExportar;
    private javax.swing.JButton buttonFiltrar;
    private javax.swing.JButton buttonImportar;
    private javax.swing.JButton buttonRecargar;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JLabel labelID;
    private javax.swing.JPanel panel1;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField textID;
    // End of variables declaration//GEN-END:variables
}