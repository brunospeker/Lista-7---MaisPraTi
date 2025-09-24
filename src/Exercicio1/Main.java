package Exercicio1;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Smartphone", 3.500, 10);

        produto1.exibirInformacoes();

        try {
            produto1.setPreco(-100.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir preço: " + e.getMessage());
        }

        try {
            produto1.setQuantidadeEmEstoque(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir quantidade: " + e.getMessage());
        }

        try {
            produto1.setNome("");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir nome: " + e.getMessage());
        }


    }
}
