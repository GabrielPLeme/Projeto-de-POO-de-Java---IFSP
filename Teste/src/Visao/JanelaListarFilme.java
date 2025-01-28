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

import Controladores.Filme;
import Modelo.Modelo_Filme;

public class JanelaListarFilme extends JFrame {
    private JFrame janela = new JFrame("Janela de listagem: Filmes");
    private JList<String> JlistFilme;
    private Modelo_Filme modelo_filme = new Modelo_Filme();

    public void initialize() {
        // Busca filme na database e guarda numa ArrayList
        ArrayList<Filme> arrayFilmes = modelo_filme.listarFilmes();

        // Cria painel de listagem
        JPanel painel = new JPanel();
        painel.add(new JScrollPane(JlistFilme));

        // Cria uma ArrayList com os nomes dos objetos filme
        ArrayList<String> nomesFilme = new ArrayList<>();
        for (Filme func : arrayFilmes) {
            JButton botaoDetalhes = new JButton("Detalhes");
            botaoDetalhes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Filme selectedFilme = func; // Assuming 'func' is the selected Filme

                    JFrame detailsFrame = new JFrame("Detalhes do Filme");
                    detailsFrame.setSize(400, 150);
                    JPanel detailsPanel = new JPanel();
                    
                    // Retrieve details of the selected employee
                    String detalhes = modelo_filme.listarDadosFilme(selectedFilme.getIdFilme(), selectedFilme);
                    
                    JTextArea detailsTextArea = new JTextArea(detalhes);
                    detailsTextArea.setEditable(false);
                    
                    JScrollPane scrollPane = new JScrollPane(detailsTextArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                    
                    JButton deleteButton = new JButton("Deletar");
                    deleteButton.setSize(150, 30);
                    deleteButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Chama a função delete do modelo
                            modelo_filme.excluirFilme(selectedFilme.getIdFilme(), selectedFilme);
                            JOptionPane.showMessageDialog(null, "Filme deletado com sucesso!");
                            detailsFrame.dispose();
                            }
                        });
                    
                    detailsPanel.add(scrollPane);
                    detailsFrame.add(detailsPanel);
                    detailsPanel.add(deleteButton);
                    detailsFrame.setVisible(true);
                }
            });
            nomesFilme.add(func.getTitulo());
            painel.add(new JLabel(func.getTitulo()));
            painel.add(botaoDetalhes);
        }
        

        // Janela
        janela.add(painel);
        janela.setSize(150, 300);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create an instance of JanelaListarF
        JanelaListarFilme janela = new JanelaListarFilme();
        janela.initialize();
    }
}

