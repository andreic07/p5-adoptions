package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.repository.cats.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter
    {
        public static Cat fromDto(CatDTO catDTO)
        {
            if(catDTO.getName().equals("")){
                catDTO.setName("Generic cat");
            }
            return (Cat) new Cat().setName(catDTO.getName()).setPhotoUrl(catDTO.getPhotoUrl());
        }

        public static CatDTO toDto(Cat cat)
        {
            return new CatDTO(cat.getName(),cat.getPhotoUrl(), cat.getId());
        }

        public static List<CatDTO> toListDto(List<Cat> catList)
        {

            List<CatDTO> dtoList=new ArrayList<>();
            catList.forEach(cat -> dtoList.add(toDto(cat)));
            return dtoList;

        }

    }
