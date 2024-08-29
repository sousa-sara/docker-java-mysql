package br.com.javamysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Entidade: Representa a estrutura dos dados armazenados no banco de dados, mapeando atributos da classe para colunas da tabela. */

// Anotações Lombok para gerar getters, setters, construtores padrão e com parâmetros
@Getter
@Setter
@NoArgsConstructor // Construtor padrão gerado
@AllArgsConstructor // Construtor com todos os parâmetros gerado
@Entity // Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados
@Table(name = "words") // Define o nome da tabela no banco de dados
public class Word {

    @Id // Marca o campo como a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valores para a chave primária como auto-incremento
    private Long id; // Identificador único da palavra

    @Column(name = "pt_word", nullable = false, length = 128, unique = true) // Define a coluna correspondente na tabela, com restrições
    private String ptWord; // Palavra em português

    @Column(name = "en_word", nullable = false, length = 128) // Define a coluna correspondente na tabela, com restrições
    private String enWord; // Palavra em inglês

    @Column(name = "pt_meaning", nullable = false, length = 512) // Define a coluna correspondente na tabela, com restrições
    private String ptMeaning; // Significado da palavra em português
}