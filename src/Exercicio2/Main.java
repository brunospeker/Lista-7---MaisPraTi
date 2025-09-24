package Exercicio2;

import Exercicio2.Desconto;

public class Main {
    public static void main(String[] args) {

        Desconto produto1 = new Desconto("Smartphone", 2000.00, 15);
        Desconto produto2 = new Desconto("Computador", 2000.00, 15);

        produto1.exibirInformacoes();
        produto2.exibirInformacoes();

        try {
            produto1.aplicarDesconto(5); //Funciona
            produto1.exibirInformacoes();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir nome: " + e.getMessage());
        }

        try {
            produto2.aplicarDesconto(51); //Não funciona
            produto2.exibirInformacoes();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir nome: " + e.getMessage());
        }
    }
}
