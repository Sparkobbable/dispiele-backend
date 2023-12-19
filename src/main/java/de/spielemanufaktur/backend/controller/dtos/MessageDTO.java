package de.spielemanufaktur.backend.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    @NotBlank
    private String title;
    private String content;
    @NotBlank
    private String email;
    @NotBlank
    private String captchaToken;
}
