package br.com.livraygap.library.entities;

import br.com.livraygap.library.enums.GenreEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "author")
    String author;

    @Column(name = "publisher")
    String publisher;

    @Column(name = "pages")
    Integer pages;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    GenreEnum genre;

    @Column(name = "isbn")
    String isbn;

    @Column(name = "price")
    Double price;

    @Column(name = "release_date")
    String releaseDate;

    @Column(name = "stocked")
    Integer stocked;

    @Column(name = "rating")
    Double rating;

    @Column(name = "sales")
    Integer sales;

    @Column(name = "deleted_at")
    Boolean deletedAt;

    @Column(name = "created_at")
    String createdAt;

    @Column(name = "updated_at")
    String updatedAt;
}
