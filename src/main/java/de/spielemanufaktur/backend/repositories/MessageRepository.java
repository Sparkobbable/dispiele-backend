package de.spielemanufaktur.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.spielemanufaktur.backend.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // You can add custom query methods here if needed
}
