package com.p5.adoptions.service;

import com.p5.adoptions.repository.dogs.Dog;
import com.p5.adoptions.repository.dogs.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService
{

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository)
    {
        this.dogRepository = dogRepository;
    }

    public void addDog(Dog dog)
    {
        if(dog.getName()!=null && dog.getUrl()==null)
        {
            throw new RuntimeException("Dog must have a name and a photo!");
        }
       Dog dogToSave= new Dog()
                .setName(dog.getName())
                .setUrl(dog.getUrl());

        dogRepository.save(dogToSave);
    }
    public List<Dog> findAll()
    {
        return dogRepository.findAll();
    }

    public Dog findDog(String name)
    {
        if(name==null || name=="")
        {
            throw new RuntimeException("Must specify name!");
        }

        return dogRepository.findDogByName(name);

    }
}
