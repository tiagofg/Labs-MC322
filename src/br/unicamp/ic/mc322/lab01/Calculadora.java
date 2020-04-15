package br.unicamp.ic.mc322.lab01;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        int opcao = 0, numeroUm = 0, numeroDois = 0, numero = 0;

         do {
             Scanner entrada = new Scanner(System.in);

             System.out.println("Digite uma das opções: \n");
             System.out.println("1. Somar ");
             System.out.println("2. Subtrair ");
             System.out.println("3. Multiplicar ");
             System.out.println("4. Dividir ");
             System.out.println("5. Fatorial ");
             System.out.println("6. É primo ");
             System.out.println("7. sair ");

             opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite um número: ");
                    numeroUm = entrada.nextInt();

                    System.out.println("Digite outro número: ");
                    numeroDois = entrada.nextInt();

                    System.out.println("A soma de " + numeroUm + " e " + numeroDois + " é: " + somar(numeroUm, numeroDois) + "\n");

                    break;

                case 2:
                    System.out.println("Digite um número: ");
                    numeroUm = entrada.nextInt();

                    System.out.println("Digite outro número: ");
                    numeroDois = entrada.nextInt();

                    System.out.println("A subtração de " + numeroUm + " e " + numeroDois + " é: " + subtrair(numeroUm, numeroDois) + "\n");

                    break;

                case 3:
                    System.out.println("Digite um número: ");
                    numeroUm = entrada.nextInt();

                    System.out.println("Digite outro número: ");
                    numeroDois = entrada.nextInt();

                    System.out.println("A multiplicação de " + numeroUm + " e " + numeroDois + " é: " + multiplicar(numeroUm, numeroDois) + "\n");

                    break;

                case 4:
                    System.out.println("Digite um número: ");
                    numeroUm = entrada.nextInt();

                    System.out.println("Digite outro número: ");
                    numeroDois = entrada.nextInt();

                    System.out.println("A divisão de " + numeroUm + " por " + numeroDois + " é: " + dividir(numeroUm, numeroDois) + "\n");

                    break;

                case 5:
                    System.out.println("Digite um número: ");
                    numero = entrada.nextInt();

                    System.out.println("O fatorial de " + numero + " é: " + fatorial(numero) + "\n");

                    break;

                case 6:
                    System.out.println("Digite um número: ");
                    numero = entrada.nextInt();

                    if (ehPrimo(numero)) {
                        System.out.println(numero + " é um número primo");
                    } else {
                        System.out.println(numero + " não é um número primo");
                    }

                    break;
            }

        } while (opcao > 0 && opcao < 7);

    }

    public static int somar(int numeroUm, int numeroDois) {
        return numeroUm + numeroDois;
    }

    public static int subtrair(int numeroUm, int numeroDois) {
        return numeroUm - numeroDois;
    }

    public static int multiplicar(int numeroUm, int numeroDois) {
        return numeroUm * numeroDois;
    }

    public static double dividir(int numeroUm, int numeroDois) {
        return numeroUm/numeroDois;
    }

    public static int fatorial(int numero) {
        int fat = 1;

        for (int i = 2; i <= numero; i++ ) {
            fat = fat * i;
        }

        return fat;
    }

    public static boolean ehPrimo(int numero) {
        for (int i = 2; i < numero/2; i++) {

            if (numero % i == 0) {
                return false;
            }

        }

        return true;
    }
}
