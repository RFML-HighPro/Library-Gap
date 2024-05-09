package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.entities.Purchase;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.enums.PaymentMethodEnum;
import br.com.livraygap.library.enums.StatusEnum;

public record PurchaseDTO(
        Long id,
        User user,
        Book book,
        Integer quantity,
        Double totalPrice,
        Double unitPrice,
        String purchaseDate,
        PaymentMethodEnum paymentMethod,
        StatusEnum status,
        String shippingAddress,
        Double discounts,
        Double shippingCost,
        String trackingNumber,
        Boolean deletedAt
) {
    public static PurchaseDTO getDtoPurchase(Purchase purchase) {
        return new PurchaseDTO(
                purchase.getId(),
                purchase.getUser(),
                purchase.getBook(),
                purchase.getQuantity(),
                purchase.getTotalPrice(),
                purchase.getUnitPrice(),
                purchase.getPurchaseDate(),
                purchase.getPaymentMethod(),
                purchase.getStatus(),
                purchase.getShippingAddress(),
                purchase.getDiscounts(),
                purchase.getShippingCost(),
                purchase.getTrackingNumber(),
                purchase.getDeletedAt());
    }
}
