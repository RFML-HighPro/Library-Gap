package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.enums.GenreEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO {
    Long id;
    String title;
    String author;
    String publisher;
    Integer pages;
    GenreEnum genre;
    String isbn;
    Double price;
    String releaseDate;
    String createdAt;
    Boolean deletedAt;
    String updatedAt;
    Integer stock;
    Double rating;
    Integer sales;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.pages = book.getPages();
        this.genre = book.getGenre();
        this.isbn = book.getIsbn();
        this.price = book.getPrice();
        this.releaseDate = book.getReleaseDate();
        this.createdAt = book.getCreatedAt();
        this.deletedAt = book.getDeletedAt();
        this.updatedAt = book.getUpdatedAt();
        this.stock = book.getStock();
        this.rating = book.getRating();
        this.sales = book.getSales();
    }
}
