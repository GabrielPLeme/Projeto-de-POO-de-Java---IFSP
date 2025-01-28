package Visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import Visao.JanelaListar;
import Visao.JanelaAdicionar;

public class JanelaMenu {
    private JFrame janela = new JFrame("Menu ");
    private JLabel lblmostrar, lblArea;
    private JButton cadastrar,listar;
    

    public void initialize(){

        //Cria e define tamanho e posição de labels e inputs
        
        JLabel lblArea = new JLabel("Olá seja bem-vindo :)");
        lblArea.setBounds(75,10, 150,80); 

        
        lblmostrar=new JLabel("Menu:");   
        lblmostrar.setBounds(75,75, 100,30); 

        cadastrar=new JButton("Cadastrar");  
        cadastrar.setBounds(75,100, 100,30);  
        
        listar = new JButton("Listar");
        listar.setBounds(75, 150, 100, 30);
        
        JButton fechar = new JButton("Fechar");
        fechar.setBounds(150, 250, 100, 30);
        fechar.addActionListener(e -> System.exit(0));
        
        //Adiciona os labels e inputs à janela
        janela.add(cadastrar);
        janela.add(listar);
        janela.add(lblArea);
        janela.add(lblmostrar);
        janela.add(fechar);
        //Define o tamanho da janela
        janela.setSize(300,350);  
        janela.setLayout(null);  
        janela.setVisible(true);    
    
            cadastrar.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaAdicionar janelaAdicionar = new JanelaAdicionar();
                    janelaAdicionar.initialize();    
                }

            
            });
            
            listar.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaListar JanelaListar = new JanelaListar();
                    JanelaListar.initialize();    
                }
            
            });

            
    }
}
