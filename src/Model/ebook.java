package Model;

public class Ebook extends Livro {
    private int acesso;  
    public Ebook(int id, String nome, String autor, int tipo, double preco, int acesso) {
        super(id, nome, autor, tipo, preco);
        this.acesso = acesso;
    }

    @Override
    public void liberacao() {
        String status = switch(this.acesso) {
            case 1 -> "Liberado para download";
            case 2 -> "Acesso restrito (pendente de pagamento)";
            default -> "Status desconhecido";
        };
        System.out.println(status);
    }

    // Getters e Setters 
    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
}