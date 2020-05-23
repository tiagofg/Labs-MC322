package br.unicamp.ic.mc322.lab09.lista;

public class Lista {

    private Pessoa inicio;
    private Pessoa fim;

    public Lista() {
        inicio = null;
        fim = null;
    }

    private boolean listaVazia() {
        return inicio == null && fim == null;
    }

    private void inicializarLista(Pessoa pessoa) {
        pessoa.setPosicao(0);
        inicio = pessoa;
        fim = pessoa;
    }

    private void incrementarPosicoes(Pessoa pessoa) {
        do {
            pessoa.setPosicao(pessoa.getPosicao() + 1);

            pessoa = pessoa.getProximo();
        } while (pessoa != null);
    }

    private void decrementarPosicoes(Pessoa pessoa) {
        do {
            pessoa.setPosicao(pessoa.getPosicao() - 1);

            pessoa = pessoa.getProximo();
        } while (pessoa != null);
    }

    public void adicionarInicio(Pessoa pessoa) {
        if (listaVazia()) {
            inicializarLista(pessoa);
        } else {
            pessoa.setPosicao(0);
            pessoa.setProximo(inicio);

            incrementarPosicoes(inicio);

            inicio = pessoa;
        }
    }

    public void adicionarFim(Pessoa pessoa) {
        if (listaVazia()) {
            inicializarLista(pessoa);
        } else {
            pessoa.setPosicao(fim.getPosicao() + 1);
            pessoa.setAnterior(fim);

            fim.setProximo(pessoa);

            fim = pessoa;
        }
    }

    private Pessoa encontrar(Integer posicao) {
        Pessoa pessoa = inicio;

        do {
            if (pessoa.getPosicao().equals(posicao)) {
                return pessoa;
            }

            pessoa = pessoa.getProximo();
        } while (pessoa != null);

        return null;
    }

    public void adicionar(Pessoa pessoa, Integer posicao) {
        if (posicao < 0 || posicao > tamanho()) {
            System.err.println("Impossível inserir nessa posição");
            return;
        }

        if (listaVazia() && posicao == 0) {
            adicionarInicio(pessoa);
            return;
        }

        Pessoa atual = encontrar(posicao);

        if (atual == null) {
            adicionarFim(pessoa);
        } else {
            pessoa.setAnterior(atual.getAnterior());
            pessoa.setProximo(atual);

            incrementarPosicoes(atual);
        }
    }

    public void removerInicio() {
        if (inicio.equals(fim)) {
            limpa();
        } else {
            Pessoa proximo = inicio.getProximo();

            decrementarPosicoes(inicio);

            inicio.setProximo(null);
            proximo.setAnterior(null);

            inicio = proximo;
        }
    }

    public void removerFim() {
        if (inicio.equals(fim)) {
            limpa();
        } else {
            Pessoa anterior = fim.getAnterior();

            fim.setAnterior(null);
            anterior.setProximo(null);

            fim = anterior;
        }
    }

    public void remover(Integer posicao) {
        if (posicao < 0 || posicao > tamanho()) {
            System.err.println("Posição inválida.");
            return;
        }

        Pessoa atual = encontrar(posicao);

        if (atual == null) {
            System.err.println("Impossível remover dessa posição");
            return;
        }

        Pessoa anterior = atual.getAnterior();
        Pessoa proximo = atual.getProximo();

        decrementarPosicoes(atual);

        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);
    }

    public Integer tamanho() {
        if (fim == null) {
            return 0;
        }

        return fim.getPosicao() + 1;
    }

    public void limpa() {
        if (inicio == null && fim == null) {
            return;
        }

        Pessoa pessoa = inicio;
        Pessoa proximo;

        do {
            proximo = pessoa.getProximo();

            pessoa.setAnterior(null);
            pessoa.setProximo(null);

        } while (proximo != null);

        inicio = null;
        fim = null;
    }

    public void imprimir() {
        if (listaVazia()) {
            return;
        }

        Pessoa atual = inicio;

        do {
            System.out.println(atual);

            atual = atual.getProximo();
        } while (atual != null);
    }

}
