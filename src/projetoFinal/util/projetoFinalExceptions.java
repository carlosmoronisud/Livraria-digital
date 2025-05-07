package projetoFinal.util;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe para gerenciar as exceções personalizadas do sistema bancário
 */
public class projetoFinalExceptions {
    
    /**
     * Classe de exceção para operações de entrada/saída
     */
    public static class EntradaSaidaException extends Exception {
        private static final long serialVersionUID = 1L;
        
        public EntradaSaidaException(String mensagem) {
            super(mensagem);
        }
        
        public EntradaSaidaException(String mensagem, Throwable causa) {
            super(mensagem, causa);
        }
    }
    
    /**
     * Classe de exceção para operações de conta não encontrada
     */
    public static class ContaNaoEncontradaException extends Exception {
        private static final long serialVersionUID = 1L;
        
        public ContaNaoEncontradaException(int numeroConta) {
            super("A conta número " + numeroConta + " não foi encontrada!");
        }
    }
    
    /**
     * Classe de exceção para saldo insuficiente
     */
    public static class SaldoInsuficienteException extends Exception {
        private static final long serialVersionUID = 1L;
        
        public SaldoInsuficienteException(float saldo, float valorSolicitado) {
            super("Saldo insuficiente! Saldo atual: R$ " + saldo + ", Valor solicitado: R$ " + valorSolicitado);
        }
        
        //Ler entradas inválidas
        
       
        
        
    }
    
    /**
     * Classe de exceção para valores inválidos
     */
    public static class ValorInvalidoException extends Exception {
        private static final long serialVersionUID = 1L;
        
        public ValorInvalidoException() {
            super("O valor informado é inválido! Deve ser maior que zero.");
        }
        
        public ValorInvalidoException(String mensagem) {
            super(mensagem);
        }
    }
    
    /**
     * Classe de exceção para tipos de conta inválidos
     */
    public static class TipoContaInvalidoException extends Exception {
        private static final long serialVersionUID = 1L;
        
        public TipoContaInvalidoException(int tipo) {
            super("Tipo de conta inválido: " + tipo + ". Utilize 1 para Conta Corrente ou 2 para Conta Poupança.");
        }
    }
    
    /**
     * Método utilitário para tratar problemas de entrada do teclado
     */
    public static void tratarErroTeclado(Exception e) {
        System.err.println(Cores.TEXT_RED_BOLD + "Erro ao ler entrada do teclado: " + e.getMessage() + Cores.TEXT_RESET);
    }
    
    /**
     * Método utilitário para exibir mensagens de erro formatadas
     */
    public static void exibirErro(String mensagem) {
        System.err.println(Cores.TEXT_RED_BOLD + "\nERRO: " + mensagem + Cores.TEXT_RESET);
    }
    
    /**
     * Método utilitário para exibir mensagens de erro formatadas com a exceção
     */
    public static void exibirErro(String mensagem, Exception e) {
        System.err.println(Cores.TEXT_RED_BOLD + "\nERRO: " + mensagem);
        System.err.println("Detalhes: " + e.getMessage() + Cores.TEXT_RESET);
    }
    //Ler número float
    public static float lerFloat (Scanner leia) {
    	while(true){
    		try {
    			return leia.nextFloat();
    		}catch
    			(InputMismatchException e){
    				System.out.println(Cores.TEXT_RED_BOLD + "entrada inválida digite um número válido!");
    				leia.next();
    			}
    		
    	}
    	
    }
    //Ler apenas número inteiro
    public static int lerInteiro (Scanner leia) {
    	while(true){
    		try {
    			return leia.nextInt();
    		}catch
    			(InputMismatchException e){
    				System.out.println(Cores.TEXT_RED_BOLD + "entrada inválida digite um número válido!");
    				leia.next();
    			}
    		
    	}
    	
    }
    
    public static void keyPress() {
	    try {
	        System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
	        
	        // Lê apenas a tecla Enter e ignora outras teclas
	        int input;
	        while ((input = System.in.read()) != '\n') {
	            // Ignora qualquer outra tecla diferente do Enter
	            if (input == -1) {
	                throw new IOException("Entrada encerrada inesperadamente");
	            }
	        }
	        
	    } catch (IOException e) {
	        System.err.println("Erro de entrada/saída: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
	    }
	}
    
    
}