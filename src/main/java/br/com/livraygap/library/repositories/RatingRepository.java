package br.com.livraygap.library.repositories;

import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.entities.Rating;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("SELECT r FROM Rating r WHERE r.book = :id")
    List<Rating> findByBook(@Param("id") Book book);
}
