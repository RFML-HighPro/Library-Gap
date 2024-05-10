package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.entities.Purchase;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.enums.PaymentMethodEnum;
import br.com.livraygap.library.enums.StatusEnum;
import lombok.Data;

@Data
public class PurchaseDTO {
    Long id;
    User user;
    Book book;
    Integer quantity;
    Double totalPrice;
    Double unitPrice;
    String purchaseDate;
    PaymentMethodEnum paymentMethod;
    StatusEnum status;
    String shippingAddress;
    Double discounts;
    Double shippingCost;
    String trackingNumber;
    Boolean deletedAt;

    Long keyUser;
    Long keyBook;

    public PurchaseDTO(Purchase purchase) {
        this.id = purchase.getId();
        this.user = purchase.getUser();
        this.book = purchase.getBook();
        this.quantity = purchase.getQuantity();
        this.totalPrice = purchase.getTotalPrice();
        this.unitPrice = purchase.getUnitPrice();
        this.purchaseDate = purchase.getPurchaseDate();
        this.paymentMethod = purchase.getPaymentMethod();
        this.status = purchase.getStatus();
        this.shippingAddress = purchase.getShippingAddress();
        this.discounts = purchase.getDiscounts();
        this.shippingCost = purchase.getShippingCost();
        this.trackingNumber = purchase.getTrackingNumber();
        this.deletedAt = purchase.getDeletedAt();
    }
}
