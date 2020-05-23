package br.unicamp.ic.mc322.lab09;

import br.unicamp.ic.mc322.lab09.filas.FilaDeAtendimento;
import br.unicamp.ic.mc322.lab09.lista.Pessoa;

public class Main {

    public static void main(String[] args) {
        FilaDeAtendimento fila = new FilaDeAtendimento();

        Pessoa joao = new Pessoa("João",
                40, "123.456.789-10");

        Pessoa maria = new Pessoa("Maria",
                30, "123.456.789-10");

        Pessoa jose = new Pessoa("José",
                50, "123.456.789-10");

        fila.adicionar(joao);
        fila.adicionarPrioritario(maria);
        fila.adicionarPrioritario(jose);

        System.out.println(fila.tamanho());

        fila.imprimir();

        fila.remover();
        fila.remover();

        System.out.println(fila.tamanho());

        fila.imprimir();
    }

}
