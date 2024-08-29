package br.com.javamysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok Annotations
@Getter
@Setter
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor // Construtor cheio

// JPA Annotations
@Entity // Classe como entidade JPA que será mapeada para uma tabela no banco de dados
@Table(name = "addresses") // Nome da tabela
public class Address {

    @Id // Id como chave primária (PK) da tebala
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática da chave primária
    private Long id;

    @Column(nullable = false) // Campo obrigatório (não pode ser nulo)
    private String street;

    @Column(nullable = false) // Campo obrigatório (não pode ser nulo)
    private String city;

    @Column(nullable = false) // Campo obrigatório (não pode ser nulo)
    private String state;

    @Column(nullable = false) // // Campo obrigatório (não pode ser nulo)
    private String zipCode; // CEP
}
