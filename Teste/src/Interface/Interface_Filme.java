/*
Define os metodos utilizados em Modelo_Filme

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Interface;
import java.util.ArrayList;
import Controladores.Filme;

public interface Interface_Filme {
    public boolean cadastrarFilme(Filme filme);
    public boolean editarFilme(int idFilme, Filme filme);
    public boolean excluirFilme(int idFilme, Filme filme);
    public ArrayList<Filme> listarFilmes();
    public String listarDadosFilme(int id, Filme filme);
}
