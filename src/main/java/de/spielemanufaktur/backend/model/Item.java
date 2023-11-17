package de.spielemanufaktur.backend.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ITEM", schema = "DISPIELE")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DISPLAY_NAME", length = 100)
    private String displayName;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "STOCK")
    private Integer stock;

    // Join with Order
    @OneToMany(mappedBy = "item")
    private List<Order> orders;

    // No need for explicit getters and setters
}
