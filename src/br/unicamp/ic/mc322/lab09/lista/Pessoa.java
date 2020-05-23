package br.unicamp.ic.mc322.lab09.lista;

public class Pessoa {

    private String nome;
    private Integer idade;
    private String cpf;
    private Pessoa proximo;
    private Pessoa anterior;
    private Integer posicao;

    public Pessoa(String nome, Integer idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.proximo = null;
        this.anterior = null;
    }

    public Pessoa getProximo() {
        return proximo;
    }

    public void setProximo(Pessoa proximo) {
        this.proximo = proximo;
    }

    public Pessoa getAnterior() {
        return anterior;
    }

    public void setAnterior(Pessoa anterior) {
        this.anterior = anterior;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "CPF: " + cpf + "\n";
    }
}
