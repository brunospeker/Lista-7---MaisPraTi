package Exercicio7;

public class Main {
    public static void main(String[] args) {
        IRepository<Produto, Integer> produtoRepository = new InMemoryRepository<>();
        IRepository<Funcionario, String> funcionarioInteger = new InMemoryRepository<>();

        Produto produto1 = new Produto(1,"Caneta", 250.00);
        Produto produto2 = new Produto(2,"Chiclete", 650.00);

        produtoRepository.salvar(produto1);
        produtoRepository.salvar(produto2);

        for (Produto produto:produtoRepository.getAll()){
            System.out.println(produto.getNome());
        }
    }
}
