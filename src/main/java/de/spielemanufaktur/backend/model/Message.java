package de.spielemanufaktur.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "MESSAGE", schema = "DISPIELE")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", length = 50)
    private String title;

    @Column(name = "CONTENT", length = 1500)
    private String content;

    @Column(name = "EMAIL", length = 255)
    private String email;

    @Column(name = "RESPONDED")
    private Boolean responded;
}
