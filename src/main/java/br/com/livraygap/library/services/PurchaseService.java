package br.com.livraygap.library.services;

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

    public List<Purchase> getAllPurchase(){
        return repository.findAll();
    }

    public void delPurchase(Long id) {
        Purchase purchase = getPurchaseById(id);
        purchase.setDeletedAt(true);
        saveOrDeleteOrUpdate(purchase);
    }

    public void savePurchase(Purchase purchase){
        User user = userService.getUserById(purchase.getKeyUser());
        Book book = bookService.getBookById(purchase.getKeyBook());

        purchase.setUser(user);
        purchase.setBook(book);

        Double priceObtained = purchase.getQuantity() * book.getPrice();
        purchase.setUnitPrice(book.getPrice());
        purchase.setTotalPrice(priceObtained);

        purchase.setPurchaseDate(FormatDates.getDataByYearMonthDay(new Date()));
        saveOrDeleteOrUpdate(purchase);
    }
}
