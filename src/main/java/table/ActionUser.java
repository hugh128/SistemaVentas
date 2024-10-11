package table;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionUser extends javax.swing.JPanel {

    public ActionUser() {
        initComponents();
    }
    
    
    public void initEvent(TableActionEventUser eventUser, int row) {
        cmdEditUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eventUser.onEditUser(row);
            }
        });
        cmdDeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eventUser.onDeleteUser(row);
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
        cmdDeleteUser = new modelo.MyButton();
        cmdEditUser = new modelo.MyButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cmdDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        cmdDeleteUser.setClickEnabled(true);
        cmdDeleteUser.setColorClick(new java.awt.Color(230, 230, 230));
        cmdDeleteUser.setRadius(50);
        cmdDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteUserActionPerformed(evt);
            }
        });

        cmdEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        cmdEditUser.setClickEnabled(true);
        cmdEditUser.setColorClick(new java.awt.Color(230, 230, 230));
        cmdEditUser.setCursorType(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmdEditUser.setRadius(50);
        cmdEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(cmdEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(cmdDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cmdDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdDeleteUserActionPerformed

    private void cmdEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditUserActionPerformed
        
    }//GEN-LAST:event_cmdEditUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private modelo.MyButton cmdDeleteUser;
    private modelo.MyButton cmdEditUser;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
