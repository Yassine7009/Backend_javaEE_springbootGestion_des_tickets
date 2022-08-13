package com.example.demo.resource;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.clientservice;
import com.example.demo.model.client;

import java.util.List;
@RestController
@RequestMapping("/client")
public class clientresource {
    private final clientservice clientservice;

    public clientresource(clientservice clientservice) {
        this.clientservice = clientservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<client>> getAllclients () {
        List<client> clients = clientservice.findAllclients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<client> getclientById(@PathVariable("id") Long id) {
        client client = clientservice.findclientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<client> addclient(@RequestBody client client) {
        client newclient = clientservice.addclient(client);
        return new ResponseEntity<>(newclient, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<client> updateclient(@RequestBody client client) {
        client updateclient = clientservice.updateclient(client);
        return new ResponseEntity<>(updateclient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteclient(@PathVariable("id") Long id) {
        clientservice.deleteclient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

