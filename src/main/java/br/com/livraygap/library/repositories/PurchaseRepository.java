package br.com.livraygap.library.repositories;

import br.com.livraygap.library.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
