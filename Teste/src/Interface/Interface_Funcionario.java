/*
Define os metodos utilizados em Modelo_Funcionario

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Interface;
import java.util.ArrayList;
import Controladores.Funcionario;

public interface Interface_Funcionario {
    public boolean cadastrarFuncionario (Funcionario funcionario);
    public boolean editarFuncionario (int idFuncionario, Funcionario funcionario);
    public boolean excluirFuncionario (int idFuncionario, Funcionario funcionario);
    public ArrayList<Funcionario> listarFuncionarios();
    public String listarDadosFuncionario(int id, Funcionario funcionario);
}
