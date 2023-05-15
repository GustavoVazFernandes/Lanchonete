/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author gusta
 */
public class Funcionario extends Cliente {
    
    private String user;
    private String senha;
    
    Funcionario( String user, String senha, String nome, String endereco, String telefone,int id){
        super(nome,endereco,telefone, id);
        this.senha = senha; 
        this.user = user;
    }
    Funcionario(){
        
    }

    public void SetUser(String user){
        this.user = user;
    }
    public String GetUser(){
        return user;
    }

    public void SetSenha(String senha){
        this.senha = senha;
    }
    public String GetSenha(){
        return senha;
    }

 
    
    
}
