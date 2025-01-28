/*
Define os comandos a serem executados na tabela Cliente dentro da Database

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interface.Interface_Cliente;
import Controladores.Cliente;

public class Modelo_Cliente implements Interface_Cliente{
    private Conexao conectar;

    //Criar conexao
    public Modelo_Cliente(){
        conectar = new Conexao();
    }
    // MySQL Insert
    public boolean cadastrarCliente (Cliente cliente){
        String comando = new String();
        comando = "INSERT INTO Cliente (nome, idade) VALUES ('" + cliente.getNome() + "', " + cliente.getIdade() + ")";
        // Tratamento de excessão
        try {
            conectar.inserir(comando);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    // MySQL Update
    public boolean editarCliente (int idCliente, Cliente cliente){
        String comando = new String();
        comando = "UPDATE Cliente SET nome = '" + cliente.getNome() + "', idade = " + cliente.getIdade() + " WHERE idCliente = " + cliente.getIdCliente();
        // Tratamento de excessão
        try {
            conectar.atualizar(comando);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    // MySQL Delete
    public boolean excluirCliente (int idCliente, Cliente cliente){
        String comando = new String();
        comando = "DELETE FROM Cliente WHERE idCliente = " + cliente.getIdCliente();
        // Tratamento de excessão
        try {
            conectar.atualizar(comando);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    //MySQL Select *
    public ArrayList<Cliente> listarClientes(){
        ResultSet resultSet = null;
        String comando = new String();
        comando = "SELECT * FROM Cliente";
        ArrayList<Cliente> listarClientes = new ArrayList<Cliente>();
        try {
            resultSet = conectar.listar(comando);
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setIdade(resultSet.getInt("idade"));
                listarClientes.add(cliente);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listarClientes;
    }
    //MySQL Select
    public String listarDadosCliente(int id, Cliente cliente){
        ResultSet resultSet = null;
        String comando = new String();
        comando = "SELECT * FROM Cliente WHERE id = " + cliente.getIdCliente();
        try {
            resultSet = conectar.listar(comando);
            while (resultSet.next()) {
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setIdade(resultSet.getInt("idade"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente.toString();
    }
}
