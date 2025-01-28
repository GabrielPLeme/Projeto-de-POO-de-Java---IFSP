/*
Classe Filme

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Controladores;

public class Filme {
    private int idFilme;
    private String titulo;
    private String classificacao;
    private String genero;

    public Filme(){}

    public int getIdFilme() {
        return idFilme;
    }
    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme: " + getIdFilme() + " || " + getTitulo() + " | Classificacao: " + getClassificacao() + " | genero: " + getGenero();
    }
}
