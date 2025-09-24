package Exercicio8;

import java.math.BigDecimal;

public class Pedido {
    private final String cepDestino;
    private final BigDecimal valorTotal;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(String cepDestino, BigDecimal valorTotal, CalculadoraFrete estrategiaFrete) {
        if (cepDestino.length() != 8) {
            throw new CepInvalidoException("CEP inválido: " + cepDestino);
        }
        if (valorTotal == null || valorTotal.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor do pedido inválido.");
        }
        if (estrategiaFrete == null) {
            throw new IllegalArgumentException("Estratégia de frete não pode ser nula.");
        }

        this.cepDestino = cepDestino;
        this.valorTotal = valorTotal;
        this.estrategiaFrete = estrategiaFrete;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal calcularFrete() {
        return estrategiaFrete.calcular(this);
    }

    public void setEstrategiaFrete(CalculadoraFrete novaEstrategia) {
        if (novaEstrategia == null) {
            throw new IllegalArgumentException("Estratégia de frete não pode ser nula.");
        }
        this.estrategiaFrete = novaEstrategia;
    }
}
