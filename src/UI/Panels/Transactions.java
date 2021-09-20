/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Panels;

import UI.Elementos.HeaderTransacciones;
import UI.Elementos.TransaccionesInfo;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author guest
 */
public class Transactions extends javax.swing.JPanel {

    /**
     * Creates new form Transactions
     */
    public Transactions() {
        initComponents();
        jPanel1.setLayout(new MigLayout("fillx"));
        jPanel1.add(new HeaderTransacciones(), "wrap, w 572");
        jPanel1.setBackground(Color.white);
        jPanel1.repaint();
        jPanel1.revalidate();
        addTransaction(new TransaccionesInfo(14.400, "huy90384y2023"));
        addTransaction(new TransaccionesInfo(14.400, "huy90384y2023"));
        addTransaction(new TransaccionesInfo(14.400, "huy90384y2023"));
        addTransaction(new TransaccionesInfo(14.400, "huy90384y2023"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        jLayeredPane1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 602, 530));

        add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void addTransaction(TransaccionesInfo transaccionesInfo) {
        jPanel1.add(transaccionesInfo, "wrap, w 572");
        jPanel1.setBackground(Color.white);
        jPanel1.repaint();
        jPanel1.revalidate();
    }
}
