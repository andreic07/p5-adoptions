package com.p5.adoptions.service;

import com.p5.adoptions.repository.cats.Cat;
import com.p5.adoptions.repository.cats.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService
{
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

        public void addCat(Cat cat)
        {
            if(cat.getName()!=null && cat.getUrl()==null)
            {
                throw new RuntimeException("Cat must have a name and a photo!");

            }
            Cat catToSave=new Cat()
                    .setName(cat.getName())
                    .setUrl(cat.getUrl());
            catRepository.save(catToSave);
        }
    public List<Cat> findAll()
    {
        return catRepository.findAll();
    }

    public Cat findCat(String name)
    {
        if(name==null || name=="")
        {
            throw new RuntimeException("Must specify name!");
        }

        return catRepository.findCatByName(name);



    }
}
