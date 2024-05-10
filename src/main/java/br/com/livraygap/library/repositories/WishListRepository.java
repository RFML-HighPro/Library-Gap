package br.com.livraygap.library.repositories;

import br.com.livraygap.library.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

    List<WishList> findByuserID(Long id);
}