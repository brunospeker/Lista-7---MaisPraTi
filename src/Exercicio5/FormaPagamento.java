package Exercicio5;

import java.math.BigDecimal;

public abstract class FormaPagamento {

    public abstract void validarPagamento() throws PagamentoInvalidoException;
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException{
        validarPagamento();
        System.out.println("Pagamento processado: "+valor);
    }
}
