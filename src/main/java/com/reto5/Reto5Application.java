package com.reto5;

import com.reto5.repository.crud.GadgetInterface;
import com.reto5.repository.crud.OrderInterface;
import com.reto5.repository.crud.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto5Application implements CommandLineRunner {
    @Autowired
    private GadgetInterface gadgetInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private OrderInterface orderInterface;
    public static void main(String[] args) {
        SpringApplication.run(Reto5Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        gadgetInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
    }
}
