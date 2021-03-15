package com.buildings.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @OneToMany(mappedBy="person", cascade=CascadeType.ALL)


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  Long id;
    private String name;



        public Person(){

        }




}
