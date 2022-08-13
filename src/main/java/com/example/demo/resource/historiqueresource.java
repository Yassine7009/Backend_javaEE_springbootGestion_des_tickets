package com.example.demo.resource;


import com.example.demo.model.client;
import com.example.demo.service.clientservice;
import org.springframework.http.HttpStatus;
import com.example.demo.service.historiqueservice;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.historique;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historique")

public class historiqueresource {
    private final historiqueservice historiqueservice;

    public historiqueresource(com.example.demo.service.historiqueservice historiqueservice) {
        this.historiqueservice = historiqueservice;

    }
    @GetMapping("/all")
    public ResponseEntity<List<historique>> gethistorique() {
        List<historique> historiques = historiqueservice.findAllhistoriques();
        return new ResponseEntity<>(historiques, HttpStatus.OK);
    }

}
