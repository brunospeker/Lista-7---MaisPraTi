package Exercicio5;

public class Pix extends FormaPagamento{
    private String ChavePix;

    public Pix(String ChavePix) {
        this.ChavePix = ChavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException{
        if(ChavePix.length() !=11){
            throw new PagamentoInvalidoException("Erro no número da chave pix.");
        }
        System.out.println("Chave Pix validado.");
    }
}