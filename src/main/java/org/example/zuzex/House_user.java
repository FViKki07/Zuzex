package org.example.zuzex;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Entity
@Data
public class House_user{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_user;
    private int age;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_house",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    private List<House> houses = new ArrayList<>();

    public House_user() {}

    public House_user(String name, int age, String pass){
        this.name_user = name;
        this.age = age;
        this.password = pass;
    }

}
