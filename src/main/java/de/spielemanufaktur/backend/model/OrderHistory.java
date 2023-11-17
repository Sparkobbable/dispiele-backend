package de.spielemanufaktur.backend.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "ORDER_HISTORY", schema = "DISPIELE")
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "C_USER_ID", nullable = false)
    private Long cUserId;

    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;

    @Column(name = "ACTION", nullable = false, length = 500)
    private String action;

    // Join with User
    @ManyToOne
    @JoinColumn(name = "C_USER_ID", insertable = false, updatable = false)
    private User user;

    // Join with Order
    @ManyToOne
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
    private Order order;

    // No need for explicit getters and setters
}
