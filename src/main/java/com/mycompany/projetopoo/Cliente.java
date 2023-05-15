/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author gusta
 */
public class Cliente extends Pessoa implements Comparable<Cliente> {
    
    private int id;
    private static int numero_cliente;
    
    //Construtores da classe
    
    Cliente(String nome, String endereco, String telefone, int id){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.id = id;
        numero_cliente = numero_cliente + 1;
    }
    
    Cliente(){
        numero_cliente = numero_cliente +1;
       
    }
    //Método comparable um dos atributos
    
    @Override
    public int compareTo(Cliente other){
        if(this.id<other.id){
            return this.id;
        }
        else{return other.id;}
    }
    @Override
    public boolean equals(Object obj) {
    if (obj instanceof Cliente) {
      Cliente qualquer = (Cliente) obj;
      if(qualquer.id == this.id)
          return true;
    } 
      return false;
    
  }
     
    
    
    //Método Get para numero de clientes
    
    public static int GetNumeroCliente(){
        return numero_cliente;
    }
    
    //Métodos Get e Set para todos os atributos de Cliente
    
    public void SetNome(String nome){
        this.nome = nome;
    }
    public String GetNome(){
        return nome;
    }
    
    public void SetTelefone(String telefone){
        this.telefone = telefone;
    }
    public String GetTelefone(){
        return telefone;
    }
    
    public void SetEndereco(String endereco){
        this.endereco = endereco;
    }
    public String GetEndereco(){
        return endereco;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return id;
    }
    
    //Método toString sobrescrito
    
    @Override
    public String toString(){
        
        String txt;
        txt = String.format("\nNome: %s "
                + "\nEndereco: %s"
                + "\nTelefone: %s"
                + "\nId do Cliente: %s", GetNome(),GetEndereco(),GetTelefone(),GetId());
        return txt;
    }
}
