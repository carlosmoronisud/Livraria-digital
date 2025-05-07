package projeto_final_bloco_01;

import java.util.Scanner;
import LivroController.LivroController; 
import java.util.List;
import Model.Livro;
import Model.LivroFisico;
import Model.Ebook;
import projetoFinal.util.Cores;
import projetoFinal.util.projetoFinalExceptions;

public class Menu {
    private static LivroController controller = new LivroController();
   
    private static Scanner leia = new Scanner(System.in);     
       

        public static void main(String[] args) {
            int opcao;
            
            do {
                exibirMenu();
                opcao = lerOpcao();
                
                if (opcao == 0) {
                   sobre();
                    break;
                }
                
                processarOpcao(opcao);
                
            } while (true);
    }

   

	private static void exibirMenu() {
        System.out.println(Cores.TEXT_CYAN_BOLD + "\n=== BOOKSTORE ===" + Cores.TEXT_RESET);
        System.out.println("1. Cadastrar Livro Físico");
        System.out.println("2. Cadastrar E-book");
        System.out.println("3. Listar Todos os Produtos");
        System.out.println("4. Buscar Produto por ID");
        System.out.println("5. Atualizar Livro");
        System.out.println("6. Deletar Livro");
        
        System.out.println("0. Sair");
        System.out.print(Cores.TEXT_YELLOW + "Opção: " + Cores.TEXT_RESET);
    }

    private static int lerOpcao() {
        try {
            return leia.nextInt();
        } catch (Exception e) {
            leia.nextLine(); // Limpa o buffer
            return -1; // Valor inválido
        }
    }

    private static void processarOpcao(int opcao) {
        switch(opcao) {
            case 1:
                cadastrarLivroFisico();
                break;
            case 2:
                cadastrarEbook();
                break;
            case 3:
                listarTodos();
                break;
            case 4:
                buscarPorId();
                break;
            case 5:
                atualizarLivro();
                break;
            case 6:
                deletarLivro();
                break;
           
            default:
                System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
        }
        projetoFinalExceptions.keyPress();
    }
    
    private static void cadastrarLivroFisico() {
        System.out.println(Cores.TEXT_GREEN_BOLD + "\nCadastrar Livro Físico\n" + Cores.TEXT_RESET);
        
        System.out.print("Título: ");
        String titulo = leia.nextLine();
        leia.nextLine();
        
        System.out.print("Autor: ");
        String autor = leia.nextLine();
        leia.nextLine();
        
        System.out.print("Preço: ");
        double preco = leia.nextDouble();
        leia.nextLine(); // Limpa buffer
        
        System.out.print("Quantidade em estoque: ");
        int quantidade = leia.nextInt();
        leia.nextLine(); // Limpa buffer
        
        LivroFisico livro = new LivroFisico(0, titulo, autor, 1, preco, quantidade);
        controller.cadastrar(livro);
        
        System.out.println(Cores.TEXT_GREEN + "Livro físico cadastrado com sucesso!" + Cores.TEXT_RESET);
    }

    private static void cadastrarEbook() {
        System.out.println(Cores.TEXT_GREEN_BOLD + "\nCadastrar E-book\n" + Cores.TEXT_RESET);
        
        System.out.print("Título: ");
        String titulo = leia.nextLine();
        leia.nextLine();
        
        System.out.print("Autor: ");
        String autor = leia.nextLine();
        leia.nextLine();
        
        double preco = lerDouble("Preço: ");
        
        int acesso = lerInteiro("Tipo de acesso (1-Liberado/2-Restrito): ");
        
        Ebook ebook = new Ebook(0, titulo, autor, 2, preco, acesso);
        controller.cadastrar(ebook);
        
        System.out.println(Cores.TEXT_GREEN + "E-book cadastrado com sucesso!" + Cores.TEXT_RESET);
    }

    private static void listarTodos() {
        System.out.println(Cores.TEXT_BLUE_BOLD + "\nLista de Todos os Livros\n" + Cores.TEXT_RESET);
        
        List<Livro> livros = controller.listarTodos();
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            livros.forEach(Livro::visualizar);
        }
    }

    private static void buscarPorId() {
        System.out.println(Cores.TEXT_BLUE_BOLD + "\nBuscar Livro por ID\n" + Cores.TEXT_RESET);
        
        System.out.print("Digite o ID: ");
        int id = leia.nextInt();
        leia.nextLine(); // Limpa buffer
        
        Livro livro = controller.buscarPorId(id);
        
        if (livro != null) {
            livro.visualizar();
        } else {
            System.out.println(Cores.TEXT_RED + "Livro não encontrado!" + Cores.TEXT_RESET);
        }
    }

    private static void atualizarLivro() {
        System.out.println(Cores.TEXT_PURPLE_BOLD + "\nAtualizar Livro\n" + Cores.TEXT_RESET);
        
        System.out.print("Digite o ID do livro que deseja atualizar: ");
        int id = leia.nextInt();
        leia.nextLine(); // Limpa o buffer
        
        Livro livroExistente = controller.buscarPorId(id);
        if (livroExistente == null) {
            System.out.println(Cores.TEXT_RED + "Livro não encontrado!" + Cores.TEXT_RESET);
            return;
        }
        
        System.out.println("\nLivro encontrado:");
        livroExistente.visualizar();
        
        System.out.println("\nDigite os novos dados:");
        
        System.out.print("Título (" + livroExistente.getNome() + "): ");
        String novoTitulo = leia.nextLine();
        novoTitulo = novoTitulo.isEmpty() ? livroExistente.getNome() : novoTitulo;
        
        System.out.print("Autor (" + livroExistente.getAutor() + "): ");
        String novoAutor = leia.nextLine();
        novoAutor = novoAutor.isEmpty() ? livroExistente.getAutor() : novoAutor;
        
        System.out.print("Preço (" + livroExistente.getPreco() + "): ");
        String precoInput = leia.nextLine();
        double novoPreco = precoInput.isEmpty() ? livroExistente.getPreco() : Double.parseDouble(precoInput);
        
        Livro livroAtualizado;
        if (livroExistente instanceof LivroFisico) {
            LivroFisico livroFisico = (LivroFisico) livroExistente;
            System.out.print("Quantidade em estoque (" + livroFisico.getQuantidade() + "): ");
            String quantidadeInput = leia.nextLine();
            int novaQuantidade = quantidadeInput.isEmpty() ? livroFisico.getQuantidade() : Integer.parseInt(quantidadeInput);
            
            livroAtualizado = new LivroFisico(id, novoTitulo, novoAutor, 1, novoPreco, novaQuantidade);
        } else {
            Ebook ebook = (Ebook) livroExistente;
            System.out.print("Tipo de acesso (" + ebook.getAcesso() + " [1-Liberado/2-Restrito]): ");
            String acessoInput = leia.nextLine();
            int novoAcesso = acessoInput.isEmpty() ? ebook.getAcesso() : Integer.parseInt(acessoInput);
            
            livroAtualizado = new Ebook(id, novoTitulo, novoAutor, 2, novoPreco, novoAcesso);
        }
        
        boolean sucesso = controller.atualizar(livroAtualizado);
        if (sucesso) {
            System.out.println(Cores.TEXT_GREEN + "Livro atualizado com sucesso!" + Cores.TEXT_RESET);
            System.out.println("\nDados atualizados:");
            livroAtualizado.visualizar();
        } else {
            System.out.println(Cores.TEXT_RED + "Erro ao atualizar o livro." + Cores.TEXT_RESET);
        }
    }

    private static void deletarLivro() {
        System.out.println(Cores.TEXT_RED_BOLD + "\nDeletar Livro\n" + Cores.TEXT_RESET);
        
        System.out.print("Digite o ID do livro que deseja deletar: ");
        int id = leia.nextInt();
        leia.nextLine(); 
        
        Livro livro = controller.buscarPorId(id);
        if (livro == null) {
            System.out.println(Cores.TEXT_RED + "Livro não encontrado!" + Cores.TEXT_RESET);
            return;
        }
        
        System.out.println("\nLivro encontrado:");
        livro.visualizar();
        
        System.out.print("\nTem certeza que deseja deletar este livro? (S/N): ");
        String confirmacao = leia.nextLine();
        
        if (confirmacao.equalsIgnoreCase("S")) {
            boolean sucesso = controller.deletar(id);
            if (sucesso) {
                System.out.println(Cores.TEXT_GREEN + "Livro deletado com sucesso!" + Cores.TEXT_RESET);
            } else {
                System.out.println(Cores.TEXT_RED + "Erro ao deletar o livro." + Cores.TEXT_RESET);
            }
        } else {
            System.out.println(Cores.TEXT_YELLOW + "Operação cancelada." + Cores.TEXT_RESET);
        }
        
    }
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = leia.nextInt();
                leia.nextLine(); 
                return valor;
            } catch (Exception e) {
                System.out.println(Cores.TEXT_RED + "Valor inválido! Digite um número inteiro." + Cores.TEXT_RESET);
                leia.nextLine(); 
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = leia.nextDouble();
                leia.nextLine(); 
                return valor;
            } catch (Exception e) {
                System.out.println(Cores.TEXT_RED + "Valor inválido! Digite um número válido." + Cores.TEXT_RESET);
                leia.nextLine(); 
            }
        }
    }
    public static void sobre() {
    	System.out.println("\n*********************************************************");
    	System.out.println("Projeto Desenvolvido por: ");
    	System.out.println("Carlos Moroni Garcia - carlosmoronisud@gmail.com");
    	System.out.println("https://github.com/carlosmoronisud");
    	System.out.println("*********************************************************");
       }

    
}