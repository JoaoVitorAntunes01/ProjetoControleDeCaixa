/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    public void cadastrar(UsuarioBean usuario) {
        try {
            String sql = "insert into usuario (nome, usuario, senha) values (?,?,?)";
            
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean existsByUsername(String username, String senha){
        String sql = "SELECT 1 from usuario where usuario = ? and senha = ?";
       
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
           
            stmt.setString(1, username);
            stmt.setString(2, senha);
           
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
           
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public UsuarioBean logar(String usuario, String senha) {
        UsuarioBean user = new UsuarioBean();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from usuario where usuario = ? and senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            if(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

    