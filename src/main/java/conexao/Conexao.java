/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexao {
    private static Connection conn = null;
    
    private static String url = "jdbc:mysql://localhost:3607/registroCaixa";
    private static String user = "root";
    private static String senha = "";
    
    private Conexao(){
    }
    
    public static synchronized Connection conectar() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, senha);
            }
        } catch( SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}