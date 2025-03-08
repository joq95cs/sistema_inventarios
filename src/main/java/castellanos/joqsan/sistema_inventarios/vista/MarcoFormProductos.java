
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.LogicaProductos;
import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.orm.Producto;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
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

        //Se llama al metodo de cargar en caso de que se reciba true
        if(cargar) {

            cargar();
        }

        //Se inicia el array con todos los campos del formulario
        this.campos = new JTextField[] {

            textStockMax, 
            textId, 
            textNombre, 
            textCategoria, 
            textStockMin, 
            textStockIdeal, 
            textStockReorden, 
            textStockMaxPedido
        }; 
        
        //Texto del area
        areaNotas.append("NOTAS\n");
        areaNotas.append("* Esto es una nota...\n");
        areaNotas.append("** Esto es una nota...\n\n");
        areaNotas.append("ATAJOS\n");
        areaNotas.append("CTRL+I: Insertar\n");
        areaNotas.append("CTRL+B: Buscar\n");
        areaNotas.append("CTRL+A: Actualizar\n");
        areaNotas.append("CTRL+E: Eliminar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        labelStockReorden = new javax.swing.JLabel();
        textStockIdeal = new javax.swing.JTextField();
        labelStockIdeal = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textStockMax = new javax.swing.JTextField();
        labelStockMin = new javax.swing.JLabel();
        labelStockMax = new javax.swing.JLabel();
        textStockMin = new javax.swing.JTextField();
        labelId = new javax.swing.JLabel();
        textStockReorden = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textCategoria = new javax.swing.JTextField();
        textStockMaxPedido = new javax.swing.JTextField();
        textId = new javax.swing.JTextField();
        labelStockMaxPedido = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        areaNotas = new javax.swing.JTextArea();
        panel3 = new javax.swing.JPanel();
        buttonInsertar = new javax.swing.JButton();
        buttonActualizar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonBuscar = new javax.swing.JButton();
        buttonLista = new javax.swing.JButton();
        buttonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Formulario Productos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelStockReorden.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelStockReorden.setText("Stock Reorden*");

        textStockIdeal.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textStockIdeal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textStockIdealKeyPressed(evt);
            }
        });

        labelStockIdeal.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelStockIdeal.setText("Stock Ideal");

        labelCategoria.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelCategoria.setText("Categoría");

        labelNombre.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        labelNombre.setText("Nombre");

        textStockMax.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textStockMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textStockMaxKeyPressed(evt);
            }
        });

        labelStockMin.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelStockMin.setText("Stock Mínimo");

        labelStockMax.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelStockMax.setText("Stock Máximo");

        textStockMin.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textStockMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textStockMinKeyPressed(evt);
            }
        });

        labelId.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelId.setText("ID (Clave)");

        textStockReorden.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textStockReorden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textStockReordenKeyPressed(evt);
            }
        });

        textNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNombreKeyPressed(evt);
            }
        });

        textCategoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCategoriaKeyPressed(evt);
            }
        });

        textStockMaxPedido.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textStockMaxPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textStockMaxPedidoKeyPressed(evt);
            }
        });

        textId.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textIdKeyPressed(evt);
            }
        });

        labelStockMaxPedido.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelStockMaxPedido.setText("Stock Máximo Pedido**");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(labelStockMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addComponent(labelStockMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addComponent(labelId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStockReorden)
                            .addComponent(labelNombre)
                            .addComponent(labelStockMaxPedido)
                            .addComponent(labelStockIdeal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textStockMaxPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textStockReorden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textStockIdeal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addComponent(labelCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelId))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCategoria))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStockMin))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStockMax))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStockIdeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStockIdeal))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStockReorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStockReorden))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStockMaxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStockMaxPedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        areaNotas.setEditable(false);
        areaNotas.setColumns(20);
        areaNotas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        areaNotas.setRows(5);
        scroll1.setViewportView(areaNotas);

        buttonInsertar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonInsertar.setText("INSERTAR");
        buttonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertarActionPerformed(evt);
            }
        });

        buttonActualizar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonActualizar.setText("ACTUALIZAR");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        buttonEliminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonEliminar.setText("ELIMINAR");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonBuscar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonBuscar.setText("BUSCAR");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        buttonLista.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonLista.setText("LISTA");
        buttonLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListaActionPerformed(evt);
            }
        });

        buttonVolver.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buttonVolver.setText("VOLVER");
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonActualizar)
                    .addComponent(buttonLista, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLista, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try {
            
            //Se cierran las entidades que ya no se van a utilizar
            Utilidades.cerrarEntidad(Producto.class);
            Utilidades.cerrarMarco(this);
            
        } catch (Errores.CerrarEntidadException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertarActionPerformed

        insertar();
    }//GEN-LAST:event_buttonInsertarActionPerformed

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed

        actualizar();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
      
        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
       
        buscar();
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaActionPerformed
       
        lista();
    }//GEN-LAST:event_buttonListaActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed

        
    }//GEN-LAST:event_buttonVolverActionPerformed

    private void textIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textIdKeyPressed
        
        atajo(evt);
    }//GEN-LAST:event_textIdKeyPressed

    private void textNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNombreKeyPressed
       
        atajo(evt);
    }//GEN-LAST:event_textNombreKeyPressed

    private void textCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCategoriaKeyPressed
        
        atajo(evt);
    }//GEN-LAST:event_textCategoriaKeyPressed

    private void textStockMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textStockMinKeyPressed
        
        atajo(evt);
    }//GEN-LAST:event_textStockMinKeyPressed

    private void textStockMaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textStockMaxKeyPressed
       
        atajo(evt);
    }//GEN-LAST:event_textStockMaxKeyPressed

    private void textStockIdealKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textStockIdealKeyPressed
       
        atajo(evt);
    }//GEN-LAST:event_textStockIdealKeyPressed

    private void textStockReordenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textStockReordenKeyPressed
     
        atajo(evt);
    }//GEN-LAST:event_textStockReordenKeyPressed

    private void textStockMaxPedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textStockMaxPedidoKeyPressed
      
        atajo(evt);
    }//GEN-LAST:event_textStockMaxPedidoKeyPressed

    //Los metodos de los eventos llaman a sus metodos internos correspondientes
    //Todos los metodos tiene una estructura try catch para capturar errores
    
    //Este metodo inserta un registro en la base de datos de acuerdo a los datos del formulario
    private void insertar() {
        
        try {
            
            //Se declaran y obtienen los campos obligatorios
            //El metodo para obtener cadenas regresa null si estan vacias o en blanco
            String id = Utilidades.obtenerCadena(textId); //No puede ser vacio
            String nombre = Utilidades.obtenerCadena(textNombre); //No puede ser vacio
            
            if(id == null || nombre == null) { //Se verifica que no haya nulos
                
                //Si hay campos vacios se lanza el error
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se declaran los campos no obligatorios y se les asigna el valor por defecto
            String categoria = "No definido";
            int stock_min = 0;
            int stock_max = 0;
            int stock_ideal = 0;
            int stock_reorden = 0;
            int stock_max_pedido = 0;
            
            //Se comprueba que no haya cadenas vacias
            if(Utilidades.obtenerCadena(textCategoria) != null) {
                
                categoria = Utilidades.obtenerCadena(textCategoria);
            }
            
            //Se verifica que no se hayan ingresado cadenas en los campos numericos
            if(Utilidades.obtenerCadena(textStockMin) != null) {
                
                stock_min = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockMin));
            }
            
            if(Utilidades.obtenerCadena(textStockMax) != null) {
                
                stock_max = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockMax));
            }
            
            if(Utilidades.obtenerCadena(textStockIdeal) != null) {
                
                stock_ideal = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockIdeal));
            }
            
            if(Utilidades.obtenerCadena(textStockReorden) != null) {
                
                stock_reorden = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockReorden));
            }
            
            if(Utilidades.obtenerCadena(textStockMaxPedido) != null) {
                
                stock_max_pedido = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockMaxPedido));
            }
            
            //Se llama a la logica correspondiente para insertar el producto
            Producto producto = new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido);
            LogicaProductos.crud.setProducto(producto);
            LogicaProductos.crud.insertarProducto();
            LogicaProductos.crud.setProducto(null);
            Utilidades.limpiarCampos(campos, null); //Se limpian los campos despues de insertar el registro
            
            Dialogos.d_clave(this, "insercion_productos"); //Se muestra un dialogo de confirmacion
            
        } catch(Errores.CadenaIngresadaException | Errores.CamposVaciosException | Errores.InsertarProductoException | NumberFormatException ex) {
                        
            Dialogos.d_error(this, ex); //Se muestra un dialogo de error general
        }
    }
    
    //Este metodo busca un registro de acuerdo al campo de id y lo muestra en el formulario
    private void buscar() {
        
        try {
            
            //Primero se obtiene el campo de id obligatorio
            String id = Utilidades.obtenerCadena(textId);
            
            //Se verifica que el campo de id no este vacio
            if(id == null) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se llama a la logica para buscar el producto segun el id
            LogicaProductos.crud.buscarProducto(id);
            cargar(); //Se llama un metodo interno para cargar el registro en el formulario
            
        } catch(Errores.BuscarProductoException | Errores.CamposVaciosException ex) {
            
            Dialogos.d_error(this, ex);
        }
    }
    
    //Este metodo actualiza un registro de dos maneras diferentes
    //Si se ha llamado al metodo de buscar primero, permite actualizar cualquier campo del registro
    //Si no se ha llamado al metodo de buscar primero, se utiliza el campo de id para actualizar
    private void actualizar() {
        
        try {
            
            //Primero se declaran y obtienen los valores obligatorios
            String id = Utilidades.obtenerCadena(textId);
            String nombre = Utilidades.obtenerCadena(textNombre);
            
            //Se verifica que no haya cadenas vacias
            if(id == null || nombre == null) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
            
            //Se declaran y se definen los valores por defecto del resto de campos
            String categoria = "No definido";
            int stock_min = 0;
            int stock_max = 0;
            int stock_ideal = 0;
            int stock_reorden = 0;
            int stock_max_pedido = 0;
            
            //Se verifica que no haya cadenas vacias
            if(Utilidades.obtenerCadena(textCategoria) != null) {
                
                categoria = Utilidades.obtenerCadena(textCategoria);
            }
            
            //Se verifica que no haya cadenas en los valores numericos
            if(Utilidades.obtenerCadena(textStockMin) != null) {
                
                stock_min = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockMin));
            }
            
            if(Utilidades.obtenerCadena(textStockMax) != null) {
                
                stock_max = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockMax));
            }
            
            if(Utilidades.obtenerCadena(textStockIdeal) != null) {
                
                stock_ideal = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockIdeal));
            }
            
            if(Utilidades.obtenerCadena(textStockReorden) != null) {
                
                stock_reorden = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockReorden));
            }
            
            if(Utilidades.obtenerCadena(textStockMaxPedido) != null) {
                
                stock_max_pedido = Utilidades.obtenerEntero(Utilidades.obtenerCadena(textStockMaxPedido));
            }

            //Se llama a la logica para actualizar el producto
            LogicaProductos.crud.actualizarProducto(new Producto(id, nombre, categoria, stock_min, stock_max, stock_ideal, stock_reorden, stock_max_pedido));
            Utilidades.limpiarCampos(campos, null); //Despues de actualizar se limpian los campos del formulario
            LogicaProductos.crud.setProducto(null);
            
            Dialogos.d_clave(this, "actualizacion_productos"); //Se muestra un dialogo de confirmacion
            
        } catch(Errores.ActualizarProductoException | Errores.CadenaIngresadaException | Errores.CamposVaciosException ex) {
            
            Dialogos.d_error(this, ex);
        } 
    }
    
    //Este metodo permite eliminar un registro en base a su id
    private void eliminar() {
        
        try {
            
            //Se declara el campo obligatorio de id
            String id = Utilidades.obtenerCadena(textId);
            
            //Se verifica que no sea vacio
            if(id == null) {
                
                throw new Errores.CamposVaciosException("Error de campos vacíos", null);
            }
                       
            //Se llama a la logica para eliminar el producto
            LogicaProductos.crud.eliminarProducto(id);
            Utilidades.limpiarCampos(campos, null); //Se limpian los campos del formulario despues de eliminar
            LogicaProductos.crud.setProducto(null);
            
            Dialogos.d_clave(this, "eliminacion_productos"); //Se muestra un dialogo de confirmacion
            
        } catch(Errores.CamposVaciosException | Errores.EliminarProductoException | HeadlessException ex) {
            
            Dialogos.d_error(this, ex);
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
            
            Dialogos.d_error(this, ex);
        }
    }
    
    //Este metodo se llama para cargar un registro en el formulario
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
    
    private void atajo(KeyEvent evt) {
        
        if(evt.isControlDown()) {
            
            switch (evt.getKeyCode()) {
                
                case KeyEvent.VK_I -> insertar();
                case KeyEvent.VK_B -> buscar();
                case KeyEvent.VK_A -> actualizar();
                case KeyEvent.VK_E -> eliminar();
            }
        }
    }
    
    //Metodo main que permite ejecutar el formulario directamente
    public static void main(String[] args) {
        
        try {
            
            Utilidades.setLookAndFeel();
            m = new MarcoFormProductos(false);
            Utilidades.ejecutarMarco(m);
        
        } catch(Errores.ConexionException | Errores.IniciarEntidadException | Errores.LookAndFeelException ex) {
            
            Dialogos.d_error(m, ex);
        }
    }
    
    private JTextField[] campos = null; //Se guardan los campos en un array para manipularlos mas facilmente
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaNotas;
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonInsertar;
    private javax.swing.JButton buttonLista;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelStockIdeal;
    private javax.swing.JLabel labelStockMax;
    private javax.swing.JLabel labelStockMaxPedido;
    private javax.swing.JLabel labelStockMin;
    private javax.swing.JLabel labelStockReorden;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JScrollPane scroll1;
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