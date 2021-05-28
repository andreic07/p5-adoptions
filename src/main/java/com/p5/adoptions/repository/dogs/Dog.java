package com.p5.adoptions.repository.dogs;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String url;

    public Integer getId() {
        return id;
    }

    public Dog setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Dog setUrl(String url) {
        this.url = url;
        return this;
    }
}
