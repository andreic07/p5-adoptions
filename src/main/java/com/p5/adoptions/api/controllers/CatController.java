package com.p5.adoptions.api.controllers;

import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cats")
public class CatController
{
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping


    public ResponseEntity<ListDTO<CatDTO>> getAllCats()
    {
        return ResponseEntity.ok(catService.findAll());

    }

    @PostMapping
    public void addCat(@RequestBody CatDTO catDto)
    {
        catService.addCat(catDto);

    }

    @GetMapping("/{name}")
    public ResponseEntity<CatDTO> getCatByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(catService.findCat(name));
    }
}
