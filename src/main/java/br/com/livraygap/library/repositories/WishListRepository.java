package br.com.livraygap.library.repositories;

import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    @Query("SELECT wl FROM WishList wl WHERE wl.user = :id")
    List<WishList> findByUser(@Param("id") User id);
}