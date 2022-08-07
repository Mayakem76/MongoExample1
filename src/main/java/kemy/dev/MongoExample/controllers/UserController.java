package kemy.dev.MongoExample.controllers;

import kemy.dev.MongoExample.entities.User;
import kemy.dev.MongoExample.repositories.UserRepository;
import kemy.dev.MongoExample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("")  // Crea User
    public User createUser(@RequestBody User user){
        //   user.setId(null); per evitare che l'utente imposti l'id;
        return userService.createUser(user);
    }
    @GetMapping("") //trova tutti gli user
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}") //trova un solo user
    public Optional<User> getOneUser(@PathVariable String id){
        return userService.getOneUser(id);
    }
    @PutMapping("/{id}") //modifica user
    public User editUser(@PathVariable String id,@RequestBody User user){
        user.setId(id);
        return userService.editUser(id, user);
    }

    @DeleteMapping("/{id}") //cancella user
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        System.out.println("deleted user id: "+id);
        return "deleted user id: "+id;
    }


}
