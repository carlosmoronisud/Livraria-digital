package Model;

public class ebook extends Livro {
	
	public ebook(int id, String nome, String autor, int tipo, double preco, String acesso) {
		super(id, nome, autor, tipo, preco);
		// TODO Auto-generated constructor stub
	}

	private String acesso;

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	public void liberacao(String acesso){		
		
		switch(this.acesso) {
		case "1" ->acesso = "Liberado ";
		case "2" -> acesso = "Restrito ";
		default -> acesso = "Inválido!";
		}
	}

	public void visualizar() {	
		super.visualizar();
		System.out.println("Quantidade em estoque:  " + acesso);
	}
	

		
}
