/*
Define os metodos utilizados em Modelo_Cliente
EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Interface;
import java.util.ArrayList;
import Controladores.Cliente;

public interface Interface_Cliente {
    public boolean cadastrarCliente (Cliente cliente);
    public boolean editarCliente (int idCliente, Cliente cliente);
    public boolean excluirCliente (int idCliente, Cliente cliente);
    public ArrayList<Cliente> listarClientes();
    public String listarDadosCliente(int id, Cliente cliente);
}
