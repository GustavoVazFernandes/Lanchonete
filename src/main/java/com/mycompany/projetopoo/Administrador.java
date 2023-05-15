/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author gusta
 */
public class Administrador extends Funcionario {
    
    //Construtores da classe administrador
    Administrador(String user, String senha, String nome, String telefone, String endereco, int id){
        super(user, senha, nome, endereco, telefone, id);
    }
    Administrador(){
        
    }

    @Override
    public String toString() {
        return "Adm{" + '}';
    }
    
    
}
