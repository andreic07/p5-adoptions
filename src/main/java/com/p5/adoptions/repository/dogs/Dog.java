package com.p5.adoptions.repository.dogs;


import com.p5.adoptions.repository.animals.Animal;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal

{
    public Dog()
    {

    }

    private String size;

    public String getSize() {
        return size;
    }

    public Dog setSize(String size) {
        this.size = size;
        return this;
    }
}
