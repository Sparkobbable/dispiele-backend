package de.spielemanufaktur.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.spielemanufaktur.backend.model.OrderHistory;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    // You can add custom query methods here if needed
}
