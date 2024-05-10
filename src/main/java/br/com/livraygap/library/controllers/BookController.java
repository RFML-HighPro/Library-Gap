package br.com.livraygap.library.controllers;

import br.com.livraygap.library.dtos.BookDTO;
import br.com.livraygap.library.interfaces.FilterBook;
import br.com.livraygap.library.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/BOOK")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/GET-BOOK/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id){
        BookDTO book = service.getBook(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/ALL-BOOKS")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> books = service.getBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/CREATE-BOOK")
    public ResponseEntity<Object> createBook(@RequestBody BookDTO book){
        service.addBook(book);
        return ResponseEntity.ok("Um livro foi criado com sucesso!");
    }

    @PutMapping("/UPDATE-BOOK/{id}")
    public ResponseEntity<Object> updBook(@RequestBody BookDTO book, @PathVariable Long id){
        service.updBook(book, id);
        return ResponseEntity.ok("Um livro foi atualizado com sucesso!");
    }

    @DeleteMapping("/DELETE-BOOK/{id}")
    public ResponseEntity<Object> delBook(@PathVariable Long id){
        service.delBook(id);
        return ResponseEntity.ok("Um livro foi deletado com sucesso!");
    }

    @GetMapping("/SEARCH-BOOK")
    public ResponseEntity<List<BookDTO>> searchBooks(@RequestBody FilterBook filter){
        List<BookDTO> books = service.getBookByFilter(filter);
        return ResponseEntity.ok(books);
    }
}
