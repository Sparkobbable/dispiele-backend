package de.spielemanufaktur.backend.controller.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderDTO implements Serializable {
    private Long itemId;
    @NotNull
    private String email;
    @NotNull
    private GENDER gender;
    @NotNull
    private String firstName;
    @NotNull
    private String surename;
    private String company;
    @NotNull
    private String adressline;
    @NotNull
    private String postalCode;
    @NotNull
    private String city;
    @NotNull
    private String country;
    private String phoneNumer;
    @NotNull
    private Integer quantity;
    private String comment;

    public enum GENDER {
        M, W, D, U
    }
}