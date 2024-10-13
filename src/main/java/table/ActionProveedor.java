package table;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionProveedor extends javax.swing.JPanel {

    public ActionProveedor() {
        initComponents();
    }
    
    
    public void initEvent(TableActionEventProveedor eventProveedor, int row) {
        cmdEditProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eventProveedor.onEditProveedor(row);
            }
        });
        cmdDeleteProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eventProveedor.onDeleteProveedor(row);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(230, 230, 230));
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmdDeleteProveedor = new modelo.MyButton();
        cmdEditProveedor = new modelo.MyButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cmdDeleteProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        cmdDeleteProveedor.setClickEnabled(true);
        cmdDeleteProveedor.setColorClick(new java.awt.Color(230, 230, 230));
        cmdDeleteProveedor.setRadius(50);
        cmdDeleteProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteProveedorActionPerformed(evt);
            }
        });

        cmdEditProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        cmdEditProveedor.setClickEnabled(true);
        cmdEditProveedor.setColorClick(new java.awt.Color(230, 230, 230));
        cmdEditProveedor.setCursorType(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmdEditProveedor.setRadius(50);
        cmdEditProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(cmdEditProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(cmdDeleteProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdEditProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDeleteProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDeleteProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdDeleteProveedorActionPerformed

    private void cmdEditProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditProveedorActionPerformed
        
    }//GEN-LAST:event_cmdEditProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private modelo.MyButton cmdDeleteProveedor;
    private modelo.MyButton cmdEditProveedor;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
