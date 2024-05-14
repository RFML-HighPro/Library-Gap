package br.com.livraygap.library.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ratings")
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @Column(name = "reviews")
    String reviews;

    @Column(name = "rating")
    Double rating;

    @Column(name = "created_at")
    String createdAt;

    @Column(name = "updated_at")
    String updatedAt;
}