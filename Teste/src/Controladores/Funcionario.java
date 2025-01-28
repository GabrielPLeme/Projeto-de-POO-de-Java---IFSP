/*
Classe Funcionario

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Controladores;

public class Funcionario extends Pessoa{
    private int idFuncionario;
    private String email;

    public Funcionario(){}

    public Funcionario(String nome, int idade, String email){
        super.setNome(nome);
        super.setIdade(idade);
        this.email = email;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Funcionario: " + getIdFuncionario() + "|| Nome: " + getNome() + " Idade: " + getIdade() + " Email: " + getEmail();
    }
}
