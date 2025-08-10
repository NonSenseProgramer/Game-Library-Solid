

package Telas;

import DAO.UsuarioConexao;


public class Telaopcoes extends javax.swing.JFrame {
  UsuarioConexao user;
 
    public Telaopcoes(UsuarioConexao usuario) {
     user = usuario;
        initComponents();
      titulo.setText("Bem vindo " + user.getNome() + "!");
      Subtitulo.setText("Seu nível de acesso é de: " + user.getTipo_user());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        Subtitulo = new javax.swing.JLabel();
        botaoRegistrarJogo = new javax.swing.JButton();
        botaoAdicionarJogo = new javax.swing.JButton();
        botaoVerJogos = new javax.swing.JButton();
        botaoEditarRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        titulo.setText("Bem Vindo " + user);

        Subtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Subtitulo.setText("Seu nível de acesso é de:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Subtitulo)
                        .addGap(130, 130, 130))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Subtitulo)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        botaoRegistrarJogo.setText("Registrar jogo");
        botaoRegistrarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistrarJogoActionPerformed(evt);
            }
        });

        if(!user.getTipo_user().equals("ADM"))
        {
            botaoAdicionarJogo.setVisible(false);
        }
        botaoAdicionarJogo.setText("Cadastrar novo jogo");
        botaoAdicionarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarJogoActionPerformed(evt);
            }
        });

        botaoVerJogos.setText("Ver jogos registrados");
        botaoVerJogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVerJogosActionPerformed(evt);
            }
        });

        botaoEditarRegistro.setText("Editar Registro");
        botaoEditarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoVerJogos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoRegistrarJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoAdicionarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoEditarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoRegistrarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoVerJogos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoEditarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(botaoAdicionarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRegistrarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarJogoActionPerformed
   
        TelaRegistroJogo tela = new TelaRegistroJogo(user);
        tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tela.setVisible(true);
    }//GEN-LAST:event_botaoRegistrarJogoActionPerformed

    private void botaoVerJogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerJogosActionPerformed
        TelaVerJogos tela = new TelaVerJogos(user);
        tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tela.setVisible(true);
    }//GEN-LAST:event_botaoVerJogosActionPerformed

    private void botaoEditarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarRegistroActionPerformed
       TelaEditarRegistro editar = new TelaEditarRegistro(user);
       editar.setVisible(true);
       editar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_botaoEditarRegistroActionPerformed

    private void botaoAdicionarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarJogoActionPerformed
        TelaAddJogo tela = new TelaAddJogo(user);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_botaoAdicionarJogoActionPerformed


    public void main(String args[]) {
     
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Telaopcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Telaopcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Telaopcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Telaopcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telaopcoes(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Subtitulo;
    private javax.swing.JButton botaoAdicionarJogo;
    private javax.swing.JButton botaoEditarRegistro;
    private javax.swing.JButton botaoRegistrarJogo;
    private javax.swing.JButton botaoVerJogos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
