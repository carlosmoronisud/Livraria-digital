package LivrariaDigitalController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import LivrariaDigitalModel.Ebook;
import LivrariaDigitalModel.Livro;
import LivrariaDigitalModel.LivroFisico;

public class Controller {
    private List<Livro> listaLivros = new ArrayList<>();
    private int idCounter = 1;

    // Cadastrar Livro
    public void cadastrar(Livro livro) {
        livro.setId(gerarNovoId());
        listaLivros.add(livro);
    }

    // Listar Todos
    public List<Livro> listarTodos() {
        return new ArrayList<>(listaLivros);
    }

    // Buscar por ID
    public Livro buscarPorId(int id) {
        Optional<Livro> livro = listaLivros.stream()
                .filter(l -> l.getId() == id)
                .findFirst();
        return livro.orElse(null);
    }

    // Atualizar Livro (Método modificado)
    public boolean atualizar(Livro livroAtualizado) {
        for (int i = 0; i < listaLivros.size(); i++) {
            Livro livro = listaLivros.get(i);
            if (livro.getId() == livroAtualizado.getId()) {
            	
                // Preserva o tipo específico do livro
                if (livro instanceof LivroFisico && livroAtualizado instanceof LivroFisico) {
                    LivroFisico atual = (LivroFisico) livro;
                    LivroFisico novo = (LivroFisico) livroAtualizado;
                    atual.setQuantidade(novo.getQuantidade());
                } else if (livro instanceof Ebook && livroAtualizado instanceof Ebook) {
                    Ebook atual = (Ebook) livro;
                    Ebook novo = (Ebook) livroAtualizado;
                    atual.setAcesso(novo.getAcesso());
                }
                
                // Atualiza campos comuns
                livro.setTitulo(livroAtualizado.getTitulo());
                livro.setAutor(livroAtualizado.getAutor());
                livro.setPreco(livroAtualizado.getPreco());
                
                return true;
            }
        }
        return false;
    }

    // Deletar Livro
    public boolean deletar(int id) {
        return listaLivros.removeIf(livro -> livro.getId() == id);
    }

    // Listar E-books
    public List<Ebook> listarEbooks() {
        return listaLivros.stream()
                .filter(l -> l instanceof Ebook)
                .map(l -> (Ebook) l)
                .toList();
    }

    // Gerar Novo ID
    public int gerarNovoId() {
        return idCounter++;
    }

    
}