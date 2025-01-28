/*
Frame para cadastro de Pessoa

EDITADO POR ULTIMO:
Gabriel - 29/11/23
*/

//************************************************************************************************\\
package Visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Visao.JanelaCadastrarCliente;
import Visao.JanelaCadastrarFilme;
import Visao.JanelaCadastrarFuncionario;

public class JanelaAdicionar {
    private JFrame janela = new JFrame("Menu de cadastrar");
    
    private JButton cadastrarCliente,cadastrarFuncionario,cadastrarFilme;
    
    public void initialize(){

        //Cria e define tamanho e posição de labels e inputs
        cadastrarFuncionario=new JButton("Cadastrar Funcionario ");  
        cadastrarFuncionario.setBounds(50,50, 180,30); 

        cadastrarFilme=new JButton("Cadastrar Filme");  
        cadastrarFilme.setBounds(50,100, 180,30);  
        
        cadastrarCliente = new JButton("Cadastrar Cliente");
        cadastrarCliente.setBounds(50, 150, 180, 30);
        
        JButton fechar = new JButton("Fechar");
        fechar.setBounds(150, 250, 100, 30);
        fechar.addActionListener(e -> System.exit(0));
        
        //Adiciona os labels e inputs à janela
        janela.add(cadastrarCliente);
        janela.add(cadastrarFuncionario);
        janela.add(cadastrarFilme);
        janela.add(fechar);
        //Define o tamanho da janela
        janela.setSize(300,350);  
        janela.setLayout(null);  
        janela.setVisible(true);    
    
            cadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaCadastrarFuncionario janelaCadastrarFuncionario = new JanelaCadastrarFuncionario();
                    janelaCadastrarFuncionario.initialize();    
                }

            
            });
            
            cadastrarFilme.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaCadastrarFilme janelaCadastrarfilme = new JanelaCadastrarFilme();
                    janelaCadastrarfilme.initialize();    
                }
            
            });

            cadastrarCliente.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaCadastrarCliente janelaCadastrarCliente = new JanelaCadastrarCliente();
                    janelaCadastrarCliente.initialize();    
                }
            
            });
            
    }
}
