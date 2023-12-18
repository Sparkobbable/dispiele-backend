package de.spielemanufaktur.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.triology.recaptchav2java.ReCaptcha;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class CaptchaService {

    @Value("${captcha.apikey}")
    private String apiKey;

    public void checkCaptcha(String token) {
        boolean isValid = new ReCaptcha(apiKey).isValid(token);
        if (!isValid) {
            log.error("Token {} is invalid!", token);
            throw new ReCaptchaInvalidException();
        }
    }

    public class ReCaptchaInvalidException extends RuntimeException {

    }
}
