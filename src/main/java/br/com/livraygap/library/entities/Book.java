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
    String author;

    @Column
    String publisher;

    @Column
    Integer pages;

    @Column
    @Enumerated(EnumType.STRING)
    EnumGenre genre;

    @Column
    BigInteger isbn;

    @Column
    Double price;

    @Column
    Date release_date;

    @Column
    Date created_at;

    @Column
    Date updated_at;

    @Column
    Date deleted_at;

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
