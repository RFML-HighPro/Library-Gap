package br.com.livraygap.library.controllers;

import br.com.livraygap.library.dtos.WishListDTO;
import br.com.livraygap.library.services.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/WISHLIST")
@RequiredArgsConstructor
public class WishListController {
    private final WishListService service;

    @PostMapping("/CREATE-WISH-LIST")
    public ResponseEntity<Object> saveItemWishList(@RequestBody WishListDTO bookDesired){
        service.saveBook(bookDesired);
        return ResponseEntity.ok("Livro salvo nos livros desejados!");
    }
    @GetMapping("/GET-WISH-LIST/{id}")
    public ResponseEntity<WishListDTO> getItemOfWishList(@PathVariable Long id){
        WishListDTO wishList = service.getItemOfWishList(id);
        return ResponseEntity.ok(wishList);
    }

    @GetMapping("/GET-WISH-LIST-BY-USER/{id}")
    public ResponseEntity<List<WishListDTO>> getWishListByUser(@PathVariable Long id){
        List<WishListDTO> wishLists = service.getWishLists(id);
        return ResponseEntity.ok(wishLists);
    }

    @GetMapping("/ALL-WISH-LIST")
    public ResponseEntity<List<WishListDTO>> getAllItemOfWishList(@PathVariable Long id){
        List<WishListDTO> wishLists = service.getWishLists(id);
        return ResponseEntity.ok(wishLists);
    }

    @DeleteMapping("/DEL-WISH-LIST/{id}")
    public ResponseEntity<Object> delItemOfWishList(@PathVariable Long id){
        service.delWishList(id);
        return ResponseEntity.ok("Livro retirado dos desejados!");
    }
}
