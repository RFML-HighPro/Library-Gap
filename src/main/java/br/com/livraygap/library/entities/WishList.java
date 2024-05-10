package br.com.livraygap.library.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wishLists")
@Data
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    User user;

    @ManyToOne
    @JoinColumn(name = "bookID", referencedColumnName = "id")
    Book book;
}
