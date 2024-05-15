package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.Purchase;
import br.com.livraygap.library.entities.PurchaseHistory;
import br.com.livraygap.library.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseHistoryDTO {
    Long id;
    User user;
    Purchase purchase;
    String createdAt;

    Long keyUser;
    Long keyPurchase;

    public PurchaseHistoryDTO(PurchaseHistory purchase) {
        this.id = purchase.getId();
        this.user = purchase.getUser();
        this.purchase = purchase.getPurchase();
        this.createdAt = purchase.getCreatedAt();
    }
}
