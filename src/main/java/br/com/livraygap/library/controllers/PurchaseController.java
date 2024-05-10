package br.com.livraygap.library.controllers;

import br.com.livraygap.library.dtos.PurchaseDTO;
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
    public ResponseEntity<Object> savePurchase(@RequestBody PurchaseDTO purchase){
        service.savePurchase(purchase);
        return ResponseEntity.ok("Compra efetuada com sucesso");
    }

    @GetMapping("/GET-PURCHASE/{id}")
    public ResponseEntity<PurchaseDTO> getPurchase(@PathVariable Long id){
        PurchaseDTO purchase = service.getPurchase(id);
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/ALL-PURCHASE")
    public ResponseEntity<List<PurchaseDTO>> getAllPurchases(){
        List<PurchaseDTO> purchases = service.getPurchases();
        return ResponseEntity.ok(purchases);
    }

    @DeleteMapping("/DEL-PURCHASE/{id}")
    public ResponseEntity<Object> delPurchase(@PathVariable Long id){
        service.delPurchase(id);
        return ResponseEntity.ok("Compra deletada com sucesso");
    }
}
