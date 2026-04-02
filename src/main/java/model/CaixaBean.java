/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author João Vitor Antunes
 */
public class CaixaBean {
    private int id;
    private String cliente;
    private TipoRecibo tipo;
    private double valor;
    
    public CaixaBean(){
        
    }
    
    public CaixaBean(int id, String cliente, TipoRecibo tipo, double valor){
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public enum TipoRecibo{
        ENTRADA,
        SAIDA
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public TipoRecibo getTipo() {
        return tipo;
    }

    public void setTipo(TipoRecibo tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
