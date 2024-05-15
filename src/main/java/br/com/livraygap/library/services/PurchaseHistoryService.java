package br.com.livraygap.library.services;

import br.com.livraygap.library.dtos.PurchaseHistoryDTO;
import br.com.livraygap.library.entities.Purchase;
import br.com.livraygap.library.entities.PurchaseHistory;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.repositories.PurchaseHistoryRepository;
import br.com.livraygap.library.utils.FormatDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryService {
    private final PurchaseHistoryRepository repository;
    private final UserService userService;
    private final PurchaseService purchaseService;

    private void savePurchaseInHistory(PurchaseHistory purchHist){
        repository.save(purchHist);
    }

    public PurchaseHistory getOnePurchase(Long id){
        return repository.findById(id).get();
    }

    public List<PurchaseHistory> getAllPurchase(User user){
        return repository.findByUser(user);
    }

    public PurchaseHistoryDTO getPurchase(Long id){
        return new PurchaseHistoryDTO(getOnePurchase(id));
    }

    public List<PurchaseHistoryDTO> getPurchases(Long id) {
        User user = userService.getUserById(id);
        return getAllPurchase(user).stream().map(PurchaseHistoryDTO::new).toList();
    }

    public void createPurchInHist(PurchaseHistoryDTO purchHistDTO){
        PurchaseHistory purchaseForSave = new PurchaseHistory();

        User user = userService.getUserById(purchHistDTO.getKeyUser());
        Purchase purchase = purchaseService.getPurchaseById(purchHistDTO.getKeyPurchase());

        purchaseForSave.setUser(user);
        purchaseForSave.setPurchase(purchase);
        purchaseForSave.setCreatedAt(FormatDates.getDataByYearMonthDay(new Date()));

        savePurchaseInHistory(purchaseForSave);
    }
}
