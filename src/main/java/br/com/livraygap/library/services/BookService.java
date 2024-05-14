package br.com.livraygap.library.services;

import br.com.livraygap.library.dtos.BookDTO;
import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.interfaces.FilterBook;
import br.com.livraygap.library.repositories.BookRepository;
import br.com.livraygap.library.utils.FormatDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    private void saveOrUpdOrDelete(Book book) {
        repository.save(book);
    }

    public Book getBookById(Long id) {
        return repository.findById(id).get();
    }

    private List<Book> getAllBooks() {
        return repository.findAll();
    }

    public List<Book> getStockOfBooks() {
        return repository.findByStocked();
    }

    public List<BookDTO> getBooks() {
        return getAllBooks().stream().map(BookDTO::new).toList();
    }

    public BookDTO getBook(Long id) {
        return new BookDTO(getBookById(id));
    }

    public void delBook(Long id) {
        Book book = getBookById(id);
        book.setDeletedAt(true);
        saveOrUpdOrDelete(book);
    }

    public List<BookDTO> getBookByFilter(FilterBook filter) {
        List<Book> books = new ArrayList<>();
        boolean filterIsEmpty = !filter.getFilter().isBlank();
        if (filterIsEmpty) {
            books = repository.findByFilter(filter.getFilter());
        }
        boolean priceIsEmpty = filter.getOptionalPriceMin() != 0 || filter.getOptionalPriceMax() != 0;
        if (priceIsEmpty) {
            books = repository.findByPrice(filter.getOptionalPriceMin(), filter.getOptionalPriceMax());
        }
        boolean soldIsEmpty = filter.getOptionalMoreSold();
        if (soldIsEmpty) {
            books = repository.findBySales();
        }
        boolean recommendationEmpty = filter.getOptionalRecommended();
        if (recommendationEmpty) {
            books = repository.findByRating();

        }
        return books.stream().map(BookDTO::new).toList();
    }

    public void addBook(BookDTO bookDTO) {
        Book book = new Book();

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setPages(bookDTO.getPages());
        book.setGenre(bookDTO.getGenre());
        book.setIsbn(bookDTO.getIsbn());
        book.setPrice(bookDTO.getPrice());
        book.setReleaseDate(bookDTO.getReleaseDate());
        book.setDeletedAt(bookDTO.getDeletedAt());
        book.setUpdatedAt(bookDTO.getUpdatedAt());
        book.setStock(bookDTO.getStock());
        book.setRating(bookDTO.getRating());
        book.setSales(bookDTO.getSales());
        book.setCreatedAt(FormatDates.getDataByYearMonthDay(new Date()));

        saveOrUpdOrDelete(book);
    }

    public void updBook(BookDTO bookDTO, Long id) {
        Book book = getBookById(id);

        book.setTitle(bookDTO.getTitle());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setPages(bookDTO.getPages());
        book.setGenre(bookDTO.getGenre());
        book.setIsbn(bookDTO.getIsbn());
        book.setPrice(bookDTO.getPrice());
        book.setReleaseDate(bookDTO.getReleaseDate());
        book.setDeletedAt(bookDTO.getDeletedAt());
        book.setCreatedAt(bookDTO.getCreatedAt());
        book.setStock(bookDTO.getStock());
        book.setRating(bookDTO.getRating());
        book.setSales(bookDTO.getSales());
        book.setUpdatedAt(FormatDates.getDataByYearMonthDay(new Date()));

        saveOrUpdOrDelete(book);
    }

}