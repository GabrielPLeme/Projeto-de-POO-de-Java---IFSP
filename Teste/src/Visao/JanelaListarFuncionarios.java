/*
Frame para vizualização da lista de Funcionarios

EDITADO POR ULTIMO:
VINIE - 27/11/23
*/

//************************************************************************************************
package Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import Controladores.Funcionario;
import Modelo.Modelo_Funcionario;

public class JanelaListarFuncionarios extends JFrame {
    private JFrame janela = new JFrame("Janela de listagem: Funcionarios");
    private JList<String> JlistFuncionarios;
    private Modelo_Funcionario modelo_funcionario = new Modelo_Funcionario();

    public void initialize() {
        // Busca funcionarios na database e guarda numa ArrayList
        ArrayList<Funcionario> arrayFuncionarios = modelo_funcionario.listarFuncionarios();

        // Cria painel de listagem
        JPanel painel = new JPanel();
        painel.add(new JScrollPane(JlistFuncionarios));

        // Cria uma ArrayList com os nomes dos objetos funcionario
        ArrayList<String> nomesFuncionarios = new ArrayList<>();
        for (Funcionario func : arrayFuncionarios) {
            JButton botaoDetalhes = new JButton("Detalhes");
            botaoDetalhes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Funcionario selectedFuncionario = func; // Assuming 'func' is the selected Funcionario

                    JFrame detailsFrame = new JFrame("Detalhes do Funcionário");
                    detailsFrame.setSize(400, 150);
                    JPanel detailsPanel = new JPanel();
                    
                    // Retrieve details of the selected employee
                    String detalhes = modelo_funcionario.listarDadosFuncionario(selectedFuncionario.getIdFuncionario(), selectedFuncionario);
                    
                    JTextArea detailsTextArea = new JTextArea(detalhes);
                    detailsTextArea.setEditable(false);
                    
                    JScrollPane scrollPane = new JScrollPane(detailsTextArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                    
                    JButton deleteButton = new JButton("Deletar");
                    deleteButton.setSize(150, 30);
                    deleteButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Chama a função delete do modelo
                            modelo_funcionario.excluirFuncionario(selectedFuncionario.getIdFuncionario(), selectedFuncionario);
                            JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso!");
                            detailsFrame.dispose();
                            }
                        });
                    
                    detailsPanel.add(scrollPane);
                    detailsFrame.add(detailsPanel);
                    detailsPanel.add(deleteButton);
                    detailsFrame.setVisible(true);
                }
            });
            nomesFuncionarios.add(func.getNome());
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
        JanelaListarFuncionarios janela = new JanelaListarFuncionarios();
        janela.initialize();
    }
}

