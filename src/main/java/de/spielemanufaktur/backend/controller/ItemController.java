package de.spielemanufaktur.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.spielemanufaktur.backend.model.Item;
import de.spielemanufaktur.backend.repositories.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/latest")
    public ResponseEntity<Item> getLatestAvailableItem() {
        // Assuming you have a method in ItemRepository to find the latest available
        // item
        Item latestItem = itemRepository.findFirstByOrderByIdDesc();

        if (latestItem != null) {
            return ResponseEntity.ok(latestItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}