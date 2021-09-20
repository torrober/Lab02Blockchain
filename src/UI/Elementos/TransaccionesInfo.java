/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Elementos;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author guest
 */
public class TransaccionesInfo extends javax.swing.JPanel {

    /**
     * Creates new form TransferenciaInfo
     */
    public TransaccionesInfo(double valor, String idTransaccion) {
        initComponents();
        jLabel1.setText("Transacción - " + idTransaccion);
        NumberFormat formatter = new DecimalFormat("#0.000");
        jLabel2.setText("$" + formatter.format(valor));
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tRButton1 = new ComponentesUI.TRButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tRShadowPane1.setBackground(new java.awt.Color(255, 255, 255));
        tRShadowPane1.setBorderRadius(30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8_currency_exchange_48px.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Transacción - ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("$10.000");

        tRButton1.setBackground(new java.awt.Color(245, 127, 23));
        tRButton1.setText("Ver resumen");
        tRButton1.setBorderRadius(10);
        tRButton1.setColor(new java.awt.Color(245, 127, 23));

        javax.swing.GroupLayout tRShadowPane1Layout = new javax.swing.GroupLayout(tRShadowPane1);
        tRShadowPane1.setLayout(tRShadowPane1Layout);
        tRShadowPane1Layout.setHorizontalGroup(
            tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tRShadowPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(tRButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        tRShadowPane1Layout.setVerticalGroup(
            tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tRShadowPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tRShadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addGroup(tRShadowPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(tRButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tRShadowPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tRShadowPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private ComponentesUI.TRButton tRButton1;
    private ComponentesUI.TRShadowPane tRShadowPane1;
    // End of variables declaration//GEN-END:variables
}
