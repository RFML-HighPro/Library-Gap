package br.com.livraygap.library.controllers;

import br.com.livraygap.library.dtos.PurchaseHistoryDTO;
import br.com.livraygap.library.services.PurchaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/PURCHASE-HISTORY")
@RequiredArgsConstructor
public class PurchaseHistoryController {
    private final PurchaseHistoryService service;

    @PostMapping("/CREATE-PURCHASE-hISTORY")
    public ResponseEntity<Object> createPurchaseInHistory(@RequestBody PurchaseHistoryDTO purchHistDTO){
        service.createPurchInHist(purchHistDTO);
        return ResponseEntity.ok("Compra salva em Histórico de Compras");
    }

    @GetMapping("/GET-PURCHASE/{id}")
    public ResponseEntity<PurchaseHistoryDTO> getPurchase(@PathVariable Long id){
        PurchaseHistoryDTO purchase = service.getPurchase(id);
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/GET-ALL-PURCHASE/{id}")
    public ResponseEntity<List<PurchaseHistoryDTO>> getAllPurchases(@PathVariable Long id){
        List<PurchaseHistoryDTO> purchases = service.getPurchases(id);
        return ResponseEntity.ok(purchases);
    }
}
