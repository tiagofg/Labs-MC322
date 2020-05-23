package br.unicamp.ic.mc322.lab09.filas;

import br.unicamp.ic.mc322.lab09.lista.Pessoa;

public class FilaDeAtendimento extends Fila {

    Fila prioritario;

    public FilaDeAtendimento() {
        this.prioritario = new Fila();
    }

    public void adicionarPrioritario(Pessoa pessoa) {
        prioritario.adicionar(pessoa);
    }

    @Override
    public void remover() {
        if (prioritario.tamanho() > 0) {
            prioritario.remover();
        } else {
            super.remover();
        }
    }

    @Override
    public Integer tamanho() {
        return super.tamanho() + prioritario.tamanho();
    }

    @Override
    public void imprimir() {
        System.out.println("Fila de atendimento normal: ");
        super.imprimir();

        System.out.println("Fila de atendimento prioritário: ");
        prioritario.imprimir();
    }
}
