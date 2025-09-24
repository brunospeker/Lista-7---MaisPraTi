package Exercicio2;

import Exercicio1.Produto;

public class Desconto extends Produto {

    public Desconto(String nome, double preco, int quantidadeEmEstoque) {
        super(nome, preco, quantidadeEmEstoque);
    }

    public void aplicarDesconto(double porcentagem){
        if(porcentagem >= 0 && porcentagem <= 50){
            double desconto = getPreco() * (porcentagem/100);
            double resultado = getPreco() - desconto;
            setPreco(resultado);
        }
        else {
            throw new IllegalArgumentException("O desconto não pode ser menor que zero ou superior a 50.");
        }
    }
}
