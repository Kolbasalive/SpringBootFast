package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
class Coffee{

    @Id
    private String id;//final
    private String name;

    public Coffee(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Coffee(String name){
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public Coffee() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id){
        this.id = id;
    }

}
