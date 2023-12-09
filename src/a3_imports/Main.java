/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a3_imports;

/**
 *
 * @author jvabr
 */
public class Main {
    public static void main(String[] args) {
        
        /*
        Carros carroJanela = new Carros(); 
        carroJanela.setVisible(true);
        */
        
        /*
        Funcionarios funcionariosJanelas = new Funcionarios(); 
        funcionariosJanelas.setVisible(true);
        */
        /*
        DB db = new DB("bancodedados.db");
        db.query("SELECT * FROM tb_funcionarios");
        while(db.next()) {
            int codigo = db.getInt("id_funcionarios");
            String modelo = db.getString("nome");
            System.out.println("Código: "+codigo+" NOME: "+modelo);
        }
        db.closeConnection();
        */
        
        Login menuLogin = new Login(); 
        menuLogin.setVisible(true);
        
    }
}
