package Exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro {
    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor == null || moeda == null) {
            throw new IllegalArgumentException("Valor e moeda não podem ser nulos.");
        }
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Dinheiro não pode ter valor negativo.");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public Dinheiro multiplicar(BigDecimal fator) {
        return new Dinheiro(valor.multiply(fator), moeda);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        verificarMoeda(outro);
        return new Dinheiro(this.valor.subtract(outro.valor), moeda);
    }

    public Dinheiro somar(Dinheiro outro) {
        verificarMoeda(outro);
        return new Dinheiro(this.valor.add(outro.valor), moeda);
    }

    private void verificarMoeda(Dinheiro outro) {
        if (!this.moeda.equals(outro.moeda)) {
            throw new IllegalArgumentException("Moedas diferentes não podem ser operadas.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinheiro)) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return valor.equals(dinheiro.valor) && moeda == dinheiro.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }

    @Override
    public String toString() {
        return moeda + " " + valor;
    }
}