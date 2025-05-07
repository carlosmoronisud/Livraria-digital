package Model;

import java.text.NumberFormat;

public abstract class Livro {
    private int id;
    private String nome;    
    private String autor;
    private int tipo;
    private double preco;
    
    public Livro(int id, String nome, String autor, int tipo, double preco) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.tipo = tipo;
        this.preco = preco;
    }

 //Get e Set
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	public void visualizar() {
        NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
        String tipoStr = switch(this.tipo) {
            case 1 -> "Livro Físico";
            case 2 -> "E-book";
            default -> "Tipo Inválido";
        };
        
        System.out.println("\n=== DETALHES DO LIVRO ===");
        System.out.println("ID: " + this.id);
        System.out.println("Título: " + this.nome);
        System.out.println("Autor: " + this.autor);
        System.out.println("Tipo: " + tipoStr);
        System.out.println("Preço: " + nfMoeda.format(this.preco));
    }
	

    public abstract void liberacao();
}