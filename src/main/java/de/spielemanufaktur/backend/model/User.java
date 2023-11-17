package de.spielemanufaktur.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER", schema = "DISPIELE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", nullable = false, length = 20)
    private String username;

    @Column(name = "PASSWORD_HASH", nullable = false, length = 500)
    private String passwordHash;

    @Column(name = "EMAIL", length = 255)
    private String email;

    // No need for explicit getters and setters
}
