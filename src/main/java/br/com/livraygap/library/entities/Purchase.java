package br.com.livraygap.library.entities;

import br.com.livraygap.library.enums.PaymentMethodEnum;
import br.com.livraygap.library.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "purchases")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "id")
    User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookID", referencedColumnName = "id")
    Book book;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "totalPrice")
    Double totalPrice;

    @Column(name = "unitPrice")
    Double unitPrice;

    @Column(name = "purchaseDate")
    String purchaseDate;

    @Column(name = "paymentMethod")
    @Enumerated(EnumType.STRING)
    PaymentMethodEnum paymentMethod;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    StatusEnum status;

    @Column(name = "shippingAddress")
    String shippingAddress;

    @Column(name = "discounts")
    Double discounts;

    @Column(name = "shippingCost")
    Double shippingCost;

    @Column(name = "trackingNumber")
    String trackingNumber;

    @Column(name = "deletedAt")
    Boolean deletedAt;
}