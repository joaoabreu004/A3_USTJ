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
        
        
        Carros carroJanela = new Carros(); 
        carroJanela.setVisible(true);
        
     
        DB db = new DB("bancodedados.db");
        db.query("SELECT * FROM tb_carros");
        while(db.next()) {
            int codigo = db.getInt("codigo");
            String modelo = db.getString("modelo");
            System.out.println("CODIGO: "+codigo+" NOME: "+modelo);
        }
        db.closeConnection();
    }
}
