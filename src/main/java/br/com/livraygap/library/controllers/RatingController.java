package br.com.livraygap.library.controllers;

import br.com.livraygap.library.dtos.RatingDTO;
import br.com.livraygap.library.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/RATING")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService service;

    @PostMapping("CREATE-RATING")
    public ResponseEntity<Object> createRating(@RequestBody RatingDTO ratingDTO){
        service.createRating(ratingDTO);
        return ResponseEntity.ok("Avaliação criada com sucesso!");
    }

    @GetMapping("GET-ALL-RATINGS")
    public ResponseEntity<List<RatingDTO>> getRatings(@PathVariable Long idBook){
        List<RatingDTO> ratings = service.getRatings(idBook);
        return ResponseEntity.ok(ratings);
    }

    @PutMapping("UPD-RATING/{id}")
    public ResponseEntity<Object> updRating(@RequestBody RatingDTO ratingDTO, @PathVariable Long id){
        service.updateRating(ratingDTO, id);
        return ResponseEntity.ok("A avaliação foi atualizada!");
    }

    @DeleteMapping("DEL-RATING/{id}")
    public ResponseEntity<Object> delRating(@PathVariable Long id){
        service.deleteRating(id);
        return ResponseEntity.ok("A avaliação foi deletado!");
    }
}
