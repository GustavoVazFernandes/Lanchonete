/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projetopoo;

import java.awt.Menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class ProjetoLanchonete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        Sistema LanchonetedoZe = new Sistema();

        //adicionando os adm's
        Administrador adm1 = new Administrador("ADM1", "546456", "Jose", "999999999", "Rua x", 1);
        Administrador adm2 = new Administrador("ADM2", "45645", "Pedro", "99999999", "Rua y", 2);
        LanchonetedoZe.AddAdm(adm1);
        LanchonetedoZe.AddAdm(adm2);

        //adicionando os funcionarios de forma estatica
        Funcionario funcionario0 = new Funcionario("func0", "5645", "Luiz ", "rua t", "99999999", 1);
        Funcionario funcionario1 = new Funcionario("func1", "546546", "Francisca ", "rua v", "99999999", 2);
        Funcionario funcionario2 = new Funcionario("func2", "0546", "Jorge ", "rua h", "99999999", 3);
        Funcionario funcionario3 = new Funcionario("func3", "6454", "Geraldo ", "rua n", "99999999", 4);
        Funcionario funcionario4 = new Funcionario("func4", "078678", "Sandra ", "rua c", "99999999", 5);
        Funcionario funcionario5 = new Funcionario("func5", "06874", "Pompeu", "rua f", "99999999", 6);
        Funcionario funcionario6 = new Funcionario("func6", "8777856", "Roberto", "rua z", "99999999", 7);
        Funcionario funcionario7 = new Funcionario("func7", "6456454", "Márcia", "rua e", "99999999", 8);
        Funcionario funcionario8 = new Funcionario("func8", "045645", "Luis ", "rua m", "99999999", 9);
        Funcionario funcionario9 = new Funcionario("func9", "654645", "Josefa ", "rua n", "99999999", 10);
        Funcionario funcionario10 = new Funcionario("func10", "45645645", "Sérgio ", "rua g", "99999999", 11);
        Funcionario funcionario11 = new Funcionario("func11", "645645", "Edson", "rua a", "99999999", 12);
        Funcionario funcionario12 = new Funcionario("func12", "4564", "Ricardo ", "rua s", "99999999", 13);
        Funcionario funcionario13 = new Funcionario("func13", "544564", "Daniel ", "rua q", "99999999", 14);
        Funcionario funcionario14 = new Funcionario("func14", "456", "Cláudio ", "rua y", "99999999", 15);
        LanchonetedoZe.AddFunc(funcionario0, 0);
        LanchonetedoZe.AddFunc(funcionario1, 1);
        LanchonetedoZe.AddFunc(funcionario2, 2);
        LanchonetedoZe.AddFunc(funcionario3, 3);
        LanchonetedoZe.AddFunc(funcionario4, 4);
        LanchonetedoZe.AddFunc(funcionario5, 5);
        LanchonetedoZe.AddFunc(funcionario6, 6);
        LanchonetedoZe.AddFunc(funcionario7, 7);
        LanchonetedoZe.AddFunc(funcionario8, 8);
        LanchonetedoZe.AddFunc(funcionario9, 9);
        LanchonetedoZe.AddFunc(funcionario10, 10);
        LanchonetedoZe.AddFunc(funcionario11, 11);
        LanchonetedoZe.AddFunc(funcionario12, 12);
        LanchonetedoZe.AddFunc(funcionario13, 13);
        LanchonetedoZe.AddFunc(funcionario14, 14);

        //adicionando o cliente no sistema
        Cliente cliente1 = new Cliente("Vinicius", "rua k", "99999999", 1);
        LanchonetedoZe.GetClientes().add(cliente1);

        Funcionario MeusFunc[] = new Funcionario[15];
        MeusFunc = LanchonetedoZe.ListaFuncionarios();

        // Login do adm e funcionario no sistema
        System.out.println("Usuario: ");
        String user = input.nextLine();
        System.out.println("Senha: ");
        String senha = input.nextLine();

        int num = 0;

        //adm
        while (num != 5) {
            if (user.equals(adm1.GetUser()) || user.equals(adm2.GetUser())) {

                if (senha.equals(adm1.GetSenha()) || senha.equals(adm2.GetSenha())) {
                    System.out.println("""
                                    Ola, qual funcao deseja realizar? 
                                   (1) Controle de Funcionarios
                                   (2) Controle de Clientes
                                   (3) Controle de Lanches e Produtos
                                   (4) Dados do ADM 
                                   (5) Encerrar""");
                    num = input.nextInt();

                    switch (num) {
                        case 1 -> {
                            System.out.println("""
                                                                   (1) Adicionar Funcion\u00e1rio
                                                                   (2) Remover funcion\u00e1rio
                                                                   (3) Voltar""");
                            num = input.nextInt();
                            switch (num) {
                                case 1 ->
                                    LanchonetedoZe.AdicionarFuncionario();
                                case 2 ->
                                    LanchonetedoZe.RemoverFuncionario();
                                default -> {
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("""
                                                                   (1) Adicionar Cliente
                                                                   (2) Remover Cliente
                                                                   (3) Editar Cliente
                                                                   (4) Voltar""");
                            num = input.nextInt();
                            switch (num) {
                                case 1 ->
                                    LanchonetedoZe.AdicionarCliente();
                                case 2 ->
                                    LanchonetedoZe.RemoverClienteId();
                                case 3 ->
                                    LanchonetedoZe.EditarClienteId();
                                default -> {
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("""
                                                                   (1) Adicionar produto
                                                                   (2) Remover produto
                                                                   (3) Editar produto
                                                                   (6) Voltar""");
                            num = input.nextInt();
                            switch (num) {
                                case 1:
                                    LanchonetedoZe.AdicionarProduto();

                                case 2:
                                    LanchonetedoZe.RemoverProduto();

                                case 3:
                                    LanchonetedoZe.EditarProdutoId();
                                default: {
                                }
                            }
                        }
                        case 4 ->
                            LanchonetedoZe.EditarMeusDados();
                        case 5 -> {
                            System.out.println("O sistema foi encerrado!");
                            break;
                        }

                    }

                }
            } //Funcionario
            else {
                for (int i = 0; i <= 9; i++) {
                    if (user.equals(MeusFunc[i].GetUser())) {
                        if (senha.equals(MeusFunc[i].GetSenha()) || senha.equals(MeusFunc[i].GetSenha())) {
                            System.out.println("""
                                   Ola, qual funcao deseja realizar agora? 
                                   (1) Controle de  pedidos
                                   (2) Dados Funcionario
                                   (3) Encerrar""");
                        }
                        int m = input.nextInt();
                        switch (m) {
                            case 1:
                                System.out.println("""
                                       (1) Adicionar pedido
                                       (2) Remover pedido
                                       (3) Alterar pedido
                                       (4) Imprimir relatorio dos pedidos
                                       (5) Pesquisar relatorio de pedidos em um intervalo de tempo
                                       (6) Voltar""");
                                m = input.nextInt();
                                switch (m) {
                                    case 1:
                                        LanchonetedoZe.AdicionarPedido();
                                    case 2:
                                        LanchonetedoZe.RemoverPedido();
                                    case 3:
                                        LanchonetedoZe.EditarPedido();
                                    case 4:
                                        LanchonetedoZe.Estatistica();
                                    case 5:
                                        LanchonetedoZe.PesquisarIntervalo();
                                    default: {
                                    }

                                }
                            case 2:
                                LanchonetedoZe.EditarMeusDados2();
                            case 3: {
                                System.out.println("O sistema foi encerrado");
                                System.exit(0);
                            }
                        }
                    }
                }
            }

        }
    }
}
