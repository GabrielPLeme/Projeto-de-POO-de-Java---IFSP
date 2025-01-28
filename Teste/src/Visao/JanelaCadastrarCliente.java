/*
Frame para cadastro de Pessoa

EDITADO POR ULTIMO:
VINIE - 27/11/23
*/

//************************************************************************************************\\
package Visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controladores.Cliente;
import Modelo.Modelo_Cliente;

public class JanelaCadastrarCliente extends JFrame implements ActionListener{
    private JFrame janela = new JFrame("Janela de cadastro: Cliente");
    private JLabel lblNome, lblIdade;
    private JTextField txtNome, txtIdade;
    private JButton botao;
    private Cliente cliente = new Cliente();

    public void initialize(){

        //Cria e define tamanho e posição de labels e inputs
        lblNome=new JLabel("Nome: ");  
        lblNome.setBounds(10,50, 100,30);  
        txtNome= new JTextField();
        txtNome.setBounds(110, 50, 100, 30);

        lblIdade=new JLabel("Idade:");  
        lblIdade.setBounds(10,100, 100,30);  
        txtIdade= new JTextField();
        txtIdade.setBounds(110, 100, 100, 30);

        botao = new JButton("Confirmar");
        botao.setBounds(100, 200, 150, 30);
        
        JButton fechar = new JButton("Fechar");
        fechar.setBounds(50, 250, 100, 30);
        fechar.addActionListener(e -> System.exit(0));
        
        //Adiciona os labels e inputs à janela
        janela.add(lblNome); 
        janela.add(lblIdade);
        janela.add(txtNome);
        janela.add(txtIdade);
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
                cliente.setNome(txtNome.getText());
                cliente.setIdade(Integer.parseInt(txtIdade.getText()));

                //Mensagem de confirmação
                String mensagem = "O novo Cliente: " + cliente.getNome() + " foi registrado";
                JOptionPane.showMessageDialog(null, mensagem);

                //Inserção de dados na database
                Modelo_Cliente modelo_cliente = new Modelo_Cliente();
                modelo_cliente.cadastrarCliente(cliente);
                txtNome.setText("");
                txtIdade.setText("");
            }
        });
    }

    @Override
        public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()==botao) {
            cliente.setNome(txtNome.getText());
            cliente.setIdade(Integer.parseInt(txtIdade.getText()));
            System.out.println(cliente.getNome());
        }
    }
    public String getNome() {
        return txtNome.getText();
    }
}