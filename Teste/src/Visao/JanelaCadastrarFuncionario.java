/*
Frame para cadastro de Funcionarios

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controladores.Funcionario;
import Modelo.Modelo_Funcionario;

public class JanelaCadastrarFuncionario extends JFrame implements ActionListener{
    private JFrame janela= new JFrame("Janela de cadastro: Funcionario");
    private JLabel lblNome, lblEmail, lblIdade;      //Declara labels para a janela
    private JTextField txtNome, txtEmail, txtIdade;  //Declara os campos de input
    private JButton botao;
    private Funcionario funcionario = new Funcionario();

    public void initialize() {          

        //Cria e define tamanho e posição de labels e inputs
        lblNome=new JLabel("Nome: ");  
        lblNome.setBounds(10,50, 100,30);  
        txtNome= new JTextField();
        txtNome.setBounds(110, 50, 100, 30);

        lblIdade=new JLabel("Idade:");  
        lblIdade.setBounds(10,100, 100,30);  
        txtIdade= new JTextField();
        txtIdade.setBounds(110, 100, 100, 30);

        lblEmail=new JLabel("E-mail:");  
        lblEmail.setBounds(10,150, 100,30);  
        txtEmail= new JTextField();
        txtEmail.setBounds(110, 150, 100, 30);

        botao = new JButton("Confirmar");
        botao.setBounds(100, 200, 150, 30);
        
        JButton fechar = new JButton("Fechar");
        fechar.setBounds(50, 250, 100, 30);
        fechar.addActionListener(e -> System.exit(0));
        
        //Adiciona os labels e inputs à janela
        janela.add(lblNome); 
        janela.add(lblIdade);
        janela.add(lblEmail);
        janela.add(txtNome);
        janela.add(txtIdade);
        janela.add(txtEmail);
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
                //Inserção dos dados do input para a classe(Controladores)
                funcionario.setNome(txtNome.getText());
                funcionario.setIdade(Integer.parseInt(txtIdade.getText()));
                funcionario.setEmail(txtEmail.getText());

                //Mensagem de confirmação
                String mensagem = "O novo Funcionario: " + funcionario.getNome() + " foi registrado";
                JOptionPane.showMessageDialog(null, mensagem);
                
                //Inserção de dados na database
                Modelo_Funcionario modelo_funcionario = new Modelo_Funcionario();
                modelo_funcionario.cadastrarFuncionario(funcionario);
                txtNome.setText("");
                txtIdade.setText("");
                txtEmail.setText("");
             }
        });
    }
        
    @Override
        public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()==botao) {
            funcionario.setNome(txtNome.getText());
            funcionario.setIdade(Integer.parseInt(txtIdade.getText()));
            funcionario.setEmail(txtEmail.getText());
            System.out.println(funcionario.getNome());
        }
    }
    public String getNome() {
        return txtNome.getText();
    }
}
