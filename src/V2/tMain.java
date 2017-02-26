/*
 * telaCadastro.java
 *
 * Created on 11 de Novembro de 2008, 20:20
 */

package V2;

public class tMain extends javax.swing.JFrame {

    /** Creates new form telaCadastro */
    public tMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmSocio = new javax.swing.JMenu();
        jmCadastrar = new javax.swing.JMenuItem();
        jmAlterar = new javax.swing.JMenuItem();
        jmRemover = new javax.swing.JMenuItem();
        jmListar = new javax.swing.JMenuItem();
        jmProduto = new javax.swing.JMenu();
        jmpCadastrar = new javax.swing.JMenuItem();
        jmpAlterar = new javax.swing.JMenuItem();
        jmpRemover = new javax.swing.JMenuItem();
        jmpComprar = new javax.swing.JMenuItem();
        jmpListar = new javax.swing.JMenuItem();
        Ajuda = new javax.swing.JMenu();
        Sobre = new javax.swing.JMenuItem();
        jmSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("V2/Bundle"); // NOI18N
        setTitle(bundle.getString("tMain.title")); // NOI18N
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);

        jMenuBar1.setToolTipText(bundle.getString("tMain.jMenuBar1.toolTipText")); // NOI18N

        jmSocio.setText(bundle.getString("tMain.jmSocio.text")); // NOI18N

        jmCadastrar.setText(bundle.getString("tMain.jmCadastrar.text")); // NOI18N
        jmCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarActionPerformed(evt);
            }
        });
        jmSocio.add(jmCadastrar);

        jmAlterar.setText(bundle.getString("tMain.jmAlterar.text")); // NOI18N
        jmAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlterarActionPerformed(evt);
            }
        });
        jmSocio.add(jmAlterar);

        jmRemover.setText(bundle.getString("tMain.jmRemover.text")); // NOI18N
        jmRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRemoverActionPerformed(evt);
            }
        });
        jmSocio.add(jmRemover);

        jmListar.setText(bundle.getString("tMain.jmListar.text")); // NOI18N
        jmListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListarActionPerformed(evt);
            }
        });
        jmSocio.add(jmListar);

        jMenuBar1.add(jmSocio);

        jmProduto.setText(bundle.getString("tMain.jmProduto.text")); // NOI18N

        jmpCadastrar.setText(bundle.getString("tMain.jmpCadastrar.text")); // NOI18N
        jmpCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpCadastrarActionPerformed(evt);
            }
        });
        jmProduto.add(jmpCadastrar);

        jmpAlterar.setText(bundle.getString("tMain.jmpAlterar.text")); // NOI18N
        jmpAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpAlterarActionPerformed(evt);
            }
        });
        jmProduto.add(jmpAlterar);

        jmpRemover.setText(bundle.getString("tMain.jmpRemover.text")); // NOI18N
        jmpRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpRemoverActionPerformed(evt);
            }
        });
        jmProduto.add(jmpRemover);

        jmpComprar.setText(bundle.getString("tMain.jmpComprar.text")); // NOI18N
        jmpComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpConsumirActionPerformed(evt);
            }
        });
        jmProduto.add(jmpComprar);

        jmpListar.setText(bundle.getString("tMain.jmpListar.text")); // NOI18N
        jmpListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpListarActionPerformed(evt);
            }
        });
        jmProduto.add(jmpListar);

        jMenuBar1.add(jmProduto);

        Ajuda.setText(bundle.getString("tMain.Ajuda.text")); // NOI18N

        Sobre.setText(bundle.getString("tMain.Sobre.text")); // NOI18N
        Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SobreActionPerformed(evt);
            }
        });
        Ajuda.add(Sobre);

        jMenuBar1.add(Ajuda);

        jmSair.setText(bundle.getString("tMain.jmSair.text")); // NOI18N
        jmSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jmSairMenuSelected(evt);
            }
        });
        jMenuBar1.add(jmSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("null");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jmCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarActionPerformed
    new tCadastroSocio(this).show();
}//GEN-LAST:event_jmCadastrarActionPerformed

private void jmListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListarActionPerformed
    new tListarSocio(this).show();
}//GEN-LAST:event_jmListarActionPerformed

private void jmAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlterarActionPerformed
    new tAlterarSocio(this).show();
}//GEN-LAST:event_jmAlterarActionPerformed

private void jmRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRemoverActionPerformed
    new tRemoverSocio(this).show();
}//GEN-LAST:event_jmRemoverActionPerformed

private void jmpCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpCadastrarActionPerformed
    new tCadastroProduto(this).show();
}//GEN-LAST:event_jmpCadastrarActionPerformed

private void jmpConsumirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpConsumirActionPerformed
    new tConsumirProdutos(this).show();
}//GEN-LAST:event_jmpConsumirActionPerformed

private void jmpListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpListarActionPerformed
    new tListarProduto(this).show();
}//GEN-LAST:event_jmpListarActionPerformed

private void jmpAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpAlterarActionPerformed
    new tAlterarProduto(this).show();
}//GEN-LAST:event_jmpAlterarActionPerformed

private void jmpRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpRemoverActionPerformed
    new tRemoverProduto(this).show();
}//GEN-LAST:event_jmpRemoverActionPerformed

private void SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SobreActionPerformed
    new tAjudaSobre(this).show();
}//GEN-LAST:event_SobreActionPerformed

private void jmSairMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jmSairMenuSelected
    System.exit(0);
}//GEN-LAST:event_jmSairMenuSelected

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ajuda;
    private javax.swing.JMenuItem Sobre;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmAlterar;
    private javax.swing.JMenuItem jmCadastrar;
    private javax.swing.JMenuItem jmListar;
    private javax.swing.JMenu jmProduto;
    private javax.swing.JMenuItem jmRemover;
    private javax.swing.JMenu jmSair;
    private javax.swing.JMenu jmSocio;
    private javax.swing.JMenuItem jmpAlterar;
    private javax.swing.JMenuItem jmpCadastrar;
    private javax.swing.JMenuItem jmpComprar;
    private javax.swing.JMenuItem jmpListar;
    private javax.swing.JMenuItem jmpRemover;
    // End of variables declaration//GEN-END:variables

}
