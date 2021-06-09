package com.p5.adoptions.service;

import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.model.adapters.DogAdapter;
import com.p5.adoptions.repository.dogs.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogService
{

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository)
    {
        this.dogRepository = dogRepository;
    }

    public void addDog(DogDTO dogDto)
    {
        if(dogDto.getName()!=null && dogDto.getPhotoUrl()==null)
        {
            throw new RuntimeException("Dog must have a name and a photo!");
        }

        dogRepository.save(DogAdapter.fromDTO(dogDto));
    }
    public ListDTO<DogDTO> findAll()
    {
         List<DogDTO> dogs =DogAdapter.toListDto(dogRepository.findAll().stream().filter(dog -> dog.getId()!=2).collect(Collectors.toList()));
         long totalCount = dogRepository.count();

        return new ListDTO<>(Math.toIntExact(totalCount), dogs);
    }

    public DogDTO findDog(String name)
    {
        if(name==null || name.equals(""))
        {
            throw new RuntimeException("Must specify name!");
        }

        return DogAdapter.toDto(dogRepository.findDogByName(name));

    }
}
