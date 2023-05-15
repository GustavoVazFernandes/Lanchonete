/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author gusta
 */
public class Lanche {
    
    public String descricao;
    public int id_produto;
    public double preco;
    
    //Construtores
    Lanche(String descricao, int id, double preco){
        this.descricao = descricao;
        this.id_produto = id;
        this.preco = preco;
    }
    Lanche(){
        
    }
    
    //Métodos Get e Set
    public void SetDescricao(String descricao){
        this.descricao = descricao;
    }
    public String GetDescricao(){
        return descricao;
    }
    
    public void SetIdProduto(int id){
        this.id_produto = id;
    }
    public int GetIdProduto(){
        return id_produto;
    }
    
    public void SetPreco(double preco){
        this.preco = preco;
    }
    public double GetPreco(){
        return preco;
    }
    //Override do toString

    @Override
    public String toString() {
        return "Produto{" + "descricao=" + descricao 
                + ", id_produto=" + id_produto 
                + ", preco=" + preco + '}';
    }
    
}
