package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.enums.GenreEnum;

public record BookDTO(
        Long id,
        String title,
        String author,
        String publisher,
        Integer pages,
        GenreEnum genre,
        String isbn,
        Double price,
        String release_date,
        String created_at,
        Boolean deleted_at,
        String updated_at,
        Integer stocked,
        Double rating,
        Integer sales
) {
    public static BookDTO getDtoBook(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPages(),
                book.getGenre(),
                book.getIsbn(),
                book.getPrice(),
                book.getReleaseDate(),
                book.getCreatedAt(),
                book.getDeletedAt(),
                book.getUpdatedAt(),
                book.getStocked(),
                book.getRating(),
                book.getSales()
        );
    }
}