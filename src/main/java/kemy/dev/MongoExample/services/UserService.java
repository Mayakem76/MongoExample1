package kemy.dev.MongoExample.services;

import kemy.dev.MongoExample.entities.User;
import kemy.dev.MongoExample.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(@RequestBody User user){
        //   user.setId(null); per evitare che l'utente imposti l'id;
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getOneUser(@PathVariable String id){
        return userRepository.findById(id);
    }
    public User editUser(@PathVariable String id,@RequestBody User user){
        user.setId(id);
        return userRepository.save(user);
    }
    public String deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
        System.out.println("deleted user id: "+id);
        return "deleted user id: "+id;
    }
}
