package projeto_final_bloco_01;

import java.util.Scanner;

import projetoFinal.util.projetoFinalExceptions;
import projetoFinal.util.Cores;

public class Menu {
    public static void main(String[] args) {
       
        Scanner leia = new Scanner(System.in);
        
        int opcao;
       do {
            System.out.println("\n=== BOOKSTORE ===");
            System.out.println("1. Cadastrar Livro Físico");
            System.out.println("2. Cadastrar E-book");
            System.out.println("3. Listar Todos os Produtos");
            System.out.println("4. Buscar Produto por ID");
            System.out.println("5. Listar apenas Livros Físicos");
            System.out.println("6. Listar apenas E-books");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            
            opcao = leia.nextInt();
            leia.nextLine();
            
            if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nAdeus!!");
				sobre();
				leia.close();
				System.exit(0);
			}
            
            switch(opcao) {
	            case 1:
	                System.out.println("Cadastrar livro físico");
	                projetoFinalExceptions.keyPress();
	                break;
	            case 2:
	            	System.out.println("Cadastrar e-book");
	            	projetoFinalExceptions.keyPress();
	                break;
	            case 3:
	                System.out.println("Listar");
	                projetoFinalExceptions.keyPress();
	                break;
	            case 4:
	            	System.out.println("Buscar produto por id");
	            	projetoFinalExceptions.keyPress();
	                break;
	            case 5:
	                System.out.println("Listar apenas livros físicos");
	                projetoFinalExceptions.keyPress();
	                break;
	            case 6:
	            	System.out.println("Listar apenas E-books");
	            	projetoFinalExceptions.keyPress();
	                break;
	                
	            default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					
                    break;
            }
            
    	}while (opcao != 0);
           
        
    
        
    }
        public static void sobre() {
        	System.out.println("\n*********************************************************");
        	System.out.println("Projeto Desenvolvido por: ");
        	System.out.println("Carlos Moroni Garcia - carlosmoronisud@gmail.com");
        	System.out.println("https://github.com/carlosmoronisud");
        	System.out.println("*********************************************************");
           }
}
