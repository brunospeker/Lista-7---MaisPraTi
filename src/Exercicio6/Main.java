package Exercicio6;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto("Notebook", new Dinheiro(new BigDecimal("3000.00"), Moeda.BRL));
        Produto p2 = new Produto("Mouse", new Dinheiro(new BigDecimal("150.00"), Moeda.BRL));

        Carrinho carrinho = new Carrinho();
        System.out.println("Carrinho sem produtos: " + carrinho.calcularTotal()); // R$0.00

        carrinho = carrinho.adicionarItem(p1, 1);
        carrinho = carrinho.adicionarItem(p2, 2);
        System.out.println("Valor total sem descontos: " + carrinho.calcularTotal()); // 3000 + 2x150 = 3300

        carrinho = carrinho.aplicarCupom(new BigDecimal("0.20"));
        System.out.println("Valor total com cupom aplicado:: " + carrinho.calcularTotal()); // 2640.00

        carrinho = carrinho.removerItem(p2);
        System.out.println("Valor total após remover um item: " + carrinho.calcularTotal()); // 3000 * 0.8 = 2400.00

        try {
            carrinho.aplicarCupom(new BigDecimal("0.35"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        try {
            new Dinheiro(new BigDecimal("-5"), Moeda.BRL);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        try {
            new ItemCarrinho(p1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

    }
}