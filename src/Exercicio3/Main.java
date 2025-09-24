package Exercicio3;

import Exercicio3.Funcionario;
import Exercicio3.Gerente;
import Exercicio3.Desenvolvedor;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarioList = new ArrayList<>();

        funcionarioList.add(new Gerente("Bruno", new BigDecimal("5000.00")));
        funcionarioList.add(new Desenvolvedor("Raiana", new BigDecimal("5400.00")));
        funcionarioList.add(new Desenvolvedor("Jackeline", new BigDecimal("5300.00")));
        funcionarioList.add(new Desenvolvedor("Felipe", new BigDecimal("5200.00")));
        funcionarioList.add(new Desenvolvedor("João", new BigDecimal("5000.00")));
        funcionarioList.add(new Gerente("Jaques", new BigDecimal("7000.00")));

        for(Funcionario funcionario : funcionarioList){
            System.out.println("Nome: "+funcionario.getNome()+"\nSalario: "+funcionario.getSalario()+"\nBonus: "+funcionario.calcularBonus()+"\n\n");
        }
    }
}
