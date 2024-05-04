package br.com.livraygap.library.services;

import br.com.livraygap.library.entities.Book;
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

    private void saveOrUpdOrDelete(Book book){
        repository.save(book);
    }

    public Book getBookById(Long id){
        return repository.findById(id).get();
    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public void delBook(Long id){
        Book book = getBookById(id);
        book.setDeleted_at(true);
        saveOrUpdOrDelete(book);
    }

    public void addBook(Book newBook){
        newBook.setCreated_at(FormatDates.getDataByYearMonthDay(new Date()));
        saveOrUpdOrDelete(newBook);
    }

    public void updBook(Book book, Long id){
        Long idBookGetted = getBookById(id).getId();
        book.setUpdated_at(FormatDates.getDataByYearMonthDay(new Date()));
        book.setId(idBookGetted);
        saveOrUpdOrDelete(book);
    }

}


