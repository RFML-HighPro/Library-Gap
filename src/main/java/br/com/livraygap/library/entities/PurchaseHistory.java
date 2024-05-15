package br.com.livraygap.library.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "purchase_histories")
@Data
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    Purchase purchase;

    @Column(name = "created_at")
    String createdAt;
}
