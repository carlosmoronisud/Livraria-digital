package Model;

public class LivroFisico extends Livro{
	
	private int quantidade;
	
	public LivroFisico(int id, String nome, String autor, int tipo, double preco, int quantidade) {
		super(id, nome, autor, tipo, preco);
		// TODO Auto-generated constructor stub
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	@Override
	public void visualizar() {		
		super.visualizar();
		System.out.println("Quantidade em estoque:  " + this.quantidade);
	}
	
	

	

	

	

}
