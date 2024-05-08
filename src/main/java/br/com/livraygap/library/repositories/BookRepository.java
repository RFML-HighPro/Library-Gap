package br.com.livraygap.library.repositories;

import br.com.livraygap.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.stocked < 12")
    List<Book> findByStocked();

    @Query("SELECT b FROM Book b WHERE b.rating > 8.5")
    List<Book> findByRating();

    @Query("SELECT b FROM Book b ORDER BY b.sales DESC LIMIT 3")
    List<Book> findBySales();

    @Query("SELECT b FROM Book b WHERE b.price > :priceMin AND b.price < :priceMax")
    List<Book> findByPrice(@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);

    @Query("SELECT b FROM Book b WHERE b.title ILIKE %:filter% OR " +
            "b.author ILIKE %:filter% OR b.publisher ILIKE %:filter% OR " +
            "b.isbn ILIKE %:filter% OR b.genre ILIKE %:filter% OR " +
            "b.releaseDate ILIKE %:filter%"
    )
    List<Book> findByFilter(@Param("filter") String filter);
}
