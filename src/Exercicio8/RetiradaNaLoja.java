package Exercicio8;

import java.math.BigDecimal;

public class RetiradaNaLoja implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return new BigDecimal("1.00");
    }
}