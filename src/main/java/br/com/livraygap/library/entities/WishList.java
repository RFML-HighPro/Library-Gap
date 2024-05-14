package br.com.livraygap.library.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wish_lists")
@Data
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    Book book;
}
