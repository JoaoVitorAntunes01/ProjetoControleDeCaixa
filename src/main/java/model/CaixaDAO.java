/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author João Vitor Antunes
 */
public class CaixaDAO {
    
    public void addValue(CaixaBean bean){
        String sql = "insert into caixa (cliente, tipo, valor) values (?, ?, ?)";
        
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, bean.getCliente());
            stmt.setString(2, bean.getTipo().ENTRADA.name());
            stmt.setDouble(3, bean.getValor());
            
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void subValue(CaixaBean bean){
        String sql = "insert into caixa (cliente, tipo, valor) values (?, ?, ?)";
        
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, bean.getCliente());
            stmt.setString(2, bean.getTipo().SAIDA.name());
            stmt.setDouble(3, bean.getValor());
            
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<CaixaBean> listAllClients(){
        ArrayList<CaixaBean> clientes = new ArrayList<>();
        String sql = "select * from caixa";
        
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()){
                
                String tipoBD = rs.getString("tipo");
                CaixaBean.TipoRecibo tipo =
                        CaixaBean.TipoRecibo.valueOf(tipoBD);
                
                CaixaBean cliente = new CaixaBean(
                        rs.getInt("id"),
                        rs.getString("cliente"),
                        tipo,
                        rs.getDouble("valor")
                );
                
                clientes.add(cliente);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    public double sumValues(){
        String sql = "select sum(case when tipo = 'ENTRADA' then valor when tipo = 'SAIDA' then -valor end) as saldo from caixa;";
        
        double total = 0;
        
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()){
                total = rs.getDouble("saldo");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return total;
    }
}