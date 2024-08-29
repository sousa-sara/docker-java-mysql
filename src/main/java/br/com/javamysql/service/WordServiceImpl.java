package br.com.javamysql.service;

import br.com.javamysql.entity.Word;
import br.com.javamysql.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/* ServiceImpl: Implementa a interface de serviço, fornecendo a lógica concreta para criar, atualizar, buscar e deletar dados, e gerencia as regras de negócio. */

@Service // Marca a classe como um serviço Spring, permitindo a injeção de dependência
@AllArgsConstructor // Gera um construtor com todos os argumentos necessários para injeção de dependência
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository; // Repositório para acessar a base de dados

    @Override
    public Word createWord(Word word) {
        // Salva a palavra no banco de dados e retorna a entidade salva
        return wordRepository.save(word);
    }

    @Override
    public Word getWordById(Long wordId) throws ChangeSetPersister.NotFoundException {
        // Busca a palavra pelo ID e lança uma exceção se não for encontrada
        return wordRepository.findById(wordId).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public List<Word> getAllWords() {
        // Retorna todas as palavras do banco de dados
        return wordRepository.findAll();
    }

    @Override
    public Word updateWord(Long wordId, Word updatedWord) throws ChangeSetPersister.NotFoundException {
        // Busca a palavra existente pelo ID
        Word existingWord = wordRepository.findById(wordId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        // Atualiza os campos da palavra existente
        existingWord.setPtWord(updatedWord.getPtWord());
        existingWord.setEnWord(updatedWord.getEnWord());
        existingWord.setPtMeaning(updatedWord.getPtMeaning());
        // Salva as alterações no banco de dados e retorna a palavra atualizada
        return wordRepository.save(existingWord);
    }

    @Override
    public void deleteWord(Long wordId) {
        // Remove a palavra pelo ID
        wordRepository.deleteById(wordId);
    }

    @Override
    public Page<Word> searchWords(String searchTerm, Pageable pageable) {
        // Realiza uma busca por palavras com base no termo fornecido e com paginação
        return wordRepository.findBySearchTerm(searchTerm.toLowerCase(), pageable);
    }
}
