/*
Define os comandos a serem executados na tabela Filme dentro da Database

EDITADO POR ULTIMO:
VINIE - 17/11/23
*/

//************************************************************************************************
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interface.Interface_Filme;
import Controladores.Filme;

public class Modelo_Filme implements Interface_Filme{
    private Conexao conectar;

    //Criar conexao
    public Modelo_Filme(){
        conectar = new Conexao();
    }
    //MySQL insert
    public boolean cadastrarFilme(Filme filme) {
        String comando = new String();
        comando = "INSERT INTO Filme (titulo, classificacao, genero) VALUES ('" + filme.getTitulo() + "' , '" + filme.getClassificacao() + "' , '" + filme.getGenero() + "')";
        // Tratamento de excessão
        try {
            conectar.inserir(comando);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    //MySQL update
    public boolean editarFilme(int idFilme, Filme filme) {
        String comando  = new String();
        comando = "UPDATE Filme SET titulo = '" + filme.getTitulo() + "', classificacao = '" + filme.getClassificacao() + "', genero = '" + filme.getGenero() + "' WHERE idFilme = '" + filme.getClassificacao();
        // Tratamento de excessão
        try {
            conectar.atualizar(comando);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    //MySQL delete
    public boolean excluirFilme(int idFilme, Filme filme) {
        String comando = new String();
        comando = "DELETE FROM Filme WHERE idFilme = " + filme.getIdFilme();
        // Tratamento de excessão
        try {
            conectar.apagar(comando);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    //MySQL Select *
    public ArrayList<Filme> listarFilmes(){
        ResultSet resultSet = null;
        String comando = new String();
        comando = "SELECT * FROM Filme";
        ArrayList<Filme> listarFilmes = new ArrayList<Filme>();
        try {
            resultSet = conectar.listar(comando);
            while (resultSet.next()) {
                Filme filme = new Filme();
                filme.setIdFilme(resultSet.getInt("idFilme"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setClassificacao(resultSet.getString("classificacao"));
                filme.setGenero(resultSet.getString("genero"));
                listarFilmes.add(filme);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listarFilmes;
    }
    //MySQL Select
    public String listarDadosFilme(int id, Filme filme){
        ResultSet resultSet = null;
        String comando = new String();
        comando = "SELECT * FROM Filme WHERE id = " + filme.getIdFilme();
        try {
            resultSet = conectar.listar(comando);
            while (resultSet.next()) {
                filme.setIdFilme(resultSet.getInt("idFilme"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setClassificacao(resultSet.getString("classificacao"));
                filme.setGenero(resultSet.getString("genero"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filme.toString();
    }

    
}
