/*
Frame para cadastro de Filme

EDITADO POR ULTIMO:
VINIE - 27/11/23
*/

//************************************************************************************************
package Visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controladores.Filme;
import Modelo.Modelo_Filme;

public class JanelaCadastrarFilme extends JFrame implements ActionListener{
    private JFrame janela= new JFrame("Janela de cadasreo: Filme");  
    private JLabel lblTitulo, lblGenero, lblClassificacao;      //Declara labels para a janela
    private JTextField txtTitulo, txtGenero, txtClassificacao; //Declara os campos de input
    private JButton botao;
    private Filme filme = new Filme();

    public void initialize() {          

        //Cria e define tamanho e posição de labels e inputs
        lblTitulo=new JLabel("Titulo: ");  
        lblTitulo.setBounds(10,50, 100,30);  
        txtTitulo= new JTextField();
        txtTitulo.setBounds(110, 50, 100, 30);

        lblClassificacao=new JLabel("Classificação:");  
        lblClassificacao.setBounds(10,100, 100,30);  
        txtClassificacao= new JTextField();
        txtClassificacao.setBounds(110, 100, 100, 30);

        lblGenero=new JLabel("Genero:");  
        lblGenero.setBounds(10,150, 100,30);  
        txtGenero= new JTextField();
        txtGenero.setBounds(110, 150, 100, 30);

        botao = new JButton("Confirmar");
        botao.setBounds(100, 200, 150, 30);
        
        JButton fechar = new JButton("Fechar");
        fechar.setBounds(50, 250, 100, 30);
        fechar.addActionListener(e -> System.exit(0));
        
        //Adiciona os labels e inputs à janela
        janela.add(lblTitulo); 
        janela.add(lblClassificacao);
        janela.add(lblGenero);
        janela.add(txtTitulo);
        janela.add(txtClassificacao);
        janela.add(txtGenero);
        janela.add(botao);
        janela.add(fechar);
        //Define o tamanho da janela
        janela.setSize(300,350);  
        janela.setLayout(null);  
        janela.setVisible(true);    
        
        //Estabelece o que acontecerá ao interagir com o botão
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Inserção dos dados do input para a classe
                filme.setTitulo(txtTitulo.getText());
                filme.setClassificacao(txtClassificacao.getText());
                filme.setGenero(txtGenero.getText());

                //Mensagem de confirmação
                String mensagem = "FIlme : " + filme.getTitulo() + " \n Cadastrado com sucesso";
                JOptionPane.showMessageDialog(null, mensagem);
                
                //Inserção de dados na database
                Modelo_Filme modelo_Filme = new Modelo_Filme();
                modelo_Filme.cadastrarFilme(filme);
                 
                txtTitulo.setText("");
                txtClassificacao.setText("");
                txtGenero.setText("");
             }
        });
    }
        
    @Override
        public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()==botao) {
            filme.setTitulo(txtTitulo.getText());
            filme.setClassificacao(txtClassificacao.getText());
            filme.setGenero(txtGenero.getText());
            System.out.println(filme.getTitulo());
        }
    }
    public String getTitulo() {
        return txtTitulo.getText();
    }
}
 
