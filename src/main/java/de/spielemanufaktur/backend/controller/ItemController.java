package de.spielemanufaktur.backend.controller;

import org.hibernate.sql.ast.tree.from.LazyTableGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.spielemanufaktur.backend.controller.dtos.ItemDTO;
import de.spielemanufaktur.backend.model.Item;
import de.spielemanufaktur.backend.repositories.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(value = "/latest", produces = "application/json")
    public ResponseEntity<ItemDTO> getLatestAvailableItem() {
        Item latestItem = itemRepository.findFirstByOrderByIdDesc();
        if (latestItem != null) {
            ItemDTO itemDTO = new ItemDTO(latestItem.getId(), latestItem.getDisplayName(), latestItem.getPrice(),
                    latestItem.getStock());
            return ResponseEntity.ok(itemDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}