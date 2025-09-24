package Exercicio8;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        CalculadoraFrete sedex = new Sedex();
        CalculadoraFrete pac = new Pac();
        CalculadoraFrete retirada = new RetiradaNaLoja();

        CalculadoraFrete freteGratis = pedido -> {
            if (pedido.getValorTotal().compareTo(new BigDecimal("300")) >= 0) {
                return BigDecimal.ZERO;
            }
            return new BigDecimal("20.00");
        };

        Pedido pedido = new Pedido("12345678", new BigDecimal("250.00"), sedex);
        System.out.println("Frete (Sedex): R$ " + pedido.calcularFrete());

        pedido.setEstrategiaFrete(pac);
        System.out.println("Frete (PAC): R$ " + pedido.calcularFrete());

        pedido.setEstrategiaFrete(retirada);
        System.out.println("Frete (Retirada na loja): R$ " + pedido.calcularFrete());

        pedido.setEstrategiaFrete(freteGratis);
        System.out.println("Frete (Promoção abaixo de R$300): R$ " + pedido.calcularFrete());

        Pedido pedidoPromocional = new Pedido("98765432", new BigDecimal("310.00"), freteGratis);
        System.out.println("Frete (Promoção acima de R$300(Gratis)): R$ " + pedidoPromocional.calcularFrete());

        try {
            new Pedido("1234", new BigDecimal("100"), sedex);
        } catch (CepInvalidoException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}