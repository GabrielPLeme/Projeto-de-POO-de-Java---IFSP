/*
Classe Cliente

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Controladores;

public class Cliente extends Pessoa{
    private int idCliente;

    public Cliente(){}
    
    public Cliente(String nome, int idade){
        super.setNome(nome);
        super.setIdade(idade);
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString(){
        return "Cliente: " + getIdCliente() + " || Nome: " + getNome() + " Idade: " + getIdCliente();
    }
}
