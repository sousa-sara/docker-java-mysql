package br.com.javamysql.controller;

import br.com.javamysql.entity.Word;
import br.com.javamysql.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Controlador: Gerencia as requisições HTTP e define como as URLs são tratadas, chamando a lógica de negócios na camada de serviço e retornando a resposta ao cliente. */

@RestController // Indica que a classe é um controlador REST
@RequestMapping("dictionary") // Define o caminho base para os endpoints deste controlador
public class WordController {

    private final WordService wordService; // Serviço que será injetado e usado para a lógica de negócio

    @Autowired // Permite a injeção automática da dependência
    public WordController(WordService wordService) {
        this.wordService = wordService; // Inicializa o serviço através da injeção de dependência
    }

    // Endpoint para criar uma nova palavra
    @PostMapping("/create") // Mapeia requisições POST para o caminho "/dictionary/create"
    public Word createWord(@RequestBody Word word) { // Recebe um objeto Word do corpo da requisição
        return wordService.createWord(word); // Chama o método do serviço para criar a palavra e retorna o resultado
    }

    // Endpoint para obter uma palavra por ID
    @GetMapping("/{id}") // Mapeia requisições GET para o caminho "/dictionary/{id}"
    public Word getWordById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException { // Recebe o ID da palavra como parâmetro
        return wordService.getWordById(id); // Chama o método do serviço para obter a palavra e retorna o resultado
    }

    // Endpoint para obter todas as palavras
    @GetMapping("/all") // Mapeia requisições GET para o caminho "/dictionary/all"
    public List<Word> getAllWords() { // Retorna uma lista de todas as palavras
        return wordService.getAllWords(); // Chama o método do serviço para obter todas as palavras e retorna o resultado
    }

    // Endpoint para atualizar uma palavra existente
    @PutMapping("/update/{id}") // Mapeia requisições PUT para o caminho "/dictionary/update/{id}"
    public Word updateWord(@PathVariable Long id, @RequestBody Word updatedWord) throws ChangeSetPersister.NotFoundException { // Recebe o ID da palavra e o objeto Word atualizado
        return wordService.updateWord(id, updatedWord); // Chama o método do serviço para atualizar a palavra e retorna o resultado
    }

    // Endpoint para deletar uma palavra por ID
    @DeleteMapping("/delete/{id}") // Mapeia requisições DELETE para o caminho "/dictionary/delete/{id}"
    public void deleteWord(@PathVariable Long id) { // Recebe o ID da palavra a ser deletada
        wordService.deleteWord(id); // Chama o método do serviço para deletar a palavra
    }

    // Endpoint para pesquisar palavras com paginação
    @GetMapping("/search") // Mapeia requisições GET para o caminho "/dictionary/search"
    public Page<Word> searchWords(@RequestParam String term, @RequestParam int page, @RequestParam int size) { // Recebe o termo de pesquisa, número da página e tamanho da página como parâmetros
        Pageable pageable = PageRequest.of(page, size); // Cria um objeto Pageable com o número da página e tamanho da página
        return wordService.searchWords(term, pageable); // Chama o método do serviço para pesquisar palavras e retorna a página de resultados
    }
}

