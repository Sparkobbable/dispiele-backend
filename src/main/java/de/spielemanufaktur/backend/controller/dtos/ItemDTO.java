package de.spielemanufaktur.backend.controller.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ItemDTO implements Serializable {
    private Long id;
    private String displayName;
    private Double price;
    private int stock;
}
