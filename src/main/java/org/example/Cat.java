package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATS")
@Getter
@Setter
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String breed;

    @ManyToMany
    private List<Owner> ownersList = new ArrayList<>();

    public void addOwner(Owner owner){
        ownersList.add(owner);
    }
}
