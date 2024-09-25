package vista;

import modelo.Usuario;

public class HomePage extends javax.swing.JFrame {

    private Usuario usuario;
    
    public HomePage(Usuario usuario) {    
        this.usuario = usuario;
        initComponents();
        setLocationRelativeTo(null);
        
        // Añadir componentes a la ventana principal
        /*javax.swing.JLabel lblUsuario = new javax.swing.JLabel("Bienvenido, " + usuario.getNombreUsuario());
        lblUsuario.setFont(new java.awt.Font("Inria Sans", 1, 24)); // Estilo del texto
        add(lblUsuario); // Agrega el JLabel a la ventana*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Home");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });*/
    
    public static void iniciar(Usuario usuario) {
        java.awt.EventQueue.invokeLater(() -> {
            new HomePage(usuario).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
