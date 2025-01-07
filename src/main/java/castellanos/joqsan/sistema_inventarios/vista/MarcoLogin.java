
package castellanos.joqsan.sistema_inventarios.vista;

import castellanos.joqsan.sistema_inventarios.logica.Errores;
import castellanos.joqsan.sistema_inventarios.logica.LogicaLogin;
import castellanos.joqsan.sistema_inventarios.orm.Usuario;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class MarcoLogin extends javax.swing.JFrame {
    
    public static MarcoLogin m = null;

    public MarcoLogin() {
        
        initComponents();
        Utilidades.centrarMarco(this);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        buttonLogin = new javax.swing.JButton();
        textPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        labelUsername.setText("Username");

        labelPassword.setText("Password");

        textUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textUsernameKeyPressed(evt);
            }
        });

        buttonLogin.setText("INICIAR SESIÓN");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        textPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsername)
                    .addComponent(labelPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonLogin)
                    .addComponent(textUsername)
                    .addComponent(textPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername)
                    .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        login();
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void textUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textUsernameKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            login();
        }
    }//GEN-LAST:event_textUsernameKeyPressed

    private void textPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPasswordKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            login();
        }
    }//GEN-LAST:event_textPasswordKeyPressed
    
    private void login() {
        
        try {
            
            String username = textUsername.getText();
            String password = textPassword.getText();
            
            if(username.isEmpty() || password.isEmpty()) {
                
                throw new Errores.CamposVaciosException();
            }

            LogicaLogin login = new LogicaLogin(username, password);
        
            if(login.usuarioValido()) {
                
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                Utilidades.cerrarMarco(this);
                MarcoHome.m = new MarcoHome();
                Utilidades.ejecutarMarco(MarcoHome.m);
                
            } else {
                
                throw new Errores.LoginException("Usuario o contraseña incorrectos");
            }
            
        } catch (Errores.CamposVaciosException | Errores.ConexionException | Errores.LoginException | Errores.LookAndFeelException | Errores.UsuarioValidoException | HeadlessException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            if(Usuario.session != null) {
                
                Usuario.cerrar();
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}