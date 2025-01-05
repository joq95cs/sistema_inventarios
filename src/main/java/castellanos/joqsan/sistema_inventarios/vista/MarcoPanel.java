
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.Errores;

public class MarcoPanel extends javax.swing.JFrame {
    
    public static MarcoPanel m = null;

    public MarcoPanel() {
        
        initComponents();
        Utilidades.centrarMarco(this);
        setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonM1 = new javax.swing.JButton();
        buttonM2 = new javax.swing.JButton();
        buttonM3 = new javax.swing.JButton();
        buttonM4 = new javax.swing.JButton();
        buttonM5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel");

        buttonM1.setText("MarcoLogin");
        buttonM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonM1ActionPerformed(evt);
            }
        });

        buttonM2.setText("MarcoFormProductos");
        buttonM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonM2ActionPerformed(evt);
            }
        });

        buttonM3.setText("MarcoListaProductos");
        buttonM3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonM3ActionPerformed(evt);
            }
        });

        buttonM4.setText("MarcoObsProductos");
        buttonM4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonM4ActionPerformed(evt);
            }
        });

        buttonM5.setText("MarcoHome");
        buttonM5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonM5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonM3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonM4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonM5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonM1)
                .addGap(18, 18, 18)
                .addComponent(buttonM2)
                .addGap(18, 18, 18)
                .addComponent(buttonM3)
                .addGap(18, 18, 18)
                .addComponent(buttonM4)
                .addGap(18, 18, 18)
                .addComponent(buttonM5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonM1ActionPerformed

        try {
            
            MarcoLogin.m = new MarcoLogin();
            Utilidades.ejecutarMarco(MarcoLogin.m);
            Utilidades.cerrarMarco(this);
                    
        } catch(Errores.ConexionException | Errores.LookAndFeelException ex) {
            
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonM1ActionPerformed

    private void buttonM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonM2ActionPerformed
    
        try {
            
            MarcoFormProductos.m = new MarcoFormProductos(false);
            Utilidades.ejecutarMarco(MarcoFormProductos.m);
            Utilidades.cerrarMarco(this);
                    
        } catch(Errores.ConexionException | Errores.LookAndFeelException ex) {
            
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonM2ActionPerformed

    private void buttonM3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonM3ActionPerformed
        
        try {
            
            MarcoListaProductos.m = new MarcoListaProductos();
            Utilidades.ejecutarMarco(MarcoListaProductos.m);
            Utilidades.cerrarMarco(this);
                    
        } catch(Errores.ConexionException | Errores.ListaException | Errores.LookAndFeelException ex) {
            
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonM3ActionPerformed

    private void buttonM4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonM4ActionPerformed
      
        try {
            
            MarcoObsProductos.m = new MarcoObsProductos();
            Utilidades.ejecutarMarco(MarcoObsProductos.m);
            Utilidades.cerrarMarco(this);
                    
        } catch(Errores.ConexionException ex) {
            
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonM4ActionPerformed

    private void buttonM5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonM5ActionPerformed
      
        try {
            
            MarcoHome.m = new MarcoHome();
            Utilidades.ejecutarMarco(MarcoHome.m);
            Utilidades.cerrarMarco(this);
                    
        } catch(Errores.LookAndFeelException ex) {
            
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonM5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonM1;
    private javax.swing.JButton buttonM2;
    private javax.swing.JButton buttonM3;
    private javax.swing.JButton buttonM4;
    private javax.swing.JButton buttonM5;
    // End of variables declaration//GEN-END:variables
}
