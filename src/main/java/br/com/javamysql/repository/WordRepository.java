package br.com.javamysql.repository;

import br.com.javamysql.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/* Repositório: Acessa e manipula diretamente os dados no banco de dados, fornecendo métodos para operações CRUD e consultas personalizadas.   */

@Repository // Indica que esta interface é um repositório e deve ser gerenciada pelo Spring
public interface WordRepository extends JpaRepository<Word, Long> { // Estende JpaRepository para operações CRUD básicas

    // Consulta personalizada para pesquisar palavras com base em um termo de busca
    @Query("FROM Word w " + // Consulta JPQL para selecionar todas as palavras
            "WHERE LOWER(w.ptWord) LIKE %:searchTerm% " + // Filtra por ptWord contendo o termo de busca (ignorando maiúsculas e minúsculas)
            "OR LOWER(w.enWord) LIKE %:searchTerm% " + // Filtra por enWord contendo o termo de busca (ignorando maiúsculas e minúsculas)
            "OR LOWER(w.ptMeaning) LIKE %:searchTerm%") // Filtra por ptMeaning contendo o termo de busca (ignorando maiúsculas e minúsculas)
    Page<Word> findBySearchTerm(String searchTerm, Pageable pageable); // Método para buscar palavras com base no termo de busca e paginação
}

