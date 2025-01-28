/*
Define os comandos a serem executados na tabela Funcionario dentro da Database

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interface.Interface_Funcionario;
import Controladores.Funcionario;

public class Modelo_Funcionario implements Interface_Funcionario{
    private Conexao conectar;

    //Cria conexão
    public Modelo_Funcionario() {
        conectar = new Conexao();
    }
    // MySQL Insert
    public boolean cadastrarFuncionario (Funcionario funcionario) {
        String comando = new String();
        comando = "INSERT INTO Funcionario (nome, idade, email) VALUES ('"+ funcionario.getNome() +"', " + funcionario.getIdade() + ", '" + funcionario.getEmail() + "')";
        //Tratamento de excessão
        try {
            conectar.inserir(comando);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    // MySQL Update
    public boolean editarFuncionario (int idFuncionario, Funcionario funcionario) {
        String comando = new String();
        comando = "UPDATE Funcionario SET nome = '"+ funcionario.getNome() + "', idade = " + funcionario.getIdade() + ", email = '" + funcionario.getEmail() + "' WHERE id = "+ funcionario.getIdFuncionario();
        //Tratamento de excessão
        try {
            conectar.atualizar(comando);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    //MySQL Delete
    public boolean excluirFuncionario (int idFuncionario, Funcionario funcionario) {
        String comando = new String();
        comando = "DELETE FROM Funcionario WHERE idFuncionario = "+ funcionario.getIdFuncionario();
        //Tratamento de excessão
        try {
            conectar.apagar(comando);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    //MySQL Select *
    public ArrayList<Funcionario> listarFuncionarios(){
        ResultSet resultSet = null;
        String comando = new String();
        comando = "SELECT * FROM Funcionario";
        ArrayList<Funcionario> listarFuncionarios = new ArrayList<Funcionario>();
        try {
            resultSet = conectar.listar(comando);
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setIdade(resultSet.getInt("idade"));
                funcionario.setEmail(resultSet.getString("email"));
                listarFuncionarios.add(funcionario);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listarFuncionarios;
    }
    //MySQL Select
    public String listarDadosFuncionario(int id, Funcionario funcionario){
        ResultSet resultSet = null;
        String comando = new String();
        comando = "SELECT * FROM Funcionario WHERE id = " + funcionario.getIdFuncionario();
        try {
            resultSet = conectar.listar(comando);
            while (resultSet.next()) {
                funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setIdade(resultSet.getInt("idade"));
                funcionario.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario.toString();
    }
}
