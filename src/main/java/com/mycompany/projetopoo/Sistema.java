/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author gusta
 */
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema {
    
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    //Variável que armazena número de clientes
    private static int solucao1;
    private static int solucao2;
    private static int numero_cliente = Cliente.GetNumeroCliente();
    
    
    public static int NumeroDeClientes(){
        return  numero_cliente;
    }

 
    private Funcionario funcionarios[] = new Funcionario[15];
    private List<Administrador> adms = new ArrayList<Administrador>();
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private List<Pedido> estatistica = new ArrayList<Pedido>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Lanche> cardápio = new ArrayList<Lanche>();
    private List<Funcionario> novosfuncionarios = new ArrayList<Funcionario>();
    private List<Pedido> intervalo = new ArrayList<Pedido>();

    
    public List<Pedido> GetEstatistica(){
        return estatistica;
    }
  
    public Funcionario[] GetFuncionarios(){
        return funcionarios;
    }
     
    public List<Cliente> GetClientes(){
        return clientes;
    }
    
    public List<Pedido> GetPedidos(){
        return pedidos;
    }
    
     public List<Lanche> GetCardapio(){
        return cardápio;
    }
     
    public void AddAdm(Administrador adm){
        this.adms.add(adm);
    }
    public List<Administrador> GetAdms(){
        return this.adms;
    }
    
    public void AddFunc(Funcionario func, int i){
        this.funcionarios[i] = func;
    }
    public Funcionario getFunc(int i){
        return funcionarios[i];
    }
    public Funcionario[] ListaFuncionarios (){
        return funcionarios;
    }
    
    public void AdicionarFuncionario(){
               System.out.println("""
                                  Nome:
                                  Endereco:
                                  Telefne: """);  
                                String nome = input.nextLine();
                                String telefone = input.nextLine();
                                String endereco = input.nextLine();
                                System.out.println("O funcionario foi adicionado! ");
                                System.out.println("------------------------------------------------------------------------");
                                
                                Funcionario novofuncionario = new Funcionario( "user","senha",nome,endereco,telefone,random.nextInt(100000));
                                this.AddNovoFuncionario(novofuncionario);
    }

    
    public void RemoverFuncionario(){
          System.out.println("Digite o id do funcionário que deseja remover:");
                                int id = input.nextInt();
                                for(int i=0;i<=14;i++){
                                    if (funcionarios[i].GetId()==id){
                                        funcionarios[i] = null;
                                    }
                                    System.out.println("O funcionario foi removido! ");
                                    System.out.println("------------------------------------------------------------------------");
                                }
                                
     
             
    }
     
     
     public void AddNovoFuncionario(Funcionario funcionario){
         novosfuncionarios.add(funcionario);
     }
     public void RemoverFunc(Funcionario funcionario){
         novosfuncionarios.add(funcionario);
     }
     
     public void AdicionarPedido(Pedido pedido){
         System.out.println("""
                            Data:
                            Horario:
                            """);
         pedidos.add(pedido);
         System.out.println("O seu pedido foi adicionado! ");
     }
     public void RemoverPedido(Pedido pedido){
         pedidos.remove(pedido);
     }
     
     //Remover e adc cliente
     public void AdicionarCliente(){
         System.out.println("""
                            Nome:
                            Telefone:
                            Endereco: 
                            Id:""");
                                String nome = input.nextLine();
                                String telefone = input.nextLine();
                                String endereco = input.nextLine();
                                int id = input.nextInt();
                                Cliente novocliente = new Cliente(nome,telefone,endereco,id);
                                clientes.add(novocliente);
                                System.out.println("O cliente foi adicionado! ");
                                System.out.println("------------------------------------------------------------------------");
     }
     public void RemoverCliente(Cliente cliente){
         clientes.remove(cliente);
     }
     public void RemoverClienteId(){
         System.out.println("Digite o id do cliente a se remover:");
                                int id = input.nextInt();
                                
                                try{
                                boolean test = false;  
                                Cliente remover = new Cliente();
                                remover.SetId(id);
                                
                                int indice = this.GetClientes().indexOf(remover);
                                
                                if ( indice != -1){
                                this.GetClientes().remove(this.GetClientes().get(indice));
                                test = true;}
                                
                        
                                if(test == true){
                                System.out.println("Removido.");
                                System.out.println("------------------------------------------------------------------------");
                                }else{
                                System.out.println("Não encontrado.");
                                System.out.println("------------------------------------------------------------------------");
                                }
                            }
                            catch (Exception excpt){
                                    excpt.getStackTrace();
                                    }
     }
     //editar dados do cliente com id
     public void EditarClienteId(){
         System.out.println("Digite o id do cliente a se editar:");
                                String id = input.nextLine();
                                
                                  
                                Cliente editar = new Cliente();
                                editar.SetId(Integer.parseInt(id));
                                
                                int indice = this.GetClientes().indexOf(editar);
                                
                                if ( indice != -1){
                                    
                                System.out.println("""
                                                   O que deseja alterar do cliente?
                                                   (1)Nome
                                                   (2)Telefone
                                                   (3)Endereco
                                                   (4)Id """);
                                String n = input.nextLine();
                                switch(n){
                                    case "1" -> {
                                        System.out.println("Insira novo nome:");
                                        String novonome = input.nextLine();
                                        this.GetClientes().get(indice).SetNome(novonome);
                                        System.out.println("O nome foi alterado! ");
                                        System.out.println("------------------------------------------------------------------------");
                 }
                                    case "2" -> {
                                        System.out.println("Insira novo telefone:");
                                        String novotelefone = input.nextLine();
                                        this.GetClientes().get(indice).SetTelefone(novotelefone);
                                        System.out.println("O telefone foi alterado! ");
                                        System.out.println("------------------------------------------------------------------------");
                 }
                                    case "3" -> {
                                        System.out.println("Insira novo Endereço:");
                                        String novoend = input.nextLine();
                                        this.GetClientes().get(indice).SetEndereco(novoend);
                                        System.out.println("O endereco foi alterado! ");
                                        System.out.println("------------------------------------------------------------------------");
                 }
                                    case "4" -> {
                                        System.out.println("Insira novo Id:");
                                        String novoID = input.nextLine();
                                        this.GetClientes().get(indice).SetId(Integer.parseInt(id));
                                        System.out.println("O id foi alterado! ");
                                        System.out.println("------------------------------------------------------------------------");
                 }
                                }
                                    
                                
                                }
                                
                        
                                
     }
     
     
     //adicionar e remover produtos do cardápio
     public void AdicionarProduto(){
         System.out.println("""
                            Descricao:
                            Id:
                            Preco: """);
                 
         String descri = input.nextLine();
         int id = input.nextInt();
         double preco = input.nextDouble();
         System.out.println("O produto foi adicionado! ");
         System.out.println("------------------------------------------------------------------------");
         
         Lanche novoproduto = new Lanche(descri,id,preco);
         this.cardápio.add(novoproduto);
         
         
         this.cardápio.add(novoproduto);
     }
     public void RemoverProduto( ){
         System.out.println("Digite o id do produto a se remover:");
                                int id = input.nextInt();
                                
                                try{
                                boolean test = false;  
                                Lanche remover = new Lanche();
                                remover.SetIdProduto(id);
                                
                                int indice = this.GetCardapio().indexOf(remover);
                                
                                if ( indice != -1){
                                this.GetCardapio().remove(this.GetCardapio().get(indice));
                                test = true;}
                                
                        
                                if(test == true){
                                System.out.println("Removido.");
                                System.out.println("------------------------------------------------------------------------");
                                }else{
                                System.out.println("Não encontrado.");
                                System.out.println("------------------------------------------------------------------------");
                                }
                            }
                            catch (Exception excpt){
                                    excpt.getStackTrace();
                                    }
     }
     
     //editar dados de um produto
     
     public void EditarProdutoId(){
         System.out.println("Digite o id do produto a se editar:");
                                String id = input.nextLine();
                                
                                 
                                Lanche editar = new Lanche();
                                editar.SetIdProduto(Integer.parseInt(id));
                                
                                int indice = this.GetCardapio().indexOf(editar);
                                
                                if ( indice != -1){
                                    
                                System.out.println("""
                                                   O que deseja alterar do produto?
                                                   (1)Descrição
                                                   (2)Id
                                                   (3)Preço""");
                                String n = input.nextLine();
                                switch(n){
                                    case "1" -> {
                                        System.out.println("Insira nova descrição:");
                                        String novonome = input.nextLine();
                                        this.GetCardapio().get(indice).SetDescricao(novonome);
                                        System.out.println("A descricao foi alterada");
                                        System.out.println("------------------------------------------------------------------------");
                 }
                                    case "2" -> {
                                        System.out.println("Insira novo ID:");
                                        int novoID = input.nextInt();
                                        this.GetCardapio().get(indice).SetIdProduto(novoID);
                                        System.out.println("O id do produto foi alterado!");
                                        System.out.println("------------------------------------------------------------------------");
                 }
                                    case "3" -> {
                                        System.out.println("Insira novo preço:");
                                        double novopreco = input.nextDouble();
                                        this.GetCardapio().get(indice).SetPreco(novopreco);
                                        System.out.println("O preco foi alterado!");
                                        System.out.println("------------------------------------------------------------------------");
                 }
                                    
                                }
                               }
                                
                        
                                
     }
    
     //pesquisar pedido
     public void PesquisarPedido(Pedido pedido1){
         
         
         for(int i = 0; i < pedidos.size(); i++)
{
    if (pedido1 == pedidos.get(i)){ System.out.println(pedido1.GetStatus());
}
           
     }
         
     
}
    public void EditarMeusDados(){
        System.out.println("Digite seu id:");
                                String id = input.nextLine();
                                
                                  
                                Administrador editar = new Administrador();
                                editar.SetId(Integer.parseInt(id));
                                
                                
                                int indice = this.GetAdms().indexOf(editar);
                                
                                if ( indice != -1){
                                    
                                System.out.println("""
                                                   O que deseja alterar?
                                                   (1) User
                                                   (2) Senha
                                                   (3) Voltar""");
                                String n = input.nextLine();
                                switch(n){
                                    case "1" -> {
                                        System.out.println("Insira novo user:");
                                        String novouser = input.nextLine();
                                        this.GetAdms().get(indice).SetUser(novouser);
                                        System.out.println("O user foi alterado!");
                                        System.out.println("------------------------------------------------------------------------");
                }
                                    case "2" -> {
                                        System.out.println("Insira nova senha:");
                                        String novasenha = input.nextLine();
                                        this.GetAdms().get(indice).SetSenha(novasenha);
                                        System.out.println("A senha foi alterada!");
                                        System.out.println("------------------------------------------------------------------------");
                }
                                    default -> {
                                    }
                                }
                                    
                                
                                
                                }
                        
                                
                                
                            }
    //adicionar pedido
    public void AdicionarPedido(){
        System.out.println("""
                           Id do pedido:
                           Adicionais:""");
                 
         String idPedido = input.nextLine();
         String adicionais = input.nextLine();
         Calendar data = Calendar.getInstance();
         
         
         Pedido novopedido = new Pedido(Integer.parseInt(idPedido),data,"Pedido feito",adicionais);
         this.pedidos.add(novopedido);
         System.out.println("Seu Pedido foi adicionado!");
         System.out.println("------------------------------------------------------------------------");
         
         
        
        
    }
    public void voltar(){
        return;
    }
    //remover pedido
    public void RemoverPedido(){
        System.out.println("Digite o id do pedido a se remover:");
                                int id = input.nextInt();
                                
                                try{
                                boolean test = false;  
                                Pedido remover = new Pedido();
                                remover.SetIdPedido(id);
                                
                                int indice = this.GetPedidos().indexOf(remover);
                                
                                if ( indice != -1){
                                this.GetPedidos().remove(this.GetPedidos().get(indice));
                                test = true;}
                                
                        
                                if(test == true){
                                System.out.println("Removido.");
                                System.out.println("------------------------------------------------------------------------");
                                }else{
                                System.out.println("Não encontrado.");
                                System.out.println("------------------------------------------------------------------------");
                                }
                            }
                            catch (Exception excpt){
                                    excpt.getStackTrace();
                                    }
        
    }
        
    //editar pedido
    
    public void EditarPedido(){
        System.out.println("Digite o id do pedido que deseja alterar:");
                                String id = input.nextLine();
                                
                                  
                                Pedido editar = new Pedido();
                                editar.SetIdPedido(Integer.parseInt(id));
                                
                                
                                int indice = this.GetPedidos().indexOf(editar);
                                
                                if ( indice != -1){
                                    
                                System.out.println("""
                                                   O que deseja alterar?
                                                   (1) Id do pedido
                                                   (2) Adicionais
                                                   (3) Voltar""");
                                String n = input.nextLine();
                                switch(n){
                                    case "1" -> {
                                        System.out.println("Insira novo Id para o pedido:");
                                        String novoID = input.nextLine();
                                        this.GetPedidos().get(indice).SetIdPedido(Integer.parseInt(novoID));
                                        System.out.println("O id foi alterado! ");
                                        System.out.println("------------------------------------------------------------------------");
                }
                                    case "2" -> {
                                        System.out.println("Insira nova lista de adicionais:");
                                        String novosadicionais = input.nextLine();
                                        this.GetPedidos().get(indice).SetAdicionais(novosadicionais);
                                        System.out.println("Os adicionais foram incluidos! ");
                                        System.out.println("------------------------------------------------------------------------");
                }
                                    default -> {
                                    }
                                }
                                    
                                
                                
                                }
    }
    
    public List<Pedido> PesquisarIntervalo(){
        
        
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        System.out.println("Informe a primeira data: (dia, mês e ano ");
        
        int l = input.nextInt();
        int k = input.nextInt();
        int p = input.nextInt();
        
        c1.set(l,k,p);
        
        System.out.println("Informe a segunda data: (dia, mês e ano ");
        
        l = input.nextInt();
        k = input.nextInt();
        p = input.nextInt();                                       
        
        
        
        
		
                
        for (Pedido pedido: this.pedidos){
           int h = pedido.GetData().compareTo(c1);
           int j = pedido.GetData().compareTo(c2);
           if (h>0&&j<0){
               intervalo.add(pedido);
               
           }
        }
        
        return intervalo;
        
    }
    
    public void EditarMeusDados2(){
        System.out.println("Digite seu id:");
                                String id = input.nextLine();
                                
                                  
                                Funcionario editar = new Funcionario();
                                editar.SetId(Integer.parseInt(id));
                                
                                
                                for(int i=0;i<15;i++){
                                
                                if ( this.funcionarios[i].GetId()==editar.GetId()){
                                    
                                System.out.println("""
                                                   O que deseja alterar?
                                                   (1)User
                                                   (2)Senha""");
                                String n = input.nextLine();
                                switch(n){
                                    case "1" -> {
                                        System.out.println("Insira novo user:");
                                        String novouser = input.nextLine();
                                        this.funcionarios[i].SetUser(novouser);
                                        System.out.println("Seu user foi alterado!");
                                        System.out.println("------------------------------------------------------------------------");
                                        }
                                    case "2" -> {
                                        System.out.println("Insira nova senha:");
                                        String novasenha = input.nextLine();
                                        this.funcionarios[i].SetSenha(novasenha);
                                        System.out.println("Sua senha foi alterada!");
                                        System.out.println("------------------------------------------------------------------------");
                                        }
                                }
                                    
                                
                                
                                }
                        
                                }
                                
                            }
    //estatística dos pedidos de um dia
    public void Estatistica(){
        System.out.println("Infome a data do relatorio que sera gerado: (dia, mês e ano) ");
        int dia = input.nextInt();
        int mes = input.nextInt();
        int ano = input.nextInt();
        int num = 0;
        
        Calendar date = Calendar.getInstance();
        date.set(dia,mes,ano);
        
        for(Pedido pedido: this.pedidos){
          int h = pedido.GetData().compareTo(date);
          if(h!=0){
              estatistica.add(pedido);
              num = num + 1;
            
        }
    
    }
        System.out.printf("Nesse dia foram feitos %s pedidos.", num);
        System.out.println("------------------------------------------------------------------------");
    
    
    }
    
    //Json
     public void DadosClientes()throws IOException{
        FileWriter filewriter = new FileWriter("clientes.json");
        for (Cliente cliente: this.GetClientes() ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try{
                String json = gson.toJson(cliente);
                
                filewriter.write(json);
                filewriter.flush();
                
                System.out.println(json);
            }catch(IOException ex){
                Logger.getLogger(Sistema.class.toString()).log(Level.SEVERE,null,ex);
            }
        }
    } 
     public void DadosAdms()throws IOException{
        FileWriter filewriter = new FileWriter("adm.json");
        for (Administrador adm: this.GetAdms() ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try{
                String json = gson.toJson(adm);
                
                filewriter.write(json);
                filewriter.flush();
                
                System.out.println(json);
            }catch(IOException ex){
                Logger.getLogger(Sistema.class.toString()).log(Level.SEVERE,null,ex);
            }
        }
    }
     public void DadosPedidos()throws IOException{
        FileWriter filewriter = new FileWriter("pedidos.json");
        for (Pedido pedido: this.GetPedidos() ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try{
                String json = gson.toJson(pedido);
                
                filewriter.write(json);
                filewriter.flush();
                
                System.out.println(json);
            }catch(IOException ex){
                Logger.getLogger(Sistema.class.toString()).log(Level.SEVERE,null,ex);
            }
        }
    }
     public void DadosProdutos()throws IOException{
        FileWriter filewriter = new FileWriter("dadosproduto.json");
        for (Lanche produto: this.GetCardapio() ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try{
                String json = gson.toJson(produto);
                
                filewriter.write(json);
                filewriter.flush();
                
                System.out.println(json);
            }catch(IOException ex){
                Logger.getLogger(Sistema.class.toString()).log(Level.SEVERE,null,ex);
            }
        }
    }
}