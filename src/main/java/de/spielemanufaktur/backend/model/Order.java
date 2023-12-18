package de.spielemanufaktur.backend.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.sql.Time;

@Data
@Entity
@Table(name = "ORDER", schema = "DISPIELE")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @Column(name = "ITEM_ID", nullable = false)
    private Long itemId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "ORDER_DATE", nullable = false)
    private Date orderDate;

    @Column(name = "ORDER_TIME", nullable = false)
    private Time orderTime;

    @Column(name = "COMMENT", length = 500)
    private String comment;

    @Column(name = "FOUND_BY")
    private String foundBy;

    @Column(name = "PAYED", nullable = false)
    private boolean payed;

    @Column(name = "SHIPPED", nullable = false)
    private boolean shipped;

    @Column(name = "TRACKING_NUMBER", length = 255)
    private String trackingNumber;

    // Join with User
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", insertable = false, updatable = false)
    private Customer customer;

    // Join with Item
    @ManyToOne
    @JoinColumn(name = "ITEM_ID", insertable = false, updatable = false)
    private Item item;

    // Join with OrderHistory
    @OneToMany(mappedBy = "order")
    private List<OrderHistory> orderHistories;

    // No need for explicit getters and setters
}
