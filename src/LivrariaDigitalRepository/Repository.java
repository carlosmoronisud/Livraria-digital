package LivrariaDigitalRepository;

import java.util.List;

import LivrariaDigitalModel.Livro;

public interface Repository {
    // CRUD básico
    void cadastrar(Livro livro);
    List<Livro> listarTodos();
    Livro buscarPorId(int id);
    boolean atualizar(Livro livro);
    boolean deletar(int id);
    
   
}