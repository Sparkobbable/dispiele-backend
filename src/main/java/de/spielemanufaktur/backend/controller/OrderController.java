package de.spielemanufaktur.backend.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.spielemanufaktur.backend.controller.dtos.OrderDTO;
import de.spielemanufaktur.backend.controller.dtos.OrderDTO.GENDER;
import de.spielemanufaktur.backend.model.Customer;
import de.spielemanufaktur.backend.model.Order;
import de.spielemanufaktur.backend.repositories.CustomerRepository;
import de.spielemanufaktur.backend.repositories.OrderRepository;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orders;

    @Autowired
    private CustomerRepository customers;

    @PostMapping("/new")
    ResponseEntity<Long> createOrder(@RequestBody OrderDTO request) {
        Customer customer = new Customer(); // todo check if customer exists
        customer.setEmail(request.getEmail());
        customer.setGender(getValueByGender(request.getGender()));
        customer.setFirstName(request.getFirstName());
        customer.setSurname(request.getSurename());
        customer.setCompany(request.getCompany());
        customer.setAddressLine(request.getAdressline());
        customer.setPostalCode(request.getPostalCode());
        customer.setCity(request.getCity());
        customer.setCountry(request.getCountry());
        customer.setPhoneNumber(request.getPhoneNumer());
        Customer savedCustomer = customers.save(customer);
        Order order = new Order();
        order.setQuantity(request.getQuantity());
        order.setItemId(request.getItemId());
        order.setCustomerId(savedCustomer.getId());
        order.setOrderDate(Date.valueOf(LocalDate.now()));
        order.setOrderTime(Time.valueOf(LocalTime.now()));
        order.setComment(request.getComment());
        order.setPayed(false);
        order.setShipped(false);
        Order savedOrder = orders.save(order);
        return new ResponseEntity<>(savedOrder.getId(), HttpStatus.CREATED);
    }

    private Integer getValueByGender(GENDER g) {
        switch (g) {
            case M:
                return 1;
            case W:
                return 2;
            case D:
                return 3;
            case U:
                return 0;
            default:
                return 0;
        }
    }
}
