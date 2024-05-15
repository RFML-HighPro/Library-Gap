package br.com.livraygap.library.repositories;

import br.com.livraygap.library.entities.PurchaseHistory;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
    @Query("SELECT ph FROM PurchaseHistory ph WHERE ph.user = :id")
    List<PurchaseHistory> findByUser(@Param("id") User id);
}
