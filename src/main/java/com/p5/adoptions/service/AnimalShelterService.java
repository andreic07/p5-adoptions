package com.p5.adoptions.service;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.AnimalShelterDTO;
import com.p5.adoptions.model.adapters.AnimalShelterAdapter;
import com.p5.adoptions.model.validations.OnCreate;
import com.p5.adoptions.model.validations.OnUpdate;
import com.p5.adoptions.repository.animals.AnimalRepository;
import com.p5.adoptions.repository.shelter.AnimalShelter;
import com.p5.adoptions.repository.shelter.AnimalShelterRepository;
import com.p5.adoptions.service.exceptions.ShelterAddressException;
import com.p5.adoptions.service.exceptions.Violation;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Service
@Validated
public class AnimalShelterService
{
    private final AnimalShelterRepository animalShelterRepository;
    private final AnimalRepository animalRepository;
    public AnimalShelterService(AnimalShelterRepository animalShelterRepository, AnimalRepository animalRepository) {
        this.animalShelterRepository = animalShelterRepository;
        this.animalRepository = animalRepository;
    }

    public AnimalShelterDTO getShelter(Integer id)
    {
        return AnimalShelterAdapter.toDto(animalShelterRepository.getOne(id));
    }


    @Validated(OnCreate.class)
    public AnimalShelterDTO createShelter(@Valid AnimalShelterDTO shelterDTO)
    {

        AnimalShelter animalShelter = AnimalShelterAdapter.fromDto(shelterDTO);
        return AnimalShelterAdapter.toDto(animalShelterRepository.save(animalShelter));

    }


    @Validated(OnUpdate.class)
    public AnimalShelterDTO updateShelter(@Valid AnimalShelterDTO shelterDTO)
    {
        validateShelter(shelterDTO);
        //try catch block with exception propagation
       /* try {
            validateShelter(shelterDTO);

        } catch (RuntimeException ex){
            Logger.getAnonymousLogger().warning(ex.getMessage());
            throw new RuntimeException(ex);

        }
        */
        return AnimalShelterAdapter.toDto(animalShelterRepository.save(AnimalShelterAdapter.fromDto(shelterDTO)));
    }

    private void validateShelter(AnimalShelterDTO shelterDTO) {

        if(!shelterDTO.getAddress().toLowerCase(Locale.ROOT).contains("brasov"))
        {
            throw new ShelterAddressException(new Violation("address","Shelter is not from BRASOV",shelterDTO.getAddress()));
        }
        for(AnimalDTO animal : shelterDTO.getAnimals())
        {
            if(!animal.getPhotoUrl().toLowerCase(Locale.ROOT).contains("https"))
            {
                throw new RuntimeException("Animal does not have a valid url");

            }

        }

        animalShelterRepository.findById(shelterDTO.getId())
                .orElseThrow(() -> new RuntimeException("Shelter not found"));
    }

    public List<AnimalShelterDTO> getAll()
    {
        return AnimalShelterAdapter.toListDto(animalShelterRepository.findAll());
    }
}
