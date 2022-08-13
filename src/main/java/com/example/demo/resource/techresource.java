package com.example.demo.resource;

import com.example.demo.model.tech;
import com.example.demo.service.techservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tech")
public class techresource {
    private final techservice techservice;

    public techresource(techservice techservice) {
        this.techservice = techservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<tech>> getAlltechs () {
        List<tech> techs = techservice.findAlltechs();
        return new ResponseEntity<>(techs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<tech> gettechById(@PathVariable("id") Long id) {
        tech tech = techservice.findtechById(id);
        return new ResponseEntity<>(tech, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<tech> addclient(@RequestBody tech tech) {
        tech newtech = techservice.addtech(tech);
        return new ResponseEntity<>(newtech, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<tech> updateclient(@RequestBody tech tech) {
        tech updateclient = techservice.updatetech(tech);
        return new ResponseEntity<>(updateclient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteclient(@PathVariable("id") Long id) {
        techservice.deletetech(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
