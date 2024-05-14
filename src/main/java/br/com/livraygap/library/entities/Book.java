package br.com.livraygap.library.entities;

import br.com.livraygap.library.enums.GenreEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "books")
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

    @Column(name = "stock")
    Integer stock;

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

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    List<Rating> ratings;
}






