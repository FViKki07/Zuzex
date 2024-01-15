package org.example.zuzex;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class House{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id_house;

    private Long id_own;

    private String address;

    @ManyToMany(mappedBy = "houses")
    private List<House_user> occupants = new ArrayList<>();

    public House(){}

    public House(Long id_own, String ad){
        this.id_own = id_own;
        this.address = ad;

    }
}
