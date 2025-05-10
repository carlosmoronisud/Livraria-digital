package LivrariaDigitalModel;

public class Ebook extends Livro {
    private int acesso;  
    public Ebook(int id, String titulo, String autor, int tipo, double preco, int acesso) {
        super(id, titulo, autor, tipo, preco);
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
    public void visualizar() {
        super.visualizar();
        System.out.println("Status " );
        liberacao();
        System.out.println("=========================");
    }

    // Getters e Setters 
    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
}