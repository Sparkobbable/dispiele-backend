package de.spielemanufaktur.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.spielemanufaktur.backend.controller.dtos.MessageDTO;
import de.spielemanufaktur.backend.model.Message;
import de.spielemanufaktur.backend.repositories.MessageRepository;
import de.spielemanufaktur.backend.services.CaptchaService;
import de.spielemanufaktur.backend.services.MailService;
import de.spielemanufaktur.backend.services.CaptchaService.ReCaptchaInvalidException;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private CaptchaService captcha;

    @Autowired
    private MailService mail;

    @Autowired
    private MessageRepository repo;

    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<Long> sendNewMessage(@RequestBody MessageDTO request) {
        try {
            captcha.checkCaptcha(request.getCaptchaToken());
        } catch (ReCaptchaInvalidException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }

        Message m = new Message();
        m.setTitle(request.getTitle());
        m.setContent(request.getContent());
        m.setEmail(request.getEmail());
        m.setResponded(false);
        Message savedMessage = repo.save(m);

        mail.sendMail(String.format("[ANFRAGE] Es ist die Anfrage #%s eingegangen!", savedMessage.getId()),
                String.format(
                        "Hi!%nEs ist eine Anfrage mit der Nummer #%s eingegangen.%n%nDie Nachricht stammt vom Absender %s%n%nTitel: %n%s%n%%nInhalt: %n%s%n",
                        savedMessage.getId(), request.getEmail(), request.getTitle(), request.getContent()));

        return ResponseEntity.ok(savedMessage.getId());
    }
}
