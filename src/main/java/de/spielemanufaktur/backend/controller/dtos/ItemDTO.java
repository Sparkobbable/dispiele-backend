package de.spielemanufaktur.backend.controller.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ItemDTO implements Serializable {
    private Long id;
    private String displayName;
    private BigDecimal price;
    private int stock;
}
