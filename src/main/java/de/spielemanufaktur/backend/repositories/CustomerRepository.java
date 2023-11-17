package de.spielemanufaktur.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.spielemanufaktur.backend.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom query methods here if needed
}
