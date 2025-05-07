package projeto_final_bloco_01.repository;

import Model.Livro;
import java.util.List;

public interface LivroRepository {
    // CRUD básico
    void cadastrar(Livro livro);
    List<Livro> listarTodos();
    Livro buscarPorId(int id);
    boolean atualizar(Livro livro);
    boolean deletar(int id);
    
    // Métodos específicos
    List<Livro> buscarPorAutor(String autor);
    List<Livro> buscarPorTipo(int tipo);
    int gerarNovoId();
}