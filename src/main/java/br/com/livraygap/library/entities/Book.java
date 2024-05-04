package br.com.livraygap.library.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String author;

    @Column
    String publisher;

    @Column
    Integer pages;

    @Column
    @Enumerated(EnumType.STRING)
    EnumGenre genre;

    @Column
    String isbn;

    @Column
    Double price;

    @Column
    String release_date;

    @Column
    Boolean deleted_at;

    @Column
    String created_at;

    @Column
    String updated_at;

    public enum EnumGenre {
        Romance,
        Conto,
        Poesia,
        Crônica,
        Biografia,
        Fantasia,
        Suspense,
        Aventura,
        Horror,
        Histórico,
        Infantil,
        Educacional
    }
}
