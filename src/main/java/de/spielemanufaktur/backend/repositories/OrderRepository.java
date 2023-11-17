package de.spielemanufaktur.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.spielemanufaktur.backend.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can add custom query methods here if needed
}
