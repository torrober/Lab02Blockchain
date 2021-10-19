/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Objetos.Transaccion;
import Objetos.Usuario;
import static Objetos.Usuario.getUsuarioByWalletID;
import java.util.Base64;
import java.awt.Color;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest
 */
public class NewTransaction extends javax.swing.JFrame {

    private int mouseX;
    private Usuario a;

    /**
     * Creates new form NewTransaction
     */
    public NewTransaction(Usuario u) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        this.a = u;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tRShadowPane1 = new ComponentesUI.TRShadowPane();
        tRShadowPane2 = new ComponentesUI.TRShadowPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tRTextField1 = new ComponentesUI.TRTextField();
        tRTextField2 = new ComponentesUI.TRTextField();
        jLabel5 = new javax.swing.JLabel();
        tRButton1 = new ComponentesUI.TRButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tRShadowPane1.setBackground(new java.awt.Color(255, 255, 255));
        tRShadowPane1.setBorderRadius(30);
        tRShadowPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tRShadowPane1MouseDragged(evt);
            }
        });
        tRShadowPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tRShadowPane1MousePressed(evt);
            }
        });

        tRShadowPane2.setBackground(new java.awt.Color(245, 127, 23));
        tRShadowPane2.setBorderRadius(30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nueva transacción");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8_delete_24px_white.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SwingPay");

        javax.swing.GroupLayout tRShadowPane2Layout = new javax.swing.GroupLayout(tRShadowPane2);
        tRShadowPane2.setLayout(tRShadowPane2Layout);
        tRShadowPane2Layout.setHorizontalGroup(
            tRShadowPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tRShadowPane2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tRShadowPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(251, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tRShadowPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30))
        );
        tRShadowPane2Layout.setVerticalGroup(
            tRShadowPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tRShadowPane2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8_wallet_24px.png"))); // NOI18N

        tRTextField1.setPlaceholder("ID de billetera");
        tRTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tRTextField1ActionPerformed(evt);
            }
        });

        tRTextField2.setPlaceholder("Valor de la transferencia");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8_currency_exchange_24px.png"))); // NOI18N

        tRButton1.setText("Realizar transacción");
        tRButton1.setBorderRadius(10);
        tRButton1.setColor(new java.awt.Color(245, 127, 23));
        tRButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tRButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tRShadowPane1Layout = new javax.swing.GroupLayout(tRShadowPane1);
        tRShadowPane1.setLayout(tRShadowPane1Layout);
        tRShadowPane1Layout.setHorizontalGroup(
            tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tRShadowPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tRShadowPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tRShadowPane1Layout.createSequentialGroup()
                        .addGroup(tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tRTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tRTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tRButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        tRShadowPane1Layout.setVerticalGroup(
            tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tRShadowPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tRShadowPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tRTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tRTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addComponent(tRButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tRShadowPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tRShadowPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked
    int mouseY;
    private void tRShadowPane1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tRShadowPane1MouseDragged
        // TODO add your handling code here:
        this.setLocation(evt.getXOnScreen() - mouseX, evt.getYOnScreen() - mouseY);
    }//GEN-LAST:event_tRShadowPane1MouseDragged

    private void tRShadowPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tRShadowPane1MousePressed
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_tRShadowPane1MousePressed

    private void tRButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tRButton1ActionPerformed

        try {
            a.getBilletera().setSaldo(a.getBilletera().saldo - Float.parseFloat(tRTextField2.getText()));
            Usuario user = getUsuarioByWalletID(tRTextField1.getText());
            System.out.println(user.getBilletera().saldo);
            user.getBilletera().setSaldo(user.getBilletera().saldo + Float.parseFloat(tRTextField2.getText()));
            System.out.println("Nuevo Saldo prueba2" + user.getBilletera().saldo);
            System.out.println("Nuevo Saldo prueba1" + a.getBilletera().saldo);
            Transaccion tr = new Transaccion(a.getBilletera().id, tRTextField1.getText(), Float.parseFloat(tRTextField2.getText()));
        } catch (IOException ex) {
            Logger.getLogger(NewTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tRButton1ActionPerformed

    private void tRTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tRTextField1ActionPerformed

    }//GEN-LAST:event_tRTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private ComponentesUI.TRButton tRButton1;
    private ComponentesUI.TRShadowPane tRShadowPane1;
    private ComponentesUI.TRShadowPane tRShadowPane2;
    private ComponentesUI.TRTextField tRTextField1;
    private ComponentesUI.TRTextField tRTextField2;
    // End of variables declaration//GEN-END:variables
}
