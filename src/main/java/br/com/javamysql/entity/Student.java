package br.com.javamysql.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long StudentID;

    @Column(length = 40) // 40 é a quantidade/tamanho de caracteres do varchar da coluna | Se não colocar o tamanho, o default é 255.
    private String StudentFirstName;

    @Column(length = 40)
    private String StudentLastName;

    @Column
    private int Age;

    @Column(length = 40)
    private String Course;
}
