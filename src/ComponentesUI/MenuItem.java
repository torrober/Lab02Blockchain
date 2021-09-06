/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesUI;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.Icon;
import javax.swing.JLabel;
/**
 *
 * @author guest
 */
public class MenuItem extends javax.swing.JPanel {

    /**
     * Creates new form MenuItem
     */

    public MenuItem() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public Icon getIcon() {
        return icon.getIcon();
    }

    public void setIcon(Icon i) {
        icon.setIcon(i);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public void setItemName(String name) {
        itemName.setText(name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        itemName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8_home_24px.png"))); // NOI18N

        itemName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        itemName.setForeground(new java.awt.Color(249, 168, 37));
        itemName.setText("Menu Item");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon)
                .addGap(18, 18, 18)
                .addComponent(itemName, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(itemName, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel itemName;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
