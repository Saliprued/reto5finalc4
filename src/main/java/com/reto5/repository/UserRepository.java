package com.reto5.repository;

import com.reto5.repository.crud.UserInterface;
import com.reto5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    
    @Autowired
    private UserInterface userCrudRepository;
    
    /**
    * consulta que retorna la lista completa de usuarios
    * @return 
    */ 
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Selecciona de la tabla un usuario específico buscado por id
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * Crea los datos del usuario
     * @param user
     * @return 
     */
    
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    
    /**
     * Actualiza los datos del usuario
     * @param user
     * @return 
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }

    /**
     * Borra el usuario y desaparece de la lista usuarios
     * @param user
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    
    /**
     * Consulta por email
     * @param email
     * @return el usuario que tenga el email ingresado
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return usuario.isPresent();
    }

    /**
     * Consulta por email y password
     * @param email
     * @param password
     * @return el usuario que tengan el mail y el pasword ingresado
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * Metodo para realizar una consulta por mes
     * @param monthBirthtDay
     * @return el listado de usuarios que se filtren por el mes de cumple específicado
     */
    public List<User> birthDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}
