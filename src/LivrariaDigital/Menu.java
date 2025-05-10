package LivrariaDigital;

import java.util.Scanner;

import LivrariaDigitalController.Controller;
import LivrariaDigitalModel.Ebook;
import LivrariaDigitalModel.Livro;
import LivrariaDigitalModel.LivroFisico;
import LivrariaDigitalUtil.Cores;
import LivrariaDigitalUtil.Exceptions;

import java.util.List;

public class Menu {
    private static Controller controller = new Controller();
    private static Scanner leia = new Scanner(System.in);     

    public static void main(String[] args) {
        int opcao;
        
        // Exibe o cabeçalho inicial
        exibirCabecalho();
        
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

    private static void exibirCabecalho() {
        System.out.println(Cores.TEXT_CYAN_BACKGROUND + Cores.TEXT_WHITE_BOLD);
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*                BOOKSTORE MANAGER                  *");
        System.out.println("*                                                   *");
        System.out.println("*    Sistema de Gerenciamento de Livros e E-books   *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        System.out.println(Cores.TEXT_RESET);
    }

    private static void exibirMenu() {
        System.out.println(Cores.TEXT_PURPLE_BOLD + "\n╔══════════════════════════════╗");
        System.out.println("║         MENU PRINCIPAL       ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ " + Cores.TEXT_YELLOW + "1. " + Cores.TEXT_RESET + "Cadastrar Livro Físico    ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "2. " + Cores.TEXT_RESET + "Cadastrar E-book          ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "3. " + Cores.TEXT_RESET + "Listar Todos os Produtos  ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "4. " + Cores.TEXT_RESET + "Buscar Produto por ID     ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "5. " + Cores.TEXT_RESET + "Atualizar Livro           ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "6. " + Cores.TEXT_RESET + "Deletar Livro             ║");
        System.out.println("║ " + Cores.TEXT_RED + "0. " + Cores.TEXT_RESET + "Sair                      ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print(Cores.TEXT_YELLOW + "\nDigite uma opção: " + Cores.TEXT_RESET);
    }

    private static int lerOpcao() {
        try {
            return leia.nextInt();
        } catch (Exception e) {
            leia.nextLine(); 
            return -1; 
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
                System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida! Por favor, escolha uma opção entre 0 e 6.\n" + Cores.TEXT_RESET);
        }
        Exceptions.keyPress();
    }

    private static void cadastrarLivroFisico() {
        System.out.println(Cores.TEXT_GREEN_BOLD + "\n╔══════════════════════════════╗");
        System.out.println("║     CADASTRAR LIVRO FÍSICO    ║");
        System.out.println("╚══════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Título: ");
        String titulo = leia.nextLine();
        leia.nextLine();
        
        System.out.print("Autor: ");
        String autor = leia.nextLine();
        leia.nextLine();
        
        System.out.print("Preço: ");
        double preco = leia.nextDouble();
        leia.nextLine(); 
        
        System.out.print("Quantidade em estoque: ");
        int quantidade = leia.nextInt();
        leia.nextLine(); 
        
        LivroFisico livro = new LivroFisico(0, titulo, autor, 1, preco, quantidade);
        controller.cadastrar(livro);
        
        System.out.println(Cores.TEXT_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\nLivro físico cadastrado com sucesso!" + Cores.TEXT_RESET);
    }

    private static void cadastrarEbook() {
        System.out.println(Cores.TEXT_GREEN_BOLD + "\n╔══════════════════════════════╗");
        System.out.println("║        CADASTRAR E-BOOK       ║");
        System.out.println("╚══════════════════════════════╝" + Cores.TEXT_RESET);
        
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
        
        System.out.println(Cores.TEXT_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\nE-book cadastrado com sucesso!" + Cores.TEXT_RESET);
    }

    private static void listarTodos() {
        System.out.println(Cores.TEXT_BLUE_BOLD + "\n╔══════════════════════════════╗");
        System.out.println("║     LISTA DE TODOS OS LIVROS   ║");
        System.out.println("╚══════════════════════════════╝" + Cores.TEXT_RESET);
        
        List<Livro> livros = controller.listarTodos();
        
        if (livros.isEmpty()) {
            System.out.println(Cores.TEXT_YELLOW + "\nNenhum livro cadastrado." + Cores.TEXT_RESET);
        } else {
            System.out.println(Cores.TEXT_CYAN + "\nTotal de livros: " + livros.size() + Cores.TEXT_RESET);
            System.out.println("----------------------------------");
            livros.forEach(Livro::visualizar);
        }
    }

    private static void buscarPorId() {
        System.out.println(Cores.TEXT_BLUE_BOLD + "\n╔══════════════════════════════╗");
        System.out.println("║      BUSCAR LIVRO POR ID      ║");
        System.out.println("╚══════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o ID: ");
        int id = leia.nextInt();
        leia.nextLine(); 
        
        Livro livro = controller.buscarPorId(id);
        
        if (livro != null) {
            System.out.println(Cores.TEXT_GREEN + "\nLivro encontrado:" + Cores.TEXT_RESET);
            livro.visualizar();
        } else {
            System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "\nLivro não encontrado!" + Cores.TEXT_RESET);
        }
    }

    private static void atualizarLivro() {
        System.out.println(Cores.TEXT_PURPLE_BOLD + "\n╔══════════════════════════════╗");
        System.out.println("║        ATUALIZAR LIVRO       ║");
        System.out.println("╚══════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o ID do livro que deseja atualizar: ");
        int id = leia.nextInt();
        leia.nextLine();
        
        Livro livroExistente = controller.buscarPorId(id);
        if (livroExistente == null) {
            System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "\nLivro não encontrado!" + Cores.TEXT_RESET);
            return;
        }
        
        System.out.println(Cores.TEXT_GREEN + "\nLivro encontrado:" + Cores.TEXT_RESET);
        livroExistente.visualizar();
        
        System.out.println(Cores.TEXT_YELLOW + "\nDigite os novos dados (deixe em branco para manter o valor atual):" + Cores.TEXT_RESET);
        
        System.out.print("Título (" + livroExistente.getTitulo() + "): ");
        String novoTitulo = leia.nextLine();
        novoTitulo = novoTitulo.isEmpty() ? livroExistente.getTitulo() : novoTitulo;
        
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
            System.out.println(Cores.TEXT_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\nLivro atualizado com sucesso!" + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_GREEN + "\nDados atualizados:" + Cores.TEXT_RESET);
            livroAtualizado.visualizar();
        } else {
            System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "\nErro ao atualizar o livro." + Cores.TEXT_RESET);
        }
    }

    private static void deletarLivro() {
        System.out.println(Cores.TEXT_RED_BOLD + "\n╔══════════════════════════════╗");
        System.out.println("║         DELETAR LIVRO        ║");
        System.out.println("╚══════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o ID do livro que deseja deletar: ");
        int id = leia.nextInt();
        leia.nextLine();
        
        Livro livro = controller.buscarPorId(id);
        if (livro == null) {
            System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "\nLivro não encontrado!" + Cores.TEXT_RESET);
            return;
        }
        
        System.out.println(Cores.TEXT_YELLOW + "\nLivro encontrado:" + Cores.TEXT_RESET);
        livro.visualizar();
        
        System.out.print(Cores.TEXT_RED + "\nTem certeza que deseja deletar este livro? (S/N): " + Cores.TEXT_RESET);
        String confirmacao = leia.nextLine();
        
        if (confirmacao.equalsIgnoreCase("S")) {
            boolean sucesso = controller.deletar(id);
            if (sucesso) {
                System.out.println(Cores.TEXT_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\nLivro deletado com sucesso!" + Cores.TEXT_RESET);
            } else {
                System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "\nErro ao deletar o livro." + Cores.TEXT_RESET);
            }
        } else {
            System.out.println(Cores.TEXT_YELLOW_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\nOperação cancelada." + Cores.TEXT_RESET);
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
                System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "Valor inválido! Digite um número inteiro." + Cores.TEXT_RESET);
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
                System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "Valor inválido! Digite um número válido." + Cores.TEXT_RESET);
                leia.nextLine();
            }
        }
    }

    public static void sobre() {
        System.out.println(Cores.TEXT_CYAN_BACKGROUND + Cores.TEXT_BLACK_BOLD);
        System.out.println("\n*****************************************************");
        System.out.println("*                BOOKSTORE MANAGER                  *");
        System.out.println("*                                                   *");
        System.out.println("*    Projeto Desenvolvido por:                      *");
        System.out.println("*    Carlos Moroni Garcia                           *");
        System.out.println("*    carlosmoronisud@gmail.com                     *");
        System.out.println("*    https://github.com/carlosmoronisud            *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        System.out.println(Cores.TEXT_RESET);
    }
}