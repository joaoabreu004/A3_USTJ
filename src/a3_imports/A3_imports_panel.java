package a3_imports;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class A3_imports_panel extends javax.swing.JFrame {

    public A3_imports_panel() {
        initComponents();
    }

    
    //MUDAR AO TESTAR
    String url = "jdbc:sqlite:C:/Users/jvabr/Downloads/a3_imports/a3_imports/src/a3_imports/db_car.db";
        
    Connection connect;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teste_READ = new javax.swing.JButton();
        teste_BANCO = new javax.swing.JButton();
        teste_ADD = new javax.swing.JButton();
        teste_DEL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teste_READ.setBackground(new java.awt.Color(153, 204, 255));
        teste_READ.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        teste_READ.setText("LER");
        teste_READ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teste_READActionPerformed(evt);
            }
        });
        getContentPane().add(teste_READ, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 150, 30));

        teste_BANCO.setBackground(new java.awt.Color(204, 204, 255));
        teste_BANCO.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        teste_BANCO.setText("CONECTAR O BANCO");
        teste_BANCO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teste_BANCOMouseClicked(evt);
            }
        });
        teste_BANCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teste_BANCOActionPerformed(evt);
            }
        });
        getContentPane().add(teste_BANCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 300, 40));

        teste_ADD.setBackground(new java.awt.Color(153, 204, 255));
        teste_ADD.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        teste_ADD.setForeground(new java.awt.Color(51, 0, 51));
        teste_ADD.setText("ADICIONAR DADOS");
        teste_ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teste_ADDActionPerformed(evt);
            }
        });
        getContentPane().add(teste_ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 300, 40));

        teste_DEL.setBackground(new java.awt.Color(255, 102, 102));
        teste_DEL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        teste_DEL.setText("EXCLUIR");
        teste_DEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teste_DELActionPerformed(evt);
            }
        });
        getContentPane().add(teste_DEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 140, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel1.setText("Primeiro, teste a conexão com o banco:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 310, 20));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel2.setText("<3");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel3.setText("Com o banco conectado, você pode...");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void teste_READActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teste_READActionPerformed
        try {
            
            
            String select = "SELECT * FROM tb_carro";
            
            PreparedStatement st = connect.prepareStatement(select);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("codcarro");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano_lancamento");
                double preco = rs.getDouble("preco");
                
                JOptionPane.showMessageDialog(null, "Select com sucesso: \n"
                        + "id: " + id
                        + "\nmarca: " + marca
                        + "\nmodelo: " + modelo
                        + "\nano: " + ano
                        + "\npreco: " + preco);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DEU RUIM: \n" + e);
        }
    }//GEN-LAST:event_teste_READActionPerformed

    private void teste_BANCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teste_BANCOActionPerformed
        try {
            connect = DriverManager.getConnection(url);
            if(connect!=null){
               JOptionPane.showMessageDialog(null, "CONECTADO");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DEU RUIM: \n" + e);
        }
    }//GEN-LAST:event_teste_BANCOActionPerformed

    private void teste_ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teste_ADDActionPerformed
        try {
            String insert = "INSERT INTO tb_carro(marca, modelo, ano_lancamento, preco) VALUES (?,?,?,?)";
            
            String marca = JOptionPane.showInputDialog("Informe a marca do carro:");
            String modelo = JOptionPane.showInputDialog("Informe o modelo do carro:");
            String ano = JOptionPane.showInputDialog("Informe o ano do carro:");
            String preco = JOptionPane.showInputDialog("Informe o preco do carro:");
            
            PreparedStatement st = connect.prepareStatement(insert);            
            st.setString(1, marca);
            st.setString(2, modelo);
            st.setInt(3, Integer.parseInt(ano));
            st.setDouble(4, Double.parseDouble(preco));
            
            int updateRowCount = st.executeUpdate();
            
            if(updateRowCount > 0){
                JOptionPane.showMessageDialog(this, "Dados cadastrados com sucesso!");                        
            }else{
                JOptionPane.showMessageDialog(this, "Erro no processamento de dados!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DEU RUIM: \n" + e);
        }
    }//GEN-LAST:event_teste_ADDActionPerformed

    private void teste_DELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teste_DELActionPerformed
        String id = JOptionPane.showInputDialog("Informe o id do carro:");
        
        String delete = "DELETE FROM tb_carro where codcarro=?";
        
        try {
            PreparedStatement st = connect.prepareStatement(delete);
            st.setInt(1, Integer.parseInt(id));
            st.execute();
            JOptionPane.showMessageDialog(null, "DEU CERTO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DEU RUIM: \n" + e);
        }
        
        
    }//GEN-LAST:event_teste_DELActionPerformed

    private void teste_BANCOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teste_BANCOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_teste_BANCOMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new A3_imports_panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton teste_ADD;
    private javax.swing.JButton teste_BANCO;
    private javax.swing.JButton teste_DEL;
    private javax.swing.JButton teste_READ;
    // End of variables declaration//GEN-END:variables
}
