package br.unicamp.ic.mc322.lab09.filas;

import br.unicamp.ic.mc322.lab09.lista.Pessoa;
import br.unicamp.ic.mc322.lab09.lista.Lista;

public class Fila {

    private Lista pessoas;

    public Fila() {
        this.pessoas = new Lista();
    }

    public void adicionar(Pessoa pessoa) {
        pessoas.adicionarFim(pessoa);
    }

    public void remover() {
        pessoas.removerInicio();
    }

    public Integer tamanho() {
        return pessoas.tamanho();
    }

    public void limpa() {
        pessoas.limpa();
    }

    public void imprimir() {
        pessoas.imprimir();
    }

}
