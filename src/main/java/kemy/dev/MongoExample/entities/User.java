package kemy.dev.MongoExample.entities;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

/*
create a spring boot project with nosql ORM module
connect to the online mongoDB
create User entity
Create a User Service
Create a Crud API for the User entity using the No SQL ORM
*/
@Data

public class User {
    @Id
    private String id;
    private String completeName;
    private int age;
}
