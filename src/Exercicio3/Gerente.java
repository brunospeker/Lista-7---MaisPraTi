package Exercicio3;

import Exercicio3.Funcionario;

import java.math.BigDecimal;

public class Gerente extends Funcionario{
    public Gerente(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        return getSalario().multiply(BigDecimal.valueOf(0.20));
    }
}
