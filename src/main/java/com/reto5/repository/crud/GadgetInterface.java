package com.reto5.repository.crud;

import com.reto5.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GadgetInterface extends MongoRepository<Gadget, Integer> {
    List<Gadget> findByPriceLessThanEqual(double price);
    List<Gadget> findByDescriptionLike(String description);
}
