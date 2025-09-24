package Exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal descontoAplicado; // Ex: 0.10 para 10%

    public Carrinho(List<ItemCarrinho> itens, BigDecimal descontoAplicado) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.descontoAplicado = descontoAplicado.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Carrinho() {
        this(List.of(), BigDecimal.ZERO);
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.add(new ItemCarrinho(produto, quantidade));
        return new Carrinho(novaLista, this.descontoAplicado);
    }

    public Carrinho removerItem(Produto produto) {
        List<ItemCarrinho> novaLista = new ArrayList<>();
        for (ItemCarrinho item : itens) {
            if (!item.getProduto().equals(produto)) {
                novaLista.add(item);
            }
        }
        return new Carrinho(novaLista, this.descontoAplicado);
    }

    public Carrinho aplicarCupom(BigDecimal percentualDesconto) {
        if (percentualDesconto == null ||
                percentualDesconto.compareTo(BigDecimal.ZERO) < 0 ||
                percentualDesconto.compareTo(BigDecimal.valueOf(0.30)) > 0) {
            throw new IllegalArgumentException("Cupom inválido. Máximo de 30% permitido.");
        }
        return new Carrinho(this.itens, percentualDesconto);
    }

    public Dinheiro calcularTotal() {
        if (itens.isEmpty()) {
            return new Dinheiro(BigDecimal.ZERO, Moeda.BRL);
        }

        Dinheiro totalBruto = itens.stream()
                .map(ItemCarrinho::getTotal)
                .reduce((a, b) -> a.somar(b))
                .orElseThrow();

        BigDecimal fatorDesconto = BigDecimal.ONE.subtract(descontoAplicado);
        return totalBruto.multiplicar(fatorDesconto);
    }

    public BigDecimal getDescontoAplicado() {
        return descontoAplicado;
    }
}