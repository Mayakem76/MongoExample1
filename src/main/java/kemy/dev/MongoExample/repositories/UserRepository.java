package kemy.dev.MongoExample.repositories;

import kemy.dev.MongoExample.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

}
