/*
Frame para vizualização da lista de Funcionarios

EDITADO POR ULTIMO:
Gabriel - 27/11/23
*/

//************************************************************************************************
package Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import Controladores.Cliente;
import Modelo.Modelo_Cliente;

public class JanelaListarCliente extends JFrame {
    private JFrame janela = new JFrame("Janela de listagem: Clientes");
    private JList<String> JlistCliente;
    private Modelo_Cliente modelo_cliente = new Modelo_Cliente();

    public void initialize() {
        // Busca funcionarios na database e guarda numa ArrayList
        ArrayList<Cliente> arrayClientes = modelo_cliente.listarClientes();

        // Cria painel de listagem
        JPanel painel = new JPanel();
        painel.add(new JScrollPane(JlistCliente));

        // Cria uma ArrayList com os nomes dos objetos funcionario
        ArrayList<String> nomesCliente = new ArrayList<>();
        for (Cliente func : arrayClientes) {
            JButton botaoDetalhes = new JButton("Detalhes");
            botaoDetalhes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Cliente selectedCliente = func; // Assuming 'func' is the selected Funcionario

                    JFrame detailsFrame = new JFrame("Detalhes do Cliente");
                    detailsFrame.setSize(400, 150);
                    JPanel detailsPanel = new JPanel();
                    
                    // Retrieve details of the selected employee
                    String detalhes = modelo_cliente.listarDadosCliente(selectedCliente.getIdCliente(), selectedCliente);
                    
                    JTextArea detailsTextArea = new JTextArea(detalhes);
                    detailsTextArea.setEditable(false);
                    
                    JScrollPane scrollPane = new JScrollPane(detailsTextArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                    
                    JButton deleteButton = new JButton("Deletar");
                    deleteButton.setSize(150, 30);
                    deleteButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Chama a função delete do modelo
                            modelo_cliente.excluirCliente(selectedCliente.getIdCliente(), selectedCliente);
                            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
                            detailsFrame.dispose();
                            }
                        });
                    
                    detailsPanel.add(scrollPane);
                    detailsFrame.add(detailsPanel);
                    detailsPanel.add(deleteButton);
                    detailsFrame.setVisible(true);
                }
            });
            nomesCliente.add(func.getNome());
            painel.add(new JLabel(func.getNome()));
            painel.add(botaoDetalhes);
        }
        

        // Janela
        janela.add(painel);
        janela.setSize(150, 300);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create an instance of JanelaListarFuncionarios
        JanelaListarCliente janela = new JanelaListarCliente();
        janela.initialize();
    }
}

