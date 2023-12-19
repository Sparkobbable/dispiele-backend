package de.spielemanufaktur.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.spielemanufaktur.backend.repositories.UserRepository;

@RestController
@RequestMapping("availabilty")
public class AvailabilityController {
    @Autowired
    private UserRepository repo;

    @GetMapping(value = "/fullsystem", produces = "application/json")
    public ResponseEntity<Void> pingSystem() {
        repo.count();
        return ResponseEntity.ok(null);
    }
}
