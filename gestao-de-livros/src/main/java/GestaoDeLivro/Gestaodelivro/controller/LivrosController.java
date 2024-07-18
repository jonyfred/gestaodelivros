package GestaoDeLivro.Gestaodelivro.controller;

import GestaoDeLivro.Gestaodelivro.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    private ArrayList<Livro> listaDeLivros = new ArrayList<>();
    @GetMapping("/lista")
    public ArrayList<Livro>listartodos(){
        return listaDeLivros;
    }

    @PostMapping("/inserir")
    public String inserirLivro(

            @RequestBody Livro livro

    ) {
        listaDeLivros.add(livro);
        return "Livro inserido com sucesso";
    }

    @GetMapping("/existe-livro")
    public boolean existelivro(@RequestParam String titulo){
        for (Livro livro : listaDeLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/pesquisa-titulo")
    public Livro pesquisatiulo(@RequestParam String titulo){
        for (Livro livro: listaDeLivros){
            if (livro.getTitulo().equalsIgnoreCase(titulo))
                return livro;
        }
        return null;
    }

    @GetMapping("/pesquisa-autor")
    public List<Livro>pesquisarautor(@RequestParam String autor){
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : listaDeLivros){
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }


    @GetMapping("/pesquisa-editora")
    public List<Livro>pesquisarEditora(@RequestParam String editora){
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : listaDeLivros) {
            if (livro.getEditora().equalsIgnoreCase(editora)) {
                resultado.add(livro);
            }
        }
        return resultado;

    }

    @GetMapping("/pesquisa-paginas")
    public List<Livro> pesquisaPaginas(@RequestParam int numeroDePaginas) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : listaDeLivros) {
            if (livro.getNumeroDePaginas() >= numeroDePaginas) {
                resultado.add(livro);
            }
        }
        return resultado;
    }


}
