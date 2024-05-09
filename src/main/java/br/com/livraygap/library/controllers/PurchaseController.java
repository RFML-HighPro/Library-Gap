package br.com.livraygap.library.controllers;

import br.com.livraygap.library.entities.Purchase;
import br.com.livraygap.library.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/PURCHASE")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService service;

    @PostMapping("/CREATE-PURCHASE")
    public ResponseEntity<Object> savePurchase(@RequestBody Purchase purchase){
        service.savePurchase(purchase);
        return ResponseEntity.ok("Compra efetuada com sucesso");
    }

    @GetMapping("/GET-PURCHASE/{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable Long id){
        Purchase purchase = service.getPurchaseById(id);
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/ALL-PURCHASE")
    public ResponseEntity<List<Purchase>> getAllPurchases(){
        List<Purchase> purchases = service.getAllPurchase();
        return ResponseEntity.ok(purchases);
    }

    @DeleteMapping("/DEL-PURCHASE/{id}")
    public ResponseEntity<Object> delPurchase(@PathVariable Long id){
        service.delPurchase(id);
        return ResponseEntity.ok("Compra deletada com sucesso");
    }
}
