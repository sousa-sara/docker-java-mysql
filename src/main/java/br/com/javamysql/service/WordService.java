package br.com.javamysql.service;

import br.com.javamysql.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

/* Serviço: Define a interface para a lógica de negócios e processa as regras do domínio. A camada de serviço interage com a camada de repositório para manipulação dos dados. */

public interface WordService {

    // Método para criar uma nova palavra no dicionário
    Word createWord(Word word);

    // Método para buscar uma palavra pelo ID
    Word getWordById(Long wordId) throws ChangeSetPersister.NotFoundException;

    // Método para buscar todas as palavras
    List<Word> getAllWords();

    // Método para atualizar uma palavra existente pelo ID
    Word updateWord(Long wordId, Word updatedWord) throws ChangeSetPersister.NotFoundException;

    // Método para deletar uma palavra pelo ID
    void deleteWord(Long wordId);

    // Método para buscar palavras com paginação e um termo de pesquisa
    Page<Word> searchWords(String searchTerm, Pageable pageable);
}
