package com.reto5.controller;

import com.reto5.model.Gadget;
import com.reto5.service.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gadget/")
@CrossOrigin("*")
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;

    @GetMapping("/all")
    public List<Gadget> getAll() {
        return gadgetService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gadget> getGadget(@PathVariable("id") Integer id) {
        return gadgetService.getGadget(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget create(@RequestBody Gadget gadget) {
        return gadgetService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget) {
        return gadgetService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return gadgetService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<Gadget> findByPriceLessThanEqual(@PathVariable("price") double price) {
        return gadgetService.findByPriceLessThanEqual(price);
    }

    @GetMapping("/description/{description}")
    public List<Gadget> findByDescriptionLike(@PathVariable("description") String description) {
        return gadgetService.findByDescriptionLike(description);
    }
}
