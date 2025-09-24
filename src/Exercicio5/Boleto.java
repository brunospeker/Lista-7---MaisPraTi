package Exercicio5;

public class Boleto extends FormaPagamento{
    private String codigoBoleto;

    public Boleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException{
        if(codigoBoleto.length() != 47){
            throw new PagamentoInvalidoException("Erro no código do boleto.");
        }
        System.out.println("Boleto validado.");
    }
}