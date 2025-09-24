package Exercicio5;

public class CartaoCredito extends FormaPagamento{
    private String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException{
        if(numeroCartao.length() < 16){
            throw new PagamentoInvalidoException("Erro no número do cartão de crédito.");
        }
        System.out.println("Cartão de crédito validado.");
    }
}
