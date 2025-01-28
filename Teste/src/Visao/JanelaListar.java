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

import Visao.JanelaListarCliente;
import Visao.JanelaListarFilme;
import Visao.JanelaListarFuncionarios;

public class JanelaListar {
    private JFrame janela = new JFrame("Menu Listar");
    
    private JButton ListarCliente,ListarFuncionario,ListarFilme;
    
    public void initialize(){

        //Cria e define tamanho e posição de labels e inputs
        ListarFuncionario=new JButton("Listar Funcionario ");  
        ListarFuncionario.setBounds(50,50, 180,30); 

        ListarFilme=new JButton("Listar Filme");  
        ListarFilme.setBounds(50,100, 180,30);  
        
        ListarCliente = new JButton("Listar Cliente");
        ListarCliente.setBounds(50, 150, 180, 30);
        //Adiciona os labels e inputs à janela
        janela.add(ListarCliente);
        janela.add(ListarFuncionario);
        janela.add(ListarFilme);

        //Define o tamanho da janela
        janela.setSize(300,350);  
        janela.setLayout(null);  
        janela.setVisible(true);    
    
            ListarFuncionario.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaListarFuncionarios JanelaListarFuncionarios = new JanelaListarFuncionarios();
                    JanelaListarFuncionarios.initialize();    
                }

            
            });
            
            ListarFilme.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaListarFilme JanelaListarFilme = new JanelaListarFilme();
                    JanelaListarFilme.initialize();    
                }
            
            });

            ListarCliente.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaListarCliente JanelaListarCliente = new JanelaListarCliente();
                    JanelaListarCliente.initialize();    
                }
            
            });
            
    }
}
