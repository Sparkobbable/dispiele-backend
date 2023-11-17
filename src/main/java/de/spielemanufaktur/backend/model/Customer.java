package de.spielemanufaktur.backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER", schema = "DISPIELE")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "GENDER")
    private Integer gender;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "SURENAME", nullable = false)
    private String surname;

    @Column(name = "COMPANY", length = 100)
    private String company;

    @Column(name = "ADRESSLINE", nullable = false, length = 255)
    private String addressLine;

    @Column(name = "POSTAL_CODE", nullable = false, length = 10)
    private String postalCode;

    @Column(name = "CITY", nullable = false, length = 50)
    private String city;

    @Column(name = "COUNTRY", nullable = false, length = 50)
    private String country;

    @Column(name = "PHONE_NUMBER", length = 50)
    private String phoneNumber;

    // Join with Order
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
