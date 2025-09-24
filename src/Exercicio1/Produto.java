package Exercicio1;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if ((nome == null) | nome.isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco < 0){
            throw new IllegalArgumentException("O preço não pode ser menor que zero.");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if(quantidadeEmEstoque < 0){
            throw new IllegalArgumentException("A quantidade em estoque não pode ser menor que zero.");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void exibirInformacoes(){
        System.out.println("Nome: "+ this.nome);
        System.out.println("Preco: "+ this.preco);
        System.out.println("Quantidade em Estoque: "+ this.quantidadeEmEstoque);
        System.out.println("\n");
    }
}
