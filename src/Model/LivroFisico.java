package Model;

public class LivroFisico extends Livro {
    private int quantidade;
    
    public LivroFisico(int id, String nome, String autor, int tipo, double preco, int quantidade) {
        super(id, nome, autor, tipo, preco);
        this.quantidade = quantidade;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Quantidade em estoque: " + this.quantidade);
        System.out.println("=========================");
    }

    @Override
    public void liberacao() {
        System.out.println("Livro físico disponível para envio imediato");
    }

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
	    if (quantidade < 0) {
	        throw new IllegalArgumentException("Quantidade não pode ser negativa");
	    }
	    this.quantidade = quantidade;
	}
}