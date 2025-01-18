
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.logica.LogicaArchivosExcel;
import castellanos.joqsan.sistema_inventarios.orm.ArchivoExcel;
import castellanos.joqsan.sistema_inventarios.orm.Producto;
import java.awt.HeadlessException;
import java.io.File;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MarcoFormProductos extends javax.swing.JFrame {
    
    //Todos los marcos o ventanas tienen un campo estatico para manipularlos desde fuera
    //Siempre que se llame a un marco debe hacerse con estos campos
    public static MarcoFormProductos m = null;

    //Si se recibe true se carga el registro que este guardado en el crud de la logica de productos
    public MarcoFormProductos(boolean cargar) throws Errores.ConexionException, Errores.IniciarEntidadException {
        
        initComponents();

        Utilidades.centrarMarco(this); //Se centra el marco
        setResizable(false); //Se fija un diseño fijo

        //Se inicia la logica de productos
        //La entidad Producto se inicia con su logica
        if(LogicaProductos.crud == null) {

            LogicaProductos.crud = new LogicaProductos();
        }

        //Tambien se inicia la logica de archivos de excel porque se necesitaran
        if(LogicaArchivosExcel.crud == null) {

            LogicaArchivosExcel.crud = new LogicaArchivosExcel();
        }

        //Se llama al metodo de cargar en caso de que se reciba true
        if(cargar) {

            cargar();
        }

        //Se inicia el array con todos los campos del formulario
        this.campos = new JTextField[] {

            textId, 
            textNombre, 
            textCategoria, 
            textStockMin, 
            textStockMax, 
            textStockIdeal, 
            textStockReorden, 
            textStockMaxPedido
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
        buttonExportarExcel = new javax.swing.JButton();
        buttonArchivosExcel = new javax.swing.JButton();

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

        buttonCargarExcel.setText("CARGAR EXCEL");
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

        buttonExportarExcel.setText("EXPORTAR EXCEL");
        buttonExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportarExcelActionPerformed(evt);
            }
        });

        buttonArchivosExcel.setText("ARCHIVOS EXCEL");
        buttonArchivosExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonArchivosExcelActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(buttonBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonActualizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonEliminar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(buttonCargarExcel)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonExportarExcel))))
                            .addComponent(buttonArchivosExcel))
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
                    .addComponent(buttonExportarExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonArchivosExcel)
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

        try {
            
            //Se cierran las entidades que ya no se van a utilizar
            Utilidades.cerrarEntidad(Producto.class);
            Utilidades.cerrarEntidad(ArchivoExcel.class);
            Utilidades.cerrarMarco(this);
            
        } catch (Errores.CerrarEntidadException ex) {
            
            Dialogos.d1(this, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaActionPerformed

        lista();
    }//GEN-LAST:event_buttonListaActionPerformed

    private void buttonCargarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCargarExcelActionPerformed

        cargarExcel();
    }//GEN-LAST:event_buttonCargarExcelActionPerformed

    private void buttonExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportarExcelActionPerformed
    
        exportarExcel();
    }//GEN-LAST:event_buttonExportarExcelActionPerformed

    private void buttonArchivosExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArchivosExcelActionPerformed
        
        archivosExcel();
    }//GEN-LAST:event_buttonArchivosExcelActionPerformed

    //Los metodos de los eventos llaman a sus metodos internos correspondientes
    //Todos los metodos tiene una estructura try catch para capturar errores
    
    //Este metodo inserta un registro en la base de datos de acuerdo a los datos del formulario
    private void insertar() {
        
        try {
            
            //Primero se verifica que no haya campos vacios
            if(Utilidades.obtenerCadena(textId) == null ||
               Utilidades.obtenerCadena(textNombre) == null) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se definen las variables a usar
            String id = Utilidades.obtenerCadena(textId);
            String nombre = Utilidades.obtenerCadena(textNombre);
            String categoria = "No definido";
            int stock_min = 0;
            int stock_max = 0;
            int stock_ideal = 0;
            int stock_reorden = 0;
            int stock_max_pedido = 0;
            
            //Se comprueba que no existan nulos y se fijan los valores
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
            
            //Se llama a la logica correspondiente para insertar el producto
            Producto producto = new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido);
            LogicaProductos.crud.setProducto(producto);
            LogicaProductos.crud.insertarProducto();
            LogicaProductos.crud.setProducto(null);
            Utilidades.limpiarCampos(campos, null); //Se limpian los campos despues de insertar el registro
            
            Dialogos.d3(this); //Se muestra un dialogo de confirmacion
            
        } catch(Errores.CamposVaciosException | Errores.InsertarProductoException | HeadlessException | NumberFormatException ex) {
            
            if(ex.getClass().equals(NumberFormatException.class)) {
                
                Dialogos.d2(this); //Se muestra un dialogo de error especifico
                
            } else {
               
                Dialogos.d1(this, ex); //Se muestra un dialogo de error general
            }  
        }
    }
    
    //Este metodo busca un registro de acuerdo al campo de id y lo muestra en el formulario
    private void buscar() {
        
        try {
            
            //Se verifica que el campo de id no este vacio
            if(Utilidades.obtenerCadena(textId) == null) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se fija la variable del id
            String id = Utilidades.obtenerCadena(textId);
            
            //Se llama a la logica para buscar el producto segun el id
            LogicaProductos.crud.buscarProducto(id);
            cargar(); //Se llama un metodo interno para cargar el registro en el formulario
            
        } catch(Errores.BuscarProductoException | Errores.CamposVaciosException ex) {
            
            Dialogos.d1(this, ex);
        }
    }
    
    //Este metodo actualiza un registro de dos maneras diferentes
    //Si se ha llamado al metodo de buscar primero, permite actualizar cualquier campo del registro
    //Si no se ha llamado al metodo de buscar primero, se utiliza el campo de id para actualizar
    private void actualizar() {
        
        try {
            
            //Se verifica que no haya valores nulos
            if(Utilidades.obtenerCadena(textId) == null ||
               Utilidades.obtenerCadena(textNombre) == null) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se definen las variables a usar
            String id = Utilidades.obtenerCadena(textId);
            String nombre = Utilidades.obtenerCadena(textNombre);
            String categoria = "No definido";
            int stock_min = 0;
            int stock_max = 0;
            int stock_ideal = 0;
            int stock_reorden = 0;
            int stock_max_pedido = 0;
            
            //Se fijan los valores del formulario en las variables
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

            //Se llama a la logica para actualizar el producto
            LogicaProductos.crud.actualizarProducto(new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido));
            Utilidades.limpiarCampos(campos, null); //Despues de actualizar se limpian los campos del formulario
            LogicaProductos.crud.setProducto(null);
            
            Dialogos.d4(this); //Se muestra un dialogo de confirmacion
            
        } catch(Errores.ActualizarProductoException | Errores.CamposVaciosException | HeadlessException | NumberFormatException ex) {
            
            if(ex.getClass().equals(NumberFormatException.class)) {
                
                Dialogos.d5(this);
                
            } else {
               
                Dialogos.d1(this, ex);
            } 
        } 
    }
    
    //Este metodo permite eliminar un registro en base a su id
    private void eliminar() {
        
        try {
            
            //Se verifica que el campo de id no sea vacio
            if(Utilidades.obtenerCadena(textId) == null) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se fija la variable del id
            String id = Utilidades.obtenerCadena(textId);
            
            //Se llama a la logica para eliminar el producto
            LogicaProductos.crud.eliminarProducto(id);
            Utilidades.limpiarCampos(campos, null); //Se limpian los campos del formulario despues de eliminar
            LogicaProductos.crud.setProducto(null);
            
            Dialogos.d6(this); //Se muestra un dialogo de confirmacion
            
        } catch(Errores.CamposVaciosException | Errores.EliminarProductoException | HeadlessException ex) {
            
            Dialogos.d1(this, ex);
        }
    }
    
    //Este metodo permite tomar un archivo excel y cargarlo de dos maneras diferentes
    //Si existen archivos guardados internamente, pregunta si se desea usar uno de ellos
    //Si no existen archivos guardados internamente, se abre un chooser para seleccionarlo
    //Aunque existan archivos, si el usuario no acepta usar uno guarado, se abre tambien el chooser
    private void cargarExcel() {

        try {
            
            File carpeta = new File("storage/excel/productos"); //Se guarda la carpeta
            
            //Se verifica que exista la carpeta con los archivos guardados
            if(carpeta.exists()) {
            
                File[] archivos = carpeta.listFiles(); //Se crea un array con los archivos

                if(archivos != null && archivos.length > 0) { //Se verifica que la carpeta no este vacia

                    int op = Dialogos.d7(this);

                    if(op == JOptionPane.YES_OPTION) { //Si se presiona yes

                        JComboBox combo = new JComboBox(); //Se usa un combo para elegir las opciones

                        for (File each: archivos) {

                            combo.addItem(each.getName()); //Se agrega un item por cada archivo de la carpeta
                        }

                        if(Dialogos.d8(this, combo) == JOptionPane.OK_CANCEL_OPTION) {

                            return;
                        }

                        //Se llama a la logica para cargar el archivo excel
                        LogicaProductos.crud.cargarExcel(archivos[combo.getSelectedIndex()], 0);
                        
                        Dialogos.d9(this); //Se muestra un dialogo de confirmacion
                        
                        return; //Se termina el metodo porque ya no hay nada mas que hacer
                        
                    } else if(op == JOptionPane.CANCEL_OPTION) {

                        return; //Si el usuario cancela el chooser se termina el metodo
                    }
                }
            }
            
            //Si se elije que no, no existe la carpeta o esta vacia
            //Se llama a la clase Copiador para agregar el archivo al almacenamiento interno
            LogicaArchivosExcel.Copiador copiador = new LogicaArchivosExcel.Copiador();
            
            //Los metodos del copiador deben ejecutarse en cadena, cada uno debe regresar true para ejecutar el siguiente
            if(copiador.elegirOrigen("xlsx", this)) { //Se elige el origen y se verifica que la extension sea la correcta
                
                if(copiador.getRutaOrigen() == null) {
                    
                    return; //En caso de que el usuario cancele el chooser se termina el metodo
                }
                
                //Se crea un combo para opciones
                JComboBox combo = new JComboBox();
                combo.addItem("Reemplazar");
                combo.addItem("Agregar");
                int opcion = 0; //Por defecto se fija el valor 0

                //Se llama al dialogo y se verifica que se presione ok
                if(Dialogos.d10(this, combo) == JOptionPane.OK_OPTION) {

                    if(combo.getSelectedItem().equals("Agregar")) {

                        opcion = 1; //Si se elige la opcion de agregar se fija el valor 1
                    }

                } else {

                    return; //En caso de que el dialogo se cancele se termina el metodo
                }
                     
                //La opcion 0 indica que los registros del excel reemplazaran por completo a la tabla existente
                //La opcion 1 indica que los registros del excel se agregaran a los registros ya existentes de la tabla
                //Se llama a la logica para cargar el archivo excel
                LogicaProductos.crud.cargarExcel(new File(copiador.getRutaOrigen()), opcion);
                
                Dialogos.d11(this); //Se muestra un dialogo de confirmacion
                        
                if(Dialogos.d12(this) == JOptionPane.YES_NO_OPTION) { //Si se presiona que si
                        
                    //Si los metodos del copiador te regresan false entonces se lanza un error del copiador
                    if(!copiador.elegirDestino("excel/productos", new File(copiador.getRutaOrigen()).getName()) || !copiador.copiar()) {
                        
                        throw new Errores.CopiadorException("Error de copiado de archivo", null); 
                    }
                    
                    //Se llama a la logica para guardar el archivo excel
                    LogicaArchivosExcel.crud.setExcel(new ArchivoExcel(

                        new File(copiador.getRutaOrigen()).getName(),
                        "Productos"
                    ));
                                        
                    LogicaArchivosExcel.crud.insertarArchivoExcel();
                    
                    Dialogos.d13(this); //Se muestra dialogo de confirmacion
                }
                
            } else {
                
                //Si la extension no corresponde se muestra un error
                throw new Errores.ArchivoIncorrectoException("Archivo incorrecto", null);
            }
            //Si se presiona no o no existe la carpeta excel/productos
            /*JFileChooser chooser = new JFileChooser();
            
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

                        if(JOptionPane.showConfirmDialog(this, combo, "Elija una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {

                            if(combo.getSelectedItem().equals("Agregar")) {

                                opcion = 1;
                            }

                        } else {

                            return;
                        }
                        
                        LogicaProductos.crud.cargarExcel(new File(ruta), opcion);
                        JOptionPane.showMessageDialog(this, "Carga de Excel exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                        
                        if(JOptionPane.showConfirmDialog(null, "¿Copiar el archivo?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION) {
                            
                            Copiador copiador = new Copiador();
                            copiador.setRutaOrigen(ruta);
                            copiador.setRutaDestino("excel/" + new File(ruta).getName());
                            
                            if(!copiador.copiar()) {
                                
                                throw new Errores.CopiadorException("Error de copiado de archivo");
                            }
                            
                            if(LogicaArchivosExcel.crud == null) {

                                LogicaArchivosExcel.crud = new LogicaArchivosExcel();
                            }
                            
                            LogicaArchivosExcel.crud.setExcel(new ArchivoExcel(
                                    
                                new File(ruta).getName(),
                                "Productos"
                            ));
                            LogicaArchivosExcel.crud.insertarArchivoExcel();
                            
                            JOptionPane.showMessageDialog(this, "Copia de Excel exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                            ArchivoExcel.cerrar();
                        }
                        
                        return;
                    }
                }
                
                throw new Errores.ArchivoIncorrectoException("Error de archivo incorrecto");
            }*/
            
        } catch (Errores.ArchivoIncorrectoException | Errores.CargarExcelException | Errores.CopiadorException | Errores.InsertarArchivoExcelException | HeadlessException ex) {
            
            Dialogos.d1(this, ex);
        }
    }
    
    //Este metodo permite tomar la tabla y exportarla a un archivo excel
    private void exportarExcel() {
        
        try {
            
            //Se crea un panel con etiqueta y campo
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Nota: Si ya existe será reemplazado"));
            panel.add(Box.createVerticalStrut(10));
            JTextField tf = new JTextField("Productos.xlsx");
            panel.add(tf);
            
            //Se muestra un dialogo con el panel creado anteriormente
            if(Dialogos.d14(this, panel) == JOptionPane.CANCEL_OPTION) {
                
                return;
            }
            
            //Se fija el nombre a utilizar para crear el archivo
            //En caso de que se ingrese un nombre que ya existe, el archivo reemplazara al anterior
            String nombre = tf.getText().trim();
            
            //Se verifica si se escribio la extension, si no, se agrega
            if(!nombre.endsWith(".xlsx")) {
                
                nombre += ".xlsx";
            }
            
            //Se guarda la carpeta donde se tiene que guardar el archivo exportado
            File carpeta = new File("storage/excel/productos"); //Es la misma carpeta de almacenamiento interno
            
            if(!carpeta.exists()) { //Si no existe la carpeta se debe de crear
                
                carpeta.mkdirs(); 
            }
            
            //Se llama a la logica para exportar el archivo
            LogicaProductos.crud.exportarExcel(new File("storage/excel/productos/" + nombre), "Productos");
            
        } catch(Errores.ExportarExcelException | HeadlessException ex) {
            
            Dialogos.d1(this, ex);
        }
    }
    
    //ESte metodo permite llamar a otra venta que muestra los archivos excel del almacenamiento interno
    private void archivosExcel() {
        
        try {
            
            //Se crea y se ejecuta el marco correspondiente
            MarcoArchivosExcel.m = new MarcoArchivosExcel();
            Utilidades.ejecutarMarco(MarcoArchivosExcel.m);
            Utilidades.cerrarMarco(this);
            
        } catch(Errores.CargarArchivosExcelException | Errores.IniciarEntidadException ex) {
            
            Dialogos.d1(this, ex);
        }
    }
    
    //Este metodo permite llamar a la ventana para mostrar los registros de la tabla en una lista
    private void lista() {
        
        try {
            
            //Se crea y se ejecuta el marco
            MarcoListaProductos.m = new MarcoListaProductos();
            Utilidades.ejecutarMarco(MarcoListaProductos.m);
            Utilidades.cerrarMarco(this);
            
        } catch(Errores.CargarListaProductosException | Errores.IniciarEntidadException ex) {
            
            Dialogos.d1(this, ex);
        }
    }
    
    //Este metodo privado simplemente permite cargar un registro en el formulario
    //Se llama cuando se busca un archivo y tambien cuando se inicia el marco con el atributo true
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
    
    private JTextField[] campos = null; //Se guardan los campos en un array para manipularlos mas facilmente
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonArchivosExcel;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonCargarExcel;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonExportarExcel;
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