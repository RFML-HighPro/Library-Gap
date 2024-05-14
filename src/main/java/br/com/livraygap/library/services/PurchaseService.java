package br.com.livraygap.library.services;

import br.com.livraygap.library.dtos.PurchaseDTO;
import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.entities.Purchase;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.repositories.PurchaseRepository;
import br.com.livraygap.library.utils.FormatDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository repository;
    private final UserService userService;
    private final BookService bookService;

    private void saveOrDeleteOrUpdate(Purchase purchase){
        repository.save(purchase);
    }

    public Purchase getPurchaseById(Long id){
        return repository.findById(id).get();
    }

    private List<Purchase> getAllPurchases(){
        return repository.findAll();
    }

    public List<PurchaseDTO> getPurchases(){
        return getAllPurchases().stream().map(PurchaseDTO::new).toList();
    }

    public PurchaseDTO getPurchase(Long id){
        Purchase purchase = getPurchaseById(id);
        return new PurchaseDTO(purchase);
    }

    public void delPurchase(Long id) {
        Purchase purchase = getPurchaseById(id);
        purchase.setDeletedAt(true);
        saveOrDeleteOrUpdate(purchase);
    }

    public void savePurchase(PurchaseDTO purchaseDTO){
        User user = userService.getUserById(purchaseDTO.getKeyUser());
        Book book = bookService.getBookById(purchaseDTO.getKeyBook());

        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setBook(book);

        Double priceObtained = purchaseDTO.getQuantity() * book.getPrice();
        purchase.setUnitPrice(book.getPrice());
        purchase.setTotalPrice(priceObtained);

        purchase.setQuantity(purchaseDTO.getQuantity());
        purchase.setPaymentMethod(purchaseDTO.getPaymentMethod());
        purchase.setStatus(purchaseDTO.getStatus());
        purchase.setShippingAddress(purchaseDTO.getShippingAddress());
        purchase.setDiscounts(purchaseDTO.getDiscounts());
        purchase.setShippingCost(purchaseDTO.getShippingCost());
        purchase.setTrackingNumber(purchaseDTO.getTrackingNumber());
        purchase.setDeletedAt(purchaseDTO.getDeletedAt());
        purchase.setPurchaseDate(FormatDates.getDataByYearMonthDay(new Date()));

        saveOrDeleteOrUpdate(purchase);
    }
}
