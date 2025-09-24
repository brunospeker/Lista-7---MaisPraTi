package Exercicio5;

import Exercicio5.FormaPagamento;
import Exercicio5.CartaoCredito;
import Exercicio5.Pix;
import Exercicio5.Boleto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        FormaPagamento cartao = new CartaoCredito("1234567812345678");
        FormaPagamento boleto = new Boleto("123456789012345678901234567890123456789012345");
        FormaPagamento pix = new Pix("12345678901");

        try {
            cartao.processarPagamento(new BigDecimal("100.00"));
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro no pagamento com cartão: " + e.getMessage());
        }

        try {
            boleto.processarPagamento(new BigDecimal("150.00"));
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro no pagamento com boleto: " + e.getMessage());
        }

        try {
            pix.processarPagamento(new BigDecimal("200.00"));
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro no pagamento com Pix: " + e.getMessage());
        }
    }
}
