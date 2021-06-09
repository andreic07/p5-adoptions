package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.repository.dogs.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter {

    public static Dog fromDTO(DogDTO dogDTO)
    {
        if(dogDTO.getName().equals(""))
        {
            dogDTO.setName("Generic dog");
        }
        return new Dog().setName(dogDTO.getName()).setUrl(dogDTO.getPhotoUrl());
    }


    public static DogDTO toDto(Dog dog)
    {
        return new DogDTO(dog.getName(),dog.getUrl(), dog.getId());

    }

    public static List <DogDTO> toListDto(List<Dog> dogList)
    {
        List<DogDTO> dtoList=new ArrayList<>();

        dogList.forEach(dog -> dtoList.add(toDto(dog)));

        return dtoList;
    }

}
