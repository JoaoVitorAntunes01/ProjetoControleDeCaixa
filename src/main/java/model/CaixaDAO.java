/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import conexao.Conexao;
import java.sql.*;

/**
 *
 * @author João Vitor Antunes
 */
public class CaixaDAO {
    
     public boolean inserir(CaixaBean caixa) {
        String sql = "INSERT INTO caixa (tipo, valor) VALUES (?, ?)";
        try {
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, caixa.getTipo());
            ps.setDouble(2, caixa.getValor());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}