package br.com.livraygap.library.services;

import br.com.livraygap.library.dtos.BookDTO;
import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.interfaces.FilterBook;
import br.com.livraygap.library.repositories.BookRepository;
import br.com.livraygap.library.utils.FormatDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<Book> getStockOfBooks(){
        return repository.findByStocked();
    }

    public List<BookDTO> getAllBooksConfigured() {
        return getAllBooks().stream().map(BookDTO::getDtoBook).toList();
    }

    public BookDTO getBookConfigured(Long id) {
        return BookDTO.getDtoBook(getBookById(id));
    }

    public void addBook(Book newBook) {
        newBook.setCreatedAt(FormatDates.getDataByYearMonthDay(new Date()));
        saveOrUpdOrDelete(newBook);
    }

    public void delBook(Long id) {
        Book book = getBookById(id);
        book.setDeletedAt(true);
        saveOrUpdOrDelete(book);
    }

    public void updBook(Book book, Long id) {
        Long idBookGetted = getBookById(id).getId();
        book.setUpdatedAt(FormatDates.getDataByYearMonthDay(new Date()));
        book.setId(idBookGetted);
        saveOrUpdOrDelete(book);
    }

    public List<Book> getBookByFilter(FilterBook filter) {
        boolean filterIsEmpty = !filter.getFilter().isBlank();
        if (filterIsEmpty)
            return repository.findByFilter(filter.getFilter());
        boolean priceIsEmpty = filter.getOptionalPriceMin() != 0 || filter.getOptionalPriceMax() != 0;
        if (priceIsEmpty)
            return repository.findByPrice(filter.getOptionalPriceMin(), filter.getOptionalPriceMax());
        boolean soldIsEmpty = filter.getOptionalMoreSold();
        if (soldIsEmpty)
            return repository.findBySales();
        boolean recommendationEmpty = filter.getOptionalRecommended();
        if (recommendationEmpty)
            return repository.findByRating();
        return null;
    }

}