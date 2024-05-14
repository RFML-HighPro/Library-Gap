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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    Book book;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "total_price")
    Double totalPrice;

    @Column(name = "unit_price")
    Double unitPrice;

    @Column(name = "purchase_date")
    String purchaseDate;

    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    PaymentMethodEnum paymentMethod;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    StatusEnum status;

    @Column(name = "shipping_address")
    String shippingAddress;

    @Column(name = "discounts")
    Double discounts;

    @Column(name = "shipping_cost")
    Double shippingCost;

    @Column(name = "tracking_number")
    String trackingNumber;

    @Column(name = "deleted_at")
    Boolean deletedAt;
}
