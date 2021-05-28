package com.p5.adoptions.api.controllers;

import com.p5.adoptions.repository.cats.Cat;
import com.p5.adoptions.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cats")
public class CatController
{
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getAllCats()
    {
        List<Cat> catList = catService.findAll();
        return ResponseEntity.ok(catList);

    }

    @PostMapping
    public void addCat(@RequestBody Cat cat)
    {
        catService.addCat(cat);

    }

    @GetMapping("/{name}")
    public ResponseEntity<Cat> getCatByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(catService.findCat(name));
    }
}
