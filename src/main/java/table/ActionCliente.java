package table;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCliente extends javax.swing.JPanel {

    public ActionCliente() {
        initComponents();
    }
    
    
    public void initEvent(TableActionEventCliente eventCliente, int row) {
        cmdEditCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eventCliente.onEditCliente(row);
            }
        });
        cmdDeleteCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eventCliente.onDeleteCliente(row);
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
        cmdDeleteCliente = new modelo.MyButton();
        cmdEditCliente = new modelo.MyButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cmdDeleteCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        cmdDeleteCliente.setClickEnabled(true);
        cmdDeleteCliente.setColorClick(new java.awt.Color(230, 230, 230));
        cmdDeleteCliente.setRadius(50);
        cmdDeleteCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteClienteActionPerformed(evt);
            }
        });

        cmdEditCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        cmdEditCliente.setClickEnabled(true);
        cmdEditCliente.setColorClick(new java.awt.Color(230, 230, 230));
        cmdEditCliente.setCursorType(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmdEditCliente.setRadius(50);
        cmdEditCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(cmdEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(cmdDeleteCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDeleteCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cmdDeleteClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdDeleteClienteActionPerformed

    private void cmdEditClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditClienteActionPerformed
        
    }//GEN-LAST:event_cmdEditClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private modelo.MyButton cmdDeleteCliente;
    private modelo.MyButton cmdEditCliente;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
