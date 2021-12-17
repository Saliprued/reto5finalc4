package com.reto5.repository;

import com.reto5.repository.crud.GadgetInterface;
import com.reto5.model.Gadget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GadgetRepository {
    @Autowired
    private GadgetInterface gadgetCrudRepository;

    public List<Gadget> getAll() {
        return gadgetCrudRepository.findAll();
    }

    public Optional<Gadget> getGadget(Integer id) {
        return gadgetCrudRepository.findById(id);
    }

    public Gadget create(Gadget gadget) {
        return gadgetCrudRepository.save(gadget);
    }

    public void update(Gadget gadget) {
        gadgetCrudRepository.save(gadget);
    }

    public void delete(Gadget gadget) {
        gadgetCrudRepository.delete(gadget);
    }

    public List<Gadget> findByPriceLessThanEqual(double price) {
        return gadgetCrudRepository.findByPriceLessThanEqual(price);
    }

    public List<Gadget> findByDescriptionLike(String description) {
        return gadgetCrudRepository.findByDescriptionLike(description);
    }
}
