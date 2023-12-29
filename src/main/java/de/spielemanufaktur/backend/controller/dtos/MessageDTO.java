package de.spielemanufaktur.backend.controller.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO implements Serializable {
    @NotBlank
    private String title;
    private String content;
    @NotBlank
    private String email;
    @NotBlank
    private String captchaToken;
}
